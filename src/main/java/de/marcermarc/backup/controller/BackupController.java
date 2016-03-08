package de.marcermarc.backup.controller;

import java.util.ArrayList;

public class BackupController {
    private PluginController controller;

    private ArrayList<String> worldFolder;

    public BackupController(PluginController controller) {
        this.controller = controller;
    }

    public synchronized ArrayList<String> getWorldFolder() {
        return worldFolder;
    }

    public synchronized void setWorldFolder(ArrayList<String> worldFolder) {
        this.worldFolder = worldFolder;
    }

    public synchronized void addWorldFolder(String worldFolder) {
        this.worldFolder.add(worldFolder);
    }

    public synchronized String getStartMessage() {
        return controller.getConfig().getStartMessage();
    }

    public synchronized String getEndMessage() {
        return controller.getConfig().getEndMessage();
    }

}
