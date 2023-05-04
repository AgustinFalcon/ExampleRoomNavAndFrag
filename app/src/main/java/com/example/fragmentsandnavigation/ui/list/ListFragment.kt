package com.example.fragmentsandnavigation.ui.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentsandnavigation.R
import com.example.fragmentsandnavigation.viewmodel.UserViewModel
import com.example.fragmentsandnavigation.databinding.FragmentListBinding


class ListFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentListBinding
    private val userViewModel by viewModels<UserViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentListBinding.inflate(inflater, container, false)

        // The usage of an interface lets you inject your own implementation
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)


        // Seteo el adapter
        val adapter = ListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


        // Linea divisoria del recyclerview
        val divider = DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation)
        binding.recyclerView.addItemDecoration(divider)


        binding.btnAddNewUser.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        userViewModel.readAllData.observe(viewLifecycleOwner) { users ->
            adapter.setData(users = users)
        }




        return binding.root
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId) {
            R.id.menu_delete -> {
                deleteAllUsers()
                true
            }

            else -> {
                true
            }
        }
    }

    private fun deleteAllUsers() {

        val dialog = AlertDialog.Builder(requireContext())

        dialog.setPositiveButton("Yes") { _, _ ->
            userViewModel.deleteAllUsers()
            Toast.makeText(requireContext(),
                "Succesfully deleted database",
                Toast.LENGTH_SHORT
            ).show()
        }

        dialog.setNegativeButton("No") { _, _ ->
        }

        dialog.setTitle("Delete All Users")
        dialog.setMessage("Are you sure want to delete all users!?")

        dialog.create().show()

    }


}