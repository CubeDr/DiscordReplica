package discord.titlebar

import javafx.geometry.Pos
import tornadofx.View
import tornadofx.button
import tornadofx.hbox
import tornadofx.style

class TitlebarView: View() {
    val controller: TitlebarController by inject()

    override val root = hbox {
        style {
            alignment = Pos.CENTER_RIGHT
        }

        button("_").setOnMouseClicked { controller.minimize(it) }
        button("ㅁ").setOnMouseClicked { controller.maximize(it) }
        button("X").setOnMouseClicked { controller.close(it) }

        setOnMousePressed {
            controller.pressed(it)
        }

        setOnMouseDragged {
            controller.dragged(it)
        }
    }
}