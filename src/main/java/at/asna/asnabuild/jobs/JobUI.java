package at.asna.asnabuild.jobs;

import at.asna.asnabuild.Main;
import at.asna.asnabuild.api.InventoryAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class JobUI implements InventoryHolder {

    private final Inventory inventory;
    private final Player player;

    public JobUI(Player player) {
        this.player = player;
        this.inventory = Bukkit.createInventory(this, 3 * 9, "§8| §aJobs §7✗ §aArbeit §8|");

        InventoryAPI.drawOutline(inventory, 3);

        initInventory();
        player.openInventory(inventory);
    }

    protected void initInventory() {

        //MinerItemStack
        ItemStack minerStack = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta minerMeta = minerStack.getItemMeta();
        minerMeta.setDisplayName("§8» §aMiner");


        List<String> lore0 = new ArrayList<>();
        lore0.add("§7Werde ein Minenarbeiter und bekomme pro Kohle, Eisen, Gold- oder Diamanterz 3€!");

        minerMeta.setLore(lore0);
        minerStack.setItemMeta(minerMeta);
        getInventory().setItem(11, minerStack);


        //LumberjackItemStack
        ItemStack lumberjackItemStack = new ItemStack(Material.WOODEN_AXE);
        ItemMeta mergeItemMeta = lumberjackItemStack.getItemMeta();
        mergeItemMeta.setDisplayName("§8» §aHolzfäller");

        List<String> lore1 = new ArrayList<>();
        lore1.add("§7Werde ein Holzfäller und bekomme pro gefällten Stamm 2€!");


        mergeItemMeta.setLore(lore1);
        lumberjackItemStack.setItemMeta(mergeItemMeta);
        getInventory().setItem(15, lumberjackItemStack);

        //ZURÜCKSETZEN
        ItemStack zurücksetzen = new ItemStack(Material.BARRIER);
        ItemMeta zurücksetzenm = lumberjackItemStack.getItemMeta();
        mergeItemMeta.setDisplayName("§8» §aKündigen");

        List<String> lore2 = new ArrayList<>();
        lore1.add("§7Kündige deinen Job!");


        zurücksetzenm.setLore(lore2);
        zurücksetzen.setItemMeta(mergeItemMeta);
        getInventory().setItem(13, zurücksetzen);



    }


    public void onClick(ItemStack stack, int slot, ClickType clickType) {
        switch (slot) {
            case 11: {
                if (JobCompletion.getJob(player.getUniqueId()) != JobCompletion.Job.MINER) {
                    //SET LUMBERJACK
                    JobCompletion.setJob(player.getUniqueId(), JobCompletion.Job.MINER);
                    player.sendMessage(Main.prefix + "Du bist jetzt ein §aMiner§7. Du kannst Geld durch das abbauen von Erzen erhalten!");
                    player.closeInventory();
                } else {
                    player.sendMessage(Main.prefix + "§7Du bist bereits §aMiner§7.");
                }
                break;
            }
            case 15: {
                if (JobCompletion.getJob(player.getUniqueId()) != JobCompletion.Job.LUMBERJACK) {
                    //SET MINER MINER
                    JobCompletion.setJob(player.getUniqueId(), JobCompletion.Job.LUMBERJACK);
                    player.sendMessage(Main.prefix + "Du bist jetzt ein §aHolzfäller§7. Du kannst Geld durch das fällen von Bäumen erhalten!");
                    player.closeInventory();
                } else {
                    player.sendMessage(Main.prefix + "§7Du bist bereits §aHolzfäller§7.");
                }
                break;
            }
            case 13: {
                if (JobCompletion.getJob(player.getUniqueId()) == JobCompletion.Job.LUMBERJACK) {
                    JobCompletion.setJob(player.getUniqueId(), JobCompletion.Job.NONE);
                    player.sendMessage(Main.prefix + "Du bist jetzt §aArbeitslos§7.");
                } else if (JobCompletion.getJob(player.getUniqueId()) == JobCompletion.Job.MINER) {
                    JobCompletion.setJob(player.getUniqueId(), JobCompletion.Job.NONE);
                    player.sendMessage(Main.prefix + "Du bist jetzt §aArbeitslos§7.");
                } else {
                    player.sendMessage(Main.prefix + "§7Du bist bereits §aArbeitslos§7.");
                }
            }
        }
    }


    @Override
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }
}