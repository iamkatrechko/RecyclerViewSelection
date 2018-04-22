package com.iamkatrechko.recyclerviewselection.selection

import androidx.recyclerview.selection.ItemDetailsLookup

/**
 * Интерфейс ViewHolder'а, способный возвращать Details для библиотеки выделений RecyclerViewSelection
 * @author iamkatrechko
 *         Date: 22.04.2018
 *
 * @property [T] тип элемента деталей
 */
interface ViewHolderWithDetails<T> {

    /** Возвращает детализацию для трекинга выделений элеметов */
    fun getItemDetail(): ItemDetailsLookup.ItemDetails<T>
}
