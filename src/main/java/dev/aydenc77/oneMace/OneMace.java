package dev.aydenc77.oneMace;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareItemCraftEvent;


import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public final class OneMace extends JavaPlugin implements Listener {

    public boolean allowmace;

    @Override
    public void onEnable() {
        getLogger().log(new LogRecord(Level.INFO , "OneMase has Loaded"));
        getServer().getPluginManager().registerEvents(this, this);

        saveDefaultConfig();
        allowmace = getConfig().getBoolean("mace");
    }

    @Override
    public void onDisable() {}


    @EventHandler
    public void onPrepareItemCraftEvent(PrepareItemCraftEvent event) {
        ItemStack result = event.getInventory().getResult();

        if (result != null && result.getType() == Material.MACE && allowmace == false) {
            event.getInventory().setResult(new ItemStack(Material.AIR));
        } else if (result != null && result.getType() == Material.MACE && allowmace == true && getConfig().getBoolean("enabled") == true){
            allowmace = false;
            getConfig().set("mace", false);
            saveDefaultConfig();
        }
    }
}
