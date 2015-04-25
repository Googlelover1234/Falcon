package net.verendus.main;

import net.verendus.cmds.FalconCommand;
import net.verendus.listeners.BlockBreak;
import net.verendus.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Jeremy Gooch on 4/24/15.
 */
public class Main extends JavaPlugin {

    public void onEnable() {
        ConfigManager.getInstance().setup(this);
        registerCommands();
        registerListeners(this, new BlockBreak());
    }

    private void registerCommands() {
        getCommand("Falcon").setExecutor(new FalconCommand());
    }

    private void registerListeners(Plugin plugin, Listener... listeners) {
        for (Listener l : listeners) {
            Bukkit.getPluginManager().registerEvents(l, plugin);
        }
    }

}
