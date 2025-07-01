package org.example;

import java.util.*;



public class Main{
    public static char numericToLetterGrader(int grade){
        if (grade >= 90 && grade <= 100){
            return 'A';
        } else if (grade >= 80 && grade <= 89) {
            return 'B';
        } else if (grade >= 70 && grade <= 79) {
            return 'C';
        } else if (grade >= 60 && grade <= 69) {
            return 'D';
        } else {
            return 'F';
        }
    }
    public static void letterGradeCounter(int[] letterGradeCount, char letterGrade){
        switch (letterGrade){
            case 'A':{
                letterGradeCount[0] += 1;
                break;
            }
            case 'B':{
                letterGradeCount[1] += 1;
                break;
            }
            case 'C':{
                letterGradeCount[2] += 1;
                break;
            }
            case 'D':{
                letterGradeCount[3] += 1;
                break;
            }
            case 'F':{
                letterGradeCount[4] += 1;
                break;
            }

        }
    }

    public static void main(String[] args) {
        class StudentInfo{
            String name;
            int numericGrade;
            char letterGrade;

            StudentInfo(String name, int numericGrade, boolean willDisplayLetterGrade){
                this.name = name;
                this.numericGrade = numericGrade;
                this.letterGrade = numericToLetterGrader(numericGrade);
                if (willDisplayLetterGrade){
                    System.out.println(name + " got grade: " + letterGrade);
                }
            }
            void displayLetterGrade(){
                System.out.println(name + " got grade: " + letterGrade);
            }

        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");

        int numberOfStudents = scanner.nextInt();
        System.out.println("");

        StudentInfo[] classInfo = new StudentInfo[numberOfStudents];
        int[] letterGradeCount = new int[5];
        /*
           letterGradeCount[0] -> the number of students with grade 'A'
           letterGradeCount[1] -> the number of students with grade 'B'
           and so on...
        */
        int highestGrade = -99;
        ArrayList<Integer> highestGradesIdx =  new ArrayList<>();

        for (int i = 0; i < numberOfStudents; i++){
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String studentName = scanner.next();

            System.out.print("Enter score for " + studentName + ": ");
            int currentGrade = scanner.nextInt();

            classInfo[i] = new StudentInfo(studentName, currentGrade, true);
            System.out.println("");

            letterGradeCounter(letterGradeCount, numericToLetterGrader(currentGrade));
            if (currentGrade >= highestGrade){
                highestGrade = currentGrade;
                highestGradesIdx.add(i);
            }
        }

        double classAverage = 0.00;
        for (StudentInfo info : classInfo){
            classAverage += (double) info.numericGrade;
        }
        classAverage /= numberOfStudents;

        System.out.println("----- Class Summary -----");
        System.out.println("Average Score: " + String.format("%.2f", classAverage));
        System.out.print("Grade Counts:");
        System.out.print(" A:" + letterGradeCount[0]);
        System.out.print(" B:" + letterGradeCount[1]);
        System.out.print(" C:" + letterGradeCount[2]);
        System.out.print(" D:" + letterGradeCount[3]);
        System.out.println(" F:" + letterGradeCount[4]);
        System.out.print("Top Student(s):");
        for (int idx : highestGradesIdx){
            StudentInfo topStudent = classInfo[idx];
            System.out.print(" " + topStudent.name + " (" + topStudent.numericGrade + ")");
        }
    }
}
