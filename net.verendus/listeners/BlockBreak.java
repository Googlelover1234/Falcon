package net.verendus.listeners;

import net.verendus.managers.ConfigManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Jeremy Gooch on 4/24/15.
 */
public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block block = e.getBlock();
        if (!p.getItemInHand().hasItemMeta()) return;
        if (!p.getItemInHand().getItemMeta().hasEnchants()) return;
        if (!p.getItemInHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS)) return;
        if (!ConfigManager.getInstance().getConfig().contains("items." + block.getTypeId())) return;
        e.setCancelled(true);
        e.setExpToDrop(0);
        for (int i = 0; i < (ConfigManager.getInstance().getConfig().getInt("items." + block.getTypeId()) * p.getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_BLOCKS)); i++) {
            p.getInventory().addItem(new ItemStack(Material.getMaterial(block.getTypeId())));
        }
        block.setType(Material.AIR);
    }
}
