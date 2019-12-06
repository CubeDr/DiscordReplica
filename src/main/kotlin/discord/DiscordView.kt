package discord

import discord.main.MainView
import discord.navigator.NavigatorView
import discord.titlebar.TitleBarView
import tornadofx.View
import tornadofx.borderpane

class DiscordView: View() {
    override val root = borderpane {
        top<TitleBarView>()
        left<NavigatorView>()
        center<MainView>()
    }
}