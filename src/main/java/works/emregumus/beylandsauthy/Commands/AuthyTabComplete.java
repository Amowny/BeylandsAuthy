package works.emregumus.beylandsauthy.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthyTabComplete implements TabCompleter {

    @Override
    @ParametersAreNonnullByDefault
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender.hasPermission("beylandsauthy.admin")) {
            if (1 == args.length) {
                return Arrays.asList("bagla","kaldir","reload","admin");
            }
            if (2 == args.length && args[0].equalsIgnoreCase("bagla")) {
                return Arrays.asList("kod","qr");
            } else if (2 == args.length && args[0].equalsIgnoreCase("admin")) {
                return Arrays.asList("bagla","kaldir");
            }
            if (3 == args.length && args[1].equalsIgnoreCase("bagla") && args[0].equalsIgnoreCase("admin")) {
                return Arrays.asList("kod","qr");
            }
            if (4 == args.length && args[1].equalsIgnoreCase("bagla") && args[0].equalsIgnoreCase("admin")) {
                return online_players();
            }
        } else {
            if (1 == args.length){
                return Arrays.asList("bagla","kaldir");
            }
            if (2 == args.length && args[0].equalsIgnoreCase("bagla")){
                return Arrays.asList("kod","qr");
            }
        }
        return null;
    }

    private static List<String> online_players(){
        List<String> online = new ArrayList<>();
        Bukkit.getOnlinePlayers().forEach((player -> online.add(player.getDisplayName())));
        return online;
    }

}
