package works.emregumus.beylandsauthy.Commands;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import works.emregumus.beylandsauthy.BeylandsAuthy;
import works.emregumus.beylandsauthy.Config.MessageConfig;
import works.emregumus.beylandsauthy.Utils.AdventureUtil;
import works.emregumus.beylandsauthy.Utils.ConfigUtil;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

public class AuthyCommand implements CommandExecutor {

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length < 1) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                AdventureUtil.sendMessage(player, "<green>Running <aqua>BeyAuthy <green>by <gray>Amownyy <green>for <dark_aqua>BeyLands");
            }
            return true;
        }
        if(args[0].equalsIgnoreCase("reload")){
            ConfigUtil.reloadConfigs();
            long time1 = System.currentTimeMillis();
            if(sender instanceof Player){
                AdventureUtil.playerMessage((Player) sender, MessageConfig.prefix + MessageConfig.reload_basarili.replace("{time}", String.valueOf(System.currentTimeMillis() - time1)));
            }
            else {
                AdventureUtil.consoleMessage(MessageConfig.prefix + MessageConfig.reload_basarili.replace("{time}", String.valueOf(System.currentTimeMillis() - time1)));
            }
            return true;
        }
        if (args.length > 1){
            if (args[0].equalsIgnoreCase("bagla")){
                if (args[1].equalsIgnoreCase("qr")){
                    if (sender instanceof Player){
                        Player player = (Player) sender;
                        if (!BeylandsAuthy.getInstance().getConfig().contains("2ad_kodları." + player.getUniqueId())) {
                            GoogleAuthenticator gAuth = new GoogleAuthenticator();
                            GoogleAuthenticatorKey key = gAuth.createCredentials();
                            GoogleAuthenticatorQRGenerator qrGenerator = new GoogleAuthenticatorQRGenerator();
                            String qr = qrGenerator.getOtpAuthURL("BeyLands", player.getName(), key);


                            AdventureUtil.sendMessage(player, MessageConfig.bagla_qr_basarili.replace("{qr-link}", String.valueOf(qr)));

                            BeylandsAuthy.getInstance().getConfig().set("2ad_kodları." + player.getUniqueId(), key.getKey());
                            BeylandsAuthy.getInstance().saveConfig();
                        } else {
                            BeylandsAuthy.authlocked.add(player.getUniqueId());
                            AdventureUtil.sendMessage(player, MessageConfig.bagla_qr_basarisiz);
                        }
                    }
                }
                if (args[1].equalsIgnoreCase("kod")){
                    if (sender instanceof Player){
                        Player player = (Player) sender;
                        if (!BeylandsAuthy.getInstance().getConfig().contains("2ad_kodları." + player.getUniqueId())) {
                            GoogleAuthenticator gAuth = new GoogleAuthenticator();
                            GoogleAuthenticatorKey key = gAuth.createCredentials();

                            AdventureUtil.sendMessage(player, MessageConfig.bagla_kod_basarili.replace("{auth-code}", String.valueOf(key.getKey())));
                            AdventureUtil.sendMessage(player, MessageConfig.ikiad_etkin_degil_iki);

                            BeylandsAuthy.getInstance().getConfig().set("2ad_kodları." + player.getUniqueId(), key.getKey());
                            BeylandsAuthy.getInstance().saveConfig();
                        } else {
                            BeylandsAuthy.authlocked.add(player.getUniqueId());
                            AdventureUtil.sendMessage(player, MessageConfig.bagla_kod_basarisiz);
                        }
                    }
                }
            }
        }
        if(args[0].equalsIgnoreCase("kaldir")){
            Player player = (Player) sender;
            if (!BeylandsAuthy.getInstance().getConfig().contains("2ad_kodları." + player.getUniqueId())) {
                AdventureUtil.sendMessage(player, MessageConfig.kaldir_basarisiz);
            } else {
                AdventureUtil.sendMessage(player, MessageConfig.kaldir_basarili);
                BeylandsAuthy.getInstance().getConfig().set("2ad_kodları." + player.getUniqueId(), null);
                BeylandsAuthy.getInstance().saveConfig();
            }
            return true;
        }
        if (args.length == 4){
            if (args[0].equalsIgnoreCase("admin")){
                if (args[1].equalsIgnoreCase("bagla")){
                    if (args[2].equalsIgnoreCase("qr")){
                        if (sender instanceof Player){
                            Player player = Bukkit.getPlayer(args[3]);
                            Player admin = (Player) sender;
                            if (player == admin){
                                AdventureUtil.sendMessage(admin, "<red>Kendi Üzerinde Admin Komutu Kullanamazsın!");
                                return true;
                            }else {
                                if (!BeylandsAuthy.getInstance().getConfig().contains("2ad_kodları." + player.getUniqueId())) {
                                    GoogleAuthenticator gAuth = new GoogleAuthenticator();
                                    GoogleAuthenticatorKey key = gAuth.createCredentials();
                                    GoogleAuthenticatorQRGenerator qrGenerator = new GoogleAuthenticatorQRGenerator();
                                    String qr = qrGenerator.getOtpAuthURL("BeyLands", player.getName(), key);


                                    AdventureUtil.sendMessage(player, MessageConfig.admin_bagla_qr_oyuncu_basarili.replace("{qr-link}", String.valueOf(qr)));
                                    AdventureUtil.sendMessage(admin, MessageConfig.admin_bagla_qr_admin_basarili.replace("{qr-link}", String.valueOf(qr)));

                                    BeylandsAuthy.getInstance().getConfig().set("2ad_kodları." + player.getUniqueId(), key.getKey());
                                    BeylandsAuthy.getInstance().saveConfig();
                                } else {
                                    BeylandsAuthy.authlocked.add(player.getUniqueId());
                                    AdventureUtil.sendMessage(player, MessageConfig.admin_bagla_qr_oyuncu_basarisiz);
                                    AdventureUtil.sendMessage(admin, MessageConfig.admin_bagla_qr_admin_basarisiz);
                                }
                            }
                        }
                    }
                    if (args[2].equalsIgnoreCase("kod")){
                        if (sender instanceof Player){
                            Player player = Bukkit.getPlayer(args[3]);
                            Player admin = (Player) sender;
                            if (player == admin){
                                AdventureUtil.sendMessage(admin, "<red>Kendi Üzerinde Admin Komutu Kullanamazsın!");
                                return true;
                            }else {
                                if (!BeylandsAuthy.getInstance().getConfig().contains("2ad_kodları." + player.getUniqueId())) {
                                    GoogleAuthenticator gAuth = new GoogleAuthenticator();
                                    GoogleAuthenticatorKey key = gAuth.createCredentials();

                                    AdventureUtil.sendMessage(player, MessageConfig.admin_bagla_kod_admin_basarili.replace("{auth-code}", String.valueOf(key.getKey())));
                                    AdventureUtil.sendMessage(player, MessageConfig.ikiad_etkin_degil_iki);
                                    AdventureUtil.sendMessage(admin, MessageConfig.admin_kaldir_admin_basarili.replace("{auth-code}", String.valueOf(key.getKey())));

                                    BeylandsAuthy.getInstance().getConfig().set("2ad_kodları." + player.getUniqueId(), key.getKey());
                                    BeylandsAuthy.getInstance().saveConfig();
                                } else {
                                    BeylandsAuthy.authlocked.add(player.getUniqueId());
                                    AdventureUtil.sendMessage(player, MessageConfig.admin_bagla_kod_oyuncu_basarisiz);
                                    AdventureUtil.sendMessage(admin, MessageConfig.admin_bagla_kod_admin_basarisiz);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (args.length == 3){
            if (args[0].equalsIgnoreCase("admin")){
                if (args[1].equalsIgnoreCase("kaldir")){
                    Player player = Bukkit.getPlayer(args[2]);
                    Player admin = (Player) sender;
                    if (player == admin){
                        AdventureUtil.sendMessage(admin, "<red>Kendi Üzerinde Admin Komutu Kullanamazsın!");
                        return true;
                    }else {
                        if (!BeylandsAuthy.getInstance().getConfig().contains("2ad_kodları." + player.getUniqueId())) {
                            AdventureUtil.sendMessage(player, MessageConfig.admin_kaldir_oyuncu_basarisiz);
                            AdventureUtil.sendMessage(admin, MessageConfig.admin_kaldir_admin_basarisiz);
                        } else {
                            AdventureUtil.sendMessage(player, MessageConfig.admin_kaldir_oyuncu_basarili);
                            AdventureUtil.sendMessage(admin, MessageConfig.admin_kaldir_admin_basarili);
                            BeylandsAuthy.getInstance().getConfig().set("2ad_kodları." + player.getUniqueId(), null);
                            BeylandsAuthy.getInstance().saveConfig();
                            BeylandsAuthy.authlocked.remove(player.getUniqueId());
                        }
                        return true;
                    }
                }
            }
        }
        return true;
    }
}