package com.example.fragmentsandnavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fragmentsandnavigation.data.User
import com.example.fragmentsandnavigation.data.UserViewModel
import com.example.fragmentsandnavigation.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val userViewModel by viewModels<UserViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)


        val user = User(0, "Agus", "Falcon", 26)
        val user2 = User(0, "Hola", "Mundo", 31)

        userViewModel.addUser(user)
        userViewModel.addUser(user2)

        val list = userViewModel.getAllUsers()

        Log.d("TAG", "lista de usuarios: ${list.toString()}")


        binding.btnA.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            findNavController().navigate(action)
            //findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }



        return binding.root
    }


}