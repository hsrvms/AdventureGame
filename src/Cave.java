import java.rmi.server.Skeleton;

public class Cave extends BattleLocation {

    Cave(Player player) {
        super(player, "Cave", new SkeletonWarrior(), "Food");
    }
}
