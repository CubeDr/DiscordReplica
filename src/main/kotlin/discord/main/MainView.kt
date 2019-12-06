package discord.main

import tornadofx.*

class MainView: View() {
    override val root = hbox {
        style {
            backgroundColor += c("#2F3136")
        }
        label("Main")
    }
}