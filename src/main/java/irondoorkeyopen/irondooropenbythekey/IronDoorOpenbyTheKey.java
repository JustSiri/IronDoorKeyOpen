package irondoorkeyopen.irondooropenbythekey;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class IronDoorOpenbyTheKey extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("The plugin IronDoorOpenbyTheKey enabled.");
        Bukkit.getPluginManager().registerEvents(new KeyRightClickEvent(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("The plugin IRonDoorOpenbyTheKey disabled.");
    }

}
