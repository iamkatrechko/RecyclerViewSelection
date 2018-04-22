package com.iamkatrechko.recyclerviewselection

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import com.iamkatrechko.recyclerviewselection.selection.ViewHolderWithDetails
import com.iamkatrechko.recyclerviewselection.selection.WordDetails
import kotlinx.android.synthetic.main.item_word.view.*

/**
 * Адаптер списка
 * @author iamkatrechko
 *         Date: 22.04.2018
 */
class WordsAdapter(
        /** Элементы списка */
        private val items: List<Word>
) : RecyclerView.Adapter<WordsAdapter.WordViewHolder>() {

    /** Трекер состояний выделения элементов */
    var tracker: SelectionTracker<Word>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            WordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int, payloads: MutableList<Any>) {
        holder.setActivatedState(tracker?.isSelected(items[position]) ?: false)
        // Если изменения касаются только состояния выбора
        if (SelectionTracker.SELECTION_CHANGED_MARKER !in payloads) {
            onBindViewHolder(holder, position)
        }
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(items[position])
    }

    /** Основной ViewHolder */
    inner class WordViewHolder(view: View) : RecyclerView.ViewHolder(view), ViewHolderWithDetails<Word> {

        override fun getItemDetail() = WordDetails(adapterPosition, items.getOrNull(adapterPosition))

        /** Меняет состояние выделения элемента */
        fun setActivatedState(selected: Boolean) {
            itemView.isActivated = selected
            itemView.setBackgroundColor(if (selected) Color.LTGRAY else Color.WHITE)
        }

        /** Связывает элемент списпка данных с текущий виджетом Holder'а */
        fun bind(word: Word) {
            itemView.text_view_title.text = word.text
        }
    }
}