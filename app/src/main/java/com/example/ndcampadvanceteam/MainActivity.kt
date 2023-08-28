package com.example.ndcampadvanceteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.ndcampadvanceteam.adapter.MainViewPagerAdapter
import com.example.ndcampadvanceteam.databinding.MainActivityBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    // viewBinding
    private lateinit var binding: MainActivityBinding
    // widget
    private val mainToolbar: Toolbar by lazy { binding.mainToolbar }
    private val mainTabLayout: TabLayout by lazy { binding.mainTabLayout }
    private val mainViewPager: ViewPager2 by lazy { binding.mainViewPager }
    private val mainFloatingButton: FloatingActionButton by lazy { binding.mainFloatingButton }
    // other
    private lateinit var todoAddLauncher: ActivityResultLauncher<Intent>
    private val mainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager, lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewPager.adapter = mainViewPagerAdapter    // connect adapter
        TabLayoutMediator(mainTabLayout, mainViewPager) { tab, pos ->   // set tabLayout title
            tab.text = getString(mainViewPagerAdapter.getTitleByIndex(pos))
        }.attach()
        mainToolbar.title = "Camp"  // set toolbar title
        mainViewPagerChanged()
        mainFloatingButton.setOnClickListener { mainFloatingButtonClickEvent() }
        addTodoItem()
    }

    private fun addTodoItem() {
        todoAddLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val title = result.data?.getStringExtra("title") ?: ""
                    val content = result.data?.getStringExtra("content") ?: ""
                    val getTodoInstance =
                        mainViewPagerAdapter.getFragmentByIndex(mainViewPager.currentItem) as TodoFragment
                    getTodoInstance.setItemData(title, content)
                }
            }
    }

    private fun mainViewPagerChanged() {
        mainViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
//                if (position == 0) {
//                    mainFloatingButton.show()
//                }
//                if (position == 1) {
//                    mainFloatingButton.hide()
//                }
                val nFragment=mainViewPagerAdapter.getFragmentByIndex(position)
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
        val intent = Intent(this, TodoAddActivity::class.java)
        todoAddLauncher.launch(intent)
    }
}