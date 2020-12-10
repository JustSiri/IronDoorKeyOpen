package irondoorkeyopen.irondooropenbythekey;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class KeyRightClickEvent implements Listener {

    @EventHandler
    void rightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();

        if(a == Action.RIGHT_CLICK_BLOCK) {
            if (p.getItemInHand().getType() == Material.TRIPWIRE_HOOK) {
                if (p.getItemInHand().getItemMeta().hasDisplayName()) {
                    String itemName = p.getItemInHand().getItemMeta().getDisplayName();
                    if (itemName.equals("key")) {
                    Block block = e.getClickedBlock();

                        if (block.getType() == Material.IRON_DOOR_BLOCK) {
                            if (block.getData() >= 8)
                                block = block.getRelative(BlockFace.DOWN);

                            if (block.getType() == Material.IRON_DOOR_BLOCK) {
                                if (block.getData() < 4) {
                                    block.setData((byte) (block.getData() + 4));
                                    block.getWorld().playEffect(block.getLocation(), Effect.DOOR_TOGGLE, 0);
                                    p.sendMessage("You opened the door!");
                                } else {
                                    block.setData((byte) (block.getData() - 4));
                                    block.getWorld().playEffect(block.getLocation(), Effect.DOOR_TOGGLE, 0);
                                    p.sendMessage("You closed the door!");
                                }
                                e.setUseItemInHand(Event.Result.DENY);
                            }
                        }
                    }
                }
            }
        }
    }
}
