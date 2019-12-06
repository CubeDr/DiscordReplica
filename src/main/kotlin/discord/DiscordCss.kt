package discord

import javafx.scene.paint.Color
import tornadofx.*

class DiscordCss: Stylesheet() {
    companion object {
        val titleBar by cssclass()
        val closeButton by cssclass()
        val titleBarButtonHoverColor: Color = Color.DARKGRAY
        val titleBarCloseButtonHoverColor: Color = Color.RED
    }

    init {
        titleBar {
            backgroundColor += c("#202225")

            imageView {
                backgroundColor += c("#ffffff")
            }

            button {
                backgroundColor += Color.TRANSPARENT
                textFill = Color.LIGHTGRAY
                prefWidth = 30.px
                backgroundRadius = multi(box(0.px))

                and(hover) {
                    backgroundColor += titleBarButtonHoverColor
                }

                and(closeButton) {
                    and(hover) {
                        backgroundColor += titleBarCloseButtonHoverColor
                    }
                }
            }
        }
    }
}