# padskyfallsim
Simulator - Full Board Skyfall - Random Match %
Created 2016-11-16
Last Updated 2016-11-17
padskyfallsim (this repository) owned by Phi161803
Puzzle and Dragons owned by GungHo Online Entertainment

A small program to find the chance of a random match from any given full board skyfall in Puzzle And Dragons.
Rather than using an equation, this program uses the Monte Carlo method by running extremely high numbers of simulations.

Modifiable variables:
Line 11 - orbTypes - Number of different possible orbs. Defaults to 6, tricolor = 4, no RCV = 5, etc
Line 12 - reps - Number of simulations to run, capped at the int ceiling (2147483647). Multiple millions are generally recommended.
Line 13/14 - boardWidth/boardHeight - Dimensions of the board, defaults to 6 and 5, respectively.
Line 15 - notifyCount - Outputs progress and most current probability. 
