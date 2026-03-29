package me.darkboat.opTools.commands;

import me.darkboat.opTools.utils.CommandsUtils;
import me.darkboat.opTools.utils.PlayerUtils;
import me.darkboat.opTools.utils.ServerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
    final CommandsUtils commandsUtils;

    public FlyCommand(CommandsUtils utils) {
        this.commandsUtils = utils;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player p) {
            this.commandsUtils.defaultCommandExecution(p, args, command, p::getAllowFlight, p::setAllowFlight);
        }
        return true;
    }
}
