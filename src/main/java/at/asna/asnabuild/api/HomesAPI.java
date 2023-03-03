package at.asna.asnabuild.api;

import at.asna.asnabuild.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.List;

public class HomesAPI {
    public static File ordner = new File("plugins/AsnaBuild/homes");

    public static void loadHomes() {
        if (!ordner.exists())
            ordner.mkdirs();
    }


    public static void removeHome(Player p, String name) {
        File homes = new File(ordner, String.valueOf(p.getUniqueId()));
        YamlConfiguration homeconfig = YamlConfiguration.loadConfiguration(homes);
        List<String> homelist = homeconfig.getStringList("homes");
        if (ifHomeExist(p, name)) {
            homeconfig.set(name + ".world", null);
            homeconfig.set(name + ".x", null);
            homeconfig.set(name + ".y", null);
            homeconfig.set(name + ".z", null);
            homeconfig.set(name + ".pitch", null);
            homeconfig.set(name + ".yaw", null);
            homelist.remove(name);
            homeconfig.set("homes", homelist);
            try {
                homeconfig.save(homes);
            } catch (Exception exception) {}
        }
    }

    public static void newHome(Player p, String name) {
        File homes = new File(ordner, String.valueOf(p.getUniqueId()));
        YamlConfiguration homeconfig = YamlConfiguration.loadConfiguration(homes);
        List<String> homelist = homeconfig.getStringList("homes");
        String world = p.getWorld().getName();
        double x = p.getLocation().getX();
        double y = p.getLocation().getY();
        double z = p.getLocation().getZ();
        double pitch = p.getLocation().getPitch();
        double yaw = p.getLocation().getYaw();
        if (!homelist.contains(name)) {
            homeconfig.set(name + ".world", world);
            homeconfig.set(name + ".x", Double.valueOf(x));
            homeconfig.set(name + ".y", Double.valueOf(y));
            homeconfig.set(name + ".z", Double.valueOf(z));
            homeconfig.set(name + ".pitch", Double.valueOf(pitch));
            homeconfig.set(name + ".yaw", Double.valueOf(yaw));
            homelist.add(name);
            homeconfig.set("homes", homelist);
            try {
                homeconfig.save(homes);
            } catch (Exception exception) {}
        } else {
            p.sendMessage(Main.prefix + "§7Dieses Zuhause gibt es bereits!");
        }
    }

    public static List<String> getListOfHomes(Player p) {
        File homes = new File(ordner, String.valueOf(p.getUniqueId()));
        YamlConfiguration homeconfig = YamlConfiguration.loadConfiguration(homes);
        return homeconfig.getStringList("homes");
    }

    public static Location getHome(Player p, String name) {
        File homes = new File(ordner, String.valueOf(p.getUniqueId()));
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(homes);
        String world = cfg.getString(name + ".world");
        double x = cfg.getDouble(name + ".x");
        double y = cfg.getDouble(name + ".y");
        double z = cfg.getDouble(name + ".z");
        double pitch = cfg.getDouble(name + ".pitch");
        double yaw = cfg.getDouble(name + ".yaw");
        Location loc = new Location(Bukkit.getWorld(world), x, y, z);
        loc.setPitch((float)pitch);
        loc.setYaw((float)yaw);
        return loc;
    }

    public static boolean ifHomeExist(Player p, String name) {
        File homes = new File(ordner, String.valueOf(p.getUniqueId()));
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(homes);
        return cfg.getStringList("homes").contains(name);
    }
}
