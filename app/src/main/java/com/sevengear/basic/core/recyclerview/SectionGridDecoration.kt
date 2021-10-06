package com.sevengear.basic.core.recyclerview

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sevengear.basic.R

class SectionGridDecoration(
    resources: Resources,
    private val spanSize: Int
) : RecyclerView.ItemDecoration() {

    private val marginLarge = resources.getDimensionPixelSize(R.dimen.margin)
    private val marginSmall = resources.getDimensionPixelSize(R.dimen.margin_tiny)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val left = when {
            isFirstColumn(position) -> marginLarge
            isLastColumn(position) && spanSize > 2 -> 0
            else -> marginSmall
        }
        val top = if (isFirstRow(position)) marginLarge else marginSmall
        val right = when {
            isLastColumn(position) -> marginLarge
            isFirstColumn(position) && spanSize > 2 -> 0
            else -> marginSmall
        }
        val bottom = if (isLastRow(position, state.itemCount)) marginLarge else marginSmall
        outRect.set(left, top, right, bottom)
    }

    private fun isFirstColumn(position: Int) = (position % spanSize == 0)

    private fun isFirstRow(position: Int) = (position < spanSize)

    private fun isLastColumn(position: Int) = (position % spanSize == spanSize - 1)

    private fun isLastRow(position: Int, count: Int): Boolean {
        val rowCount = (count / spanSize).toDouble().apply { Math.ceil(this) }.toInt()
        val itemRow = position / spanSize
        return itemRow == rowCount
    }
}