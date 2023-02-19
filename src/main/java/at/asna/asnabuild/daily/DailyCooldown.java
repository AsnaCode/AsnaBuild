package at.asna.asnabuild.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DailyCooldown {
    private final Map<UUID, Integer> cooldowns = new HashMap<>();

    public static final int DEFAULT_COOLDOWN = 86400;

    public void setCooldown(UUID player, int time) {
        if (time < 1) {
            this.cooldowns.remove(player);
        } else {
            this.cooldowns.put(player, Integer.valueOf(time));
        }
    }

    public int getCooldown(UUID player) {
        return ((Integer)this.cooldowns.getOrDefault(player, Integer.valueOf(0))).intValue();
    }
}
