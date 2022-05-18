package menus;

import student.Students;
import student.StudentsRepositoryFileImpl;
import subjects.Subjects;
import subjects.SubjectsRepositoryFileImpl;
import teacher.TeacherMenu;
import teacher.Teachers;
import teacher.TeachersRepositoryFileImpl;

import java.util.*;


public class DirectorMenu {


    public static void DMenu() {
        System.out.println("Welcome to TeacherPart !");
        try {
            System.out.print("Please type your Login\n");
            Scanner input = new Scanner(System.in);
            String acType = input.nextLine();
            System.out.print("Please type your Password\n");
            String password = input.nextLine();
            if (loginChecker(acType, password)) {
                System.out.print("Welcome to Director's part\n");
                System.out.println("Please Type the number to open certain things part!");
                System.out.println("""
                        1 - Show all subjects:
                        2 - Number of All students:
                        3 - Show all students:
                        4 - Add teacher:
                        5 - Delete teacher:
                        6 - Add Student:
                        7 - Delete Student:
                        8 - Go to Main menu:
                        9 - Quit:
                        """);
                int choose = input.nextInt();
                switch (choose) {
                    case 1 -> listSubjects();
                    case 2 -> numberOfStdts();
                    case 3 -> listOfTeachers();
                    case 4 -> addTeacher();
                    case 5 -> deleteTeacher();
                    case 6 -> addStudent();
                    case 7 -> deleteStudent();
                    case 8 -> toPreMenu();
                    case 9 -> MainMenu.mMenu();
                    case 10 -> quit();
                }
            } else {
                System.out.println("Login or Password is wrong !");
                System.out.println("1 - Go to previous menu\n" +
                        "2 - Quit");
                int choose = input.nextInt();
                if (choose == 1) TeacherMenu.tMenu();
                else if (choose == 2) System.exit(0);

            }
        } catch (Exception e) {
            System.out.println("You typed wrong type of variable !");
            TeacherMenu.tMenu();
        }
    }

    private static void selfMenu() {
        try {
            Scanner input = new Scanner(System.in);
                System.out.println("Please Type the number to open certain things part!");
                System.out.println("""
                        1 - Show all subjects:
                        2 - Number of All students:
                        3 - Show all students:
                        4 - Add teacher:
                        5 - Delete teacher:
                        6 - Add Student:
                        7 - Delete Student:
                        8 - Go to Main menu:
                        9 - Quit:
                        """);
                int choose = input.nextInt();
                switch (choose) {
                    case 1 -> listSubjects();
                    case 2 -> numberOfStdts();
                    case 3 -> listOfTeachers();
                    case 4 -> addTeacher();
                    case 5 -> deleteTeacher();
                    case 6 -> addStudent();
                    case 7 -> deleteStudent();
                    case 8 -> toPreMenu();
                    case 9 -> MainMenu.mMenu();
                    case 10 -> quit();
                }

        } catch (Exception e) {
            System.out.println("You typed wrong type of variable !");
            TeacherMenu.tMenu();
        }
    }

    private static boolean loginChecker(String login, String password) {
        //проверяет есть ли в тот иной директор в базе данных
        TeachersRepositoryFileImpl teachersRepositoryFile = new TeachersRepositoryFileImpl("directors.txt");
        List<Teachers> teachers = teachersRepositoryFile.findAll();
        boolean checker = false;
        for (Teachers teachers1 : teachers) {
            if (login.equals(teachers1.getLogin()) && password.equals(teachers1.getPassword())) {
                checker = true;
                break;
            }
        }
        return checker;
    }


    private static void listSubjects() {//#1 Показать список предметов
        // TODO To complete
        SubjectsRepositoryFileImpl subjectsRepositoryFile = new SubjectsRepositoryFileImpl("subjects.txt");
        List<Subjects> subjects = subjectsRepositoryFile.findAll();
        for (Subjects subjects1 : subjects) {
            System.out.printf("Subject:%-5s| Teacher:%-5s |\n", subjects1.getSubjectName(), subjects1.getTeacherName());
            System.out.println();
            System.out.println("""
                    1 - Go to previous menu
                    2 - Quit""");
            Scanner input = new Scanner(System.in);
            int choose = input.nextInt();
            if (choose == 1) {
                DirectorMenu.selfMenu();
            } else {
                System.exit(0);
            }
        }
    }


    private static void numberOfStdts() {// #2 Количество студентов во всем курсе
        SubjectsRepositoryFileImpl subjectsRepositoryFile = new SubjectsRepositoryFileImpl("subjects.txt");
        List<Subjects> subjects = subjectsRepositoryFile.findAll();
        subjects.forEach(subjects1 -> System.out.printf("Subject: %-5s Number: %-5s", subjects1.getSubjectName(), subjects.size()));
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            DirectorMenu.selfMenu();
        } else {
            System.exit(0);
        }


    }

    private static void listOfTeachers() {//#3 Показывает список учителей и предмет который они ведут
        TeachersRepositoryFileImpl teachersRepositoryFile = new TeachersRepositoryFileImpl("teachers.txt");
        List<Teachers> teachers = teachersRepositoryFile.findAll();
        teachers.forEach(teachers1 -> System.out.printf("Teacher: %-5s| Subject: %-5s", teachers1.getFullName(), teachers1.getSubject()));
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            DirectorMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }


    private static void addTeacher() {//#4 Добавить учителя
        TeachersRepositoryFileImpl teachersRepositoryFile = new TeachersRepositoryFileImpl("teachers.txt");
        Scanner input = new Scanner(System.in);
        System.out.println("Type AcType\n");
        String acType = input.nextLine();
        System.out.println("Type login\n");
        String login = input.nextLine();
        System.out.println("Type password\n");
        String password = input.nextLine();
        System.out.println("Type Full Name of The Teacher\n");
        String fullName = input.nextLine();
        System.out.println("Type the subject the teacher will teach!\n");
        String subject = input.nextLine();
        System.out.println("Type age of your teacher!\n");
        int age = input.nextInt();
        Teachers teacher = new Teachers(acType, login, password, fullName, subject, age);
        teachersRepositoryFile.save(teacher);
        System.out.println("SAVED!");
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input1 = new Scanner(System.in);
        int choose = input1.nextInt();
        if (choose == 1) {
            DirectorMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    private static void deleteTeacher() {//TODO #5 to learn how to delete from txt
    }

    private static void addStudent() {// #6 Добавить студента

        StudentsRepositoryFileImpl studentsRepositoryFile = new StudentsRepositoryFileImpl("students.txt");
        Scanner input = new Scanner(System.in);
        System.out.println("Type AcType\n");
        String acType = input.nextLine();
        System.out.println("Type login\n");
        String login = input.nextLine();
        System.out.println("Type password\n");
        String password = input.nextLine();
        System.out.println("Type Full Name of The Student\n");
        String fullName = input.nextLine();
        System.out.println("Type age of your teacher!\n");
        int age = input.nextInt();
        Students students = new Students(acType, login, password, fullName, age);
        studentsRepositoryFile.save(students);
        System.out.println("SAVED!");
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input2 = new Scanner(System.in);
        int choose = input2.nextInt();
        if (choose == 1) {
            DirectorMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    private static void deleteStudent() {// #7 Удалить студента  TODO to learn how to delete from txt
    }

    private static void toPreMenu() {// #8 Возвратиться к придыдущему меню
        MainMenu.mMenu();
    }

    private static void quit() {// #9 Выйти
        System.exit(0);
    }
}
