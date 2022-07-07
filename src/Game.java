import java.util.Scanner;

public class Game {

    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);


    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Adventure Game!");
        System.out.println("Please enter your name before starting the game: ");
        //String userName = scan.nextLine();
        player = new Player("a");
        player.selectChar();
        start();
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("=====================================================");
            System.out.println();
            System.out.println("Choose a place to perform the action.");
            System.out.println("1. Safe House --> A safe place for you!");
            System.out.println("2. Cave --> There are Skeleton Warriors here. Be careful!");
            System.out.println("3. Jungle --> There are Vampires here. Watch your steps!");
            System.out.println("4. River --> There are Bears here. You must be strong!");
            System.out.println("5. Store --> You can buy weapons or armor here.");
            System.out.print("Where do you want to go: ");
            int selectLocation = scan.nextInt();
            while (selectLocation < 1 || selectLocation > 5) {
                System.out.println("Please select a valid Location!");
                System.out.print("Where do you want to go: ");
                selectLocation = scan.nextInt();
            }
            switch (selectLocation) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 5:
                    location = new Store(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (!location.getLocation()) {
                System.out.println("Game Over!");
                break;
            }
        }

    }

}
