package de.marcermarc.backup;

import de.marcermarc.backup.controller.ConfigController;
import de.marcermarc.backup.controller.PluginController;
import de.marcermarc.backup.listener.Command;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private PluginController controller = new PluginController();

    @Override
    public void onEnable() {
        controller.setMain(this);

        PluginManager pM = getServer().getPluginManager();

        registerEvents(pM);

        controller.setConfig(new ConfigController(controller));
    }

    private void registerEvents(PluginManager in_PM) {
        Command c = new Command(controller);
        this.getCommand("marcerBackup").setExecutor(c);
        this.getCommand("mB").setExecutor(c);
    }

    @Override
    public void onDisable() {

    }
}
