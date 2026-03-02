package src.main;

import java.util.*;

public class Menu {
    private final Scanner scanner;
    private final Map<String, Runnable> menuActions = new HashMap<>();

    public Menu(Scanner scanner) {
        this.scanner = scanner;

        menuActions.put("m", this::printMenu);
        menuActions.put("1", () -> outputInBinary(getInt()));
    }

    public void run() {
        printMenu();
        String choice;
        do {
            choice = getChoice();
            if (choice.equalsIgnoreCase("q")) break;

            menuActions.getOrDefault(choice,
                () -> System.err.println("Please enter a valid choice..."))
                .run();
        } while (true);
    }

    public void printMenu() {
        System.out.println("""
                 -------------------
                | 1) Convert decimal integer to binary
                | m) Print menu
                | qQ) Quit
                 -------------------""");
    }

    public String getChoice() {
        System.out.println("Enter your choice: ");
        return scanner.nextLine();
    }

    public int getInt() {
        int integer;
        do {
            integer = 0;
            System.out.println("Enter integer:");
            try {
                integer = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Not an integer...");
                scanner.nextLine();
            }
        } while (true);
        return integer;
    }

    public void outputInBinary(int x) {
        ArrayStack<Integer> s = new ArrayStack<>();
        String binaryNum = "";
        while (x > 0) {
            int bit = x % 2;
            s.push(bit);
            x /= 2;
        }
        while (!s.isEmpty()) {
            binaryNum += s.topAndPop().toString();
        }
        System.out.println(binaryNum);
    }
}
