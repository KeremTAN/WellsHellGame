package Models.AttacksPackage;

public class Defend implements Attacks {
    @Override
    public double hit(double attackPower) {
       // System.out.println("stopped to defend yourself");
        System.out.println("------||||| DEFEND ||||||||-----");
        return attackPower*0.05;
    }
}
