package com.example.ndcampadvanceteam.ui.todo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.ndcampadvanceteam.R
import com.example.ndcampadvanceteam.databinding.TodoAddActivityBinding
import com.example.ndcampadvanceteam.model.TodoModel

class TodoContentActivity : AppCompatActivity() {

    private lateinit var binding: TodoAddActivityBinding

    companion object {
        const val EXTRA_TODO_MODEL = "extra_todo_model"
        fun newIntentForAdd(
            context: Context,
        ) = Intent(context, TodoContentActivity::class.java).apply {
        }

        fun newIntentForEdit(
            context: Context,
            position: Int,
            data: TodoModel,
        ) = Intent(context, TodoContentActivity::class.java).apply {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TodoAddActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        binding.todoSubmit.setOnClickListener { addTodoSuccess() }
    }

    private fun addTodoSuccess(): Unit? = with(binding) {
//        val intent = Intent(this@TodoAddActivity, MainActivity::class.java)
        if (todoTitle.text.isNullOrBlank()) {
            todoTitle.requestFocus()
            return null
        }
        if (todoContent.text.isNullOrBlank()) {
            todoContent.requestFocus()
            return null
        }
        val intent = Intent()
        intent.putExtra(
            EXTRA_TODO_MODEL,
            TodoModel(todoTitle.text.toString(), todoContent.text.toString())
        )
        setResult(RESULT_OK, intent)
        finish()
        return null
    }

    private fun setToolbar() {
        setSupportActionBar(binding.todoAddToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(true)
            title = getString(R.string.todo_add_activity_title)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}