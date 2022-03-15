#Rolling Dice Game
The "Game of Dice" is a multiplayer game where N players roll a 6 faced dice in a round-robin
fashion. Each time a player rolls the dice their points increase by the number (1 to 6) achieved
by the roll.
As soon as a player accumulates M points they complete the game and are assigned a rank.
Remaining players continue to play the game till they accumulate at least M points. The game
ends when all players have accumulated at least M points.
---

##Setup required
- Java 1.8
- Apache Maven 3

##Steps to make executable jar:

- Step 1: clone the project
- Step 2: navigate to the greatlearning folder
- Step 3: Run mvn clean install -DskipTest

##Steps to execute the program
 - Run command java -jar ./target/greatlearning-0.0.1-SNAPSHOT-jar-with-dependencies.jar "{playerCount}" "{maxScore}" "{interactiveMode}"
 - playerCount (type Integer) is the count of player participating in the game. 
 - maxScore: (type Integer) is the score the needs to get to player to finish the game.
 - interactiveMode is the flag for interactive mode. 1 means interactive mode is ON otherwise OFF.
 
```
===========================================
For config:
playerCount = 3
maxScore = 60
interactMode = ON

java -jar ./target/greatlearning-0.0.1-SNAPSHOT-jar-with-dependencies.jar "3" "60" "1"

===================================
For config:
playerCount = 3
maxScore = 60
interactMode = OFF

java -jar ./target/greatlearning-0.0.1-SNAPSHOT-jar-with-dependencies.jar "3" "60"

```
##Support
In case of any help needed kindly drop a mail to **asifmd786kgn@gmail.com**
