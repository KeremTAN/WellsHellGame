package Models.AttacksPackage;

public class KickAttack implements Attacks{
    @Override
    public double hit(double attackPower) {
       // System.out.println("have attacked with Kick");
        return attackPower*0.85;
    }
}
