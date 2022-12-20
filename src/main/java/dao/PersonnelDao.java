package dao;

import entity.Personnel;
import utils.DbHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonnelDao {
    private static List<Personnel> personnelList = new ArrayList<>();

    public static List<Personnel> findALL(Personnel personnel) {
        return personnelList;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void insert(Personnel personnel) throws SQLException {
        Connection conn = DbHandler.getConnection();

        String query = "insert into PERSONNEL (NAME,FAMILYNAME,NATIONAL_CODE,id) values (?,?,?,?);";
        PreparedStatement statement = conn.prepareStatement(query);

        statement.setString(1, personnel.getName());
        statement.setString(2, personnel.getFamilyName());
        statement.setString(3, personnel.getNationalCode());
        statement.setInt(4, getRandomNumber(1, 10000));

        int row = statement.executeUpdate();
        System.out.println(row);
    }

    public void findAll() throws SQLException {
        Connection conn = DbHandler.getConnection();
        String querySelect = "select * from PERSONNEL";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(querySelect);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String familyName = resultSet.getString("familyName");
            String nationalCode = resultSet.getString("national_code");
            Personnel personnel = new Personnel(name, familyName, nationalCode, id);
            System.out.println(personnel);
        }
    }

    public void delete(String nationalCode) throws SQLException {
        Connection conn = DbHandler.getConnection();

        String queryDelete = "delete from PERSONNEL where national_code = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(queryDelete);
        preparedStatement.setString(1, nationalCode);
        preparedStatement.executeUpdate();
        System.out.println("delete successfully ");
    }

    public void update(Personnel personnel) throws SQLException {
        Connection conn = DbHandler.getConnection();

        String queryUpdate = "update Personnel set name =? ,familyName =? where national_code=?";
        PreparedStatement preparedStatement = conn.prepareStatement(queryUpdate);
        preparedStatement.setString(1, personnel.getName());
        preparedStatement.setString(2, personnel.getFamilyName());
        preparedStatement.setString(3, personnel.getNationalCode());
        preparedStatement.executeUpdate();
        System.out.println("update successfully");
    }

    public Personnel findByNationalCode(String nationalCode) throws SQLException {
        Connection conn = DbHandler.getConnection();

        String findByNationalCode = "select * from Personnel where national_code = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(findByNationalCode);
        preparedStatement.setString(1, nationalCode);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String familyName = resultSet.getString("familyName");
            nationalCode = resultSet.getString("national_code");
            return new Personnel(name, familyName, nationalCode, id);
        }

        return null;
    }

    public Personnel findPersonnelById(Long id) throws SQLException {
        Connection conn = DbHandler.getConnection();
        String query = "select * from Personnel where id = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String familyName = resultSet.getString("familyName");
            String nationalCode = resultSet.getString("national_code");
            return new Personnel(name, familyName, nationalCode,id);
        }

        return null;
    }
}







