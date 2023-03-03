package at.asna.asnabuild.listener;

import at.asna.asnabuild.Main;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;

import static at.asna.asnabuild.Main.jda;

public class ChatListener implements Listener {

    @EventHandler
    public void OnChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();

        TextChannel channel = jda.getTextChannelById(Main.getInstance().getConfig().getString("CHANNEL_TEAM_ID"));

        EmbedBuilder embed = new EmbedBuilder();

        embed.setColor(new Color(3, 175, 255));
        embed.setTitle(e.getMessage().replaceAll("§f", "").replaceAll("§b", "").replaceAll("§a", "").replaceAll("§c", "").replaceAll("§d", "").replaceAll("§0", "").replaceAll("§1", "").replaceAll("§2", "").replaceAll("§3", "").replaceAll("§4", "").replaceAll("§5", "").replaceAll("§6", "").replaceAll("§7", "").replaceAll("§8", "").replaceAll("§9", "").replaceAll("§l", "").replaceAll("§m", "").replaceAll("§k", ""));
        embed.setDescription("Powered by AsnaCode.de");
        embed.setAuthor(player.getName(), null, "https://crafatar.com/avatars/" + player.getUniqueId());

        channel.sendMessageEmbeds(embed.build()).queue();
    }


}




