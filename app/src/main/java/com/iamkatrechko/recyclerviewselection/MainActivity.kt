package com.iamkatrechko.recyclerviewselection

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.ActionMode
import android.support.v7.widget.LinearLayoutManager
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import com.iamkatrechko.recyclerviewselection.selection.WordKeyProvider
import com.iamkatrechko.recyclerviewselection.selection.WordLookup
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Главный экран приложения
 * @author iamkatrechko
 *         Date: 22.04.2018
 */
class MainActivity : AppCompatActivity() {

    /** Список элементов виджета */
    private val wordItems = (1..30).map { Word(it, "Элемент $it") }
    /** Адаптер списка элементов */
    private val adapter = WordsAdapter(wordItems)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        val tracker = SelectionTracker.Builder<Word>(
                hashCode().toString(), // Идентификатор трекера в контексте
                recycler_view,
                WordKeyProvider(wordItems), // Для Long ItemKeyProvider реализован в виде StableIdKeyProvider
                WordLookup(recycler_view),
                StorageStrategy.createParcelableStorage(Word::class.java) // Существуют аналогичные реализации для Long и String
        ).build()

        adapter.tracker = tracker
        tracker.addObserver(object : SelectionTracker.SelectionObserver<Any>() {

            /** Шапка действий */
            var actionMode: ActionMode? = null

            override fun onSelectionChanged() {
                super.onSelectionChanged()
                actionMode ?: startSupportActionMode(ActionModeController(tracker)).also { actionMode = it }
                if (!tracker.hasSelection()) {
                    actionMode?.finish()
                    actionMode = null
                } else {
                    setSelectedTitle(tracker.selection.size())
                }
            }

            /** Устанавливает заголовок шапки действий */
            private fun setSelectedTitle(selectedCount: Int) {
                actionMode?.title = "Выделено: $selectedCount"
            }
        })
    }
}

