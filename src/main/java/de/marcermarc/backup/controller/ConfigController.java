package de.marcermarc.backup.controller;

public class ConfigController {

    private PluginController controller;

    private String startMessage, endMessage;
    private int intervalInMin;

    public ConfigController(PluginController controller) {
        this.controller = controller;

        setDefaultConfig();

        load();
    }

    private void setDefaultConfig() {

        controller.getMain().getConfig().addDefault("intervalInMin", 60);
        controller.getMain().getConfig().addDefault("startMessage", "StartBackup startet");
        controller.getMain().getConfig().addDefault("endMessage", "StartBackup startet");

        controller.getMain().getConfig().options().copyDefaults(true);
        controller.getMain().saveDefaultConfig();

    }

    private void load() {
        startMessage = controller.getMain().getConfig().getString("startMessage");
        endMessage = controller.getMain().getConfig().getString("endMessage");
        intervalInMin = controller.getMain().getConfig().getInt("intervalInMin");

    }

    //region getters and setters

    public String getStartMessage() {
        return startMessage;
    }

    public void setStartMessage(String startMessage) {
        this.startMessage = startMessage;
    }

    public String getEndMessage() {
        return endMessage;
    }

    public void setEndMessage(String endMessage) {
        this.endMessage = endMessage;
    }

    public int getIntervalInMin() {
        return intervalInMin;
    }

    public void setIntervalInMi(int intervalInMin) {
        this.intervalInMin = intervalInMin;
    }

    //endregion


}
