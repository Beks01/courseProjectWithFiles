package teacher;

import exams.ExamRepositoryImpl;
import exams.Exams;
import menus.MainMenu;
import subjects.*;
import tasks.Tasks;
import tasks.TasksRepositoryFileImpl;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;

import student.*;


public class TeacherMenu {
    public static void tMenu() {
        //TODO Complete method
        System.out.println("Welcome to TeacherPart !");
        try {
            System.out.print("Please type your Login\n");
            Scanner input = new Scanner(System.in);
            String acType = input.nextLine();
            System.out.print("Please type your Password\n");
            String password = input.nextLine();
            if (loginChecker(acType, password)) {
                System.out.print("Welcome to Teacher's part\n");
                System.out.println("Please Type the number to open certain things part!");
                System.out.println("""
                        1 - Show all subjects:
                        2 - Show all marks of the certain student:
                        3 - Show all students:
                        4 - Show all exams:
                        5 - Show all students who passed the exams:
                        6 - Show max points of certain student for the definite subject:
                        7 - Show min points of certain student for the definite subject:
                        8 - Add a task:
                        9 - Go to Main menu:
                        10 - Quit:
                        """);
                int choose = input.nextInt();
                switch (choose) {
                    case 1 -> subjectList();
                    case 2 -> markList();
                    case 3 -> numberOfSdnts();
                    case 4 -> listOfExams();
                    case 5 -> listOfPassers();
                    case 6 -> maxNumOfMarks();
                    case 7 -> minNumOfMarks();
                    case 8 -> addTask();
                    case 9 -> MainMenu.mMenu();
                    case 10 -> System.exit(0);
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
        System.out.print("Welcome to Teacher's part\n");
        System.out.println("Please Type the number to open certain things part!");
        System.out.println("""
                1 - Show all subjects:
                2 - Show all marks of the certain student:
                3 - Show all students:
                4 - Show all exams:
                5 - Show all students who passed the exams:
                6 - Show max points of certain student for the definite subject:
                7 - Show min points of certain student for the definite subject:
                8 - Go to Main menu:
                9 - Quit:
                """);
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        switch (choose) {
            case 1 -> subjectList();
            case 2 -> markList();
            case 3 -> numberOfSdnts();
            case 4 -> listOfExams();
            case 5 -> listOfPassers();
            case 6 -> maxNumOfMarks();
            case 7 -> minNumOfMarks();
            case 8 -> MainMenu.mMenu();
            case 9 -> System.exit(0);
        }
    }

    private static boolean loginChecker(String login, String password) {
        //проверяет есть ли в тот иной учитель в базе данных
        TeachersRepositoryFileImpl teachersRepositoryFile = new TeachersRepositoryFileImpl("teachers.txt");
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

    private static void subjectList() { //#1 Показывает список предметов которую ведет учитель
        TeachersRepositoryFileImpl teachersRepositoryFile = new TeachersRepositoryFileImpl("teachers.txt");
        List<Teachers> teachers = teachersRepositoryFile.findAll();
        teachers.forEach(subjects1 -> System.out.printf("Teacher:%-5s | Subject:%-5s|\n", subjects1.getFullName(),subjects1.getSubject()));
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            TeacherMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    public static void markList() {//#2 Показывает список оценок и студентов
        SubjectsRepositoryFileImpl subjectsRepositoryFile = new SubjectsRepositoryFileImpl("subjects.txt");
        List<Subjects> subjects = subjectsRepositoryFile.findAll();
        for (Subjects subjects1 : subjects) {
            System.out.println(subjects1);
        }
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            TeacherMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    public static void numberOfSdnts() {// #3 Показывает количество всех студентов
        StudentsRepositoryFileImpl studentsRepositoryFile = new StudentsRepositoryFileImpl("students.txt");
        List<Students> students = studentsRepositoryFile.findAll();
        System.out.println("Number of all Students: " + students.size());
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            TeacherMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    public static void numberOfSdntsBySbjct() {//#4 Показывает количество студентов по предметам
        // TODO complete this method
        StudentsRepositoryFileImpl studentsRepositoryFile = new StudentsRepositoryFileImpl("students.txt");
        List<Students> list = studentsRepositoryFile.findAll();
        System.out.println("Number of all Students: " + list.size());
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            TeacherMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    private static void listOfExams() {//#5 Показывает список экзаменов
        ExamRepositoryImpl examRepository = new ExamRepositoryImpl("exams.txt");
        List<Exams> exams = examRepository.findAll();
        for (Exams exams1 : exams) {
            System.out.println(exams1);
        }
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            TeacherMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    private static void listOfPassers() {// #6 Показывает список зачетов
        // TODO complete method by adding list of Students

    }

    private static void maxNumOfMarks() {//#7 Показать максимальный балл по предмету
        // TODO complete this method
        SubjectsRepositoryFileImpl subjectsRepositoryFile = new SubjectsRepositoryFileImpl("subject.txt");
        List<Subjects> subjects = subjectsRepositoryFile.findAll();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type name of the subject\n");
        String subject = sc.nextLine();
        for (Subjects subjects1 : subjects) {
            if (subject.equals(subjects1.getSubjectName())) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            TeacherMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

    private static void addTask() {//#8 добавляет задание
        TasksRepositoryFileImpl tasksRepositoryFile = new TasksRepositoryFileImpl("tasks.txt");
        LocalDate since = LocalDate.now();
        Scanner input = new Scanner(System.in);
        System.out.println("Type the Subject Name:");
        String subject = input.nextLine();
        System.out.println("Type the task:");
        String task = input.nextLine();
        System.out.println("Please type the day till the students have to do their task !");
        int day = input.nextInt();
        Date deadLine = new Date(since.getYear(), since.getMonth().getValue(), day);
        Tasks tasks = new Tasks(subject, task, since, deadLine);
        tasksRepositoryFile.save(tasks);
        System.out.println("SAVED!");
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input1 = new Scanner(System.in);
        int choose = input1.nextInt();
        if (choose == 1) {
            TeacherMenu.selfMenu();
        } else {
            System.exit(0);
        }


    }

//      private static void deleteTaskAfterDdln(int day) {
//        try {
//            TasksRepositoryFileImpl tasksRepositoryFile = new TasksRepositoryFileImpl("tasks.txt");
//            List<Tasks> tasks = tasksRepositoryFile.findAll();
//            File file = new File("tasks.txt");
//            Writer writer = new FileWriter(file,true);
//            BufferedWriter bufferedWriter = new BufferedWriter(writer);
//            String filePath = "task.txt";
//            String result = fileToString(filePath);
//            System.out.println("Contents of the file: " + result);
//            //Replacing the word with desired one
//            result = result.replaceAll("\\bTutorialspoint\\b", "");
//            //Rewriting the contents of the file
//           // PrintWriter writer = new PrintWriter(new File(filePath));
//            writer.append(result);
//            writer.flush();
//            System.out.println("Contents of the file after replacing the desired word:");
//            System.out.println(fileToString(filePath));
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//    }

//    public static String fileToString(String filePath) throws Exception {
//        String input = null;
//        Scanner sc = new Scanner(new File(filePath));
//        StringBuilder sb = new StringBuilder();
//        while (sc.hasNextLine()) {
//            input = sc.nextLine();
//            sb.append(input);
//        }
//        return sb.toString();
//    }


    private static void minNumOfMarks() {//#9 Показать минимальный балл по предмету
        // TODO complete this method
        SubjectsRepositoryFileImpl subjectsRepositoryFile = new SubjectsRepositoryFileImpl("subject.txt");
        List<Subjects> subjects = subjectsRepositoryFile.findAll();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type name of the subject\n");
        String subject = sc.nextLine();
        for (Subjects subjects1 : subjects) {
            if (subject.equals(subjects1.getSubjectName())) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("""
                1 - Go to previous menu
                2 - Quit""");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        if (choose == 1) {
            TeacherMenu.selfMenu();
        } else {
            System.exit(0);
        }
    }

}
