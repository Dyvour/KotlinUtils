package me.dyvour.utils.color

import org.bukkit.ChatColor
import java.util.stream.Collectors

object Color {

    @JvmStatic
    fun translate(input: String): String {
        return ChatColor.translateAlternateColorCodes('&', input)
    }

    @JvmStatic
    fun translate(input: List<String>): MutableList<String> {
        return input.stream().map(Color::translate).collect(Collectors.toList())
    }
}