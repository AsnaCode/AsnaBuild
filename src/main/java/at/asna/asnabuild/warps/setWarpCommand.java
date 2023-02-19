package at.asna.asnabuild.warps;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.manager.LocationManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class setWarpCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;
        if (p.hasPermission("system.setwarp")){
            if (args.length == 1){
                if (args[0].equals("farmwelt")){
                    String farmwelt = "Farmwelt";
                    LocationManager.setLocation(p.getLocation(), farmwelt);
                    p.sendMessage(Main.prefix + "§7Du hast §eFarmwelt §7gesetzt!");
                } else if (args[0].equals("nether")) {
                    String farmwelt = "Nether";
                    LocationManager.setLocation(p.getLocation(), farmwelt);
                    p.sendMessage(Main.prefix + "§7Du hast den §eNether §7gesetzt!");
                } else if (args[0].equals("end")) {
                    String farmwelt = "End";
                    LocationManager.setLocation(p.getLocation(), farmwelt);
                    p.sendMessage(Main.prefix + "§7Du hast den §eEnd §7gesetzt!");
                }
            } else {
                p.sendMessage(Main.prefix + "§7Verwendung: §e/setWarp farmwelt|nether|end");
            }
        }


        return false;
    }
}
