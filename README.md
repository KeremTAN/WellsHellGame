# WellsHellGame
## Strategy and Simple Factory Design Patterns
It is a homework for lecture of Design Patterns. <br/>
### Statement of Work:
Our project is to design a 2 player fighting game. The logic of our game is 
quite simple. Although our game looks like a fighting game, it is actually a strategy game. Our 
players have to choose the most effective attack for them by trying to predict their opponent's 
moves correctly to win the game. The game will be played on the console. When our game 
starts, the players will first choose their characters. Players should only be able to create 
characters determined by us. The main characteristics of our characters are their attack power 
and self-defense coefficient. Characters can harm their opponents with their attack power and 
protect themselves with their self-defense coefficient. After our players have selected their 
characters, the game will continue until 1 of 2 players has 0 health. During the game, our 
players will be asked to choose an attack to attack their opponent every time it comes to their 
turn, and according to this selected attack, our player will hit his opponent. In each attack 
selection, the hitting property of the player's fighter character must be changed instantly and 
the hitting process must take place. <br/>
### Design Patterns:
Strategy pattern and simple factory pattern were used in our project. The 
reason for this is as it will be remembered, our players were hitting each other in turn. In the 
game, the same hitting can be done in different ways. A different percentage of the user's 
attack power is used according to each strike action. For the hitting process, the attack process 
that the user wants to do is selected first. The choice made by our player is sent as a parameter 
to the createAttack method of an object of our FactoryAttack class. When the Attacks object 
created according to the sent value is sent back to us, we send the returned Attacks object as a 
parameter to the setAttacks method of our player's fight object. <br/>
*`public int chooseAttack(Fighters attackPlayer) { `<br/>
`  … `<br/>
`  attackPlayer.setAttack(new FactoryAttack().createAttack(chosenAttack)); `<br/> 
`  … }`* <br/>
Thanks to the FactoryAttacks object, although we do not see the background, the createAttack 
method produces the Attacks object we want. So we're using the simple factory pattern here.
With the value sent, we reset the Attacks area of our player's Fighters object. In this way, while 
our user only hits his opponent through the fight method, the hit method of the Attacks object 
in the fight method applies an attack strategy as desired by our player. So here we are using 
the strategy pattern. The FactoryFighters class works the same as the FactoryAttack class. The 
only difference is that instead of producing different objects for us, our Fighter object is 
produced according to the rules we have determined.
### UML:
![UML](https://github.com/KeremTAN/WellsHellGame/blob/master/images/Uml.png)
