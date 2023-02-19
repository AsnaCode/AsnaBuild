package at.asna.asnabuild;

import at.asna.asnabuild.api.*;
import at.asna.asnabuild.commands.*;
import at.asna.asnabuild.daily.DailyCommand;
import at.asna.asnabuild.daily.DailyListener;
import at.asna.asnabuild.homes.DelHomeCommand;
import at.asna.asnabuild.homes.HomeCommand;
import at.asna.asnabuild.homes.HomesCommand;
import at.asna.asnabuild.homes.SetHomeCommand;
import at.asna.asnabuild.jobs.JobCommand;
import at.asna.asnabuild.listener.*;
import at.asna.asnabuild.manager.LocationManager;
import at.asna.asnabuild.moderation.*;
import at.asna.asnabuild.money.*;
import at.asna.asnabuild.prefix.ChatPrefix;
import at.asna.asnabuild.prefix.TeamChat;
import at.asna.asnabuild.shop.ShopCommand;
import at.asna.asnabuild.shop.ShopListener;
import at.asna.asnabuild.tablist.TabListManager;
import at.asna.asnabuild.warps.WarpGuiInteract;
import at.asna.asnabuild.warps.WarpsCommand;
import at.asna.asnabuild.warps.setWarpCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {

    //STRINGS
    public static String prefix = "§6AsnaCode§7.§6de §8» §7";
    public static String noperm = prefix + "§cDafür hast du keine Rechte!";

    public static String console = prefix + "§cDafür musst du ein Spieler sein!";
    public static String notonline = prefix + "§7Dieser §eSpieler §7ist nicht online!";

    private static CoinsAPI coinsAPI;


    //INSTANCE
    private static Main instance;

    private TabListManager tabListManager;

    @Override
    public void onEnable() {
        //START
        Bukkit.getConsoleSender().sendMessage("§aAsnaBuild §7wurde gestartet!");
        instance = this;
        this.tabListManager = new TabListManager();

        //COINSAPI
        try {
            coinsAPI = new CoinsAPIImpl(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //MANAGER
        LocationManager.setup();
        HomesAPI.loadHomes();

        //LISTENER
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new WartungenListener(), this);
        pm.registerEvents(new WeatherTimeListener(), this);
        pm.registerEvents(new ChatPrefix(), this);
        pm.registerEvents(new WarpGuiInteract(), this);
        pm.registerEvents(new INteractListener(), this);
        pm.registerEvents(new DailyListener(this), this);
        pm.registerEvents(new DeathListener(), this);
        pm.registerEvents(new AntiPLuginListener(), this);
        pm.registerEvents(new ShopListener(), this);
        pm.registerEvents(new TeamChat(), this);



        //COMMANDS

        this.getCommand("setspawn").setExecutor(new SetSpawnCommand());
        this.getCommand("spawn").setExecutor(new SpawnCommand());
        this.getCommand("wartungen").setExecutor(new WartungenCommand());
        this.getCommand("gamemode").setExecutor(new GamemodeCommand());
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("clearchat").setExecutor(new ClearChatCommand());
        this.getCommand("teleport").setExecutor(new TeleportCommand());
        this.getCommand("teleporthere").setExecutor(new TphereCommand());
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("food").setExecutor(new FoodCommand());
        this.getCommand("invsee").setExecutor(new InvseeCommand());
        this.getCommand("skull").setExecutor(new SkullCommand());
        this.getCommand("giveaway").setExecutor(new GiveawayCommand());
        this.getCommand("hilfe").setExecutor(new HilfeCommand());
        this.getCommand("setwarp").setExecutor(new setWarpCommand());
        this.getCommand("warps").setExecutor(new WarpsCommand());
        this.getCommand("daily").setExecutor(new DailyCommand());
        this.getCommand("enderchest").setExecutor(new EnderChestCommand());
        this.getCommand("broadcast").setExecutor(new BroadCastCommand());
        this.getCommand("social").setExecutor(new SocialCommand());
        this.getCommand("msg").setExecutor(new MSGCommand());
        this.getCommand("craft").setExecutor(new CraftCommand());
        this.getCommand("anvil").setExecutor(new AnvilCommand());
        this.getCommand("day").setExecutor(new DayCommand());
        this.getCommand("night").setExecutor(new NightCommand());
        this.getCommand("shop").setExecutor(new ShopCommand());
        this.getCommand("vanish").setExecutor(new VanishCommand());

        //MONEY
        this.getCommand("money").setExecutor(new MoneyCommand());
        this.getCommand("addmoney").setExecutor(new AddMoneyCommand());
        this.getCommand("removemoney").setExecutor(new RemoveMoneyCommand());
        this.getCommand("pay").setExecutor(new PayCommand());
        this.getCommand("setmoney").setExecutor(new SetMoney());

        //JOBS
        this.getCommand("job").setExecutor(new JobCommand());

        //HOMES
        this.getCommand("sethome").setExecutor(new SetHomeCommand());
        this.getCommand("home").setExecutor(new HomeCommand());
        this.getCommand("homes").setExecutor(new HomesCommand());
        this.getCommand("delhome").setExecutor(new DelHomeCommand());

        //MODERATION
        this.getCommand("kick").setExecutor(new KickCommand());
        this.getCommand("ban").setExecutor(new BanCommand());
        this.getCommand("unban").setExecutor(new UnBanCommand());
        this.getCommand("rang").setExecutor(new RangCommand());



        //CONFIG
        if (!(new File(getDataFolder(), "config.yml")).exists())
            saveResource("config.yml", false);
    }

    @Override
    public void onDisable() {
        //STOP
        Bukkit.getConsoleSender().sendMessage("§cAsnaBuild §7wurde gestopt!");

        //COINSAPI

        try {
            CoinsAPIImpl.saveConfiguration(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static Main getInstance(){
        return instance;
    }

    public TabListManager getTabListManager(){
        return this.tabListManager;
    }

    public static CoinsAPI getCoinsAPI() {
        return coinsAPI;
    }

}
