package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.manager.LocationManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("system.setspawn")) {
                if (args.length == 0) {
                    String spawn = "Spawn";
                    LocationManager.setLocation(p.getLocation(), spawn);
                    p.sendMessage(Main.prefix + "§7Du hast erfolgreich den §aSpawn §7gesetzt!");
                }
            } else {
                p.sendMessage(Main.noperm);
            }
        }
        return false;
    }
}
