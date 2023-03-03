package at.asna.asnabuild.homes;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.api.HomesAPI;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;
        if (args.length == 0) {
            List<String> home = HomesAPI.getListOfHomes(p);
            if (home.isEmpty()) {
                p.sendMessage("§7§m----------§8[§aHomes§8]§7§m----------");
                p.sendMessage("§7 ");
                p.sendMessage("§7Du besitzt keine §aHomes§7!");
                p.sendMessage("§a ");
                p.sendMessage("§7§m----------§8[§aHomes§8]§7§m----------");
                return true;
            }
            p.sendMessage("§7§m----------§8[§aHomes§8]§7§m----------");
            p.sendMessage("§7 ");
            List<String> str = new ArrayList<>();
            List<String> str2 = new ArrayList<>();
            int i;
            for (i = 0; i < home.size(); i++){
                Location loc = HomesAPI.getHome(p, home.get(i));
                str.add(home.get(i));
                str2.add(loc.getWorld().getName());
            }
            for (i = 0; i < home.size(); i++)
                p.sendMessage("§7" + str.get(i) + " §8[§aWORLD§7: " + str2.get(i) + "§8]");
            p.sendMessage("§7§m----------§8[§aHomes§8]§7§m----------");

        } else {
            p.sendMessage(Main.prefix + "§7Verwendung: §a/Homes");
        }


        return false;
    }
}
