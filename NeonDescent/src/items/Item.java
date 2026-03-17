package items;

public class Item {
    private final String name;
    private Ability ability;
    private final boolean isStackable;
    private int amount;

    public Item(String name, int isStackable, String a) {
        this.name = name;
        if (isStackable == 1) {
            this.isStackable = true;
        } else {
            this.isStackable = false;
        }
        this.amount = 1;
        setAbility(a);
    }

    public String getName() {
        return name;
    }

    public boolean isStackable() {
        return isStackable;
    }

    public int getAmount() {
        return amount;
    }

    public void changeAmount(int amount) {
        this.amount += amount;
    }

    /**
     * @return String with the information about the inventory
     */
    public String description(){
        if (isStackable && amount != 1) {
            return name + "(" + amount + ")" + abilityDescription();
        }
        return name + abilityDescription();
    }

    private void setAbility(String a) {
        switch (a){
            case "h":
                ability = Ability.h;
                break;
            case "k":
                ability = Ability.k;
                break;
            case "a":
                ability = Ability.a;
                break;
            case "s":
                ability = Ability.s;
                break;
            default:
                ability = Ability.n;
        }
    }

    private String abilityDescription() {
        switch (this.ability){
            case h:
                return ", it can restore your health by 50";
            case k:
                return ", it unlocks the Control Nexus in the Server Crypts";
            case a:
                return ", it reduces the damage taken from APEX";
            case s:
                return ", it can teleport you out of danger";
            default:
                return switch (name) {
                    case "Blade-Enhancer" -> ", it increases Plasma-Blade's damage by 5";
                    case "Rail-Accelerator" -> ", it increases Rail-Gun's damage by 5";
                    case "Ion-Amplifier" -> ", it increases Ion-Cannon's damage by 5";
                    default -> "";
                };
        }
    }

    public Ability getAbility() {
        return ability;
    }
}