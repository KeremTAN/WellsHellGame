package Models.FightersPackage;

import Models.AttacksPackage.Attacks;
import Models.AttacksPackage.Defend;

import java.text.DecimalFormat;

public class Fighters {
    private String nickName;
    private String fighterType;
    private double attackPower;
    private double fighterLife=100.0;
    private double defenceCoefficient;
    private Attacks attack;


    public Fighters(String nickName, String fighterType, double attackPower, double defenceCoefficient) {
        this.nickName = nickName;
        this.fighterType = fighterType;
        this.attackPower = attackPower;
        this.defenceCoefficient = defenceCoefficient;
        System.out.println(fighterType+" has been created with name is "+nickName+"\n");
    }

    public void fight (Fighters enemy){
        enemy.hasBeenAttacked(attack.hit(attackPower));
        System.out.println(enemy.displayInfo());
        System.out.println("---------------------------------------------------------------");
    }

    public void hasBeenAttacked(double enemyAttackPower){
        this.fighterLife-=(enemyAttackPower*getDefenceCoefficient());
        if(fighterLife<0) fighterLife=0;
    }

    public String displayInfo(){
        DecimalFormat formatter = new DecimalFormat("##.###");
        return "Life score of "+fighterType+" as known "+nickName+" : "+formatter.format(fighterLife); }

    public void setAttack(Attacks attack){
        this.attack=attack;
    }

    public double getFighterLife() {
        return fighterLife<0?0:fighterLife;
    }

    public String getNickName() {
        return nickName;
    }

    public double getDefenceCoefficient() {
       // if (attack.getClass()==Defend.class)
        if(attack.hit(attackPower)==attackPower*0.05) // it means we use defend class
            return defenceCoefficient/7;
        return defenceCoefficient;
    }
}
