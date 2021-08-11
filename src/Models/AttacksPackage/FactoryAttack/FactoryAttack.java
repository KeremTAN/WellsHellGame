package Models.AttacksPackage.FactoryAttack;

import Models.AttacksPackage.*;

public class FactoryAttack {
    public Attacks createAttack(int choose){
        if(choose==2)
            return new KickAttack();
        else if(choose==3) return new ContraAttack();
        else if(choose==4) return new Defend();

        else return new PunchAttack();
    }
}
