import java.util.Scanner;

public class Player {

    private int damage, health, money, maxHealth;
    private String charClass, userName;
    private Inventory inventory;
    Scanner scan = new Scanner(System.in);

    public Player(String userName) {
        this.userName = userName;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        switch (charMenu()) {
            case 1:
                initPlayer("Samurai", 5, 21, 15);
                break;
            case 2:
                initPlayer("Archer", 7, 18, 20);
                break;
            case 3:
                initPlayer("Paladin", 8, 24, 5);
                break;
            default:
                initPlayer("Samurai", 5, 21, 15);
        }
        System.out.println("Character: " + getCharName() + "\nDamage: " + getDamage() + "\nHealth: " + getHealth() + "\nMoney: " + getMoney());
    }

    public int charMenu() {
        System.out.println("Please select a Character!");
        System.out.println("No. Class \t Damage\t Health\t Money");
        System.out.println("1- Samurai\t   5\t   21\t  15");
        System.out.println("2- Archer\t   7\t   18\t  20");
        System.out.println("3- Paladin\t   8\t   24\t  5");
        System.out.print("Choice: ");
        int charId = scan.nextInt();

        while (charId < 1 || charId > 3) {
            System.out.println("Please select a valid Character!");
            System.out.print("Choice: ");
            charId = scan.nextInt();
        }
        return charId;
    }

    public void initPlayer(String charClass, int damage, int health, int money) {
        setCharName(charClass);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setMaxHealth(maxHealth);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charClass;
    }

    public void setCharName(String charName) {
        this.charClass = charName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }
}
