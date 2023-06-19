package me.color.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;


public class Utils {

    Variables var = new Variables();

    public String chat (String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public void sendColoredMessage(String s, Player p){
        p.sendMessage(chat(s));
    }
    public int randomInt(int min, int max){
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }

    public boolean isHoldingPickaxe(Player p){

        Material itemInHand = p.getItemInHand().getType();

        switch (itemInHand){
            case WOOD_PICKAXE:
            case IRON_PICKAXE:
            case GOLD_PICKAXE:
            case DIAMOND_PICKAXE:
            case STONE_PICKAXE:
                return true;
            default:
                return false;
        }
    }

    public int fortuneLevel(Player p){
        if(isHoldingPickaxe(p)){
            return p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
        }
        return 0;
    }

    public int addPercentage(Player p){

        int fortuneLevel = fortuneLevel(p);

        switch (fortuneLevel){
            case 1:
                return var.fortune1AddPercentage;
            case 2:
                return var.fortune2AddPercentage;
            case 3:
                return var.fortune3AddPercentage;
            default:
                return 0;
        }
    }

    public int calcPercentage(Material mat, Player p){

        switch (mat){
            case DIAMOND:
                return var.diamondPercentage + addPercentage(p);
            case IRON_INGOT:
                return var.ironPercentage + addPercentage(p);
            case GOLD_INGOT:
                return var.goldPercentage + addPercentage(p);
            case COAL:
                return var.coalPercentage + addPercentage(p);
            case TNT:
                return var.tntPercentage + addPercentage(p);
            case ENDER_PEARL:
                return var.pearlPercentage + addPercentage(p);
            default:
                return 0;
        }
    }
    public void dropItem(int randomNumber, Material mat, Player p, BlockBreakEvent e){
        if (randomNumber <= calcPercentage(mat, p)){
            p.getWorld().dropItemNaturally(e.getBlock().getLocation(), new ItemStack(mat));
        }
    }
}
