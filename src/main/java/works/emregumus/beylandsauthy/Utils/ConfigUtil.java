package works.emregumus.beylandsauthy.Utils;

import org.bukkit.configuration.file.YamlConfiguration;
import works.emregumus.beylandsauthy.BeylandsAuthy;
import works.emregumus.beylandsauthy.Config.MessageConfig;

import java.io.File;
import java.io.IOException;

public class ConfigUtil {

    public static YamlConfiguration readData(File file) {
        if (!file.exists())
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("[BeylandsAuthy] Failed to generate data files!");
            }
        return YamlConfiguration.loadConfiguration(file);
    }

    public static YamlConfiguration getConfig(String configName) {
        File file = new File(BeylandsAuthy.getInstance().getDataFolder(), configName);
        if (!file.exists())
            BeylandsAuthy.getInstance().saveResource(configName, false);
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void reloadConfigs() {
        MessageConfig.load();
    }

}
