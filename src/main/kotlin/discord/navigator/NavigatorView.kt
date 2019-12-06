package discord.navigator

import discord.navigator.button.navButton
import tornadofx.View
import tornadofx.c
import tornadofx.style
import tornadofx.vbox

class NavigatorView : View() {
    val servers = listOf(
        "하이롤",
        "알고",
        "소전1",
        "부렉",
        "옥디"
    )

    override val root = vbox {
        style {
            backgroundColor += c("#202225")
        }

        spacing = 6.0

        // Home
        // Divider

        servers.forEach { name ->
            navButton(name)
        }
    }
}