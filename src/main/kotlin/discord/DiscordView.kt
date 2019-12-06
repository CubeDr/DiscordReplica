package discord

import discord.main.MainView
import discord.navigator.NavigatorView
import discord.titlebar.TitlebarView
import tornadofx.View
import tornadofx.borderpane

class DiscordView: View() {
    override val root = borderpane {
        top<TitlebarView>()
        left<NavigatorView>()
        center<MainView>()
    }
}