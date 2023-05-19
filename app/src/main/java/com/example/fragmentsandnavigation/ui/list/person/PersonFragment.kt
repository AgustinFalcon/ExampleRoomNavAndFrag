package com.example.fragmentsandnavigation.ui.list.person

import com.example.fragmentsandnavigation.model.Address
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentsandnavigation.databinding.FragmentPersonBinding
import com.example.fragmentsandnavigation.model.Person
import com.example.fragmentsandnavigation.viewmodel.PersonViewModel


class PersonFragment : Fragment() {

    private lateinit var binding: FragmentPersonBinding

    private val adapter by lazy { PersonAdapter() }
    private val myViewModel by viewModels<PersonViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentPersonBinding.inflate(inflater, container, false)


        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val address = Address("Calle Siempre Viva", 123)
        val person = Person(0, "Agus", "Falcon", 26, address)
        myViewModel.insertPerson(person)

        myViewModel.readPerson.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        return binding.root
    }


}