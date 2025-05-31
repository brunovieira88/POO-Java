package javafullcourse;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        String[] questions = {"What year was facebook launched?",
                            "What is considered the brain of a computer?",
                            "Who invented the facebook?", 
                            "What was the first programming language?"};
        String[][] options = {{"1. 2005","2. 2006", "3. 2004", "4. 2000"},
                                {"1. CPU", "2. GPU", "3. RAM", "4. Motherboard"},
                                {"1. Steve Jobs", "2. Mark Zuckergerg", "3. Bill Gates", "4. Elon Musk"},
                                {"1. Java","2. C","3. Fortran", "4. Assembly"}};
        int[] ans = {3, 1, 2, 3};
        int score = 0;
        int guess;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);
            for(int j = 0; j < options.length; j++){
                System.out.println(options[i][j]);
            }
            System.out.print("Enter you guess: ");
            guess = scanner.nextInt();
            if (guess == ans[i]){
                System.out.println("CORRECT!!");
                score++;
            }else{
                System.out.println("WRONG!!");
            }
        }
        System.out.printf("Your final score is %d out of %d", score, questions.length);


        scanner.close();
    }
}   
