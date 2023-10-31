package ru.job4j.tracker;

import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = cn.prepareStatement("INSERT INTO items(name, created) VALUES(?, ?)")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        try (PreparedStatement ps = cn.prepareStatement("UPDATE items SET name=?, created=? WHERE id=?")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.setInt(3, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = cn.prepareStatement("DELETE FROM items WHERE id=?")) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (Statement ps = cn.createStatement()) {
            ResultSet rs = ps.executeQuery("SELECT * FROM items");
            while (rs.next()) {
                list.add(new Item(rs.getString("name"), rs.getInt("id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (Statement ps = cn.createStatement()) {
            ResultSet rs = ps.executeQuery(String.format("SELECT * FROM items WHERE name='%s'", key));
            while (rs.next()) {
                list.add(new Item(rs.getString("name"), rs.getInt("id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (Statement ps = cn.createStatement()) {
            ResultSet rs = ps.executeQuery(String.format("SELECT * FROM items WHERE id=%s", id));
            if (rs.next()) {
                item = new Item(rs.getString("name"), rs.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}