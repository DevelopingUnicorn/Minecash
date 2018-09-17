package at.schni.minecash.listener;

import at.schni.minecash.main.Plugin;
import at.schni.minecash.util.FileBuilder_MC;
import at.schni.minecash.util.MinecashConfig;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MiningListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if (p.getGameMode() != GameMode.CREATIVE) {
            Plugin pl = Plugin.getInstance();
            Economy econ = pl.getEconomy();
            MinecashConfig mc = pl.getMcConfig();
            FileBuilder_MC f = mc.getF();
            
            Material m = e.getBlock().getType();
            String state = mc.getBlockState("" + m.getId());
            
            switch (state) {
                case "null":
                    break;
                case "common":
                    econ.depositPlayer(p, mc.getBase() * mc.getM_c());
                    break;
                case "uncommon":
                    econ.depositPlayer(p, mc.getBase() * mc.getM_uc());
                    break;
                case "rare":
                    econ.depositPlayer(p, mc.getBase() * mc.getM_r());
                    break;
                case "superrare":
                    econ.depositPlayer(p, mc.getBase() * mc.getM_sr());
                    break;
            }
        }

    }
}
