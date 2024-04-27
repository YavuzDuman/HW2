package com.yavuzduman.hw2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yavuzduman.hw2.databinding.ListItemBinding

class ToDoAdapter(private val list: MutableList<ItemDataModel>): RecyclerView.Adapter<ToDoAdapter.MyListViewHolder>() {

    inner class MyListViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(getList: ItemDataModel) {
            binding.textView2.text = getList.title
            binding.textView3.text = getList.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}