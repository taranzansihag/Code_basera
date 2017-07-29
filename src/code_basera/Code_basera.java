/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_basera;

import java.lang.*;
import java.util.*;

/**
 *
 * @author taranzan
 */
public class Code_basera {

    Scanner sc = new Scanner(System.in);
    ArrayList<Course> courses = new ArrayList<Course>(1000);
    ArrayList<Student> std = new ArrayList<Student>(1000);

    /**
     * @param args the command line arguments
     */
    Course findCourse(String name) {
        for (int i = 0; i < courses.size(); i++) {
            if (name.equals(courses.get(i).name)) {
                return courses.get(i);
            }
        }
        return null;
    }

    Course getCourse() {
        System.out.print("Enter name of Course: ");
        String name = sc.next();
        Course c = findCourse(name);
        if (c == null) {
            System.out.print("Enter Fees of Course : ");
            int fees = sc.nextInt();
            return new Course(name, fees);
        } else {

            System.out.println("Sorry ! This course allready available");
            System.out.print("enter any key : ");
            sc.next();
            return null;
        }
    }

    void addCourse(Course c) {
        courses.add(c);
    }

    Student findStudent(String name) {
        for (int i = 0; i < std.size(); i++) {
            if (name.equals(std.get(i).name)) {
                return std.get(i);
            }
        }
        return null;
    }

    Student getStudent() {
        System.out.print("Enter name of Student: ");
        String name = sc.next();
        Student st = findStudent(name);
        if (st == null) {
            return new Student(name);
        } else {

            System.out.println("Sorry ! This student allready available");
            System.out.print("enter any key : ");
            sc.next();
            return null;
        }
    }

    void addStudent(Student st) {
        std.add(st);
    }
    void displayStudent(){
        for (int i = 0; i < std.size(); i++) {
            System.out.print(i + " ");
            std.get(i).print();
        }
    }
    void enrollStudent() {
        displayStudent();
        System.out.print("choose id of student : ");
        int id = sc.nextInt();
        if (id >= 0 && id < std.size()) {
            //ArrayList<Course> course_name = new ArrayList<Course>(1000);
            while (true) {
                System.out.print("Enter course name : ");
                String c_name = sc.next();
                Course c = findCourse(c_name);
                if (c != null) {
                    std.get(id).course_name.add(c);

                } else {
                    System.out.println("this course not found");
                }

                System.out.println("enter key 0 to exit other key to add more course");
                int key = sc.nextInt();
                if (key == 0) {
                    break;
                }
            }
        } else {
            System.out.print("please enter valid id");
        }
    }

    void takenCourse() {
        displayStudent();
        System.out.print("choose id of student : ");
        int id = sc.nextInt();
        if (id >= 0 && id < std.size()) {
            std.get(id).printCourse();
            System.out.print("Enter any key : ");
            sc.next();
        } else {
            System.out.println("Invalid id");
            System.out.print("enter any key : ");
            sc.next();
        }
    }

    void takenStudent() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.print(i + " ");
            courses.get(i).print();
        }
        System.out.print("choose id of Course : ");
        int id = sc.nextInt();
        if (id >= 0 && id < courses.size()) {
            for (int i = 0; i < std.size(); i++) {
                std.get(i).printStudent(courses.get(id));
            }
            System.out.print("enter any key : ");
            sc.next();
        } else {
            System.out.println("Invalid id");
            System.out.print("enter any key : ");
            sc.next();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Code_basera cb = new Code_basera();
        Scanner sc = new Scanner(System.in);
        boolean input = true;
        while (input) {
            System.out.println("0.Exit");
            System.out.println("1.Add new Course");
            System.out.println("2.Add new Student");
            System.out.println("3.Enroll Student in Course");
            System.out.println("4.Print all course taken by student");
            System.out.println("5.print all student enrolled in course");
            System.out.print("Enter Your choice : ");
            int choose = sc.nextInt();
            switch (choose) {
                case 0: {
                    input = false;
                    break;
                }
                case 1: {

                    Course c = cb.getCourse();
                    if (c != null) {
                        cb.addCourse(c);
                    }
                    break;

                }
                case 2: {
                    Student st = cb.getStudent();
                    if (st != null) {
                        cb.addStudent(st);
                    }
                    break;
                }
                case 3: {
                    cb.enrollStudent();
                    break;
                }
                case 4: {
                    cb.takenCourse();
                    break;
                }
                case 5: {
                    cb.takenStudent();
                    break;
                }
                default: {
                    System.out.println("please choose b/w choice");
                    System.out.print("enter any key : ");
                    sc.next();
                }
            }
        }
    }

}
