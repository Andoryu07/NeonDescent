package mapState;

import NPCs.Boss;
import NPCs.Enemy;
import NPCs.NPC;
import items.Item;

import java.util.ArrayList;

/**
 * This class is used to create rooms of the map
 */
public class Room {

    private final String name;
    private int westRoom;
    private final int northRoom;
    private final int eastRoom;
    private int southRoom;
    private Enemy attackedEnemy;
    private final ArrayList<NPC> npcs;
    private final ArrayList<Item> items;

    public Room(String name, int westRoom, int northRoom, int eastRoom, int southRoom) {
        this.name = name;
        this.westRoom = westRoom;
        this.northRoom = northRoom;
        this.eastRoom = eastRoom;
        this.southRoom = southRoom;
        items = new ArrayList<>();
        npcs = new ArrayList<>();
    }

    public int getWestRoom() {
        return westRoom;
    }

    public int getNorthRoom() {
        return northRoom;
    }

    public int getEastRoom() {
        return eastRoom;
    }

    public int getSouthRoom() {
        return southRoom;
    }

    public String roomName() {
        return name;
    }

    public Enemy getAttackedEnemy() {
        return attackedEnemy;
    }

    public void setAttackedEnemy(Enemy attackedEnemy) {
        this.attackedEnemy = attackedEnemy;
    }

    public String getName() {
        String line = "You are now in " + name + ". ";
        if (westRoom != 0) {
            line += "You can see an entrance on the west. ";
        }
        if (northRoom != 0) {
            line += "There is a path on the north. ";
        }
        if (eastRoom != 0) {
            line += "The doors on the east can be entered. ";
        }
        if (southRoom != 0) {
            line += "You can go to the room on the south. ";
        }
        return line;
    }

    public String roomInfo() {
        return getName() + "\nTo move between rooms use the command 'go'. The entry should look like this: go [direction]." +
                "\n" + itemsList() + "\n" + NPCList();
    }

    public void addItem(Item item) {
        if (items.contains(item) && item != null) {
            items.get(items.indexOf(item)).changeAmount(item.getAmount());
        } else {
            items.add(item);
        }
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * @param name is a name of the item
     * @return Item if it has been found
     */
    public Item findItem(String name) {
        for (Item item : items) {
            if (item != null) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item;
                }
            }
        }
        return null;
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);

    }

    /**
     * @param name is a name of the NPC
     * @return NPC if it has been found
     */
    public NPC findNPC(String name) {
        for (NPC n : npcs) {
            if (n.getName().equalsIgnoreCase(name)) {
                return n;
            }
        }
        return null;
    }

    public void removeNPC(NPC n) {
        npcs.remove(n);
    }

    /**
     * @return String with information about items in the room
     */
    public String itemsList() {
        String line = "There are no items in the room.";
        if (getSize() > 0) {
            line = "You can see a ";
            int i = -1;
            for (Item item : items) {
                if (item != null) {
                    i += 1;
                    line += "'" + item.getName() + "'";
                    if (item.getAmount() > 1) {
                        line += "(" + item.getAmount() + ")";
                    }
                    if (i <= getSize() - 3) {
                        line += ", ";
                    } else if (i <= getSize() - 2) {
                        line += " and ";
                    } else if (i == getSize() - 1) {
                        line += " laying on the floor.";
                    }
                }
            }
        }
        return line;
    }

    /**
     * @return String with information about NPCs in the room
     */
    public String NPCList() {
        String line = "There is noone in this room.";
        ArrayList<NPC> tempNPC = new ArrayList<>();
        ArrayList<Enemy> tempEnemy = new ArrayList<>();
        for (NPC npc : npcs) {
            if (npc.getClass() == Enemy.class || npc.getClass() == Boss.class) {
                tempEnemy.add((Enemy) npc);
            } else {
                tempNPC.add(npc);
            }
        }
        if (!tempNPC.isEmpty()) {
            line = NPCDescription(tempNPC);
            if (!tempEnemy.isEmpty()) {
                line += "\n" + enemyDescription(tempEnemy);
            }
        } else if (tempEnemy.isEmpty()) {
            return line;
        } else {
            line = enemyDescription(tempEnemy);
        }
        return line;
    }

    private String NPCDescription(ArrayList<NPC> tempNPC) {
        String line = "";
        if (!tempNPC.isEmpty()) {
            if (tempNPC.size() > 1) {
                line = "There are NPCs ";
            } else {
                line = "There is NPC ";
            }
            for (int i = 0; i < tempNPC.size(); i++) {
                line += "'" + tempNPC.get(i).getName() + "'";
                if (i <= tempNPC.size() - 3) {
                    line += ", ";
                } else if (i <= tempNPC.size() - 2) {
                    line += " and ";
                } else if (i == tempNPC.size() - 1) {
                    line += " in the room.";
                }
            }
        }
        return line;
    }

    private String enemyDescription(ArrayList<Enemy> tempEnemy) {
        String line = "";
        if (!tempEnemy.isEmpty()) {
            if (tempEnemy.size() > 1) {
                line += "There are enemies ";
            } else {
                line += "There is enemy ";
            }
            for (int i = 0; i < tempEnemy.size(); i++) {
                line += "'" + tempEnemy.get(i).getName() + "'";
                if (i <= tempEnemy.size() - 3) {
                    line += ", ";
                } else if (i <= tempEnemy.size() - 2) {
                    line += " and ";
                } else if (i == tempEnemy.size() - 1) {
                    line += " in the room.";
                }
            }
        }
        return line;
    }

    public int getSize() {
        int i = 0;
        for (Item item : items) {
            if (item != null) {
                i += 1;
            }
        }
        return i;
    }

    /**
     * @return String with the information about the room
     */
    public String roomDescription() {
        return getName() + "\n" + itemsList() + "\n" + NPCList();
    }

    public void setSouthRoom(int southRoom) {
        this.southRoom = southRoom;
    }

    public void setWestRoom(int westRoom) {
        this.westRoom = westRoom;
    }
}