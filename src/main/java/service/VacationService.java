package service;

import dao.VacationDao;
import entity.Vacation;

import java.sql.SQLException;
import java.util.List;


public class VacationService {
    private final VacationDao vacationDao = new VacationDao();

    public void addVacation(Vacation vacation) throws SQLException {
        vacationDao.insert(vacation);
    }

    public List<Vacation> findVacationsByPersonnelId(long personnelId) throws SQLException {
        return  vacationDao.findVacationsBYPersonnelID(personnelId);
    }
}
