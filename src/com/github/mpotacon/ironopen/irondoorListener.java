package com.github.mpotacon.ironopen;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Door;

@SuppressWarnings("deprecation")
public class irondoorListener implements Listener{

	@EventHandler
	public void onPlayerInteract (PlayerInteractEvent event) {
		Player player = event.getPlayer();
        ItemStack held = player.getItemInHand();
        Action action = event.getAction();
        Block clicked = event.getClickedBlock();
        if (clicked.getType() == Material.IRON_DOOR_BLOCK) {
            if (action == Action.RIGHT_CLICK_BLOCK) {
                if (held.getType() == Material.AIR) {
                    BlockState state = clicked.getState();
                    Door door = (Door) state.getData();
                    if (door.isTopHalf()){
                    	Block set = clicked.getRelative(BlockFace.DOWN);
                    	BlockState state2 = set.getState();
                    	Door setDoor = (Door) state2.getData();
                        if (setDoor.isOpen() == false) {
                        	setDoor.setOpen(true);
                            event.getPlayer().sendMessage("Open");
                            state2.update();
                        } else {
                        	setDoor.setOpen(false);
                            event.getPlayer().sendMessage("Closed");
                            state2.update();
                        }
                    	
                    } else {
                    	if (door.isOpen() == false) {
                    		door.setOpen(true);
                    		event.getPlayer().sendMessage("Open");
                    		state.update();
                    	} else {
                    		door.setOpen(false);
                    		event.getPlayer().sendMessage("Closed");
                    		state.update();
                    	}
                   
                    }
                }
            }
        }		
	}
}
