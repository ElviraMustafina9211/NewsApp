package com.example.newsapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(article: Article)
}