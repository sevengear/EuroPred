package com.sevengear.basic.core.ktx

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.ItemDecoration.attachTo(recyclerView: RecyclerView) {
    recyclerView.addItemDecoration(this)
}