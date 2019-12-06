package discord.titlebar

import javafx.scene.Node
import javafx.scene.input.MouseEvent
import javafx.stage.Screen
import javafx.stage.Stage
import tornadofx.Controller

private fun MouseEvent.stage() = (this.source as Node).scene.window as Stage

class TitleBarController: Controller() {
    var x: Double = 500.0
    var y: Double = 500.0

    var isFullscreen: Boolean = false
    var originalX: Double = 0.0
    var originalY: Double = 0.0
    var originalWidth: Double = 600.0
    var originalHeight: Double = 400.0

    fun dragged(event: MouseEvent) {
        val stage = event.stage()

        stage.x = event.screenX - x
        stage.y = event.screenY - y
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

        if(isFullscreen) { // disable fullscreen
            stage.x = originalX
            stage.y = originalY
            stage.width = originalWidth
            stage.height = originalHeight

            isFullscreen = false
        } else { // make fullscreen
            originalX = stage.x
            originalY = stage.y
            originalWidth = stage.width
            originalHeight = stage.height

            val bounds = Screen.getPrimary().visualBounds
            stage.x = bounds.minX
            stage.y = bounds.minY
            stage.width = bounds.width
            stage.height = bounds.height

            isFullscreen = true
        }
    }

    fun close(event: MouseEvent) {
        event.stage().close()
    }
}