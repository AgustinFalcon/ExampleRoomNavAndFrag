package com.example.fragmentsandnavigation.ui.list.character

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fragmentsandnavigation.databinding.ItemAdapterCharacterFragmentBinding
import com.example.fragmentsandnavigation.model.Character


class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var characters = emptyList<Character>()


    inner class CharacterViewHolder(val binding: ItemAdapterCharacterFragmentBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.CharacterViewHolder {
        val binding = ItemAdapterCharacterFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.CharacterViewHolder, position: Int) {
        holder.binding.firstNameTxt.text = characters[position].firstName
        holder.binding.lastNameTxt.text = characters[position].lastName
        holder.binding.imageView.load(characters[position].profilePhoto)
    }

    override fun getItemCount(): Int {
        return characters.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setData(characters: List<Character>){
        this.characters = characters
        notifyDataSetChanged()
    }

}