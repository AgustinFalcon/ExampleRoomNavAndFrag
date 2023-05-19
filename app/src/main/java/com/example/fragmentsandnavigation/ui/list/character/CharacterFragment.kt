package com.example.fragmentsandnavigation.ui.list.character

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.fragmentsandnavigation.model.Character
import com.example.fragmentsandnavigation.databinding.FragmentCharacterBinding
import com.example.fragmentsandnavigation.databinding.ItemAdapterCharacterFragmentBinding
import com.example.fragmentsandnavigation.viewmodel.CharacterViewModel
import kotlinx.coroutines.launch


class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private val characterViewModel by viewModels<CharacterViewModel>()
    private val adapter by lazy { CharacterAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)



        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launch {
            val character = Character("Lionel", "Messi", getBitmap())
            characterViewModel.insertCharacter(character)
        }

        characterViewModel.readCharacter.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }




        return binding.root
    }


    private suspend fun getBitmap(): Bitmap {
        val loading = ImageLoader(requireContext())
        val request = ImageRequest.Builder(requireContext())
            .data("https://upload.wikimedia.org/wikipedia/commons/b/b4/Lionel-Messi-Argentina-2022-FIFA-World-Cup_%28cropped%29.jpg")
            .build()

        val result = (loading.execute(request) as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }

}