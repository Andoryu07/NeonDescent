package commands;

import NPCs.NPC;
import items.Item;
import items.player.Player;
import mapState.MapState;

import java.util.Scanner;

/**
 * This class is used to display a puzzle if the room has one
 */
public class Puzzle extends Command {

    private boolean SOF = true;
    private boolean Lib = true;
    private final Scanner sc = new Scanner(System.in);

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        String name = mapS.getCurrentRoom().roomName();
        switch (name) {
            case "Detention Pod":
                if (mapS.getCurrentRoom().findNPC("Glitched-Android") != null) {
                    return """
                            "Systems... failing... Kai, searching for... puzzles? No puzzles here... but if you can provide a Nano-Stim, I might be able to... 
                            help you. You can synthesize it using Scrap-Metal and Bio-Gel."
                            - the Glitched-Android's vocoder crackles.""";
                }
                break;
            case "Data Archive":
                System.out.print("I hold a million secrets, yet I cannot speak.\n" +
                        "I connect the world, yet I never meet.\n" +
                        "Touch me and you travel, but I never move.\n" +
                        "What am I?\n" +
                        ">> ");
                name = sc.next();
                if (name.equalsIgnoreCase("network")) {
                    mapS.getCurrentRoom().setWestRoom(5);
                    return "A server rack on the west side slides open, revealing a hidden maintenance shaft.";
                } else {
                    return "- ACCESS DENIED";
                }
            case "Quantum Core":
                System.out.print("I am invisible, yet I drive all things.\n" +
                        "One spark of me, and darkness falls.\n" +
                        "I live in circuits, yet I light the world.\n" +
                        "What am I?\n" +
                        ">> ");
                name = sc.next();
                if (name.equalsIgnoreCase("electricity")) {
                    Item shielding = new Item("EMP-Shielding", 0, "a");
                    mapS.getCurrentRoom().addItem(shielding);
                    return "A beam of pure energy materializes, forming 'EMP-Shielding' before you.";
                } else {
                    return "- ACCESS DENIED";
                }
            }
        return "Seems like there isn't any puzzles in this room.";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setCommand(String command) {

    }

    @Override
    public String attackPlayer(MapState mapS, Player player, NPC npc) {
        return null;
    }
}