package aula10.ex2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Gradebook {
    private Map<String, List<Double>> students = new HashMap<>();
    public void load(String ficheiro){
        try {
            Files.lines(Paths.get(ficheiro))
                 .forEach(line -> {
                     String[] parts = line.split("\\|");
                     String name = parts[0].trim();
                     List<Double> grades = new ArrayList<>(Arrays.stream(parts, 1, parts.length)
                                                 .map(String::trim)
                                                 .map(Double::parseDouble)
                                                 .toList());
                     students.put(name, grades);
                 });
        } catch (IOException e) {
            System.err.println("error reading the file: " + e.getMessage());
        }
    }

    public void removeStudent (String studentName){
        if(students.containsKey(studentName)){
            students.remove(studentName);
            System.out.println("student removed successfully");
        }
        else{
            System.out.println("student not found");
        }
    }

    public void addStudent (Student student){
        if(students.containsKey(student.getName())){
            System.out.println("estudante já existe");
        }
        else{
            students.put(student.getName(), student.getGrades());
            System.out.println("student added successfully");
        }
    }

    public Student getStudent(String name){
        if(students.containsKey(name)){
            Student student = new Student(name, students.get(name));
            return student;
        }
        else{
            System.out.println("student not found");
            return null; 
        }
    }

    public Student getStudent(List<Double> grades){
        if(students.containsValue(grades)){
            for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
                if (entry.getValue().equals(grades)) {
                    Student student = new Student(entry.getKey(), entry.getValue());
                    return student;
                }
            }
            Student student = new Student("", grades);
            return student;
        }
        else{
            System.out.println("student not found");
            return null; 
        }
    }

    public double calculateAverageGrade(String studentName){
        double average = students.get(studentName).stream()
                                  .mapToDouble(Double::doubleValue)
                                  .average()
                                  .orElse(0.0);
        return average;
    }

    public void printAllStudents(){
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Student: ").append(entry.getKey()).append(", Grades: ").append(entry.getValue());
            System.out.println(sb.toString());
        }
    }
}
