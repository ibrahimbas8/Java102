package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String userName;
    private String password;
    private String type;

    public User(){

    }

    public User(int id, String name, String userName, String password, String type) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    public static ArrayList<User> getList(){
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("usertype"));
                userList.add(obj);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return userList;
    }

    public static boolean add(String name,String userName, String password, String type){
        String query = "INSERT INTO user (name,username,password,usertype) VALUES(?,?,?,?)";
        User findUser = User.getFetch(userName);
        if (findUser != null){
            Helper.showMessage("Bu kullanıcı adı kullanılmakta");
            return false;
        }
        else{
            try {
                PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
                pr.setString(1,name);
                pr.setString(2,userName);
                pr.setString(3,password);
                pr.setString(4,type);

                int response = pr.executeUpdate() ;
                if (response == -1){
                    Helper.showMessage("error");
                }
                return response != -1;
            } catch (SQLException exception) {
                System.out.println(exception.getMessage());
            }
            return true;
        }
    }

    public static User getFetch(String uname){
        User obj = null;
        String query = "SELECT * FROM user Where username = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,uname);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("usertype"));

            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return obj;
    }
    public static User getFetch(int id){
        User obj = null;
        String query = "SELECT * FROM user Where id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("usertype"));

            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return obj;
    }

    public static User getFetch(String uname, String pass){
        User obj = null;
        String query = "SELECT * FROM user Where username = ? AND pass = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,uname);
            pr.setString(2,pass);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("usertype"));

            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return obj;
    }

    public static boolean delete(int id){
        String query = "DELETE FROM user Where id = ?";
        ArrayList<Course> courseList = Course.getListByUser(id);
        for (Course c : courseList){
            Course.delete(c.getId());
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);

            return pr.executeUpdate() != -1;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return true;
    }

    public static boolean update(int id, String name, String userName, String password, String type){
        String query = "UPDATE user SET name = ?, username = ?, password = ?, usertype = ? Where id = ?";
        User findUser = User.getFetch(userName);
        //type değerini kontrol ettir
        if (findUser != null && findUser.getId() != id){
            Helper.showMessage("Bu kullanıcı adı kullanılmakta");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,userName);
            pr.setString(3,password);
            pr.setString(4,type);
            pr.setInt(5,id);

            return pr.executeUpdate() != -1;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return true;
    }

    public static ArrayList<User> searchUserList(String query){
        ArrayList<User> userList = new ArrayList<>();
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setType(rs.getString("usertype"));
                userList.add(obj);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return userList;
    }
    public static String searchQuery(String name, String userName, String userType){
        String query = "SELECT * FROM user WHERE username LIKE '%{{username}}%' AND name LIKE '%{{name}}%'";
        query  = query.replace("{{username}}", userName);
        query  = query.replace("{{name}}", name);
        if (!userType.isEmpty()){
            query += " AND usertype='{{usertype}}'";
            query  = query.replace("{{usertype}}", userType);
        }
        System.out.println(query);
        return query;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
