package com.example.ndcampadvanceteam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ndcampadvanceteam.adapter.TodoRecyclerViewAdapter
import com.example.ndcampadvanceteam.databinding.MainTodoFragmentBinding

class MainTodoFragment : Fragment() {
    private val _binding: MainTodoFragmentBinding by lazy {
        MainTodoFragmentBinding.inflate(
            layoutInflater
        )
    }
    private val todoRecyclerView: RecyclerView by lazy { _binding.mainTodoRecyclerView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setRecyclerView(todoRecyclerView)
        return _binding.root
    }

    private fun setRecyclerView(view: RecyclerView) {
        view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TodoRecyclerViewAdapter()
        }
    }

    companion object {
    }
}