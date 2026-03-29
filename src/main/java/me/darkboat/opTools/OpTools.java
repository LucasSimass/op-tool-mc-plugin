package me.darkboat.opTools;

import me.darkboat.opTools.commands.*;
import me.darkboat.opTools.utils.CommandsUtils;
import me.darkboat.opTools.utils.PlayerUtils;
import me.darkboat.opTools.utils.ServerUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class OpTools extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        PlayerUtils playerUtils = new PlayerUtils(this);
        ServerUtils serverUtils = new ServerUtils(this);

        CommandsUtils commandsUtils = new CommandsUtils(playerUtils, serverUtils);

        Objects.requireNonNull(getCommand("feed")).setExecutor(new FeedCommand(playerUtils, serverUtils));
        Objects.requireNonNull(getCommand("fly")).setExecutor(new FlyCommand(commandsUtils));
        Objects.requireNonNull(getCommand("invincible")).setExecutor(new InvincibleCommand(commandsUtils));
        Objects.requireNonNull(getCommand("invisible")).setExecutor(new InvisibleCommand(commandsUtils));
        Objects.requireNonNull(getCommand("glow")).setExecutor(new GlowCommand(commandsUtils));
        Objects.requireNonNull(getCommand("pickup")).setExecutor(new PickUpItemsCommand(commandsUtils));
        Objects.requireNonNull(getCommand("silent")).setExecutor(new SilentCommand(commandsUtils));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
