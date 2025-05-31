package javafullcourse;

public class Student {
    String name = "Bruno";
    int age;
    double gpa;
    boolean isActive;

    Student(String name, int age, double gpa){
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    void study(){
        System.out.println(this.name + " is studying");
    }
}
