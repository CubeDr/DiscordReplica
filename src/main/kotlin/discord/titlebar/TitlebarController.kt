package discord.titlebar

import javafx.scene.Node
import javafx.scene.input.MouseEvent
import javafx.stage.Screen
import javafx.stage.Stage
import tornadofx.Controller

private fun MouseEvent.stage() = (this.source as Node).scene.window as Stage

class TitlebarController: Controller() {
    var x: Double = 500.0
    var y: Double = 500.0

    fun dragged(event: MouseEvent) {
        val stage = event.stage()
        stage.x = event.screenX - x
        stage.y = event.screenY - y
        println("${stage.x}, ${stage.y}")
    }

    fun pressed(event: MouseEvent) {
        x = event.sceneX
        y = event.sceneY
    }

    fun minimize(event: MouseEvent) {
        event.stage().isIconified = true
    }

    fun maximize(event: MouseEvent) {
        val stage = event.stage()
        val bounds = Screen.getPrimary().visualBounds
        stage.x = bounds.minX
        stage.y = bounds.minY
        stage.width = bounds.width
        stage.height = bounds.height
    }

    fun close(event: MouseEvent) {
        event.stage().close()
    }
}