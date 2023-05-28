package works.emregumus.beylandsauthy.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import works.emregumus.beylandsauthy.BeylandsAuthy;
import works.emregumus.beylandsauthy.Config.MessageConfig;
import works.emregumus.beylandsauthy.Utils.AdventureUtil;

public class BlockedListener implements Listener {

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            if (!message.startsWith("1") && !message.startsWith("2") && !message.startsWith("3") && !message.startsWith("4") && !message.startsWith("5") && !message.startsWith("6") && !message.startsWith("7") && !message.startsWith("8") && !message.startsWith("9") && !message.startsWith("0")){
                AdventureUtil.sendMessage(player, MessageConfig.ikiad_kodunuzu_girin);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBedLeave(PlayerBedLeaveEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEditBook(PlayerEditBookEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEggThrow(PlayerEggThrowEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setHatching(false);
        }
    }

    @EventHandler
    public void onExpChange(PlayerExpChangeEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setAmount(0);
        }
    }

    @EventHandler
    public void onFish(PlayerFishEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onGamemodeChange(PlayerGameModeChangeEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onHarvestBlock(PlayerHarvestBlockEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteractAtEntity(PlayerInteractAtEntityEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteractEntity(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            if (event.getItem() != null){
                if (event.getItem().getType().isEdible()){
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickupArrow(PlayerPickupArrowEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickupItem(PlayerPickupItemEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPortal(PlayerPortalEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
            player.sendMessage("§cYou can't use portals while auth locked!");
        }
    }

    @EventHandler
    public void onSwapHandItems(PlayerSwapHandItemsEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
            player.sendMessage("§cYou can't swap items while auth locked!");
        }
    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onToggleFlight(PlayerToggleFlightEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onToggleSneak(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onToggleSprint(PlayerToggleSprintEvent event) {
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onVehicleEnter(VehicleEnterEvent event){
        if (event.getEntered() instanceof Player){
            Player player = (Player) event.getEntered();
            if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onUnleashEntityEvent(PlayerUnleashEntityEvent event){
        Player player = event.getPlayer();
        if (BeylandsAuthy.authlocked.contains(player.getUniqueId())){
            event.setCancelled(true);
            player.sendMessage("§cYou can't unleash entities while auth locked!");
        }
    }
}
