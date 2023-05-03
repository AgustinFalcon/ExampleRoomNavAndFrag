package com.example.fragmentsandnavigation.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentsandnavigation.R
import com.example.fragmentsandnavigation.data.UserViewModel
import com.example.fragmentsandnavigation.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val userViewModel by viewModels<UserViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)


        val adapter = ListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())


        binding.btnAddNewUser.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        userViewModel.readAllData.observe(viewLifecycleOwner) { users ->
            adapter.setData(users = users)
        }




        return binding.root
    }


}