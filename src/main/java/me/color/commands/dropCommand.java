package me.color.commands;

import me.color.utils.Variables;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.color.utils.Utils;

import java.util.Random;

public class dropCommand implements CommandExecutor {
    Utils utils = new Utils();
    Variables var = new Variables();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("You can only send it as player!");
            return true;
        }

        Player p = (Player) sender;

        utils.sendColoredMessage("&a&lCurrent drops:",p);
        utils.sendColoredMessage("&b&lDiamond: &6" + utils.calcPercentage(Material.DIAMOND, p),p);
        utils.sendColoredMessage("&e&lGold: &6" + utils.calcPercentage(Material.GOLD_INGOT, p),p);
        utils.sendColoredMessage("&7&lIron: &6" + utils.calcPercentage(Material.IRON_INGOT, p),p);
        utils.sendColoredMessage("&0&lCoal: &6" + utils.calcPercentage(Material.COAL, p),p);
        utils.sendColoredMessage("&4&lTNT: &6" + utils.calcPercentage(Material.TNT, p),p);
        utils.sendColoredMessage("&5&lEnderPearl: &6" + utils.calcPercentage(Material.ENDER_PEARL, p),p);


        return true;
    }
}
