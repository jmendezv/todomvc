package todomvcfx.tornadofx.views

import todomvcfx.tornadofx.app.Styles
import todomvcfx.tornadofx.controllers.Store
import tornadofx.*

class Header : View() {
    val store: Store by inject()
    val allDone = booleanBinding(store.todos.items) { all { it.completed } }

    override val root = vbox {
        addClass(Styles.header)
        label(messages["subtitol"]).setId(Styles.title)
        hbox {
            addClass(Styles.addItemRoot)
            checkbox {
                addClass(Styles.mainCheckBox)
                visibleWhen { booleanBinding(store.todos) { isNotEmpty() } }
                action { store.toggleCompleted(isSelected) }
                allDone.onChange { isSelected = it }
            }
            textfield {
                promptText = messages["que-cal-fer"]
                action {
                    text.apply {
                        if (isNotBlank()) {
                            store.addTodo(this.trim().capitalize())
                            clear()
                        }
                    }

                }
            }
        }
    }
}