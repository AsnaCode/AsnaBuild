package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.manager.LocationManager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            p.teleport(LocationManager.getLocation("Spawn"));
            p.sendMessage(Main.prefix + "§7Du wurdest zum §aSpawn §7teleportiert!");
            p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 2F, 1F);
            p.sendTitle("§a§lSPAWN", "");
        }
        return false;
    }
}
