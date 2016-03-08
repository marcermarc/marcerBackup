package de.marcermarc.backup.tasks;

import de.marcermarc.backup.controller.PluginController;
import org.bukkit.scheduler.BukkitTask;

public class StartBackup implements Runnable {

    private PluginController controller;

    public StartBackup(PluginController pluginController) {
        this.controller = pluginController;
    }

    @Override
    public void run() {

        BukkitTask bukkitTask = controller.getMain().getServer().getScheduler().runTaskAsynchronously(controller.getMain(), new AsyncBackup(controller));

    }
}
