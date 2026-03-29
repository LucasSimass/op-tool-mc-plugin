package me.darkboat.opTools.commands;

import me.darkboat.opTools.utils.CommandsUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class InvincibleCommand implements CommandExecutor {
    final  CommandsUtils commandsUtils;

    public InvincibleCommand(CommandsUtils commandsUtils) {
        this.commandsUtils = commandsUtils;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender instanceof Player p){
            commandsUtils.defaultCommandExecution(p, args, command, p::isInvulnerable, p::setInvulnerable);
        }
        return true;
    }
}
