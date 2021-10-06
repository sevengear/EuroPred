package com.sevengear.basic.core.recyclerview

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sevengear.basic.R

class CardDecoration(resources: Resources) : Decoration() {

    private val marginLarge = resources.getDimensionPixelSize(R.dimen.margin)
    private val marginSmall = resources.getDimensionPixelSize(R.dimen.margin_small)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemPosition = parent.getChildAdapterPosition(view)
        when {
            unknownPosition(itemPosition) -> return
            isFirstItem(itemPosition) -> outRect.set(marginLarge, marginSmall, marginLarge, marginSmall)
            isLastItem(itemPosition, state.itemCount) -> outRect.set(marginLarge, 0, marginLarge, marginSmall)
            else -> outRect.set(marginLarge, 0, marginLarge, marginSmall)
        }
    }

}