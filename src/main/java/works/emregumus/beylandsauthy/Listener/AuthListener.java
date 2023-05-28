package works.emregumus.beylandsauthy.Listener;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import works.emregumus.beylandsauthy.BeylandsAuthy;
import works.emregumus.beylandsauthy.Config.MessageConfig;
import works.emregumus.beylandsauthy.Utils.AdventureUtil;
import works.emregumus.beylandsauthy.Utils.ConfigUtil;

public class AuthListener implements Listener {

    YamlConfiguration databaseconfig = ConfigUtil.getConfig("DataBase.yml");

    public boolean playerInputCode(Player player, int kod){
        String secretkey = BeylandsAuthy.getInstance().getConfig().getString("2ad_kodları." + player.getUniqueId());

        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        boolean isCodeValid = gAuth.authorize(secretkey, kod);

        if (isCodeValid){
            BeylandsAuthy.authlocked.remove(player.getUniqueId());
            return true;
        }
        return isCodeValid;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!BeylandsAuthy.getInstance().getConfig().contains("2ad_kodları." + player.getUniqueId())) {
            AdventureUtil.sendMessage(player, MessageConfig.ikiad_etkin_degil);
            AdventureUtil.sendMessage(player, MessageConfig.ikiad_etkin_degil_iki);
        } else {
            BeylandsAuthy.authlocked.add(player.getUniqueId());
            AdventureUtil.sendMessage(player, MessageConfig.prefix + MessageConfig.ikiad_kodunuzu_girin);
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            try {
                int kod = Integer.parseInt(message);
                if (playerInputCode(player, kod)){
                    BeylandsAuthy.authlocked.remove(player.getUniqueId());
                    AdventureUtil.sendMessage(player, MessageConfig.prefix + MessageConfig.ikiad_kodunuz_dogrulandi);
                } else {
                    AdventureUtil.sendMessage(player, MessageConfig.prefix + MessageConfig.ikiad_kodunuz_dogrulanamadi);
                }
            } catch (NumberFormatException e){
                AdventureUtil.sendMessage(player, MessageConfig.prefix + MessageConfig.ikiad_kodunuz_dogrulanamadi_sadecerakam);
            }
            event.setCancelled(true);
        }
    }
}
