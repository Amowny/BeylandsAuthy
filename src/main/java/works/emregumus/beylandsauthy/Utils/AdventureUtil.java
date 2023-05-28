package works.emregumus.beylandsauthy.Utils;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import works.emregumus.beylandsauthy.BeylandsAuthy;

import java.time.Duration;

public class AdventureUtil {
    /**
     * Get component from text
     * @param sender text
     * @return component
     */
    public static void sendMessage(CommandSender sender, String s) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            playerMessage(player, s);
        } else {
            consoleMessage(s);
        }
    }

    public static void consoleMessage(String s) {
        Audience au = BeylandsAuthy.getAdventure().sender((CommandSender)Bukkit.getConsoleSender());
        MiniMessage mm = MiniMessage.miniMessage();
        Component parsed = mm.deserialize(s);
        au.sendMessage(parsed);
    }

    public static void playerMessage(Player player, String s) {
        Audience au = BeylandsAuthy.getAdventure().player(player);
        MiniMessage mm = MiniMessage.miniMessage();
        Component parsed = mm.deserialize(s);
        au.sendMessage(parsed);
    }

    public static void playerTitle(Player player, String s1, String s2, int in, int duration, int out) {
        Audience au = BeylandsAuthy.getAdventure().player(player);
        MiniMessage mm = MiniMessage.miniMessage();
        Title.Times times = Title.Times.times(Duration.ofMillis(in), Duration.ofMillis(duration), Duration.ofMillis(out));
        Title title = Title.title(mm.deserialize(s1), mm.deserialize(s2), times);
        au.showTitle(title);
    }

    public static void playerActionbar(Player player, String s, int i) {
        Audience au = BeylandsAuthy.getAdventure().player(player);
        MiniMessage mm = MiniMessage.miniMessage();
        au.sendActionBar(mm.deserialize(s));
    }

    public static void playerSound(Player player, Sound.Source source, Key key, float volume, float pitch) {
        Sound sound = Sound.sound(key, source, volume, pitch);
        Audience au = BeylandsAuthy.getAdventure().player(player);
        au.playSound(sound);
    }
}
