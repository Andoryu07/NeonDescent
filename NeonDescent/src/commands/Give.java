package commands;

import NPCs.NPC;
import items.Item;
import items.player.Player;
import mapState.MapState;

import java.util.Random;

/**
 * This class is used to give items to NPCs
 */
public class Give extends Command{
    private String command;
    private final Random rd = new Random();

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        if (mapS.getCurrentRoom().findNPC("Glitched-Android") != null) {
            if (command.equalsIgnoreCase("Nano-Stim")) {
                if (player.hasItem("Nano-Stim")) {
                    player.findItem("Nano-Stim").changeAmount(-1);
                    if (player.findItem("Nano-Stim").getAmount() <= 0) {
                        player.removeItem("Nano-Stim");
                    }
                    switch (rd.nextInt(3)) {
                        case 0:
                            mapS.getCurrentRoom().addItem(new Item("Rail-Accelerator", 0, "n"));
                            return "Systems... restored... Thank you, Kai. Here's a 'Rail-Accelerator' from my storage.";
                        case 1:
                            mapS.getCurrentRoom().addItem(new Item("Blade-Enhancer", 0, "n"));
                            return "Systems... restored... Thank you, Kai. Here's a 'Blade-Enhancer' from my storage.";
                        case 2:
                            mapS.getCurrentRoom().addItem(new Item("Ion-Amplifier", 0, "n"));
                            return "Systems... restored... Thank you, Kai. Here's an 'Ion-Amplifier' from my storage.";
                    }
                }
            }
        }
        return "There's nothing you can give.";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String attackPlayer(MapState mapS, Player player, NPC npc) {
        return null;
    }
}