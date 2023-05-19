package com.example.fragmentsandnavigation.ui.list.person

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentsandnavigation.R
import com.example.fragmentsandnavigation.databinding.ItemAdapterPersonFragmentBinding
import com.example.fragmentsandnavigation.model.Person


class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private var personList = emptyList<Person>()

    inner class PersonViewHolder(val binding: ItemAdapterPersonFragmentBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonViewHolder {
        val binding = ItemAdapterPersonFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.binding.tvFirstName.text = personList[position].firstName
        holder.binding.tvLastName.text = personList[position].lastName
        holder.binding.tvAge.text = personList[position].age.toString()

        holder.binding.tvStreetName.text = personList[position].address.streetName
        holder.binding.tvStreetNumber.text = personList[position].address.streetNumber.toString()



    }

    override fun getItemCount(): Int {
        return personList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setData(person: List<Person>){
        personList = person
        notifyDataSetChanged()
    }


}