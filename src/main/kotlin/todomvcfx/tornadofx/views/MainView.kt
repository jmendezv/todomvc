package todomvcfx.tornadofx.views

import tornadofx.*
import tornadofx.FX.Companion.messages

class MainView : View(messages["titol"]) {
    override val root = borderpane {
        top(Header::class)
        center(TodoList::class)
        bottom(Footer::class)
    }
}