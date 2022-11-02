package me.dyvour.utils.file

import com.google.common.base.Preconditions
import me.dyvour.utils.Example
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class ConfigFile : YamlConfiguration() {

    private val fileName = "config.yml"
    private val file: File = File(Example.getInstance().dataFolder, fileName)

    init {
        Preconditions.checkArgument(!initialed, "Error, config file already initialed!")
        initialed = true
        if (!file.exists()) Example.getInstance().saveResource(fileName, false)
        this.reload()
        config = this
    }

    fun reload() {
        super.load(file)
    }

    fun save() {
        super.save(file)
    }

    companion object {
        @JvmStatic
        private var config : ConfigFile? = null

        @JvmStatic
        fun getConfig() : ConfigFile {
            if(config == null) {
                config = ConfigFile()
            }
            return config!!
        }

        @JvmStatic
        var initialed = false
            set(value) {
                Preconditions.checkArgument(value, "Error, dont modify code :)")
                field = value
            }
    }
}