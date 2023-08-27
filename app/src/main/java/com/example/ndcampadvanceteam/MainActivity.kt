package com.example.ndcampadvanceteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.ndcampadvanceteam.adapter.MainViewPagerAdapter
import com.example.ndcampadvanceteam.databinding.MainActivityBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding: MainActivityBinding by lazy { MainActivityBinding.inflate(layoutInflater) }
    private val mainToolbar: Toolbar by lazy { binding.mainToolbar }
    private val mainTabLayout: TabLayout by lazy { binding.mainTabLayout }
    private val mainViewPager: ViewPager2 by lazy { binding.mainViewPager }
    private val mainFloatingButton: FloatingActionButton by lazy { binding.mainFloatingButton }


    private val tabTitleList: ArrayList<String> = arrayListOf("Todo", "Bookmark")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mainViewPager.adapter = MainViewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(mainTabLayout, mainViewPager) { tab, pos ->
            tab.text = tabTitleList[pos]
        }.attach()
        mainToolbar.title = "Camp"
        mainViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 0) {
                    mainFloatingButton.show()
                }
                if (position == 1) {
                    mainFloatingButton.hide()
                }
            }
        })
    }
    }
}