package dao;

import entity.Personnel;
import entity.Vacation;

import java.util.ArrayList;
import java.util.List;

public class VacationStorage {

    public static List<Vacation> VacationList = new ArrayList<>();

    // Todo: add
    public static void addVacation(Vacation vacation) {
        VacationList.add(vacation);
    }

    // Todo: findAll
    public static List<Vacation> findAllVacation() {
        return VacationList;
    }


    // Todo: findVacationsByPersonnel
    public static List<Vacation> findVacationsByPersonnel(Personnel personnel) {
        List<Vacation> vacations = new ArrayList<>();
        for (Vacation vacation : VacationList) {
            if (vacation.getPersonnel().equals(personnel)) {
                vacations.add(vacation);
            }
        }
        return vacations;
    }

}
