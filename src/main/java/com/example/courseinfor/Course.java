package com.example.courseinfor;

import java.util.Arrays;

public class Course {
    public static final String[][] COURSES ={
            {"EECS1019","",""},
            {"MATH1019","","4.5"},
            {"EECS1022","EECS1015","4.5"},
            {"MATH1090","EECS1019/MATH1019","4.5"},
            {"EECS2001","EECS1022,MATH1019/EECS1019","4.5"},
            {"EECS2030","EECS1022","4.5"},
            {"EECS2031","EECS1022","4.5"},
            {"EECS2011","EECS2030,EECS1019/MATH1019,MATH1090","4.5"},
            {"EECS2021","EECS1022","4.5"},
            {"EECS3101","MATH1090,MATH1310,EECS2011","4.5"},
            {"EECS3311","MATH1090,EECS2011,EECS2030,EECS2031","4.5"},
            {"EECS3221","EECS2030,EECS2031,EECS2021","4.5"},
            {"EECS3401","MATH1090,EECS2030,EECS2011","4.5"},
            {"EECS3421","EECS2030","4.5"},
            {"EECS3461","EECS2030","4.5"},
            {"EECS3000","EECS2030","4.5"}
    };

    private String code; //course code
    //private String name;
    private String prerequisite;
    private  String nextCourse; //the course after the current course
    private String minGpa;
    public Course(){

    }
    public Course(String code, String prerequisite, String minGpa){
        this.code = code;
        this.prerequisite = prerequisite;
        this.nextCourse = findNextCourse();
        this. minGpa = minGpa;
    }

    public String getCode() {

        return code;
    }



    //This method can add a new element to the end of the Array
    public static String[] append(String oldArray[], String s)
    {
        int i;
        String newArray[] = new String[oldArray.length+1];
        //copy original array into new array
        for (i = 0; i < oldArray.length; i++){
            newArray[i] = oldArray[i];
        }
        //add element to the new array
        newArray[oldArray.length] = s;

        return newArray;
    }



    public String getNextCourse() {

        return nextCourse;
    }


    private String findNextCourse(){
        String[] nextCourseSet=new String[0];
        for (int i = 0; i < COURSES.length ; i++) {
            //Split the combined prerequisite String into single courses.
            String[] preRequisiteSet = COURSES[i][1].split(", ");
            //if COURSES[i] has this course as prerequisite, add COURSE[i] coursecode to the end of Nextcourse Array
            if(Arrays.asList(preRequisiteSet).contains(this.code)){
                nextCourseSet = append(nextCourseSet,COURSES[i][0]);
            }
        }
        String allNextCourses="";
        for(int i=0;i<nextCourseSet.length;i++){
            if(i!=nextCourseSet.length-1){
                allNextCourses = allNextCourses.concat(nextCourseSet[i]).concat(",");
            }
            else {
                allNextCourses = allNextCourses.concat(nextCourseSet[i]);
            }
        }
        return allNextCourses;
    }


    public String getDetails(){
        return "Course: " + code + "\t\t" + "\nPrerequisite: " + prerequisite + "\t\t" + "\nMinGPA: " + "\t\t" + minGpa;
    }
    public String toString(){
        return getDetails();
    }
}

