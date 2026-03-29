package me.darkboat.opTools.utils;

import me.darkboat.opTools.OpTools;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerUtils {
    private final OpTools plugin;

    public PlayerUtils(OpTools plugin) {
        this.plugin = plugin;
    }

    /**
     * @return {@return Player } - An player, if the player name not found, returns the sender player
     * */
    @NotNull
    public Player getPlayerOrSender(String playerName, Player sender) {
        Player player = plugin.getServer().getPlayer(playerName);
        return player == null ? sender : player;
    }

    public boolean isArgsEmpty(String[] args) {
        return args.length == 0;
    }

    public boolean isPLayerOnline(String playerName) {
        return plugin.getServer().getPlayer(playerName) != null;
    }

    public void sendErrorMessageToPlayer(Player p, String message) {
        p.sendMessage(MiniMessage.miniMessage().deserialize("<red><bold>[ERROR]:  " + message + "</bold></red>"));
    }
}
