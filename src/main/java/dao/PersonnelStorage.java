package dao;

import entity.Personnel;

import java.util.ArrayList;
import java.util.List;

public class PersonnelStorage {
    private static List<Personnel> personnelList = new ArrayList<>();

    // findAll
    public static List<Personnel> findALL(Personnel personnel) {
        return personnelList;
    }


    // add
    public static void addPersonnel(Personnel personnel) {

        personnelList.add(personnel);
    }


    // findByNationalCode
    public static Personnel findByNationalCode(String nationalCode) {
        for (Personnel current : personnelList) {
            if (current.getNationalCode().equals(nationalCode)) {
                return current;
            }
        }
        return null;
    }
}
