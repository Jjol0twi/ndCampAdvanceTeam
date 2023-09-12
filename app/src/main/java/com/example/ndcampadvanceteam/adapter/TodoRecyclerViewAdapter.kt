package com.example.ndcampadvanceteam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ndcampadvanceteam.R
import com.example.ndcampadvanceteam.databinding.TodoRecycleviewItemBinding
import com.example.ndcampadvanceteam.model.TodoModel

class TodoRecyclerViewAdapter :
    RecyclerView.Adapter<TodoRecyclerViewAdapter.TodoRecyclerViewHolder>() {

    private val itemList = ArrayList<TodoModel>()

//    fun addItems(items: List<TodoModel>){
//        itemList.addAll(items)
//        notifyDataSetChanged()
//    }

    fun addItem(title: String, content: String) {
        itemList.add(TodoModel(title, content))
//        notifyDataSetChanged()
        notifyItemInserted(itemList.size)
    }


    inner class TodoRecyclerViewHolder(private val binding: TodoRecycleviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TodoModel) = with(binding) {
            todoItemText.text = data.title
            todoItemSubText.text = data.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoRecyclerViewHolder {
        return TodoRecyclerViewHolder(
            TodoRecycleviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: TodoRecyclerViewHolder, position: Int) {
        val data = itemList[position]
        holder.bind(data)
    }
}