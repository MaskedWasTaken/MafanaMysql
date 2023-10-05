package me.TahaCheji;

import me.TahaCheji.mysqlData.MySQL;
import me.TahaCheji.mysqlData.SQLGetter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class MainAPI extends JavaPlugin {


    public MySQL mySQL;
    public static MainAPI instance;
    public SQLGetter sqlGetter;
    UUID uuid = UUID.randomUUID();

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        new testMysql().disconnect();
    }

    public UUID getUuid() {
        return uuid;
    }

    public SQLGetter getSqlGetter() {
        return sqlGetter;
    }

    public static MainAPI getInstance() {
        return instance;
    }

    public MySQL getMySQL() {
        return mySQL;
    }
}
