package works.emregumus.beylandsauthy.Config;

import org.bukkit.configuration.file.YamlConfiguration;
import works.emregumus.beylandsauthy.Utils.ConfigUtil;

import java.io.File;

public class MessageConfig {

    public static String prefix;
    public static String ikiad_etkin_degil;
    public static String ikiad_etkin_degil_iki;
    public static String ikiad_kodunuzu_girin;
    public static String ikiad_once_kodunuzu_girin;
    public static String ikiad_kodunuz_dogrulanamadi;
    public static String ikiad_kodunuz_dogrulanamadi_sadecerakam;
    public static String ikiad_kodunuz_dogrulandi;

    public static String noperm;
    public static String reload_basarili;
    public static String reload_basarisiz;

    public static String bagla_qr_basarili;
    public static String bagla_qr_basarisiz;
    public static String bagla_kod_basarili;
    public static String bagla_kod_basarisiz;
    public static String kaldir_basarili;
    public static String kaldir_basarisiz;

    public static String admin_bagla_qr_oyuncu_basarili;
    public static String admin_bagla_qr_oyuncu_basarisiz;
    public static String admin_bagla_kod_oyuncu_basarili;
    public static String admin_bagla_kod_oyuncu_basarisiz;
    public static String admin_kaldir_oyuncu_basarili;
    public static String admin_kaldir_oyuncu_basarisiz;
    public static String admin_bagla_qr_admin_basarili;
    public static String admin_bagla_qr_admin_basarisiz;
    public static String admin_bagla_kod_admin_basarili;
    public static String admin_bagla_kod_admin_basarisiz;
    public static String admin_kaldir_admin_basarili;
    public static String admin_kaldir_admin_basarisiz;

    public static void load() {
        YamlConfiguration config = ConfigUtil.getConfig("messages" + File.separator + "lang.yml");

        prefix = config.getString("options.prefix");
        ikiad_etkin_degil = config.getString("messages.2ad_etkin_degil");
        ikiad_etkin_degil_iki = config.getString("messages.2ad_etkin_degil_iki");
        ikiad_kodunuzu_girin = config.getString("messages.2ad_kodunuzu_girin");
        ikiad_once_kodunuzu_girin = config.getString("messages.2ad_once_kodunuzu_girin");
        ikiad_kodunuz_dogrulanamadi = config.getString("messages.2ad_kodunuz_dogrulanamadi");
        ikiad_kodunuz_dogrulanamadi_sadecerakam = config.getString("messages.2ad_kodunuz_dogrulanamadi_sadecerakam");
        ikiad_kodunuz_dogrulandi = config.getString("messages.2ad_kodunuz_dogrulandi");

        noperm = config.getString("messages.command.perm.basarisiz");
        reload_basarili = config.getString("messages.command.reload.basarili");
        reload_basarisiz = config.getString("messages.command.reload.basarisiz");

        bagla_qr_basarili = config.getString("messages.command.bagla.qr.basarili");
        bagla_qr_basarisiz = config.getString("messages.command.bagla.qr.basarisiz");
        bagla_kod_basarili = config.getString("messages.command.bagla.kod.basarili");
        bagla_kod_basarisiz = config.getString("messages.command.bagla.kod.basarisiz");
        kaldir_basarili = config.getString("messages.command.kaldir.basarili");
        kaldir_basarisiz = config.getString("messages.command.kaldir.basarisiz");

        admin_bagla_qr_oyuncu_basarili = config.getString("messages.command.admin.bagla.qr.oyuncu.basarili");
        admin_bagla_qr_oyuncu_basarisiz = config.getString("messages.command.admin.bagla.qr.oyuncu.basarisiz");
        admin_bagla_qr_admin_basarili = config.getString("messages.command.admin.bagla.qr.admin.basarili");
        admin_bagla_qr_admin_basarisiz = config.getString("messages.command.admin.bagla.qr.admin.basarisiz");
        admin_bagla_kod_oyuncu_basarili = config.getString("messages.command.admin.bagla.kod.oyuncu.basarili");
        admin_bagla_kod_oyuncu_basarisiz = config.getString("messages.command.admin.bagla.kod.oyuncu.basarisiz");
        admin_bagla_kod_admin_basarili = config.getString("messages.command.admin.bagla.kod.admin.basarili");
        admin_bagla_kod_admin_basarisiz = config.getString("messages.command.admin.bagla.kod.admin.basarisiz");
        admin_kaldir_oyuncu_basarili = config.getString("messages.command.admin.kaldir.oyuncu.basarili");
        admin_kaldir_oyuncu_basarisiz = config.getString("messages.command.admin.kaldir.oyuncu.basarisiz");
        admin_kaldir_admin_basarili = config.getString("messages.command.admin.kaldir.admin.basarili");
        admin_kaldir_admin_basarisiz = config.getString("messages.command.admin.kaldir.admin.basarisiz");
    }

}
