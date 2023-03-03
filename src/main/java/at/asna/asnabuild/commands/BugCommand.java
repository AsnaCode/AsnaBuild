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

public class BugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player p = (Player) sender;

        if (args.length >= 1){
            String msg = " ";
            for (int i = 0; i < args.length; i++)
                msg = msg + args[i] + " ";

            for (Player teamler : Bukkit.getOnlinePlayers()){
                if (teamler.hasPermission("system.bug.see")){
                    teamler.sendMessage("§7§m----------§8[§aBUG§8]§7§m----------");
                    teamler.sendMessage("§7Von: §a" + p.getDisplayName());
                    teamler.sendMessage("§7Beschreibung: §a" + msg);
                    teamler.sendMessage("§7§m----------§8[§aBUG§8]§7§m----------");
                }
            }
                TextChannel channel = jda.getTextChannelById(Main.getInstance().getConfig().getString("REPORT_ID"));

                EmbedBuilder embed = new EmbedBuilder();

                embed.setColor(new Color(255, 3, 24));
                embed.setTitle("Bug Report von " + p.getDisplayName());
                embed.setDescription("Bug: " + msg);

                channel.sendMessageEmbeds(embed.build()).queue();




        }

        return false;
    }

}
