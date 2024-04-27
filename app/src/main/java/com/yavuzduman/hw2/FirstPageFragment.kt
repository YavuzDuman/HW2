package com.yavuzduman.hw2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.yavuzduman.hw2.databinding.FragmentFirstPageBinding


class FirstPageFragment : Fragment() {

    private lateinit var binding: FragmentFirstPageBinding
    private lateinit var myAdapter: ToDoAdapter
    private val myList = ArrayList<ItemDataModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun addList(item: ItemDataModel) {
        myList.add(item)
        myAdapter.notifyDataSetChanged()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button2.setOnClickListener {
            val title = binding.editTextText.text.toString()
            val description = binding.editTextText2.text.toString()

            if (title.isBlank() || description.isBlank()) {
                Snackbar.make(it, "Fill all the blanks", Snackbar.LENGTH_SHORT).show()
            }
            else {
                val newItem = ItemDataModel(title, description)
                addList(newItem)

                binding.editTextText.text.clear()
                binding.editTextText2.text.clear()

                binding.editTextText.requestFocus()
            }
        }
        myAdapter = ToDoAdapter(myList)
        binding.recyclerView.adapter = myAdapter
    }
}