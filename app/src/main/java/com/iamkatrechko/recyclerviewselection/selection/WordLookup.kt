package com.iamkatrechko.recyclerviewselection.selection

import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import com.iamkatrechko.recyclerviewselection.Word

/**
 * Помощник библиотеки выделений элементов для их идентификации в списке
 * @author iamkatrechko
 *         Date: 22.04.2018
 */
class WordLookup(
        /** Виджет списка */
        private val recyclerView: RecyclerView
) : ItemDetailsLookup<Word>() {

    override fun getItemDetails(e: MotionEvent) =
            recyclerView.findChildViewUnder(e.x, e.y)
                    ?.let { view -> (recyclerView.getChildViewHolder(view) as? ViewHolderWithDetails<Word>)?.getItemDetail() }
}