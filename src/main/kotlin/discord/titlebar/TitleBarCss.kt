package discord.titlebar

import javafx.scene.paint.Color
import tornadofx.*

class TitleBarCss: Stylesheet() {
    companion object {
        val titleBar by cssclass()
        val closeButton by cssclass()
        val buttonHoverColor: Color = Color.DARKGRAY
        val closeButtonHoverColor: Color = Color.RED
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
                    backgroundColor += buttonHoverColor
                }

                and(closeButton) {
                    and(hover) {
                        backgroundColor += closeButtonHoverColor
                    }
                }
            }
        }
    }
}