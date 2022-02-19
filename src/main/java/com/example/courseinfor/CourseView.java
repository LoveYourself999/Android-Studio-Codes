package com.example.courseinfor;

import java.util.Scanner;

public class CourseView {
    private CourseList lisCourse = new CourseList();
    public Scanner scan = new Scanner(System.in);

    public void  enterMainMenu() {
        String search;
        String answer;
        System.out.println("Welcome!");
        listAllCourses();

    }
    public String listCourse(String s){
           String str ="";
           str += lisCourse.getCourse(s);
           str+= "\nNext courses: " + lisCourse.getCourse(s).getNextCourse();
           return str;
    }


    public String listAllCourses(){

        String str = "Courses:\n";
        Course[] courses = lisCourse.getAllCourses();
        for (int i = 0; i < courses.length; i++) {
            str+=courses[i].getCode();
            str += "\n";

        }
        return str;
    }

    public static void main(String[] args) {
        CourseView courseV = new CourseView();
        courseV.enterMainMenu();
    }
}

