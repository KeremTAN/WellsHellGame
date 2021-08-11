package Models.AttacksPackage;

public class PunchAttack implements Attacks {

    @Override
    public double hit(double attackPower) {
      //  System.out.println("have attacked with Punch");
        return attackPower*0.75;
    }
}
