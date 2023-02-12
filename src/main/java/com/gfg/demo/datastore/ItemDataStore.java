package com.gfg.demo.datastore;

import com.gfg.demo.database.ConnectionManager;
import com.gfg.demo.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDataStore {
    private static final String INSERT_ITEM = "insert into item(name,author,publisher,category) values(?,?,?,?)";
    private static final String GET_ITEM_COUNT = "select availableCopies from item where name=? and author=? and publisher=? and category=?";
    private static final String UPDATE_ITEM = "update table item set availableCopies = ? where name=? and author=? and publisher=? and category=?";

    private static Connection con=ConnectionManager.getConnection();

    public static int addNewItem(Item item){
        int updateCount=0;
        try{
            boolean isAvailable=false;
            int copies=checkIfItemAlreadyExist(item, isAvailable);
            if(isAvailable){
                PreparedStatement ps=con.prepareStatement(UPDATE_ITEM);
                ps.setInt(1,copies+1);
                ps.setString(2, item.getName());
                ps.setString(3, item.getAuthor());
                ps.setString(4, item.getPublisher());
                ps.setString(5, item.getCategory());

            }else{
                PreparedStatement ps=con.prepareStatement(INSERT_ITEM);
                //set the preparedstatement parameters
                ps.setString(1, item.getName());
                ps.setString(2, item.getAuthor());
                ps.setString(3, item.getPublisher());
                ps.setString(4, item.getCategory());

                //Execute
                updateCount = ps.executeUpdate();
                if(updateCount>0){
                    System.out.println("Item inserted successfully...");
                }else{
                    System.out.println("Failed to insert item");
                }
            }


        }catch (SQLException e){
        }
        return updateCount;
    }

    public static int checkIfItemAlreadyExist(Item item, boolean isAvailable){
        int currentCopies=0;
        try{
            PreparedStatement ps=con.prepareStatement(INSERT_ITEM);
            //set the preparedstatement parameters
            ps.setString(1, item.getName());
            ps.setString(2, item.getAuthor());
            ps.setString(3, item.getPublisher());
            ps.setString(4, item.getCategory());

            //Execute
            ResultSet rs = ps.executeQuery(GET_ITEM_COUNT);
            while(rs.next()){
                currentCopies=rs.getInt(1);
                isAvailable=true;
            }

        }catch (SQLException e){
        }
        return currentCopies;
    }
}
