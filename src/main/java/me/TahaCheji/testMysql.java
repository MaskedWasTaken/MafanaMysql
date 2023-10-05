package me.TahaCheji;

import me.TahaCheji.mysqlData.MySQL;
import me.TahaCheji.mysqlData.MysqlValue;
import me.TahaCheji.mysqlData.SQLGetter;

import java.util.UUID;

public class testMysql extends MySQL {
    public testMysql() {
        super("localhost", "3306", "player_coins", "root", "");
    }
    SQLGetter sqlGetter = new SQLGetter(this);

    @Override
    public void setSqlGetter(SQLGetter sqlGetter) {
        this.sqlGetter = sqlGetter;
    }

    public void addCoins() {
        sqlGetter.setInt(new MysqlValue("COINS", MainAPI.getInstance().getUuid(), 20099090));
        sqlGetter.setString(new MysqlValue("NAME", MainAPI.getInstance().getUuid(), "WHAT EVER"));
        sqlGetter.setDouble(new MysqlValue("XP", MainAPI.getInstance().getUuid(), 1222.2));
        sqlGetter.setUUID(new MysqlValue("PLAYER",MainAPI.getInstance().getUuid(), UUID.randomUUID()));
        /*
        playercoins playercoins = new playercoins();
        playercoins.connect();
        System.out.println(playercoins.getSqlGetter().getInt(uuid, new MysqlValue("COINS")));
        System.out.println(playercoins.getSqlGetter().getString(uuid, new MysqlValue("NAME")));
        System.out.println(playercoins.getSqlGetter().getDouble(uuid, new MysqlValue("XP")));
        System.out.println(playercoins.getSqlGetter().getUUID(uuid, new MysqlValue("PLAYER")));
       */
    }

    @Override
    public void connect() {
        super.connect();
        if(this.isConnected()) sqlGetter.createTable("test", new MysqlValue("COINS", 1), new MysqlValue("NAME", ""),
                new MysqlValue("XP", 0.0), new MysqlValue("PLAYER", UUID.randomUUID().toString()));
        addCoins();
    }

    @Override
    public SQLGetter getSqlGetter() {
        return sqlGetter;
    }
}
