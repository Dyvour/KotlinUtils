package me.dyvour.utils

import me.dyvour.utils.file.ConfigFile
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Example : JavaPlugin() {

    companion object {
        @JvmStatic
        fun getInstance() : Example {
            return getPlugin(Example::class.java)
        }
    }

    override fun onEnable() {
        ConfigFile.getConfig().getBoolean("onEnable")
        ConfigFile.getConfig().save()
        ConfigFile.getConfig().reload()
    }

    override fun onDisable() {
        ConfigFile.getConfig().getBoolean("onDisable")
        ConfigFile.getConfig().save()
        ConfigFile.getConfig().reload()
    }
}