package Controls;

import Models.AttacksPackage.FactoryAttack.FactoryAttack;
import Models.FightersPackage.*;
import Models.FightersPackage.FactoryFighters.FactoryFighter;

import java.util.Random;
import java.util.Scanner;

public class Control {
    String[] nickNames={"Henry","George"}; // kullanıcı girdi girmemesi için.
    static int names=0; // kullanıcı yerine işlem yapsın;
    Random random=new Random();
    static int takenCharacter=-1;
    String fighterInfo="""
                 ----------------------
                |  Please enter,       |
                |  1 for Dr. Moreau    |
                |  2 for Time Traveler |
                |  3 for Invisible Man |
                |  4 for Human         | 
                 ----------------------
                 
                """;
    String attackInfo="""
                 ----------------------
                |  Please enter,       |
                |  1 for Punch Attack  |
                |  2 for Kick Attack   |
                |  3 for Contra Attack |
                |  4 for Defense       | 
                 ----------------------
                 
                """;

    public void getChooseInfo(String info){
        if(info.equals("attacks")) info=this.attackInfo;

        for(int index=0; index<info.length();index++) {
            try {
                Thread.sleep(5);
                System.out.print(info.charAt(index));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Fighters chooseFighters(){
        //Scanner takeValue;
        int choose=0;
        String nickName;
        getChooseInfo(fighterInfo);
       // takeValue = new Scanner(System.in);
        System.out.print("Please mighty fighter, enter your nickname : ");
        nickName=nickNames[names++];//takeValue.nextLine().toUpperCase();
        System.out.println(nickName); // scanner olmadığı için alt satıra inmiyor

        while(choose!=1 && choose!=2 && choose!=3 && choose!=4) {
            System.out.print("Please mighty fighter "+ nickName +", choose your character : ");
            choose = random.nextInt(4)+1;//takeValue.nextInt();
            System.out.println(choose); // !! will erase
            if(takenCharacter==choose) {
                System.out.println("Your character is taken! Please try to select another character...");
                choose=0;
            }
            else takenCharacter=choose;
        }
        return  new FactoryFighter().createFighter(choose,nickName);
    }
    public int chooseAttack(Fighters attackPlayer){
        int ctrl;
        //Scanner takeValue= new Scanner(System.in);
        System.out.println("Mighty Fighter "+attackPlayer.getNickName());

        System.out.print("Please Select Your Attack : ");
        ctrl = random.nextInt(4)+1;//takeValue.nextInt();
        System.out.println(ctrl); // this field is written for automatic data filling or viewing.
        attackPlayer.setAttack(new FactoryAttack().createAttack(ctrl));

        return ctrl;
    }
    public String getGameStory(){
        return """
                 ------------------------------------------------------------------- | Game Story | --------------------------------------------------------------------
                | Three ancient scientists and an ordinary person, unaware of each other, came to a deserted island where a scientist named Wells lived.                |
                | The reason these 4 people came to the island is to steal a serum made by a famous scientist.                                                          |
                | According to the legend, the feature of this serum is that it can restore permanent damage and changes that occur inside and outside of the body.     |
                | It is known that scientist Wells is missing and the last remaining sample of the serum he made is in the shelter on his island.                       |
                | One of our characters wants to get this serum and return to a normal life.                                                                            |
                | While 2 characters were searching for the shelter belonging to Wells on the deserted island,                                                          |
                | they encountered the other 2 characters and neutralized them.                                                                                         |
                | The 2 characters you choose from these 4 characters are the ones that are not disabled.                                                               |
                |                                                                                                                                                       | 
                | Our 1st character, Dr. Moreau:                                                                                                                        |
                | This character used to be conducting experiments trying to unite humans and animals.                                                                  |
                | As a result of his experiments on himself, Dr. Moreau got the arms and legs of an orangutan. Also, he has an armadillo's back.                        |
                | Therefore, HIS ATTACKING POWER IS VERY HIGH. However, HIS SELF DEFENSE COEFFICIENT IS VERY LOW due to the mismatch of the body limbs.                 |
                |                                                                                                                                                       |
                | Our 2nd character, Time Traveler:                                                                                                                     |
                | This character has managed to travel in time thanks to a vehicle he has built, but irreparable damage has occurred in his body.                       |
                | The time traveler learned how to fight as he fought the Morlock race in a stuck phase of the future.                                                  |
                | Hence, HIS ATTACKING POWER AND SELF-DEFENSE COEFFICIENT IS NORMAL.                                                                                    |
                |                                                                                                                                                       |
                | Our 3rd character, The Invisible Man:                                                                                                                 |
                | This character of ours is a scientist like our previous characters. Thanks to his albino experiments on hemoglobin,                                   |
                | he succeeded in making himself almost completely transparent.                                                                                         |
                | Thanks to this advantage, HIS ATTACKING POWER IS HIGH.                                                                                                |
                | HOWEVER, THE SELF-DEFENSE COEFFICIENT IS LOW because the chemicals in his body cause him to constantly suffer.                                        |
                |                                                                                                                                                       |
                | Our 4th character, Human:                                                                                                                             |
                | This character of ours is an ordinary human. However, he will die within 2 months of a fatal disease in his body.                                     |
                | ATTACKING POWER IS VERY LOW due to his illness. However, thanks to the survival instinct, HIS SELF-DEFENSE COEFFICIENT IS VERY HIGH.                  |
                 -------------------------------------------------------------------------------------------------------------------------------------------------------
                 
                """;
    }
    public String getGamesRules(){
        return """
                 ------------------------------------------------------------------- | Game Rules | --------------------------------------------------------------------
                | If you choose to punch attack as an attack, you will use 75 percent of your attacking power.                                                          |
                | If you choose to kick attack as an attack, you will use 85 percent of your attacking power.                                                           |
                | If you choose a contra attack as an attack, you will use 110 percent of your attack power.                                                            | 
                | However, if your opponent's previous move was no punching or kicking,                                                                                 |
                | your contra attack power will pass to your opponent and your health will be reduced.                                                                  |  
                | If you choose to defense as an attack, you will use 5 percent of your attack power.                                                                   |
                | However, you can absorb your opponent's attack 7 times more in the next move.                                                                         |
                 -------------------------------------------------------------------------------------------------------------------------------------------------------
                 
                """;
    }
}
