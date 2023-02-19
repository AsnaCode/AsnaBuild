package at.asna.asnabuild.api;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CoinsAPIImpl implements CoinsAPI {

    protected static FileConfiguration configuration;

    protected static Map<UUID, Integer> coinMap;

    public CoinsAPIImpl(JavaPlugin plugin) {
        if (!new File(plugin.getDataFolder() + "/" + "coinsAPI.yml").exists()) {
            plugin.saveResource("coinsAPI.yml", false);
        }
        coinMap = getCoinData(plugin);
    }

    protected Map<UUID, Integer> getCoinData(JavaPlugin plugin) {
        Map<UUID, Integer> data = new HashMap<>();
        configuration = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder() + "/" + "coinsAPI.yml"));

        ConfigurationSection section = this.configuration.getConfigurationSection("api");

        for (String uuid : section.getKeys(false)) {
            data.put(UUID.fromString(uuid), configuration.getInt("api." + uuid + ".job"));
        }
        return data;
    }

    public static void saveConfiguration(JavaPlugin plugin) throws IOException {

        for (UUID uuid : coinMap.keySet()) {
            configuration.set("api." + uuid.toString() + ".job", coinMap.get(uuid));
        }
        configuration.save(new File(plugin.getDataFolder() + "/" + "coinsAPI.yml"));
    }


    /**
     *
     @param player specifies the uuid owner of the coins
      * @return The amount of coins owned by the player
     */

    @Override
    public int getCoins(UUID player) {
        return coinMap.get(player);
    }

    /**
     @param player specifies the owner of the coins
     @param amount defines the target amount that should be removed from the account
     **/

    @Override
    public void removeMoney(Player player, int amount) {
        coinMap.replace(player.getUniqueId(), coinMap.get(player.getUniqueId()) - amount);
    }

    @Override
    public void setMoney(Player player, int amount) {
        coinMap.replace(player.getUniqueId(), coinMap.get(player.getUniqueId()), amount);
    }

    /**
     @param player specifies the owner of the coins
     @param amount defines the target amount that should be added to the account
     **/

    @Override
    public void addMoney(Player player, int amount) {
        coinMap.replace(player.getUniqueId(), coinMap.get(player.getUniqueId()) + amount);
    }




    /**
     @param sender specifies the sender of the amount
     @param target specifies the target of the transmission
     @param amount defines the target amount that should be transferred
     **/
    @Override
    public void sendMoney(Player sender, Player target, int amount) {
        this.removeMoney(sender, amount);
        this.addMoney(target, amount);
    }

    @Override
    public void insertPlayer(Player player) {
        if (!coinMap.containsKey(player.getUniqueId())) {
            coinMap.put(player.getUniqueId(), 0);
        }
    }



}
