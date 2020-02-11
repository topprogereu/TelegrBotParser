package config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static HikariConfig config;
    private static HikariDataSource ds;
    private static Resource res = Resource.getInstance();
    private static DataSource dataSource = null;

    private DataSource() {
        config = new HikariConfig();
        config.setJdbcUrl(res.getUrl());
        config.setUsername(res.getUsername());
        config.setPassword(res.getPassword());
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("currentSchema", "telegram");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static DataSource getInstance() {
        if (dataSource == null)
            dataSource = new DataSource();
        return dataSource;
    }
}
