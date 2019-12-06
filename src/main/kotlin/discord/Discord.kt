package discord

import javafx.stage.Stage
import javafx.stage.StageStyle
import tornadofx.App
import tornadofx.launch

class Discord: App(DiscordView::class) {
    override fun start(stage: Stage) {
        stage.initStyle(StageStyle.UNDECORATED)
        stage.width = 800.0
        stage.height = 600.0
        super.start(stage)
    }
}

fun main() {
    launch<Discord>()
}