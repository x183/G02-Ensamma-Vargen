import java.util.Scanner;

/**
 * Simple method for choosing what version of the game to launch, GUI or CLI.
 */
public class AppLaunch {
    static Scanner sc = new Scanner(System.in);
    static int choice;
    public static void main (String[] args)
    {
        while(true) {
            System.out.println("How do you wish to launch? \n for GUI launch, enter 1 \n for console launch, enter 2");
            choice = sc.nextInt();

            if (choice == 1) {
                LoneWolf.main(args);
                break;
            } else if (choice == 2) {
                try {
                    CLI.main(args);
                    break;
                } catch (Exception e) {
                    System.out.println("Exception at launch. Program stopping.");
                    e.printStackTrace();
                    break;
                }
            } else {
                System.out.println("Invalid option entered. Enter 1 or 2.");

            }
        }
    }
}
