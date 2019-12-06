package discord.navigator

import discord.navigator.button.NavigatorButtonViewCss
import discord.navigator.button.navButton
import javafx.scene.image.Image
import tornadofx.*

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

        // padding
        pane().prefHeight = 1.0

        // Home
        navButton("Home", Image("/images/home-icon.png"))
        // Divider
        borderpane {
            left = pane().apply { prefWidth = 20.0 }
            center = pane().apply {
                style {
                    prefHeight = 1.px
                    backgroundColor += NavigatorButtonViewCss.buttonBackgroundColor
                }
            }
            right = pane().apply { prefWidth = 20.0 }
        }

        servers.forEach { name ->
            navButton(name)
        }
    }
}