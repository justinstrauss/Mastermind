APCS01 Final Project: Mastermind Board Game
by Marc Katz and Justin Strauss

Background:
Our project is a recreation of the classic board game Mastermind. At the start of the game, our program will randomly select four colored pegs (out of six colors total) and place them in random order. This will be the master list for the game. During each of the ten turns, the user selects a color peg (out of six colors total) to place in each of the four slots. The goal of the game is to try to guess the master list. After each turn, our program will tell the player how many of the pegs are the right color only and how many pegs are both the right color and in the right position, but it won’t specify which peg meets the criteria. Based on these hints, the player should be able to make a more informed peg selection during their next turn. If the player guesses the master list after ten turns, they win the game. If not, they lose and the master list is revealed.

How to run the game:
1. open terminal
2. type $ mkdir Mastermind
3. type $ git init
4. type $ git pull https://github.com/justinstrauss/Mastermind.git
5. type $ javac *.java
6. type $ java Game
7. you are ready to play
