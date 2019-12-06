package discord.navigator.button

import discord.Utils
import javafx.application.Platform
import javafx.scene.image.Image
import javafx.scene.text.Font
import tornadofx.*

class NavigatorButtonView : Fragment() {
    val text: String by param()
    val image: Image? by param()

    private val controller: NavigatorButtonController by inject()

    override val root = hbox {
        importStylesheet<NavigatorButtonViewCss>()
        addClass(NavigatorButtonViewCss.navButton)

        // indicator
        pane().addClass(NavigatorButtonViewCss.indicator)

        // icon
        stackpane {
            addClass(NavigatorButtonViewCss.face)
            if (image != null) imageview(image!!)
            else label(text) {
                font = loadFont("/fonts/NotoSansKR-Regular.otf", 20.0)

                Platform.runLater {
                    var fontSize = font.size
                    var clippedText = Utils.computeClippedText(font, text,
                        width, textOverrun, ellipsisString)
                    var newFont = font
                    while(text != clippedText && fontSize > 0.5) {
                        fontSize -= 0.05
                        newFont = Font.font(font.family, fontSize)
                        clippedText = Utils.computeClippedText(font, text,
                            width, textOverrun, ellipsisString)
                        font = newFont
                    }
                    font = newFont
                }
            }
        }

        // right margin
        pane().prefWidth = 10.0
    }
}