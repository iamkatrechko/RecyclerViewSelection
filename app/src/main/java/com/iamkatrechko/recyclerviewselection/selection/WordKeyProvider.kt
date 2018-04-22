package com.iamkatrechko.recyclerviewselection.selection

import androidx.recyclerview.selection.ItemKeyProvider
import com.iamkatrechko.recyclerviewselection.Word

/**
 * Провайдер для соответствия ключей элементов списка с их позициями
 * @author iamkatrechko
 *         Date: 22.04.2018
 */
class WordKeyProvider(
        /** Список элементов */
        private val items: List<Word>
) : ItemKeyProvider<Word>(ItemKeyProvider.SCOPE_MAPPED) {

    override fun getKey(position: Int) = items.getOrNull(position)

    override fun getPosition(key: Word) = items.indexOf(key)
}