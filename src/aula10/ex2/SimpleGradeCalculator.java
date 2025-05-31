package aula10.ex2;

import java.util.List;
import java.util.Map;

public class SimpleGradeCalculator implements IGradeCalculator{
    public double calculate(List<Double> grades){
        double average = grades.stream()
                               .mapToDouble(Double::doubleValue)
                               .average()
                               .orElse(0.0);
        return average;            
    }

    public double calculateAllGrades(Map<String, List<Double>> students){
        return students.values().stream()
                       .flatMap(List::stream)
                       .mapToDouble(Double::doubleValue)
                       .average()
                       .orElse(0.0);
    }

}
