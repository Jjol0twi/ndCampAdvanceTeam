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