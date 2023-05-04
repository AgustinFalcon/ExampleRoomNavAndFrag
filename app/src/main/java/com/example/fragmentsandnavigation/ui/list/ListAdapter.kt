package com.example.fragmentsandnavigation.ui.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentsandnavigation.model.User
import com.example.fragmentsandnavigation.databinding.ItemAdapterListFragmentBinding


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {



    inner class MyViewHolder(val binding: ItemAdapterListFragmentBinding): RecyclerView.ViewHolder(binding.root) {

    }

    private var userList = emptyList<User>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemAdapterListFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]

        with(holder.binding) {
            tvId.text = currentItem.id.toString()
            tvFirstName.text = currentItem.firstName
            tvLastName.text = currentItem.lastName
            tvAge.text = currentItem.age.toString()


            rowLayoutListFrag.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
                holder.itemView.findNavController().navigate(action)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(users: List<User>) {
        this.userList = users
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return userList.size
    }


}