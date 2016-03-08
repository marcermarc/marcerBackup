/*
package de.marcermarc.backup.listener;

import de.marcermarc.backup.controller.PluginController;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

public class NewWorld implements Listener {

    private PluginController controller;

    public NewWorld(PluginController controller) {
        this.controller = controller;
    }

    @EventHandler
    public void onWorldInit(WorldInitEvent worldInit) {
        controller.getBackup().addWorldFolder(worldInit.getWorld().getWorldFolder().getPath());
    }
}
*/
