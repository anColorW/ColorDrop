package me.color.events;

import me.color.utils.Variables;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import me.color.utils.Utils;

public class dropEvent implements Listener {

    Utils utils = new Utils();
    Variables var = new Variables();

    @EventHandler
    public void onStoneBreak(BlockBreakEvent e){

        Player p = e.getPlayer();

        if (e.getBlock().getType() == Material.STONE){

            int randomNumber = utils.randomInt(0, 100);

            if(utils.isHoldingPickaxe(p)){
                System.out.println(randomNumber);

                utils.dropItem(randomNumber, Material.DIAMOND, p, e);
                utils.dropItem(randomNumber, Material.IRON_INGOT, p, e);
                utils.dropItem(randomNumber, Material.GOLD_INGOT, p, e);
                utils.dropItem(randomNumber, Material.COAL, p, e);
                utils.dropItem(randomNumber, Material.TNT, p, e);
                utils.dropItem(randomNumber, Material.ENDER_PEARL, p, e);


            }
        }
    }

    @EventHandler
    public void onOreBreak(BlockBreakEvent e){

        Material mat = e.getBlock().getType();

        if (!var.oreDrop){
            switch (mat){
                case COAL_ORE:
                case REDSTONE_ORE:
                case LAPIS_ORE:
                case GOLD_ORE:
                case IRON_ORE:
                case DIAMOND_ORE:
                case EMERALD_ORE:
                    e.getBlock().setType(Material.AIR);
                    break;
            }
        }
    }
}
