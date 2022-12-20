package dao;

import entity.Personnel;
import entity.Vacation;
import service.PersonnelService;
import utils.DbHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacationDao {

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    // TODO
    public void insert(Vacation vacation) throws SQLException {
        Connection conn = DbHandler.getConnection();

        String query = "insert into vacation (personnel_id,date,id,confirmed) values (?,?,?,?);";
        PreparedStatement statement = conn.prepareStatement(query);

        statement.setInt(1, (int) vacation.getPersonnel().getId());
        statement.setString(2, vacation.getLeaveDate().toString());
        statement.setInt(3, getRandomNumber(1, 100));
        statement.setInt(4, vacation.isConfirmed() ? 1 : 0);
        int row = statement.executeUpdate();
        System.out.println(row);
    }

    // TODO: findBYPersonnelID
    public List<Vacation> findVacationsBYPersonnelID(long personnelId) throws SQLException {
        Connection conn = DbHandler.getConnection();
        String querySelect = "select * from vacation where personnel_id = ?";

        PreparedStatement statement = conn.prepareStatement(querySelect);
        statement.setLong(1, personnelId);
        ResultSet resultSet = statement.executeQuery();

        List<Vacation> vacationList = new ArrayList<>();
        PersonnelService personnelService = new PersonnelService();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String date = resultSet.getString("date");
            Personnel personnel = personnelService.findPersonnelById(resultSet.getLong("personnel_id"));
            boolean confirmed = resultSet.getInt("confirmed") == 1;

            Vacation vac = new Vacation(id, personnel, date, confirmed);
            vacationList.add(vac);
        }

        return vacationList;
    }


}