package de.marcermarc.backup.tasks;

import de.marcermarc.backup.controller.BackupController;
import de.marcermarc.backup.controller.PluginController;

public class AsyncBackup implements Runnable {

    private PluginController pluginController;
    private BackupController backupController;

    public AsyncBackup(PluginController pluginController) {
        this.pluginController = pluginController;
        this.backupController = pluginController.getBackup();
    }

    @Override
    public void run() {



    }
}
