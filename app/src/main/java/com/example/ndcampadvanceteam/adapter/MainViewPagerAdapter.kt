package com.example.ndcampadvanceteam.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ndcampadvanceteam.BookmarkFragment
import com.example.ndcampadvanceteam.R
import com.example.ndcampadvanceteam.TodoFragment
import com.example.ndcampadvanceteam.model.MainTabsModel

//class MainViewPagerAdapter(tabList : ArrayList<MainTabsModel>, fragmentManager: FragmentManager, lifecycle: Lifecycle) :
class MainViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val viewList = ArrayList<MainTabsModel>()
    init {
        viewList.add(MainTabsModel(TodoFragment.newInstance(), R.string.main_todo_title))
        viewList.add(MainTabsModel(BookmarkFragment.newInstance(), R.string.main_bookmark_title))
    }

    fun getTitleByIndex(position : Int): Int {
        return viewList[position].title
    }

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return TodoFragment()
            1 -> return BookmarkFragment()
        }
        return TodoFragment()
    }

    fun getFragmentByIndex(position: Int): Fragment? {
        return viewList[position].fragment
    }
}