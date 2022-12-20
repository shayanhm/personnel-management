package service;


import dao.PersonnelDao;
import dao.PersonnelStorage;
import entity.Personnel;
import utils.SavedRecordException;

import java.sql.SQLException;
import java.util.List;

public class PersonnelService {

    private final PersonnelDao personnelDao = new PersonnelDao();

    //todo :create personnel
    public void addPersonnel(Personnel personnel) throws SQLException, SavedRecordException {
        if (canSave(personnel)) {
            personnelDao.insert(personnel);
        } else {
            // throws duplicateRecordException
            throw new SavedRecordException("personnel exist...");
//            System.out.println("personnel exist...");
        }
    }

    private boolean canSave(Personnel personnel) throws SQLException {
        if (personnelDao.findByNationalCode(personnel.getNationalCode()) == null) {
            // if personnel does NOT exist you can save this personnel
            return true;
        } else {
            // if personnel exist you can NOT save this personnel
            return false;
        }
    }

    //todo :findAll
    public List<Personnel> findAll(Personnel personnel) {
        return PersonnelDao.findALL(personnel);

    }

    //todo :findByNationalCode
    public Personnel findByNationalCode(String nationalCode) throws SQLException {
        return personnelDao.findByNationalCode(nationalCode);
    }

    //todo :findPersonnelById
    public Personnel findPersonnelById(Long id) throws SQLException{
        return personnelDao.findPersonnelById(id);
    }

}

