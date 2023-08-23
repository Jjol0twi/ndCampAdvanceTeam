package com.example.ndcampadvanceteam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ndcampadvanceteam.R
import com.example.ndcampadvanceteam.databinding.TodoRecycleviewItemBinding

class TodoRecyclerViewAdapter :
    RecyclerView.Adapter<TodoRecyclerViewAdapter.TodoRecyclerViewHolder>() {
    class TodoRecyclerViewHolder(private val binding : TodoRecycleviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val todoItemText: TextView = binding.todoItemText
        val todoItemSubText: TextView = binding.todoItemSubText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoRecyclerViewHolder {
        return TodoRecyclerViewHolder(
            TodoRecycleviewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int = 100

    override fun onBindViewHolder(holder: TodoRecyclerViewHolder, position: Int) {
//        holder.todoItemText.text = "test"
//        holder.todoItemSubText.text = "hi"
    }
}