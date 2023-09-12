package com.example.ndcampadvanceteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.ndcampadvanceteam.databinding.TodoAddActivityBinding

class TodoAddActivity : AppCompatActivity() {

    private lateinit var binding: TodoAddActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TodoAddActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setToolbar()
        binding.todoAddSuccessButton.setOnClickListener { addTodoSuccess() }
    }

    private fun addTodoSuccess(): Unit? {
//        val intent = Intent(this@TodoAddActivity, MainActivity::class.java)
        if (binding.todoAddTitleEdit.text.isNullOrBlank()){
            binding.todoAddTitleEdit.requestFocus()
            return null
        }
        if (binding.todoAddContentEdit.text.isNullOrBlank()){
            binding.todoAddTitleEdit.requestFocus()
            return null
        }
        val intent = Intent()
        intent.putExtra("title", binding.todoAddTitleEdit.text.toString())
        intent.putExtra("content", binding.todoAddContentEdit.text.toString())
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