package net.jmhertlein.greentext;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public final class MoCrafting implements Listener {

    MoCrafting(Plugin ref) { //you need to pass a refrence to "GreentextPlugin" around because you just have to okay???
        AddGappleRecipe(ref);
        AddWitherStarRecipe(ref);
    }

    public void AddGappleRecipe(Plugin ref) {
        NamespacedKey key = new NamespacedKey(ref, "enchanted_golden_apple");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 2));
        recipe.shape(new String[]{"GGG", "GAG", "GGG"});
        recipe.setIngredient('G', Material.GOLD_BLOCK);
        recipe.setIngredient('A', Material.ENCHANTED_GOLDEN_APPLE);
        Bukkit.addRecipe(recipe);
    }

    public void AddWitherStarRecipe(Plugin ref) {
        NamespacedKey key = new NamespacedKey(ref, "nether_star");
        ShapedRecipe recipe = new ShapedRecipe(key, new ItemStack(Material.NETHER_STAR));
        recipe.shape(new String[]{"WWW", "SSS", " S "});
        recipe.setIngredient('W', Material.WITHER_SKELETON_SKULL);
        recipe.setIngredient('S', Material.SOUL_SAND);
        Bukkit.addRecipe(recipe);
    }
}
