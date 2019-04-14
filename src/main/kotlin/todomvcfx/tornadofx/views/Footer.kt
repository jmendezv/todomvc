package todomvcfx.tornadofx.views

import todomvcfx.tornadofx.app.Styles
import todomvcfx.tornadofx.controllers.Store
import todomvcfx.tornadofx.models.FilterState
import tornadofx.*

class Footer : View() {
    val store: Store by inject()
    val itemsLeft = integerBinding(store.todos.items) { count { !it.completed } }

    override val root = hbox {
        addClass(Styles.footer)
        label(stringBinding(itemsLeft) { "${messages["tasques-pendents"]} $value item${value.plural}" })
        hbox {
            togglegroup {
                for (state in FilterState.values())
                    togglebutton(messages[state.name]).whenSelected { store.filterBy(state) }
            }
        }
    }

    val Int.plural: String get() = if (this == 1) "" else "s"
}
