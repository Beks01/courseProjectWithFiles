package student;

import exams.ExamRepositoryImpl;
import exams.Exams;
import exams.ResultImpl;
import menus.MainMenu;
import student.*;
import subjects.*;
import tasks.*;
import tasks.TasksRepositoryFileImpl;
import teacher.*;

import java.util.*;


public class StudentMenu {

    public static void sMenu() {
        //TODO Complete method
        System.out.println("Welcome to StudentsPart");
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Please type your Login\n");
            String login = input.nextLine();
            System.out.print("Please type your Password\n");
            String password = input.nextLine();
            if (loginChecker(login, password)) {
                System.out.print("Welcome to Student's part\n");
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
                    case 1 -> listSubject();
                    case 2 -> listOfMarks();
                    case 3 -> listOfTasks();
                    case 4 -> listOfExams();
                    case 5 -> listOfPassers();
                    case 6 -> maxPoint();
                    case 7 -> minPoint();
                    case 8 -> MainMenu.mMenu();
                    case 9 -> System.exit(0);
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
    private static void selfMenu(){

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
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        switch (choose) {
            case 1 -> listSubject();
            case 2 -> listOfMarks();
            case 3 -> listOfTasks();
            case 4 -> listOfExams();
            case 5 -> listOfPassers();
            case 6 -> maxPoint();
            case 7 -> minPoint();
            case 8 -> MainMenu.mMenu();
            case 9 -> System.exit(0);
        }

    }

    private static boolean loginChecker(String acType, String password) {
        //проверяет есть ли в тот иной учитель в базе данных
        TeachersRepositoryFileImpl teachersRepositoryFile = new TeachersRepositoryFileImpl("Studentpsrd.txt");
        List<Teachers> teachers = teachersRepositoryFile.findAll();
        boolean checker = false;
        for (Teachers students1 : teachers) {
            if (acType.equals(students1.getLogin()) && password.equals(students1.getPassword())) {
                checker = true;
                break;
            }
        }
        return checker;
    }

    private static void listSubject() {//#1 Показать список предметов
        // TODO To complete
        SubjectsRepositoryFileImpl subjectsRepositoryFile = new SubjectsRepositoryFileImpl("subjects.txt");
        List<Subjects> subjects = subjectsRepositoryFile.findAll();
        for (Subjects subjects1 : subjects) {
            System.out.printf("Subject:%-5s| Teacher:%-5s| Mark:%-5s \n", subjects1.getSubjectName(), subjects1.getTeacherName(), subjects1.getMark());
        }
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            StudentMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    private static void listOfMarks() {//#2 Показать список оценок по предметам
        SubjectsRepositoryFileImpl subjectsRepositoryFile = new SubjectsRepositoryFileImpl("subjects.txt");
        List<Subjects> subjects = subjectsRepositoryFile.findAll();
        for (Subjects subjects1 : subjects) {
            System.out.printf("Subject:%-5s| Mark:%-5s \n", subjects1.getSubjectName(), subjects1.getMark());
        }
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            StudentMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    private static void listOfTasks() {//#3 Показывает список заданий
        TasksRepositoryFileImpl tasksRepositoryFile = new TasksRepositoryFileImpl("tasks.txt");
        List<Tasks> tasks = tasksRepositoryFile.findAll();
        for (Tasks tasks1 : tasks) {
            System.out.printf("Subject: %-5s| Task: %-5s| Since: %-5tc| DeadLine: %-5tc| \n", tasks1.getSubject(), tasks1.getTask(), tasks1.getSince(), tasks1.getDeadline());
        }
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            StudentMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    private static void listOfExams() {//#4 Показывает лист экзаменов
        //TODO to complete part with date;
        ExamRepositoryImpl examRepository = new ExamRepositoryImpl("exams.txt");
        List<Exams> exams = examRepository.findAll();
        for (Exams exams1 : exams) {
            System.out.printf("Subject %-5s| Teacher: %-5s| Date: %-5s|", exams1.getSubject(), exams1.getTeacher(), exams1.getDate());
        }
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            StudentMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    private static void listOfPassers() {//#5 Показывает список зачетов TODO Показать класс экзаменов и результатов экзаменов
        ExamRepositoryImpl examRepository = new ExamRepositoryImpl("exams.txt");
        List<Exams> exams = examRepository.findAll();
        for (Exams exams1 : exams) {
            //System.out.printf("Subject %-5s| Mark: %-5s| isPassed: %-5s", exams1.getSubject(), exams1.getMark(), exams1.isPassed());
        }
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            StudentMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    private static void maxPoint() {//#6 Показывает ваш максимальный балл TODO показать результаты из класса Results
//        int maxPoint = 0;
//        String sub = null;
//        ExamRepositoryImpl examRepository = new ExamRepositoryImpl("exams.txt");
//        List<Exams> exams = examRepository.findAll();
//        for (Exams exams1 : exams) {
//            if (exams1.getMark() > maxPoint) {
//                maxPoint = exams1.getMark();
//                sub = exams1.getSubject();
//            }
//        }
//        System.out.printf("MaxPointOf: %-5s| Points: %-5s", sub, maxPoint);
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            StudentMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }


    private static void minPoint() {//#7 Показывает ваш минимальный балл TODO показать результаты из класса Results
//        int minPoint = 0;
//        int maxPoint = 0;
//        String sub = null;
//        ExamRepositoryImpl examRepository = new ExamRepositoryImpl("exams.txt");
//        List<Exams> exams = examRepository.findAll();
//
//        for (Exams exams1 : exams) {
//            if (exams1.getMark() > maxPoint) {
//                maxPoint = exams1.getMark();
//            }
//        }
//        for (Exams exams1 : exams) {
//            if (exams1.getMark() < maxPoint) {
//                minPoint = exams1.getMark();
//                sub = exams1.getSubject();
//            }
//        }
//        System.out.printf("MinPointOf: %-5s| Points: %-5s", sub, minPoint);
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            StudentMenu.selfMenu();
        } else {
            System.exit(0);
        }


    }
}
//sfdsdfsdfsjfijsfs
//sdfsfdsdf
//sf
//sdfdsfsdf
//sfdsdfsdf
//sdfsdf