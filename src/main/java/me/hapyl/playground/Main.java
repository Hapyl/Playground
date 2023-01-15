package me.hapyl.playground;

import me.hapyl.spigotutils.EternaAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main PLUGIN;

    @Override
    public void onEnable() {
        final PluginManager pluginManager = Bukkit.getPluginManager();
        final Plugin eterna = pluginManager.getPlugin("EternaAPI");

        if (eterna == null) {
            Bukkit.getLogger().severe("EternaAPI not found in /plugins folder!");
            pluginManager.disablePlugin(this);
            return;
        }

        // Init EternaAPI
        new EternaAPI(this);

        PLUGIN = this;
    }

    public static Main getInstance() {
        return PLUGIN;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
