package com.example.fragmentsandnavigation.ui.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmentsandnavigation.R
import com.example.fragmentsandnavigation.databinding.FragmentUpdateBinding
import com.example.fragmentsandnavigation.model.User
import com.example.fragmentsandnavigation.viewmodel.UserViewModel


class UpdateFragment : Fragment(), MenuProvider {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var binding: FragmentUpdateBinding

    private val userViewModel by viewModels<UserViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUpdateBinding.inflate(inflater, container, false)


        // The usage of an interface lets you inject your own implementation
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)


        with(binding) {
            etUpdateFirstName.setText(args.currentUser.firstName)
            etUpdateLastName.setText(args.currentUser.lastName)
            etUpdateAge.setText(args.currentUser.age.toString())
        }


        binding.btnUpdate.setOnClickListener {
            updateItem()
        }



        /*menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.delete_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when(menuItem.itemId) {
                    R.id.menu_delete -> {
                        deleteUser()
                        true
                    }

                    else -> {
                        false
                    }
                }
            }

        })*/



        return binding.root
    }



    private fun deleteUser() {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setPositiveButton("Yes") { _,_ ->
            userViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(), "Succesfully removed: ${args.currentUser.firstName}", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }

        dialog.setNegativeButton("No") { _,_ ->
        }

        dialog.setTitle("Delete ${args.currentUser.firstName}")
        dialog.setMessage("Are you sure want to delete ${args.currentUser.firstName +""+args.currentUser.lastName}")

        dialog.create().show()

    }

    private fun updateItem() {
        val firstName = binding.etUpdateFirstName.text.toString()
        val lastName = binding.etUpdateLastName.text.toString()
        val ageText = binding.etUpdateAge.text


        if (inputCheck(firstName, lastName, ageText)) {
            val age = Integer.parseInt(ageText.toString())
            val updateUser = User(args.currentUser.id, firstName, lastName, age)

            userViewModel.updateUser(updateUser)


            Toast.makeText(requireContext(), "Update Successfully", Toast.LENGTH_SHORT).show()
            val action = UpdateFragmentDirections.actionUpdateFragmentToListFragment()
            findNavController().navigate(action)

        } else {

            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }


    private fun inputCheck(firstName: String, secondName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(secondName) && age.isEmpty())
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId) {
            R.id.menu_delete -> {
                deleteUser()
                true
            }

            else -> {
                true
            }
        }
    }


}