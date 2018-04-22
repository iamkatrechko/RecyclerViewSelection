package com.iamkatrechko.recyclerviewselection.selection

import androidx.recyclerview.selection.ItemDetailsLookup
import com.iamkatrechko.recyclerviewselection.Word

/**
 * Детализация для трекинга выделений элементов списка
 * @author iamkatrechko
 *         Date: 22.04.2018
 */
class WordDetails(
        /** Позиция элемента в адаптере */
        private val adapterPosition: Int,
        /** Ключ элемента */
        private val selectedKey: Word?
) : ItemDetailsLookup.ItemDetails<Word>() {

    override fun getSelectionKey() = selectedKey

    override fun getPosition() = adapterPosition
}