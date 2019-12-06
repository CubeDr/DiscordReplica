package discord.titlebar

import discord.DiscordCss
import javafx.geometry.Pos
import javafx.scene.CacheHint
import javafx.scene.effect.ColorAdjust
import tornadofx.*

class TitleBarView: View() {
    private val controller: TitlebarController by inject()

    override val root = borderpane {
        addClass(DiscordCss.titleBar)
        left = hbox {
            alignment = Pos.CENTER
            paddingLeft = 5.0

            imageview("/logo.png") {
                val blackout = ColorAdjust()
                blackout.brightness = 0.4
                effect = blackout
                isCache = true
                cacheHint = CacheHint.SPEED

                fitWidth = 60.0
                isPreserveRatio = true
                isSmooth = true
            }
        }
        right = hbox {
            button("ㅡ").setOnMouseClicked { controller.minimize(it) }
            button("□").setOnMouseClicked { controller.maximize(it) }
            button("X")
                .addClass(DiscordCss.closeButton)
                .setOnMouseClicked { controller.close(it) }
        }

        setOnMousePressed {
            controller.pressed(it)
        }

        setOnMouseDragged {
            controller.dragged(it)
        }
    }
}