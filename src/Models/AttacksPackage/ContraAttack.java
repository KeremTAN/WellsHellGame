package Models.AttacksPackage;

public class ContraAttack implements Attacks {
    @Override
    public double hit(double attackPower) {
       // System.out.println("has contra attacked");
        return attackPower*1.1;
    }
}
