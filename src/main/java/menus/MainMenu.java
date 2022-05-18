package menus;

import student.StudentMenu;
import teacher.TeacherMenu;

import java.util.Scanner;

public class MainMenu {
    private static final String typ1 = "Director";
    private static final String typ2 = "Teacher";
    private static final String typ3 = "Student";


    public static void mMenu() {

        try {
            System.out.println("Welcome to the mountain-climbing Educational center !");
            System.out.println("Please type of our account");
            System.out.println("Please type type of your account !");
            Scanner input = new Scanner(System.in);
            String type = input.nextLine();
            if (type.equalsIgnoreCase(typ1)) {
                DirectorMenu.DMenu();
            } else if (type.equalsIgnoreCase(typ2)) {
                TeacherMenu.tMenu();
            } else if (type.equalsIgnoreCase(typ3)) {
                StudentMenu.sMenu();
            } else {
                throw new Exception("");
            }
        } catch (Exception ex) {
            System.out.println("You type wrong acType !");
            System.out.println("1 - Go to previous menu\n" +
                    "2 - Quit");
            Scanner input = new Scanner(System.in);
            int choose = input.nextInt();
            if (choose == 1) {
                MainMenu.mMenu();
            } else {
                System.exit(0);
            }
        }
    }
}
