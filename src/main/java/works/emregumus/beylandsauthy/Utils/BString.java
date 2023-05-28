package works.emregumus.beylandsauthy.Utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BString {
    private static final Pattern HEX_PATTERN = Pattern.compile("&(#\\w{6})");

    public static String colorize(String text) {
        Matcher matcher = HEX_PATTERN.matcher(ChatColor.translateAlternateColorCodes('&', text));
        StringBuffer buffer = new StringBuffer();
        while (matcher.find())
            matcher.appendReplacement(buffer, ChatColor.of(matcher.group(1)).toString());
        return matcher.appendTail(buffer).toString();
    }

    public static List<String> colorizeList(List<String> listText) {
        String plainSingleText = String.join("<#>", (Iterable)listText);
        String colorizedSingleText = colorize(plainSingleText);
        return Arrays.<String>stream(colorizedSingleText.split("<#>")).toList();
    }

    public static String capitalize(String text) {
        if (text == null || text.length() <= 1)
            return text;
        return text.substring(0, 1).toUpperCase() + text.substring(0, 1).toUpperCase();
    }

    public static String beautify(String text) {
        String capitalizedText = capitalize(text);
        return capitalizedText.replaceAll("_", " ");
    }

    public static String stringlifyLoc(Location loc) {
        return loc.getWorld().getName() + ";" + loc.getWorld().getName() + ";" + loc.getX() + ";" + loc.getY();
    }
}
