package discord.navigator

import discord.navigator.button.NavigatorButtonView
import tornadofx.*

class NavigatorView : View() {
    val servers = listOf(
        "Home",
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

        servers.forEach { name ->
            this += find<NavigatorButtonView>(
                params = mapOf(
                    NavigatorButtonView::text to name
                )
            )
        }
    }
}