package discord.navigator.button

import tornadofx.*

class NavigatorButtonViewCss: Stylesheet() {
    companion object {
        val navButton by cssclass()
        val indicator by cssclass()
        val face by cssclass()

        val buttonBackgroundColor = c("#36393F")
        val buttonHoverBackgroundColor = c("#7289DA")
        val textColor = c("#C8C9CB")
    }

    init {
        indicator {
            prefWidth = 10.px
        }
        face {
            prefWidth = 50.px
            prefHeight = 50.px

            backgroundColor += buttonBackgroundColor
            backgroundRadius = multi(box(50.percent))

            label {
                textFill = textColor
            }

            and(hover) {
                backgroundColor += buttonHoverBackgroundColor
                backgroundRadius = multi(box(35.percent))
            }
        }
    }
}