package pl.net.eerie.vulpineeconomy;

import org.bukkit.configuration.MemoryConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public final class VulpineEconomy extends JavaPlugin {

    private static VulpineEconomy instance;

    private MemoryConfiguration consolidatedConfig; // Konfiguracja ze wszystkich plików połączona dla wygody
    private YamlConfiguration dbConfig; // Konfiguracja baz danych. Na razie tylko redis bo jest do tego bardzo dobry.
    @Nullable
    private YamlConfiguration currencyConfig; // Konfiguracja wielu walut.
    private YamlConfiguration worldsConfiguration; // Konfiguracja światów

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        consolidatedConfig = new MemoryConfiguration();
        consolidatedConfig.addDefaults(dbConfig);
        consolidatedConfig.addDefaults(currencyConfig);
        consolidatedConfig.addDefaults(worldsConfiguration);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static VulpineEconomy getInstance()
    {
        return instance;
    }
}
