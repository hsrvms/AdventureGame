public class SafeHouse extends SafeLocation{

    SafeHouse(Player player) {
        super(player, "Safe House");
    }

    public boolean getLocation(){
        player.setHealth(player.getMaxHealth());
        System.out.println("Your health is full!");
        System.out.println("You are ready to fight now!!");
        return true;
    }

}
