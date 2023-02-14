package at.asna.asnabuild;

import at.asna.asnabuild.commands.SetSpawnCommand;
import at.asna.asnabuild.commands.SpawnCommand;
import at.asna.asnabuild.listener.JoinListener;
import at.asna.asnabuild.manager.LocationManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    //STRINGS
    public static String prefix = "§6AsnaCode§7.§6de §8» §7";
    public static String noperm = prefix + "§cDafür hast du keine Rechte!";

    //INSTANCE
    private static Main instance;

    @Override
    public void onEnable() {
        //START
        Bukkit.getConsoleSender().sendMessage("§aAsnaBuild §7wurde gestartet!");
        instance = this;

        //MANAGER
        LocationManager.setup();

        //LISTENER
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new JoinListener(), this);

        //COMMANDS

        this.getCommand("setspawn").setExecutor(new SetSpawnCommand());
        this.getCommand("spawn").setExecutor(new SpawnCommand());

        //CONFIG
        if (!(new File(getDataFolder(), "config.yml")).exists())
            saveResource("config.yml", false);
    }

    @Override
    public void onDisable() {
        //STOP
        Bukkit.getConsoleSender().sendMessage("§cAsnaBuild §7wurde gestopt!");
    }

    public static Main getInstance(){
        return instance;
    }

}
