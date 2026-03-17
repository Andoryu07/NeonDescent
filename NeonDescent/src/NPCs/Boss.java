package NPCs;

import items.player.Player;

public class Boss extends Enemy{

    private int specialDamage;

    public Boss(String name, int health, int damage, int defence, int specialDamage) {
        super(name, health, damage, defence);
        this.specialDamage = specialDamage;
    }

    public int getSpecialDamage() {
        return specialDamage;
    }

    public void setSpecialDamage(int specialDamage) {
        this.specialDamage = specialDamage;
    }

    public String attack(Player player) {
        String line = "";
        if (additionalDefence == 10) {
            additionalDefence = 0;
        }
        switch (attackCycle[attack]) {
            case "a":
                if (name.equals("APEX") && player.hasItem("EMP-Shielding")) {
                    player.sufferDamage(damage - 6);
                } else {
                    player.sufferDamage(damage);
                }
                line = name + " has launched an attack protocol.\n";
                if (player.getHealth() > 0) {
                    line += "Your health is " + player.getHealth() + "/" + player.getMaxHealth() + ".\n";
                } else {
                    line += "You died.  L";
                }
                break;
            case "b":
                additionalDefence = 10;
                line = name + " has activated firewall defenses. ";
                break;
            case "s":
                if (name.equals("APEX") && player.hasItem("EMP-Shielding")) {
                    player.sufferDamage(damage - 6);
                } else {
                    player.sufferDamage(specialDamage);
                }
                line = name + " has executed a system overload strike.\n";
                if (player.getHealth() > 0) {
                    line += "Your health is " + player.getHealth() + "/" + player.getMaxHealth() + ".\n";
                } else {
                    line += "System failure. You are terminated.";
                }
                break;
            default:
                line += name + " is waiting for your move. ";
        }
        if (attack == attackCycle.length - 1) {
            attack = 0;
        } else {
            attack += 1;
        }
        switch (attackCycle[attack]) {
            case "a":
                line += name + " is preparing for an attack.";
                break;
            case "b":
                line += name + " is preparing to block your next shot.";
                break;
            case "s":
                line += name + " is preparing a powerful strike.";
                break;
            default:
                line += name + " is exhausted.";
        }
        return line;
    }
}