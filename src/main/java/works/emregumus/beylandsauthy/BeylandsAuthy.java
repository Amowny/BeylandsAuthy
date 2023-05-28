package works.emregumus.beylandsauthy;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import works.emregumus.beylandsauthy.Commands.AuthyCommand;
import works.emregumus.beylandsauthy.Commands.AuthyTabComplete;
import works.emregumus.beylandsauthy.Listener.AuthListener;
import works.emregumus.beylandsauthy.Listener.BlockedListener;
import works.emregumus.beylandsauthy.Utils.ConfigUtil;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public final class BeylandsAuthy extends JavaPlugin{
    private static BeylandsAuthy instance;
    private static BukkitAudiences adventure;
    public static ArrayList<UUID> authlocked;

    @Override
    public void onEnable() {
        instance = this;
        adventure = BukkitAudiences.create(this);

        getServer().getPluginManager().registerEvents(new AuthListener(), this);
        getServer().getPluginManager().registerEvents(new BlockedListener(), this);


        Objects.requireNonNull(Bukkit.getPluginCommand("beyauthy")).setExecutor(new AuthyCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("beyauthy")).setTabCompleter(new AuthyTabComplete());

        authlocked = new ArrayList<UUID>();

        loadConfig();
    }

    @Override
    public void onDisable() {
    }

    public static BeylandsAuthy getInstance() {
        return instance;
    }
    public static BukkitAudiences getAdventure() {
        return adventure;
    }
    private void loadConfig() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        reloadConfig();
        ConfigUtil.reloadConfigs();
    }
}
