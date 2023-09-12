package com.example.ndcampadvanceteam.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ndcampadvanceteam.BookmarkFragment
import com.example.ndcampadvanceteam.R
import com.example.ndcampadvanceteam.TodoFragment
import com.example.ndcampadvanceteam.model.MainTabsModel

class MainViewPagerAdapter(fragmentManager: FragmentActivity) :
//class MainViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager) {

    private val tabList = ArrayList<MainTabsModel>()

    fun addTabList(model : MainTabsModel){
        tabList.add(model)
    }

    fun getTitleByIndex(position : Int): Int {
        return tabList[position].title
    }

    fun getFragmentByIndex(position: Int): Fragment {
        return tabList[position].fragment
    }

    override fun getItemCount(): Int = tabList.size

    override fun createFragment(position: Int): Fragment {
        return tabList[position].fragment
//        when (position) {
//            0 -> return tabList[position]
//            1 -> return BookmarkFragment()
//        }
//        return TodoFragment()
    }

}