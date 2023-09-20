package com.example.ndcampadvanceteam.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.ndcampadvanceteam.R
import com.example.ndcampadvanceteam.ui.todo.TodoContentActivity
import com.example.ndcampadvanceteam.ui.todo.TodoFragment
import com.example.ndcampadvanceteam.adapter.MainViewPagerAdapter
import com.example.ndcampadvanceteam.databinding.MainActivityBinding
import com.example.ndcampadvanceteam.model.MainTabsModel
import com.example.ndcampadvanceteam.ui.bookmark.BookmarkFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    // viewBinding
    private lateinit var binding: MainActivityBinding

    // other
    private lateinit var todoAddLauncher: ActivityResultLauncher<Intent>
    private val mainViewPagerAdapter by lazy {
        MainViewPagerAdapter(
            this@MainActivity
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        mainViewPagerChanged()
        addTodoItem()
    }

    private fun initView() = with(binding) {
        mainViewPagerAdapter.addTabList(
            MainTabsModel(
                TodoFragment.newInstance(),
                R.string.main_todo_title
            )
        )
        mainViewPagerAdapter.addTabList(
            MainTabsModel(
                BookmarkFragment.newInstance(),
                R.string.main_bookmark_title
            )
        )
        mainViewPager.adapter = mainViewPagerAdapter    // connect adapter
        TabLayoutMediator(mainTabLayout, mainViewPager) { tab, pos ->   // set tabLayout title
            tab.text = getString(mainViewPagerAdapter.getTitleByIndex(pos))
        }.attach()
        mainToolbar.title = getString(R.string.main_toolbar_title)
        mainFloatingButton.setOnClickListener { mainFloatingButtonClickEvent() }
    }

    private fun addTodoItem() = with(binding) {
        todoAddLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data =
                    val getTodoInstance =
                        mainViewPagerAdapter.getFragmentByIndex(mainViewPager.currentItem) as TodoFragment
                    getTodoInstance.setItemData(title, content)
                }
            }
    }

    private fun mainViewPagerChanged() = with(binding) {
        mainViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
//                if (position == 0) {
//                    mainFloatingButton.show()
//                }
//                if (position == 1) {
//                    mainFloatingButton.hide()
//                }
                val nFragment = mainViewPagerAdapter.getFragmentByIndex(position)
                if (nFragment is TodoFragment) {
                    mainFloatingButton.show()
                }
                if (nFragment is BookmarkFragment) {
                    mainFloatingButton.hide()
                }
            }
        })
    }

    private fun mainFloatingButtonClickEvent() {
        val intent = Intent(this, TodoContentActivity::class.java)
        todoAddLauncher.launch(intent)
    }
}