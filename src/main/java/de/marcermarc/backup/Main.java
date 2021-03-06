package de.marcermarc.backup;

import de.marcermarc.backup.controller.ConfigController;
import de.marcermarc.backup.controller.PluginController;
import de.marcermarc.backup.listener.Command;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private PluginController controller;
    private int taskId;

    @Override
    public void onEnable() {
        controller = new PluginController(this);

        PluginManager pM = getServer().getPluginManager();

        registerEvents(pM);

        controller.setConfig(new ConfigController(controller));

        startSchedules();
    }

    private void registerEvents(PluginManager in_PM) {
        Command c = new Command(controller);
        this.getCommand("marcerBackup").setExecutor(c);
        this.getCommand("mB").setExecutor(c);
    }

    private void startSchedules() {
        taskId = this.getServer().getScheduler().scheduleSyncRepeatingTask(this, controller.getStartBackup(), 1200L, 1200L * (long) controller.getConfig().getIntervalInMin());// * controller.getConfig().getIntervalInMin());
    }

    @Override
    public void onDisable() {
        this.getServer().getScheduler().cancelTask(taskId);
    }
}
