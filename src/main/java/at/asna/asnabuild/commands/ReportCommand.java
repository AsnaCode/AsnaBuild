package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static at.asna.asnabuild.Main.jda;

public class ReportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (args.length >= 2){
            String msg = " ";
            for (int i = 1; i < args.length; i++)
                msg = msg + args[i] + " ";
            Player opfer = Bukkit.getPlayer(args[0]);

            p.sendMessage(Main.prefix + "§7Du hast erfolgreich den Spieler §a" + opfer.getDisplayName() + " §7wegen §a" + msg + " §7reportet!");

            for (Player teamler : Bukkit.getOnlinePlayers()){
                if (teamler.hasPermission("system.report.see")){
                    teamler.sendMessage("§7§m----------§8[§aREPORT§8]§7§m----------");
                    teamler.sendMessage("§7Von: §a" + p.getDisplayName());
                    teamler.sendMessage("§7Spieler: §a" + opfer.getDisplayName());
                    teamler.sendMessage("§7Beschreibung: §a" + msg);
                    teamler.sendMessage("§7§m----------§8[§aREPORT§8]§7§m----------");
                }
            }

            TextChannel channel = jda.getTextChannelById(Main.getInstance().getConfig().getString("REPORT_ID"));

            EmbedBuilder embed = new EmbedBuilder();

            embed.setColor(new Color(255, 3, 24));
            embed.setTitle("Report von " + p.getDisplayName());
            embed.setDescription("Grund: " + msg);
            embed.setAuthor("Spieler: " + opfer.getDisplayName());

            channel.sendMessageEmbeds(embed.build()).queue();

        } else {
            p.sendMessage(Main.prefix + "§7Verwendung: §a/Report <name> <grund>");
        }

        return false;
    }
}
