package me.darkboat.opTools.commands;

import me.darkboat.opTools.classes.Armor;
import me.darkboat.opTools.utils.CommandsUtils;
import me.darkboat.opTools.utils.PlayerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class KitCommand implements CommandExecutor {
    PlayerUtils playerUtils;
    CommandsUtils commandsUtils;

    public KitCommand(CommandsUtils commandsUtils) {
        this.playerUtils = commandsUtils.getPlayerUtils();
        this.commandsUtils = commandsUtils;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player p) {
            String materialName;

            if (args.length > 0){
                p = playerUtils.getPlayerOrSender(args[0], p);
                materialName = playerUtils.isPLayerOnline(args[0]) ? args[1] : args[0];
                if (materialName.equalsIgnoreCase("-c") || materialName.equalsIgnoreCase("-clear")){
                    materialName = "n";
                }

                if (!Armor.isMaterialForArmorValid(materialName)){
                    if (!materialName.equalsIgnoreCase("-c") && !materialName.equalsIgnoreCase("-clear")){
                        playerUtils.sendErrorMessageToPlayer(p, "Use '/help " + command.getName() + "' to get more info!");
                        return true;
                    }
                }

                for (String arg : args) {
                    if (arg.equalsIgnoreCase("-clear") || arg.equalsIgnoreCase("-c")) {
                        p.getInventory().clear();
                        break;
                    }
                }
            } else {
                materialName = "n";
            }

            try {
                Armor.setFullArmorNToolsToPlayer(materialName, p);
            } catch (Exception e) {
                playerUtils.sendErrorMessageToPlayer(p, "Use /help " + command.getName() + " to get more info!");
            }
        }
        return true;
    }
}

