package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MuteChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;
        if (p.hasPermission("system.mutechat")){
            if (args.length == 1){
                if (args[0].equals("aus")){
                    if (Main.getInstance().getConfig().getBoolean("MuteChat") == false){
                        p.sendMessage(Main.prefix + "§7Der §aMuteChat §7ist bereits ausgeschalten!");
                    } else if (Main.getInstance().getConfig().getBoolean("MuteChat") == true){
                        Main.getInstance().getConfig().set("MuteChat", false);
                        Main.getInstance().saveConfig();
                        Bukkit.broadcastMessage(Main.prefix + "§7Der §aMuteChat §7wurde deaktiviert von §a" + p.getDisplayName());
                    }
                } else if (args[0].equals("an")) {
                    if (Main.getInstance().getConfig().getBoolean("MuteChat") == true){
                        p.sendMessage(Main.prefix + "§7Der §aMuteChat §7ist bereits eingeschalten!");
                    } else if (Main.getInstance().getConfig().getBoolean("MuteChat") == false){
                        Main.getInstance().getConfig().set("MuteChat", true);
                        Main.getInstance().saveConfig();
                        Bukkit.broadcastMessage(Main.prefix + "§7Der §aMuteChat §7wurde aktiviert von §a" + p.getDisplayName());
                    }
            }
        } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §a/Mutechat <an/aus>");
            }
        } else {
            p.sendMessage(Main.noperm);
        }

        return false;
    }
}
