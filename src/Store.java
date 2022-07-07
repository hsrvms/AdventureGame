public class Store extends SafeLocation {

    Store(Player player) {
        super(player, "Store");
    }

    public boolean getLocation() {
        System.out.println("Current money: " + player.getMoney());
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Quit");
        System.out.print("Choice: ");
        int selectTool = scan.nextInt();
        int selectItemId;

        switch (selectTool) {
            case 1:
                buyWeapon(weaponMenu());
                break;
            case 2:
                buyArmor(armorMenu());
                break;
            default:
        }
        return true;
    }

    public int armorMenu() {
        System.out.println("1. Light Armor\t <Money: 15 - Block: 1>");
        System.out.println("2. Medium Armor\t <Money: 25 - Block: 3>");
        System.out.println("3. Heavy Armor\t <Money: 40 - Block: 5>");
        System.out.println("4. Quit");
        System.out.print("Choice: ");
        int selectArmorId = scan.nextInt();
        return selectArmorId;
    }

    public void buyArmor(int itemID) {
        int avoid = 0, price = 0;
        String armorName = null;
        if (itemID > 0 && itemID < 4) {
            switch (itemID) {
                case 1:
                    avoid = 1;
                    armorName = "Light Armor";
                    price = 15;
                    break;
                case 2:
                    avoid = 3;
                    armorName = "Medium Armor";
                    price = 25;
                    break;
                case 3:
                    avoid = 5;
                    armorName = "Heavy Armor";
                    price = 40;
                    break;
                case 4:
                    System.out.println("You are leaving the store...");
                default:
                    System.out.println("Invalid Entry!");
                    break;
            }
            if (price > 0) {
                if (player.getMoney()>= price) {
                    player.getInventory().setBlock(avoid);
                    player.getInventory().setArmorName(armorName);
                    player.setMoney(player.getMoney() - price);
                    System.out.println("You bought a new Armor! Blocked damage on each hit taken: " + player.getInventory().getBlock());
                    System.out.println("New Balance: " + player.getMoney());
                }
            }
        }
    }

    public int weaponMenu() {
        System.out.println("1. Pistol\t <Money: 25 - Damage: 2>");
        System.out.println("2. Sword\t <Money: 35 - Damage: 4>");
        System.out.println("3. Rifle\t <Money: 45 - Damage: 7>");
        System.out.println("4. Quit");
        System.out.print("Choice: ");
        int selectWeaponID = scan.nextInt();
        return selectWeaponID;
    }

    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String weaponName = null;
        if (itemID > 0 && itemID < 4) {
            switch (itemID) {
                case 1:
                    damage = 2;
                    weaponName = "Pistol";
                    price = 15;
                    break;
                case 2:
                    damage = 4;
                    weaponName = "Sword";
                    price = 35;
                    break;
                case 3:
                    damage = 8;
                    weaponName = "Rifle";
                    price = 45;
                    break;
                case 4:
                    System.out.println("You are leaving the store...");
                default:
                    System.out.println("Invalid Entry!");
                    break;
            }
            if (price > 0) {
                if (player.getMoney() >= price) {
                    player.getInventory().setDamage(damage);
                    player.getInventory().setWeaponName(weaponName);
                    player.setMoney(player.getMoney() - price);
                    System.out.println("You bought a new weapon! Your new Damage: " + player.getTotalDamage());
                    System.out.println("New Balance: " + player.getMoney());
                } else {
                    System.out.println("Not enough money!");
                }
            }


        }
    }

}
