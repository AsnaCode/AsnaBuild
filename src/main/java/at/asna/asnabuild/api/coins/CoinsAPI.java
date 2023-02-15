package at.asna.asnabuild.api.coins;

import org.bukkit.entity.Player;

import java.util.UUID;

public interface CoinsAPI {

    int getCoins(UUID player);

    void removeMoney(Player player, int amount);

    void addMoney(Player player, int amount);

    void sendMoney(Player sender, Player target, int amount);
}
