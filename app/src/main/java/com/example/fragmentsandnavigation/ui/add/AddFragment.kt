package com.example.fragmentsandnavigation.ui.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fragmentsandnavigation.R
import com.example.fragmentsandnavigation.data.User
import com.example.fragmentsandnavigation.data.UserViewModel
import com.example.fragmentsandnavigation.databinding.FragmentAddBinding



class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private val userViewModel by viewModels<UserViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)




        binding.btnAdd.setOnClickListener {
            insertDataToDatabase()
        }



        return binding.root
    }

    private fun insertDataToDatabase() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val age = binding.etAge.text


        if (inputCheck(firstName, lastName, age)) {
            // Crea el objeto del usuario
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))

            // Agrega el usuario a la base de datos
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "Succesfully added!", Toast.LENGTH_LONG).show()

            // Navegamos a la lista de añadidos
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        } else {
            Toast.makeText(requireContext(), "Complete all the fields!", Toast.LENGTH_LONG).show()
        }
    }


    private fun inputCheck(firstName: String, secondName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(secondName) && age.isEmpty())
    }


}