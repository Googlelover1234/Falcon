package net.verendus.cmds;

import net.verendus.managers.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Jeremy Gooch on 4/24/15.
 */
public class FalconCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("falcon")) {
            if (args.length == 0) {
                sender.sendMessage(new String[]{ChatColor.GREEN + ConfigManager.getInstance().getDesc().getName() + ChatColor.GRAY + " version " + ChatColor.GREEN + ConfigManager.getInstance().getDesc().getVersion(),
                        ChatColor.GRAY + ConfigManager.getInstance().getDesc().getDescription(),
                        ChatColor.GREEN + "Author: " + ChatColor.GRAY + "Jeremy Gooch (Googlelover1234)"});
            }

            if (args.length == 1) {
                if (!args[0].equalsIgnoreCase("reload")) {
                    sender.sendMessage(ChatColor.RED + "Unknown command!");
                    return true;
                }
                ConfigManager.getInstance().reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "Configuration Reloaded!");
                return true;
            }
        }
        return true;
    }
}
