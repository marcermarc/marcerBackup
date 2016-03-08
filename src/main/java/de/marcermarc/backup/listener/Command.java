package de.marcermarc.backup.listener;

import de.marcermarc.backup.controller.PluginController;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command implements CommandExecutor {

    private PluginController controller;

    public Command(PluginController controller) {
        this.controller = controller;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] args) {

        if (args.length >= 1) {
            //boolean b;
            return true;
        }

        return false;
    }
}