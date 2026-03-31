package me.darkboat.opTools.utils;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommandsUtils {
    final PlayerUtils playerUtils;
    final  ServerUtils serverUtils;

    public CommandsUtils(PlayerUtils playerUtils, ServerUtils serverUtils) {
        this.playerUtils = playerUtils;
        this.serverUtils = serverUtils;
    }

    public final void defaultBooleeanCommandExecution(Player p, String[] args, Command command, Supplier<Boolean> verify, Consumer<Boolean> action) {
        p = args.length == 0 ? p : playerUtils.getPlayerOrSender(args[0], p);
        String pName = p.getName();
        String commandName = command.getName();

        if (args.length >= 1 && !(args.length == 1 && playerUtils.isPLayerOnline(args[0]))){
            if (args.length == 1 && !args[0].equalsIgnoreCase("off")){
                playerUtils.sendErrorMessageToPlayer(p, "Parameter '" + args[0] + "' is not an valid parameter, use /help " + command.getName() );
                return;
            }

            if (args.length > 1 && !args[1].equalsIgnoreCase("off")){
                playerUtils.sendErrorMessageToPlayer(p, "Parameter '" + args[1] + "' is not an valid parameter, use /help " + command.getName() );
                return;
            }

            if (!verify.get()){
                serverUtils.sendServerMessage( "<bold>"+ pName + " is disable '" + commandName + "'!</bold>");
                return;
            }
            action.accept(false);
            serverUtils.sendServerMessage("<bold>"+ pName + " is not using more '" + commandName + "'</bold>!");
        }
        else {
            if (verify.get()){
                serverUtils.sendServerMessage("<bold>"+ pName + " already using '" + commandName + "'!</bold>");
                return;
            }
            action.accept(true);
            serverUtils.sendServerMessage("<bold>"+ pName + " is enable '" + commandName + "'!</bold>");
        }
    }

    public PlayerUtils getPlayerUtils() {
        return playerUtils;
    }

    public ServerUtils getServerUtils() {
        return serverUtils;
    }
}
