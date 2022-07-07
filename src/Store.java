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

                break;
            default:
        }
        return true;
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
                    price = 5;
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
                default:
                    System.out.println("Invalid Entry!");
                    break;
            }
            if (player.getMoney() > price) {
                player.getInventory().setDamage(damage);
                player.getInventory().setWeaponName(weaponName);
                player.setMoney(player.getMoney() - price);
                System.out.println("You bought a new weapon! Your new Damage: " +
                        (player.getDamage() + player.getInventory().getDamage()));
                System.out.println("New Balance: " + player.getMoney());
            } else {
                System.out.println("Not enough money!");
            }


        }
    }

}
