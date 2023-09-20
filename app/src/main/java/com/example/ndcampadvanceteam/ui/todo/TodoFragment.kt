package com.example.ndcampadvanceteam.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ndcampadvanceteam.adapter.TodoRecyclerViewAdapter
import com.example.ndcampadvanceteam.databinding.MainTodoFragmentBinding

class TodoFragment : Fragment() {

    companion object {
        fun newInstance() = TodoFragment()
    }

    private var _binding: MainTodoFragmentBinding? = null
    private val binding get() = _binding!!
    private val todoRecyclerView: RecyclerView by lazy { binding.mainTodoRecyclerView }
    private val todoRecyclerAdapter by lazy { TodoRecyclerViewAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainTodoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(todoRecyclerView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setItemData(title: String, content: String) {
        todoRecyclerAdapter.addItem(title, content)
    }


    private fun setRecyclerView(view: RecyclerView) {
        view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = todoRecyclerAdapter
        }
    }
}