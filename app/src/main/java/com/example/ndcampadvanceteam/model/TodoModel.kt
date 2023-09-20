package com.example.ndcampadvanceteam.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TodoModel(
    val title: String,
    val content: String,
) : Parcelable