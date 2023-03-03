package at.asna.asnabuild.commands;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SignCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("system.sign")) {
                if (args.length >= 1) {
                    if (p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() != Material.AIR) {
                        ItemStack itemnew = p.getInventory().getItemInMainHand();
                        ItemMeta itemnewmeta = itemnew.getItemMeta();
                        try {
                            if (itemnewmeta.hasLore()) {
                                if (!((String)itemnewmeta.getLore().get(2)).contains("")) {
                                        String Message= "";
                                for (int i = 0; i < args.length; i++)
                                    Message = String.valueOf(Message) + args[i] + " ";
                                p.sendMessage(Main.prefix + "§7Das §aItem §7wurde signiert!");
                                Date date = new Date(System.currentTimeMillis());
                                String mm_dd_yyyy = (new SimpleDateFormat("dd.MM.yyyy")).format(date);
                                itemnewmeta.setLore(Arrays.asList(new String[] { " ", "§7" + Message.replaceAll("&", "§"), "§8----------------------------------------------" ,"§7Signiert von §a" + p.getName() + " §7am §a" + mm_dd_yyyy }));
                                itemnew.setItemMeta(itemnewmeta);
                } else {
                                    p.sendMessage(Main.prefix + "§7Dieses §aItem §7ist bereits signiert!");
                                }
                            } else {
                                String Message = "";
                                for (int i = 0; i < args.length; i++)
                                    Message = String.valueOf(Message) + args[i] + " ";
                                p.sendMessage(Main.prefix + "§7Das §aItem §7wurde signiert!");
                                Date date = new Date(System.currentTimeMillis());
                                String mm_dd_yyyy = (new SimpleDateFormat("dd.MM.yyyy")).format(date);
                                itemnewmeta.setLore(Arrays.asList(new String[] { " ", "§7" + Message.replaceAll("&", "§"), "§8----------------------------------------------" ,"§7Signiert von §a" + p.getName() + " §7am §a" + mm_dd_yyyy }));
                                itemnew.setItemMeta(itemnewmeta);
                                p.getInventory().setItemInMainHand(itemnew);
              }
                            } catch (Exception exception) {}
                        } else {
                            p.sendMessage(Main.prefix + "§7Du musst ein §aItem §7in der Hand halten!");
                        }
                    } else {
                        p.sendMessage(Main.prefix + "§7Verwendung: §a/Sign <text>");
                    }
                } else {
                    p.sendMessage(Main.noperm);
                }
            } else {
                Bukkit.getConsoleSender().sendMessage(Main.console);
            }
            return true;
        }
    }
