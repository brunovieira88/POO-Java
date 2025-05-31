package javafullcourse;
public class formatOutputs {
    public static void main(String[] args) {
        
        String name = "André Ventura";
        int age = 5;
        boolean isStupid = false;
        double weight = 74.7;
        int n1 = 1;
        int n3 = 103043;
        int n2 = 43;
        int n4 = 1931920913;
        System.out.printf("Hello %s\n", name); //printf nao passa de linha auto por isso \n é necessário
        System.out.printf("%s is %d years old, it is %b that he is stupid, he weights %.2f kg\n", name, age, isStupid, weight);



        //alinhar outputs
        System.out.printf("%-10d\n",n1);
        System.out.printf("%-10d\n",n2);
        System.out.printf("%-10d\n",n3);
        System.out.printf("%-10d\n",n4);

    }
}
