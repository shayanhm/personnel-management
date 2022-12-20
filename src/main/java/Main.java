import entity.Personnel;
import entity.Vacation;
import service.PersonnelService;
import service.VacationService;
import utils.SavedRecordException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        PersonnelService personnelService = new PersonnelService();
        VacationService vacationService = new VacationService();
        int input;
        do {
            System.out.println("1.Add Personnel");
            System.out.println("2.Add Vacation");
            System.out.println("3.Confirm Vacation");
            System.out.println("4.Exit");

            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.println("enter your name: ");
                    String name = scanner.nextLine();

                    System.out.println("enter your familyName: ");
                    String familyName = scanner.nextLine();

                    System.out.println("enter your nationalCode: ");
                    String nationalCode = scanner.nextLine();

                    try {
                        personnelService.addPersonnel(new Personnel(name, familyName, nationalCode));
                        System.out.println("your name is " + name + " and your familyName is " + familyName + " and your nationalCode is " + nationalCode);
                    } catch (SQLException e) {
                        System.out.println("sql exception..");
                    } catch (SavedRecordException e) {
                        System.out.println(e.getMessage());
                    }


                    break;

                case 2:
                    System.out.println("<<request for vacation>> ");
                    System.out.println("enter your nationalCode: ");
                    String code = scanner.nextLine();

                    try {
                        Personnel personnel = personnelService.findByNationalCode(code);
                        if (personnel == null) {
                            System.out.println("personnel not exist");
                        }

                        vacationService.addVacation(new Vacation(personnel, "txt"));
                        // Vacation vacation = new Vacation(personnel, new Date());
                        // vacation.addVacation(vacation);
                        System.out.println("vacation creation successfully ..");
                    } catch (SQLException e) {
                        System.out.println("sql exception ...");
                    }

//                    if (personnel == null) {
//                        System.out.println("personnel not exist");
//                        continue;
//                    }

                    break;
                case 3:

                    System.out.println("<< VACATION LIST >>");
                    System.out.println("Enter NationalCode to search Vacations: ");
                    String searchCode = scanner.nextLine();
                    Personnel personnel1 = personnelService.findByNationalCode(searchCode);
                    if (personnel1 == null) {
                        System.out.println("personnel not exist");
                        continue;
                    }

                    List<Vacation> vacationList = vacationService.findVacationsByPersonnelId(personnel1.getId());

                    for (Vacation vac : vacationList) {
                        System.out.println("name :" + vac.getPersonnel().getName() + "   familyName:" + vac.getPersonnel().getFamilyName() + "   nationalCode: " + vac.getPersonnel().getNationalCode() + "   date : " + vac.getLeaveDate());
                    }
                    break;

                case 4:
                    System.out.println("you exited..");
                    System.exit(0);
                    break;


                default:
                    System.out.println("incorrect value !!!!");
            }

        } while (input != 0);

    }
}
