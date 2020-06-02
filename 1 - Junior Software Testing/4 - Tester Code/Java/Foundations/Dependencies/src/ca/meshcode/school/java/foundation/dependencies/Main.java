package ca.meshcode.school.java.foundation.dependencies;

//main file for the package
public class Main {
    //main class of main file in package
    public static void main(String[] args) {
        //create three types of clients
        //the last two will inherit from the first
        //
        //create a type of client by assigning the class to a variable and running the constructor
        TrialClient trial = new TrialClient();
        Client klient = new Client();
        PremiumClient premium = new PremiumClient();
        //
        //Create a visual text output of dependencies:
        System.out.println("Who bought what with dependencies:");
        System.out.println("**********************************");
        System.out.println();
        System.out.println("The trial client tried:");
        //run the bought method of trial client, this outputs its ownership
        trial.bought();
        System.out.println();
        System.out.println("The standard client bought:");
        klient.bought();
        System.out.println();
        System.out.println("The premium client received:");
        premium.bought();

    }
}
