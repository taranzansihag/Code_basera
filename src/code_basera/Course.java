/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_basera;

/**
 *
 * @author taranzan
 */
class Course {

    String name;
    int fees;

    Course(String name, int fee) {
        this.name = name;
        this.fees = fees;
    }
    void print(){
        System.out.println(this.name);
    }
    
}
