package discord.navigator

import tornadofx.*

class NavigatorView: View() {
    override val root = vbox {
        style {
            backgroundColor += c("#202225")
        }

        button("Home")
        button("하이롤")
        button("알고")
        button("소전1")
        button("부렉")
        button("옥디")
    }
}