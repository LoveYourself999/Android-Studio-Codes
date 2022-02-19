package com.example.courseinfor;

public class CourseList {
    private Course[] allCourses;

    public CourseList(){
        allCourses = new Course[Course.COURSES.length];// create a new array to store all courses information

        for (int i = 0; i < Course.COURSES.length ; i++) {
            String code = Course.COURSES[i][0];
            String prerequisite = Course.COURSES[i][1];
            String minGpa =  Course.COURSES[i][2];

            allCourses[i] = new Course(code,prerequisite,minGpa);
        }
    }

    public Course[] getAllCourses(){
        return  allCourses;

    }

    public Course getCourse(String code){
        for (int i = 0; i < allCourses.length; i++) {
            if(code.equalsIgnoreCase(allCourses[i].getCode())){
                return allCourses[i] ;
            }
        }
        throw new IllegalArgumentException("Cannot find the course code");


    }

}

