package de.marcermarc.backup.controller;

public class ConfigController {

    private PluginController controller;

    public ConfigController(PluginController controller) {
        this.controller = controller;

        setDefaultConfig();
    }

    private void setDefaultConfig() {

        controller.getMain().getConfig().options().copyDefaults(true);
        controller.getMain().saveDefaultConfig();

    }


    //region getters and setters

    //endregion


}
