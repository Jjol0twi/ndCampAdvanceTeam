package com.example.ndcampadvanceteam.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ndcampadvanceteam.MainBookmarkFragment
import com.example.ndcampadvanceteam.MainTodoFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return MainTodoFragment()
            1 -> return MainBookmarkFragment()
        }
        return MainTodoFragment()
    }
}