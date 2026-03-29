package me.darkboat.opTools.utils;

import me.darkboat.opTools.OpTools;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class ServerUtils {
    final OpTools plugin;

    private final static String serverPrefix = "<bold>[SERVER]:</bold> ";

    public ServerUtils(OpTools plugin) {
        this.plugin = plugin;
    }

    private static Component serverMessage(String message) {
        return MiniMessage.miniMessage().deserialize(serverPrefix + message);
    }

    private static Component serverMessage(MiniMessage message) {
        return MiniMessage.miniMessage().deserialize(serverPrefix + message);
    }

    private static Component serverMessage(String serverPrefixColor, MiniMessage message) {
        return MiniMessage.miniMessage().deserialize("<"+ serverPrefixColor + ">" + serverPrefixColor + "</" + serverPrefixColor+ "> " + message);
    }

    private static Component serverMessage(String serverPrefixColor, String message) {
        return MiniMessage.miniMessage().deserialize("<"+ serverPrefixColor + ">" + serverPrefix + "</" + serverPrefixColor+ "> " + message);
    }

    public void sendServerMessage(String message) {
        plugin.getServer().sendMessage(serverMessage(message));
    }

    public void sendServerMessage(MiniMessage message) {
        plugin.getServer().sendMessage(serverMessage(message));
    }

    public void sendServerMessage(String serverPrefixColor, MiniMessage message) {
        plugin.getServer().sendMessage(serverMessage(serverPrefixColor, message));
    }

    public void sendServerMessage(String serverPrefixColor, String message) {
        plugin.getServer().sendMessage(serverMessage(serverPrefixColor, message));
    }

}
