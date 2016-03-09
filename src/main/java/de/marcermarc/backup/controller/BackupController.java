package de.marcermarc.backup.controller;

import org.bukkit.World;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class BackupController {
    private PluginController controller;

    public BackupController(PluginController controller) {
        this.controller = controller;
    }

    public synchronized ArrayList<String> getWorldFolder() {
        ArrayList<String> ret = new ArrayList<>();
        ret.addAll(controller.getMain().getServer().getWorlds().stream().map(world -> world.getWorldFolder().getPath()).collect(Collectors.toList()));
        return ret;
    }

    public synchronized String getStartMessage() {
        return controller.getConfig().getStartMessage();
    }

    public synchronized String getEndMessage() {
        return controller.getConfig().getEndMessage();
    }


    public synchronized void startBackup() {
        System.out.println("[marcerBackup] start backup... save worlds");

        for (World world : controller.getMain().getServer().getWorlds()) {
            world.setAutoSave(false);
            //world.save();
        }

        controller.getMain().getServer().broadcastMessage(controller.getConfig().getStartMessage());
        System.out.println("[marcerBackup] start backup... all worlds save, autosave off");
    }

    public synchronized void endBackup() {
        System.out.println("[marcerBackup] end backup... start autosave worlds");

        for (World world : controller.getMain().getServer().getWorlds()) {
            world.setAutoSave(true);
        }

        controller.getMain().getServer().broadcastMessage(controller.getConfig().getEndMessage());
        System.out.println("[marcerBackup] start backup... all worlds autosave on");
    }

}
