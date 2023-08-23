package com.github.tritricera.test.server;

import com.sun.tools.jconsole.JConsoleContext;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import static java.awt.SystemColor.text;

public final class Server_plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
       getLogger().info("plugin was read");
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Thanks for using this plugin.");
    }
    public boolean onCommand(CommandSender sender, Command commnad, String label, String args[]) {
        if (commnad.getName().equalsIgnoreCase("nice")) {
            if (args.length == 2) {
                if (sender instanceof Player) {
                    //sender is player
                    Player player = (Player) sender;
                    String senderr1 = sender.getName();
                    nicechat(args[0], senderr1, args[1]);
                } else {
                    //sender isn't player
                    sender.sendMessage("can't use on console");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "[ServerPlugin] command is wrong");
            }
            return true;
        }
        return true;
    }
    public static void nicechat(String player,String sender1,String Text) {
        //exetuce command "/tellraw @a ["",{"text":"<args[0]>","hoverEvent":{"action":"show_text","contents":"sender"}},{"text":"args[1]"}]"
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"tellraw @a [\"\",{\"text\":\"<" + player + ">\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"Sendername:" + sender1 + "\"}},{\"text\":\" " + Text + "\"}]");
    }
    //sender.sendMessage("<" + args[0] + ">" + " " + args[1]);
}