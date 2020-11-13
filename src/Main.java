import java.util.*;

public class Main {

    public static void main(String[] args) {
        // welcome/starting message
        System.out.println("Welcome to Blackjack!");
        System.out.println("Do you know the rules or would you like me to explain them?");

        String answer = readString();
        Case case1 = new Case(answer);
        Reply reply1 = new Reply(case1.getTrigger());
    }

    // method that reads input as a string
    public static String readString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
