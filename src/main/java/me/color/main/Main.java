package me.color.main;

import me.color.commands.dropCommand;
import me.color.events.dropEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("drop").setExecutor(new dropCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new dropEvent(),this);
    }

}
