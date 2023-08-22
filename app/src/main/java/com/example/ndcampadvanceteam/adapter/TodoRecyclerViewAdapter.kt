package com.example.ndcampadvanceteam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ndcampadvanceteam.R

class TodoRecyclerViewAdapter :
    RecyclerView.Adapter<TodoRecyclerViewAdapter.TodoRecyclerViewHolder>() {
    class TodoRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val todoItemText: TextView = itemView.findViewById(R.id.todo_item_text)
        val todoItemSubText: TextView = itemView.findViewById(R.id.todo_item_sub_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoRecyclerViewHolder {
        return TodoRecyclerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.todo_recycleview_item, parent, false)
        )
    }

    override fun getItemCount(): Int = 100

    override fun onBindViewHolder(holder: TodoRecyclerViewHolder, position: Int) {
//        holder.todoItemText.text = "test"
//        holder.todoItemSubText.text = "hi"
    }
}