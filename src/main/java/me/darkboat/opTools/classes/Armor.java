package me.darkboat.opTools.classes;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public abstract class Armor {

    public final static String notFoundErrorMessage = "This material cannot be an full armor!";

    /**
     * @throws IllegalStateException - if material cannot be an armor full set
     * */
    public static void setFullArmorNToolsToPlayer(String materialName, Player p) {
        ArrayList<ItemStack> fullArmorNTools= getFullArmorNToolsByMaterial(materialName);

        EntityEquipment equipment = p.getEquipment();
        Inventory inventory = p.getInventory();

        ItemStack bow = ItemStack.of(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();
        bow.setItemMeta(bowMeta);

        ItemStack arrow = ItemStack.of(Material.ARROW, 64);

        equipment.setBoots(fullArmorNTools.get(0));
        equipment.setLeggings(fullArmorNTools.get(1));
        equipment.setChestplate(fullArmorNTools.get(2));
        equipment.setHelmet(fullArmorNTools.get(3));

        inventory.addItem(fullArmorNTools.get(4));
        inventory.addItem(bow);
        inventory.addItem(arrow);

    }

    public static boolean isMaterialForArmorValid(String materialName) {
        try {
            getFullArmorNToolsByMaterial(materialName);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    /**
     * Get the full armor of the Material, if is a valid Material type for full armor
     *
     * @throws IllegalStateException - if material cannot be an armor full set
     * @return ItemStack[] -> 3: Helmet, 2: Chestplate, 1: Leggings, 0: Boots;
     * */
    private static ArrayList<ItemStack> getFullArmorNToolsByMaterial(String materialName) {
        ArrayList<ItemStack> fullArmorNTools = new ArrayList<>();

        switch (convertNameToMaterial(materialName)) {
            case LEATHER -> {
                fullArmorNTools.add(ItemStack.of(Material.LEATHER_BOOTS));
                fullArmorNTools.add(ItemStack.of(Material.LEATHER_LEGGINGS));
                fullArmorNTools.add(ItemStack.of(Material.LEATHER_CHESTPLATE));
                fullArmorNTools.add(ItemStack.of(Material.LEATHER_HELMET));
                fullArmorNTools.add(ItemStack.of(Material.WOODEN_SWORD));
            }
            case CHAINMAIL_BOOTS ->  {
                fullArmorNTools.add(ItemStack.of(Material.CHAINMAIL_BOOTS));
                fullArmorNTools.add(ItemStack.of(Material.CHAINMAIL_LEGGINGS));
                fullArmorNTools.add(ItemStack.of(Material.CHAINMAIL_CHESTPLATE));
                fullArmorNTools.add(ItemStack.of(Material.CHAINMAIL_HELMET));
                fullArmorNTools.add(ItemStack.of(Material.STONE_SWORD));
            }
            case IRON_INGOT -> {
                fullArmorNTools.add(ItemStack.of(Material.IRON_BOOTS));
                fullArmorNTools.add(ItemStack.of(Material.IRON_LEGGINGS));
                fullArmorNTools.add(ItemStack.of(Material.IRON_CHESTPLATE));
                fullArmorNTools.add(ItemStack.of(Material.IRON_HELMET));
                fullArmorNTools.add(ItemStack.of(Material.IRON_SWORD));
            }
            case GOLD_INGOT -> {
                fullArmorNTools.add(ItemStack.of(Material.GOLDEN_BOOTS));
                fullArmorNTools.add(ItemStack.of(Material.GOLDEN_LEGGINGS));
                fullArmorNTools.add(ItemStack.of(Material.GOLDEN_CHESTPLATE));
                fullArmorNTools.add(ItemStack.of(Material.GOLDEN_HELMET));
                fullArmorNTools.add(ItemStack.of(Material.GOLDEN_SWORD));
            }
            case DIAMOND_ORE -> {
                fullArmorNTools.add(ItemStack.of(Material.DIAMOND_BOOTS));
                fullArmorNTools.add(ItemStack.of(Material.DIAMOND_LEGGINGS));
                fullArmorNTools.add(ItemStack.of(Material.DIAMOND_CHESTPLATE));
                fullArmorNTools.add(ItemStack.of(Material.DIAMOND_HELMET));
                fullArmorNTools.add(ItemStack.of(Material.DIAMOND_SWORD));
            }
            case NETHERITE_INGOT -> {
                fullArmorNTools.add(ItemStack.of(Material.NETHERITE_BOOTS));
                fullArmorNTools.add(ItemStack.of(Material.NETHERITE_LEGGINGS));
                fullArmorNTools.add(ItemStack.of(Material.NETHERITE_CHESTPLATE));
                fullArmorNTools.add(ItemStack.of(Material.NETHERITE_HELMET));
                fullArmorNTools.add(ItemStack.of(Material.NETHERITE_SWORD));
            }
        }

        return fullArmorNTools;
    }

    /**
     * Convert shortcut or name if the material can be an armor
     *
     * @throws IllegalStateException - An material that is not a type of armor
     * */
    private static Material convertNameToMaterial(String materialName) {
        Material material;
        switch (materialName.toLowerCase()) {
            case "leather", "l" -> material = Material.LEATHER;
            case "chainmail", "c" -> material = Material.CHAINMAIL_BOOTS;
            case "iron", "i" -> material = Material.IRON_INGOT;
            case "gold", "g" -> material = Material.GOLD_INGOT;
            case "diamond", "d" -> material = Material.DIAMOND_ORE;
            case "netherite", "n" -> material = Material.NETHERITE_INGOT;
            default -> throw new IllegalStateException("Unexpected value: " + materialName.toLowerCase());
        }

        return material;
    }
}
