/*
 Version a2 (12/28/19)
 Copyright 2019 dominic03


//// EXIT CODE NUMBERS ////
 0: Reached end of code
 5: Out of range option in optionMenu()
 130: Exited due to SIGINT (signal 2) code (when running in IntelliJ IDEA)
//// If you find other error codes, please report to dominic03! ////
*/

import java.util.Scanner;
import java.util.Random;

public class program {
    private static String publicPlayerName;
    private static int publicPlayerChoice;
    private static int publicType;
    private static int publicDebug;
    private static int publicPlayerStr;

    // Create methods
    private static void text(String text) {
        System.out.println(text);
    }
    private static void dext(String dext) {
        if (publicDebug == 1) {
            System.out.println("[" + dext + "]");
        }
    }
    private static void pause(int ms) {
        dext("Pausing for " + ms + "ms");
        try {
            Thread.sleep(ms);

        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    private static void namechange() {
        Scanner userInput = new Scanner(System.in);
        text("Enter new name...");
        publicPlayerName = userInput.nextLine();
        dext("[Set publicPlayerName to " + publicPlayerName);
        text("Your new name is " + publicPlayerName);
    }

    private static void div() {
        text("----------------------------------------");
    }

    private static void waitForEnter() {
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
    private static void optionMenu(int options, int lineNumber, String option1, String option2, String option3, String option4, String option5, String option6) {
        if (options >= 1) {
            text("1. " + option1);
        }
        if (options >= 2) {
            text("2. " + option2);
        }
        if (options >= 3) {
            text("3. " + option3);
        }
        if (options >= 4) {
            text("4. " + option4);
        }
        if (options >= 5) {
            text("5. " + option5);
        }
        if (options >= 6) {
            text("6. " + option6);
        }
        if (options > 6) {
            text("[ERROR] line " + lineNumber + " out of range option menu function. Please report this to the developer (dominic03).");
            System.exit(5);
        }
    }
    public static void main(String[] args) {
        text("Battle! Game (C) 2019 Dominic03. Not for retail sale. THIS IS FREE SOFTWARE!\nPress enter to continue...");
        waitForEnter();
        text("Starting game...");
        // old system for managing variables, i'm too lazy to update it
        String playerName;
        int playerChoice;
        int type = 0;
        int debug;
        int createStat = 1;
        int playerStr;
        int playerDex;
        int playerSpd;
        int playerSpl;
        int playerMag;
        Random randomGenerator = new Random();
        Scanner userInput = new Scanner(System.in);
        div();
        pause(250);
        // the game is here
        text("\nWelcome to Battle!");
        text("What is your character's name?");
        playerName = userInput.nextLine();
        text("Hi " + playerName + "!");
        text("Now, choose your character's class.");
        text("1. Warrior");
        text("2. Thief");
        text("3. Magician");
        text("4. Sniper");
        playerChoice = userInput.nextInt();
        if (playerChoice == 1) {
            text("You are now a warrior!");
            type = 1;
            dext("Set type to " + type);
        } else if (playerChoice == 2) {
            text("You are now a thief!");
            type = 2;
            dext("Set type to " + type);
        } else if (playerChoice == 3) {
            text("You are now a magician!");
            type = 3;
            dext("Set type to " + type);
        } else if (playerChoice == 4) {
            text("You are now a sniper!");
            type = 4;
            dext("Set type to " + type);
        } else if (playerChoice == 5) {
            text("[!] Debug mode active!");
            debug = 1;
            dext("Set debug to " + debug);
            publicDebug = 1;
            dext("Set public debug to " + publicDebug);
            playerChoice = userInput.nextInt();
            if (playerChoice == 1) {
                text("You are now a warrior!");
                type = 1;
                dext("Set type to " + type);
            } else if (playerChoice == 2) {
                text("You are now a thief!");
                type = 2;
                dext("Set type to " + type);
            } else if (playerChoice == 3) {
                text("You are now a magician!");
                type = 3;
                dext("Set type to " + type);
            } else if (playerChoice == 4) {
                text("You are now a sniper!");
                type = 4;
                dext("Set type to " + type);
            }
        }
        publicType = type;
        dext("Set publicType to " + publicType);
        playerStr = (randomGenerator.nextInt(3) + 1);
        dext("Set playerStr to " + playerStr);
        playerDex = (randomGenerator.nextInt(2) + 1);
        dext("Set playerDex to " + playerDex);
        playerSpd = (randomGenerator.nextInt(3) + 1);
        dext("Set playerSpd to " + playerSpd);
        playerSpl = 1;
        dext("Set playerSpl to " + 1);
        playerMag = (randomGenerator.nextInt(1) +1);
        dext("Set playerMag to " + playerMag);
        while (createStat == 1) {
            div();
            text("Here are your stats:");
            text("STR: " + playerStr);
            text("DEX: " + playerDex);
            text("SPD: " + playerSpd);
            text("SPL: " + playerSpl);
            text("MAG: " + playerMag);
            pause(1000);
            optionMenu(3, 176, "Continue with these stats", "Reroll stats", "Help me!", "", "", "");
            playerChoice = userInput.nextInt();
            if (playerChoice == 1) {
                break;
            } else if (playerChoice == 2) {
                playerStr = (randomGenerator.nextInt(3) + 1);
                dext("Set playerStr to " + playerStr);
                playerDex = (randomGenerator.nextInt(2) + 1);
                dext("Set playerDex to " + playerDex);
                playerSpd = (randomGenerator.nextInt(3) + 1);
                dext("Set playerSpd to " + playerSpd);
                playerSpl = 1;
                dext("Set playerSpl to " + 1);
                playerMag = (randomGenerator.nextInt(1) +1);
                dext("Set playerMag to " + playerMag);
                continue;
            } else if (playerChoice == 3) {
                text("Each stat means the following:");
                text("STR: The base amount of damage your character deals; upgrading increases the higher end of your damage range.");
                text("DEX: Control over your weapons; upgrading increases your lower end of damage range.");
                text("SPD: How fast you can attack -- a higher value means you can attack enemies before they can attack you.");
                text("SPL: How often you can use special abilities you may have.");
                text("MAG: Power of magical abilities that come from magical items.");
            } else {
                text("That's not even a choice...");
            }
        }
        text("Your stats have been set.");
    }
}
