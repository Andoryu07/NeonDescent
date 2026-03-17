package commands;

import NPCs.NPC;
import items.player.Player;
import mapState.MapState;

/**
 * This class is used to display tip for the current situation
 */
public class Tip extends Command{

    /**
     * @param mapS is a current MapState in which the changes will happen
     * @param player is a Player who makes changes
     * @return String with information what had happened
     */
    @Override
    public String execute(MapState mapS, Player player) {
        String line = mapS.getCurrentRoom().roomInfo();
        line += "\nSome sectors may contain encrypted puzzles. To check if the sector has one, use the command: puzzle.";
        if (mapS.getMap().get(8).getSouthRoom() == 0) {
            line += "\nYou need to unlock the Control Nexus in the Server Crypts using the 'Core-Access-Key'.";
        }
        return line;
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
        return "";
    }

}