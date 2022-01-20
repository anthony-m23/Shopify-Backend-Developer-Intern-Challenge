package com.CompanyInventory;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    // execute query returns resultSet and update just updates
    // point DBLocation to where db is stored on your pc
    public String DBLocation = System.getProperty("catalina.base") + "\\webapps\\shopify_web_app\\db\\CompanyDB.sqlite";
   //public String DBLocation = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\shopify_web_app\\db\\CompanyDB.sqlite";

    // Establishes connection to DB
    private Connection connect(){
        String url ="jdbc:sqlite:" + DBLocation;
        Connection conn = null;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return conn;
    }


    // insert into db
    public void insert(String name, String address, String  SKU, String cost, String type){
        Connection connection = connect();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            String sql = "INSERT INTO CompanyInventory (Name,Address,SKU,COST,Type) " +
                    "VALUES ('" + name + "','" + address + "','" + SKU + "','" + cost + "','" + type + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
            connection.close();
        }
        catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
    }

    // insert into location db
    public void locationInsert(String name, String address){
        Connection connection = connect();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            String sql = "INSERT INTO Locations (Name,Address) " +
                    "VALUES ('" + name + "','" + address + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.commit();
            connection.close();
        }
        catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
    }


    // Update item in db
    public void update(String cost, String name, String SKU){
        Connection connection = connect();
        Statement stmt = null;
        try{
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.executeUpdate("UPDATE CompanyInventory SET COST = '" + cost +
                    "' WHERE Name = '" + name + "' AND SKU = '" + SKU + "';");
            stmt.close();
            connection.commit();
            connection.close();
        }
        catch (Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
    }

    // Delete item in db
    public void delete(String name, String SKU){
        Connection connection = connect();
        Statement stmt = null;
        try{
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM CompanyInventory WHERE Name = '" + name + "' AND SKU = '" + SKU + "';");
            stmt.close();
            connection.commit();
            connection.close();
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
    }

    // read all items in inventory
    public ArrayList<InventoryItem> getAll(){
        ArrayList<InventoryItem> items = new ArrayList<>();
        Connection connection = connect();
        Statement stmt = null;

        try{
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            ResultSet set = stmt.executeQuery("SELECT * FROM CompanyInventory");

            while(set.next()){
                String name = set.getString("Name");
                String address = set.getString("Address");
                String SKU = set.getString("SKU");
                String cost = set.getString("COST");
                String type = set.getString("Type");
                InventoryItem item = new InventoryItem(name, address, SKU, cost, type);
                items.add(item);
            }
            set.close();
            stmt.close();
            connection.commit();
            connection.close();
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
        return items;
    }

//    For Testing
//    public static void main(String[] args) {
//        DBManager db = new DBManager();
//
//        ArrayList<InventoryItem> items = db.getAll();
//        for(InventoryItem item: items){
//            System.out.println(item.getName() + " : " + item.getAddress());
//        }
//
//    }


}
