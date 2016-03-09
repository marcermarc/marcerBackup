package de.marcermarc.backup.controller;

import de.marcermarc.backup.Main;
import de.marcermarc.backup.tasks.StartBackup;

public class PluginController {
    private ConfigController config;
    private BackupController backup;
    private Main main;
    private StartBackup startBackup;

    public PluginController(Main main) {
        this.main = main;
        this.backup = new BackupController(this);
        this.startBackup = new StartBackup(this);
    }

    public ConfigController getConfig() {
        return config;
    }

    public void setConfig(ConfigController config) {
        this.config = config;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public StartBackup getStartBackup() {
        return startBackup;
    }

    public BackupController getBackup() {
        return backup;
    }
}
