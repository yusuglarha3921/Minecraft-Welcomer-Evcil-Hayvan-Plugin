package com.Yusuf.Welcomer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Cat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Welcomer ve Evcil Hayvan Menüsü aktif edildi");
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("Welcomer ve Evcil Hayvan Menüsü deaktif edildi");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();

        // Ekran ortasında küçük hoş geldin mesajı
        player.sendTitle(
                "",
                "§7Merhaba §f" + playerName + " §7! Sunucuya hoş geldin",
                10,
                40,
                10
        );

        // Yeni oyuncu mu kontrol et
        if (!player.hasPlayedBefore()) {
            // İlk kez giriş yapıyorsa - chatte herkes görsün
            String welcomeMessage = getConfig().getString("first-join-message", "&aHoş geldin &e{player}&a! Sunucumuza ilk kez katılıyorsun!");
            welcomeMessage = welcomeMessage.replace("{player}", playerName);
            welcomeMessage = ChatColor.translateAlternateColorCodes('&', welcomeMessage);
            event.setJoinMessage(welcomeMessage);

            // Oyuncuya özel mesaj
            String personalMessage = getConfig().getString("personal-welcome-message", "&6⭐ &eSunucumuza hoş geldin! &aKuralları okumayı unutma :)");
            personalMessage = ChatColor.translateAlternateColorCodes('&', personalMessage);
            player.sendMessage(personalMessage);

        } else {
            // Daha önce giriş yapmışsa - chatte herkes görsün
            String welcomeBackMessage = getConfig().getString("welcome-back-message", "&aTekrar hoş geldin &e{player}&a!");
            welcomeBackMessage = welcomeBackMessage.replace("{player}", playerName);
            welcomeBackMessage = ChatColor.translateAlternateColorCodes('&', welcomeBackMessage);
            event.setJoinMessage(welcomeBackMessage);
        }

        // Oyuncuya menü açıcı eşyayı ver
        player.getInventory().addItem(createPetMenuOpener());
        player.sendMessage(ChatColor.GREEN + "Envanterine evcil hayvan menüsü eklendi!");
        player.sendMessage(ChatColor.GRAY + "Kemiğe sağ tıkla ve ücretsiz evcil hayvanını seç!");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        // Oyuncu çıkış mesajı - chatte herkes görsün
        String quitMessage = getConfig().getString("quit-message", "&7[&c-&7] &e{player} &csunucudan ayrıldı!");
        quitMessage = quitMessage.replace("{player}", player.getName());
        quitMessage = ChatColor.translateAlternateColorCodes('&', quitMessage);
        event.setQuitMessage(quitMessage);
    }

    // Menü açıcı eşya oluştur
    public ItemStack createPetMenuOpener() {
        ItemStack item = new ItemStack(Material.BONE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "🐾 Evcil Hayvan Menüsü");
        meta.setLore(Arrays.asList(
                ChatColor.GRAY + "Sağ tıkla evcil hayvan seç!",
                ChatColor.GRAY + "Ücretsiz köpek veya kedi al."
        ));
        item.setItemMeta(meta);
        return item;
    }

    // Evcil Hayvan Menüsü oluştur
    public void openPetMenu(Player player) {
        Inventory menu = Bukkit.createInventory(player, 9, ChatColor.DARK_BLUE + "🐾 Evcil Hayvan Seç");

        // Köpek seçeneği
        ItemStack dog = new ItemStack(Material.BONE);
        ItemMeta dogMeta = dog.getItemMeta();
        dogMeta.setDisplayName(ChatColor.YELLOW + "🐶 Köpek");
        dogMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "Sadık bir köpek arkadaşı!",
                ChatColor.GREEN + "BEDAVA",
                ChatColor.WHITE + "Tıkla ve köpek al"
        ));
        dog.setItemMeta(dogMeta);

        // Kedi seçeneği
        ItemStack cat = new ItemStack(Material.COD);
        ItemMeta catMeta = cat.getItemMeta();
        catMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "🐱 Kedi");
        catMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "Sevimli bir kedi arkadaşı!",
                ChatColor.GREEN + "BEDAVA",
                ChatColor.WHITE + "Tıkla ve kedi al"
        ));
        cat.setItemMeta(catMeta);

        // Menüye yerleştirme
        menu.setItem(3, dog);
        menu.setItem(5, cat);

        player.openInventory(menu);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item != null && item.isSimilar(createPetMenuOpener())) {
            event.setCancelled(true);
            openPetMenu(player);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();

        if (clicked == null) return;

        String inventoryTitle = event.getView().getTitle();

        // Evcil Hayvan Menüsü tıklamaları
        if (inventoryTitle.equals(ChatColor.DARK_BLUE + "🐾 Evcil Hayvan Seç")) {
            event.setCancelled(true);

            if (clicked.getType() == Material.BONE) {
                // Köpek spawn et
                Wolf wolf = player.getWorld().spawn(player.getLocation(), Wolf.class);
                wolf.setOwner(player);
                wolf.setTamed(true);
                wolf.setAdult();

                player.sendMessage(ChatColor.GREEN + "🐶 Sadık köpeğin yanına geldi!");
                player.closeInventory();
            }
            else if (clicked.getType() == Material.COD) {
                // Kedi spawn et
                Cat cat = player.getWorld().spawn(player.getLocation(), Cat.class);
                cat.setOwner(player);
                cat.setTamed(true);
                cat.setAdult();

                player.sendMessage(ChatColor.GREEN + "🐱 Sevimli kedin yanına geldi!");
                player.closeInventory();
            }
        }
    }
}