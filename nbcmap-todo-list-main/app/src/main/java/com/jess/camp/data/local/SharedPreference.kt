package com.jess.camp.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


interface SharedPreference {
    fun addItem(title: String)
}

class SharedPreferenceImpl(private val context: Context) : SharedPreference {

    companion object {
        const val NAME = "sparta"
        const val TITLE = "title"
    }

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(NAME, MODE_PRIVATE)
    }

    override fun addItem(title: String) {
        sharedPreferences.edit().apply {
            putString(TITLE, title)
        }.apply()
    }

}