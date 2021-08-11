package Models.FightersPackage.FactoryFighters;

import Models.FightersPackage.Fighters;

public class FactoryFighter {
    public Fighters createFighter(int choose, String nickName){
        if (choose == 1)
            return new Fighters(nickName, "Dr. Moreau", 22.5, 0.85);
        else if (choose == 2)
            return new Fighters(nickName,"Time Traveler",17.5,0.65);
        else if (choose == 3)
            return new Fighters(nickName, "Invisible Man", 20, 0.75);
        else return new Fighters(nickName, "Human", 12.5, 0.55);
    }
}
