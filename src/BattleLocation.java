public abstract class BattleLocation extends Location {

    protected Obstacle obstacle;
    protected String itemName;

    BattleLocation(Player player, String name, Obstacle obstacle, String itemName) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.itemName = itemName;
    }

    public boolean getLocation() {
        int obstacleCount = obstacle.count();
        System.out.println("Entering the " + this.name);
        System.out.println("Be careful! There are " + obstacleCount + " " + obstacle.getName() + "s here!");
        System.out.print("<F>ight or <R>un :");
        String selectCase = scan.nextLine();
        System.out.println("---------------------");
        if (selectCase.equalsIgnoreCase("F")) {
            if (combat(obstacleCount)) {
                if (this.itemName.equalsIgnoreCase("Food") && !player.getInventory().isFood()) {
                    System.out.println("You earned " + this.itemName);
                    player.getInventory().setFood(true);
                } else  if (this.itemName.equalsIgnoreCase("Water") && !player.getInventory().isWater()) {
                    System.out.println("You earned " + this.itemName);
                    player.getInventory().setWater(true);
                } else  if (this.itemName.equalsIgnoreCase("Wood") && !player.getInventory().isWood()) {
                    System.out.println("You earned " + this.itemName);
                    player.getInventory().setWood(true);
                }
                return true;
            }
            if (player.getHealth() <= 0) {
                System.out.println("You died! Game Over!!");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obsCount) {

        for (int i = 0; i < obsCount; i++) {
            int defaultObstacleHealth = obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
                System.out.print("<Hit> or <R>un :");
                String selectCase = scan.nextLine();
                if (selectCase.equalsIgnoreCase("H")) {
                    System.out.println("---------------------");
                    System.out.println("Your hit!");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    printAfterHitStats();
                    if (obstacle.getHealth() >0){
                        System.out.println(obstacle.getName() + " hit you!!");
                        player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInventory().getBlock()));
                        printAfterHitStats();
                        System.out.println("---------------------");
                    }

                }else{
                    return false;
                }
            }
            if(obstacle.getHealth() < player.getHealth() ){
                System.out.println("Obstacle defeated!");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("New Balance: " + player.getMoney());
                obstacle.setHealth(defaultObstacleHealth);
            }else{
                return false;
            }
            if (obstacle.count()==0) {
                System.out.println("You cleared the " + this.name + " from " + obstacle.getName() + "s.");
            }
        }
        return true;
    }

    public void printAfterHitStats() {
        System.out.println("Your health: " + player.getHealth()+"\n") ;
        System.out.println(obstacle.getName() + "'s health: " + obstacle.getHealth()+"\n");
    }

    public void playerStats() {
        System.out.println("Player Stats\n" +
                "Health: " + player.getHealth() + "\n" +
                "Damage: " + player.getTotalDamage() + "\n" +
                "Money: " + player.getMoney());
        if (player.getInventory().getDamage() > 0) {
            System.out.println("Weapon: " + player.getInventory().getWeaponName());
        }
        if (player.getInventory().getBlock() > 0) {
            System.out.println("Armor: " + player.getInventory().getArmorName());
        }
    }


    public void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " Stats\n" +
                "Health: " + obstacle.getHealth() + "\n" +
                "Damage: " + obstacle.getDamage() + "\n" +
                "Award: " + obstacle.getAward());
    }


}
