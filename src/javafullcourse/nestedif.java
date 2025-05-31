package javafullcourse;

public class nestedif {
    public static void main(String[] args) {
        boolean isStudent = false;
        boolean isSenior = false;
        double price = 10;

        if (isSenior){
            if (isStudent){
                price *= 0.7;
            }
            else{
                price *= 0.9;
            }
        }
        else{
            if(isStudent){
                price*=0.8;
            }
        }
        System.out.printf("You'll pay %.1f euros for your ticket" , price);




    }
}
