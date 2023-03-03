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
import at.asna.asnabuild.jobs.JobCompletion;
import at.asna.asnabuild.listener.*;
import at.asna.asnabuild.manager.LocationManager;
import at.asna.asnabuild.moderation.*;
import at.asna.asnabuild.money.*;
import at.asna.asnabuild.prefix.ChatPrefix;
import at.asna.asnabuild.prefix.TeamChat;
import at.asna.asnabuild.shop.ShopCommand;
import at.asna.asnabuild.shop.ShopListener;
import at.asna.asnabuild.tablist.TabListManager;
import at.asna.asnabuild.verkaufen.VeraufCommand;
import at.asna.asnabuild.verkaufen.VerkaufListener;
import at.asna.asnabuild.warps.WarpGuiInteract;
import at.asna.asnabuild.warps.WarpsCommand;
import at.asna.asnabuild.warps.setWarpCommand;
import com.sun.security.auth.UnixNumericGroupPrincipal;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public final class Main extends JavaPlugin {

    //STRINGS
    public static String prefix = "§aAsna§fCode §8» §7";
    public static String noperm = prefix + "§cDafür hast du keine Rechte!";

    public static String console = prefix + "§cDafür musst du ein §aSpieler sein!";
    public static String notonline = prefix + "§7Dieser §aSpieler §7ist nicht online!";

    //DISCORD


    private static CoinsAPI coinsAPI;
    public static JDA jda;


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
        JobCompletion.setJobCompletion(this);

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
        pm.registerEvents(new JobCompletion(), this);
        pm.registerEvents(new MuteChatListener(), this);
        pm.registerEvents(new VerkaufListener(), this);
        pm.registerEvents(new ChatListener(), this);



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
        this.getCommand("uuid").setExecutor(new UniqueIDCommand());
        this.getCommand("mutechat").setExecutor(new MuteChatCommand());
        this.getCommand("sign").setExecutor(new SignCommand());
        this.getCommand("rename").setExecutor(new RenameCommand());
        this.getCommand("ip").setExecutor(new IpCommand());
        this.getCommand("tpa").setExecutor(new TpaCommand());
        this.getCommand("sun").setExecutor(new SunCommand());
        this.getCommand("rain").setExecutor(new RainCommand());
        this.getCommand("entchant").setExecutor(new EntchantCommand());
        this.getCommand("repair").setExecutor(new RepairCommand());
        this.getCommand("verkaufen").setExecutor(new VeraufCommand());
        this.getCommand("ping").setExecutor(new PingCommand());
        this.getCommand("pchatclear").setExecutor(new PClearChatCommand());
        this.getCommand("nick").setExecutor(new NickCommand());
        this.getCommand("bug").setExecutor(new BugCommand());
        this.getCommand("report").setExecutor(new ReportCommand());

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
        this.getCommand("tempban").setExecutor(new TempBanCommand());



        //CONFIG
        if (!(new File(getDataFolder(), "config.yml")).exists())
            saveResource("config.yml", false);

        //DISCORD
        try {
            jda = JDABuilder.createDefault(getConfig().getString("TOKEN"))
                    .setStatus(OnlineStatus.DO_NOT_DISTURB)
                    .setActivity(Activity.playing("Powered by AsnaCode.de"))
                    .build().awaitReady();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendStartEmbed();

        //AUTOMESSAGE
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(Main.prefix + "§7Reporte uns Bugs mit §a/Bug <text>");
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 900*20, 900*20);

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(Main.prefix + "§7Join doch gerne unseren Discord mit &a/Social");
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 1800*20, 1800*20);

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(Main.prefix + "§7Solltest du Probleme haben melde dich doch gerne im Support!");
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 3600*20, 3600*20);


    }




    @Override
    public void onDisable() {
        //STOP
        Bukkit.getConsoleSender().sendMessage("§cAsnaBuild §7wurde gestopt!");
        stopStartEmbed();

        //COINSAPI

        try {
            CoinsAPIImpl.saveConfiguration(this);
            JobCompletion.saveConfiguration(this);
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

    public void sendStartEmbed(){
        TextChannel channel = jda.getTextChannelById(getConfig().getString("CHANNEL_ID"));

        EmbedBuilder embed = new EmbedBuilder();

        embed.setColor(new Color(69, 255, 3));
        embed.setTitle("Server Start");
        embed.setDescription("Powered by Asnacode.de");

        channel.sendMessageEmbeds(embed.build()).queue();
    }

    public void stopStartEmbed(){
        TextChannel channel = jda.getTextChannelById(getConfig().getString("CHANNEL_ID"));

        EmbedBuilder embed = new EmbedBuilder();

        embed.setColor(new Color(255, 3, 24));
        embed.setTitle("Server Stop");
        embed.setDescription("Powered by Asnacode.de");

        channel.sendMessageEmbeds(embed.build()).queue();
    }

    public static JDA getJda(){
        return jda;
    }


}
