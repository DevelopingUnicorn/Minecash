package at.schni.minecash.main;

import at.schni.minecash.listener.MiningListener;
import at.schni.minecash.util.MinecashConfig;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    private static PluginManager pm;
    private Economy econ;
    private MinecashConfig mc;

    private static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        setupConfig();

        if (!setupEconomy()) {
            this.getLogger().severe("[MineCash] Disabled due to no Vault dependency found!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        pm = Bukkit.getPluginManager();
        pm.registerEvents(new MiningListener(), this);
    }

    private boolean setupEconomy() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return false;
        } else {
            RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
            if (rsp == null) {
                return false;
            } else {
                econ = rsp.getProvider();
                return econ != null;
            }
        }
    }

    private void setupConfig() {
        MinecashConfig temp = new MinecashConfig();

        if (!temp.exist()) {
            temp.setConfig();
        }

        mc = temp.getConfig();
    }

    public Economy getEconomy() {
        return econ;
    }

    public static Plugin getInstance() {
        return instance;
    }

    public MinecashConfig getMcConfig() {
        return mc;
    }

}
