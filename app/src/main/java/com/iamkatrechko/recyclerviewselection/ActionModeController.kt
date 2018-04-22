package com.iamkatrechko.recyclerviewselection

import android.support.v7.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.selection.SelectionTracker

/**
 * Контроллер шапки действий
 * @author iamkatrechko
 *         Date: 22.04.2018
 */
class ActionModeController(
        /** Трекер состояний выделения элементов */
        private val tracker: SelectionTracker<*>
) : ActionMode.Callback {

    override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
        mode.menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    override fun onDestroyActionMode(mode: ActionMode) {
        tracker.clearSelection()
    }

    override fun onPrepareActionMode(mode: ActionMode, menu: Menu) = true

    override fun onActionItemClicked(mode: ActionMode, item: MenuItem) = when (item.itemId) {
        R.id.action_clear -> {
            mode.finish()
            true
        }
        else -> false
    }
}