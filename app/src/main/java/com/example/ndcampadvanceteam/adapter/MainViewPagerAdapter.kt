package com.example.ndcampadvanceteam.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ndcampadvanceteam.BookmarkFragment
import com.example.ndcampadvanceteam.TodoFragment
import com.example.ndcampadvanceteam.model.MainTabsModel

//class MainViewPagerAdapter(tabList : ArrayList<MainTabsModel>, fragmentManager: FragmentManager, lifecycle: Lifecycle) :
class MainViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return TodoFragment()
            1 -> return BookmarkFragment()
        }
        return TodoFragment()
    }
}