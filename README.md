# About/Overview : 
This problem statement is to create a dungeon which consists of caves and tunnels along with arrows, 
treasures and monsters are added to the dungeon by user which are then used by the player. 
This is extension of project 3 wherein along with moving from one cave to other cave or tunnel 
and picking treasure some other functionalities are added such as picking arrows, shooting
arrows by determining direction and distance. A controller is implemented using command design 
pattern wherein it validates users input and passes to the model Dungeon.

# List of features : 

1. Dungeon is created by command line arguments in a construtor.
2. Arrows, Treasure and Monster are added to the dungeon.
3. Smell of the monster is determined by number of monsters present in caves.
   * Strong smell if monster is at distance 1 or more than 1 monsters are at distance 2.
   * Normal smell if there is a monster at distance of 2.
   * No smell if monster is not at distance of 1 or 2.
4. Player is asked to collect arrows and treasure from caves and tunnels.
5. Player is asked to shoot arrow given a specific direction and distance.
6. Misses the arrow if the distance is not exact.
7. Takes 2 hits to kill a monster.
8. Player has a 50 percent probability of escaping if monster is hit once.
9. Player either is eaten by monster or reaches end and wins.

# How To Run : 
The jar file of this project is inside the res folder. So the user directly needs to open 
the terminal in windows and set the path to the res folder and hit the command java -jar 
Dungeon.jar. The command line arguments required to run this file in order are
1. row 
2. column
3. interconnectivity
4. wrap (wrap/nowrap)
5. treasure percentage
6. monster number

# How to Use the Program : 
So basically my project contains a driver class wherein a dungeon is constructed by command
line arguments. The driver file is used wherein a dungeon is created, players are created, 
the player moves from one location to another and picks up the treasure, arrows and kills 
monster with arrows. A user can simply run the driver class and check for the output of 
the code.


# Description of Examples : 
The example run file is located in the res folder of this project. It consists of all 
the runs of the functionalities implemented in the driver class in a ordered way. 
Runs includes creating a player, collecting arrows, treasures, shooting arrows, killing
monsters and reaching end cave. Two runs are included in which one shows that player is eaten
by the monster and other shows that player reaches end cave and wins.


# Design/Model Changes : 
The design which I implemented earlier was not upto the point because few methods need to be
added and also the controller was not designed properly. In new design model I included an
interface for command pattern and implemented using two different commands. I also added a
few public method in dungeon and caves and tunnels.

# Assumptions : 

* A player can only shoot in a direction from possible moves.
* A player can shoot upto distance of 5.
* A player can shoot either from cave or tunnel.
* Arrows bend through tunnel.
* A player can shoot arrows multiple times from their current location.
* A cave or tunnel can have atmost 2 arrows.

# Limitations : 
Currently what the problem statement is given to us consists of a lot functionalities 
which are implemented in the project but if we take into consideration other assumptions 
then a 	lot more is there to implement. This is a just basic simple project asking to 
create a dungeon and move players by killing monsters. The dungeon could also be 
implemented in a way that  the player is not allowed to revisit any cave or tunnel once
visited. Or the difficulty of the game could be increased by having health of player get
affected by monster.


# Citations : 
No major source has been used.
