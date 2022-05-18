package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestStudent {
    public static void main(String[] args){
//        StudentsRepositoryFileImpl studentsRepositoryFile = new StudentsRepositoryFileImpl("students.txt");
//        List<Students> list = studentsRepositoryFile.findAll();
//        for (Students students:list) {
//            System.out.println(students);

        problenm();
    }

    static void problenm() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        try {
            if (num == 1) {
                System.out.println("Работает!");
            } else {
                throw new Exception("Код не работает");
            }
        } catch (Exception e) {
            problenm();
        }
    }
}
