package me.darkboat.opTools.commands;

import me.darkboat.opTools.utils.PlayerUtils;
import me.darkboat.opTools.utils.ServerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {
    final PlayerUtils playerUtils;
    final ServerUtils serverUtils;

    public FeedCommand(PlayerUtils playerUtils, ServerUtils serverUtils) {
        this.playerUtils = playerUtils;
        this.serverUtils = serverUtils;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player p){
            p = playerUtils.isArgsEmpty(args) ? p : playerUtils.getPlayerOrSender(args[0], p);
            p.setFoodLevel(20);

            serverUtils.sendServerMessage("<bold>The user " + p.getName() + " was feed<bold>");
        }
        return true;
    }
}
