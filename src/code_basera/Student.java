/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_basera;

import java.util.ArrayList;

/**
 *
 * @author taranzan
 */
class Student {

    String name;
    ArrayList<Course> course_name = new ArrayList<Course>(1000);
    Student(String name) {
        this.name = name;
    }
    void print(){
        System.out.println(this.name);
    }
    void printCourse() {
        for(int i=0 ; i<course_name.size() ; i++){
            System.out.print(this.course_name.get(i).name+" ");
        }
    }
    void printStudent(Course c) {
        for(int i=0 ; i<course_name.size() ; i++){
            if(course_name.get(i).name.equals(c.name)){
                 System.out.print(this.name+" ");
            }
        }
    }
}
