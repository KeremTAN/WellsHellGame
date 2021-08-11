package Views;

import Controls.Control;
import Models.FightersPackage.*;

import java.util.ArrayList;
import java.util.List;
//oyunculardan biri 0 olunca oyunu durdur.
public class App{
    public static void main(String[] args) {
        Control ctrlMain = new Control();
        ctrlMain.getChooseInfo(ctrlMain.getGameStory());
        ctrlMain.getChooseInfo(ctrlMain.getGamesRules());
        List<Fighters> allFighters =new ArrayList<>();
        List<Integer> currentAttacks =new ArrayList<>();
        int i=0;
        while(i<2){
            System.out.println("Player "+(i+1));
            allFighters.add(ctrlMain.chooseFighters());
            i++;
        }
        ctrlMain.getChooseInfo("attacks");

        while (allFighters.get(0).getFighterLife()>0 && allFighters.get(1).getFighterLife()>0) {
            System.out.println("******************************************************************************************");
            for(i=0;i<2;i++)
                currentAttacks.add(ctrlMain.chooseAttack(allFighters.get(i)));
            System.out.println("------------------------------------------------------------------------------------------");
            for(i=0;i<allFighters.size();i++) {
              //  System.out.println(allFighters.get(i).getNickName() + " has attacked to "+allFighters.get(Math.abs(i - 1)).getNickName());
                if (currentAttacks.get(currentAttacks.size()-1)==3){
                    if(currentAttacks.get(currentAttacks.size()-2)==1 || currentAttacks.get(currentAttacks.size()-2)==2){
                        allFighters.get(i).fight(allFighters.get(Math.abs(i - 1)));
                    }
                    else{
                        //Contra attack yapamzsa kendi canı gidecek
                        allFighters.get(i).fight(allFighters.get(i));
                    }
                }
                else {
                    allFighters.get(i).fight(allFighters.get(Math.abs(i - 1)));
                }

                if(allFighters.get(0).getFighterLife()<=0 || allFighters.get(1).getFighterLife()<=0) break;
            }
       }


        if (allFighters.get(0).getFighterLife()>0) System.out.println("WINNER IS PLAYER 1 who has nickname "+allFighters.get(0).getNickName());
        else if (allFighters.get(1).getFighterLife()>0) System.out.println("WINNER IS PLAYER 2 who has nickname "+allFighters.get(1).getNickName());
        else System.out.println("SCORELESS");
    }
}
