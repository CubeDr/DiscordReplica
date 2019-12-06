package discord.titlebar

import javafx.geometry.Rectangle2D
import javafx.scene.Node
import javafx.scene.input.MouseEvent
import javafx.stage.Screen
import javafx.stage.Stage
import tornadofx.Controller

private fun MouseEvent.stage() = (this.source as Node).scene.window as Stage

class TitleBarController: Controller() {
    private val screen: Rectangle2D
        get() = Screen.getPrimary().visualBounds

    private var sceneX: Double = 500.0
    private var sceneY: Double = 500.0

    private var isFullscreen: Boolean = false
    private var originalX: Double = 0.0
    private var originalY: Double = 0.0
    private var originalWidth: Double = 600.0
    private var originalHeight: Double = 400.0

    fun dragged(event: MouseEvent) {
        val stage = event.stage()

        if(isFullscreen) {
            stage.width = originalWidth
            stage.height = originalHeight

            sceneX *= originalWidth / screen.width
            sceneY *= originalHeight / screen.height

            isFullscreen = false
        }

        stage.x = event.screenX - sceneX
        stage.y = event.screenY - sceneY
    }

    fun pressed(event: MouseEvent) {
        sceneX = event.sceneX
        sceneY = event.sceneY
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

            stage.x = screen.minX
            stage.y = screen.minY
            stage.width = screen.width
            stage.height = screen.height

            isFullscreen = true
        }
    }

    fun close(event: MouseEvent) {
        event.stage().close()
    }
}