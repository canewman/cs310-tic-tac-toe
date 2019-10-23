# cs310-tic-tac-toe

This program is a command line and GUI based game of Tic-Tac-Toe. 
Running it from the command line allows an argument to be passed to specify the width of the board, if the width is not specified 
it generates a 3 by 3 board. If the GUI version (under second branch) is used, then a grid of buttons are created and players take
turns clicking the buttons. If a button is clicked it displays either 'X' or 'O'. Once a player wins a message is displayed showing
the player and the buttons are disabled. If the command line version of the game is used (master branch) then its a text based version
of the game where the board is drawn out using StringBuilder and changed according to where the player marks. Besides that it works fairly
the same.  

--------  
  
The format for the code is based off Model/View/Controller. 
  
-Model  
Handles the back-end of the game such as checking to see if theres a winner, filling and changing the board and checking to see if the game
is over.   
-View  
This controls what the players see, this includes generating the game board in GUI or displaying the built string board (done in model) in 
the command line.   
-Controller  
This is what allows the view and model to communicate with each other. This is also where the main loop of the program occurs in the text
based version of the game.  
  
--------  
The main function creates the controller which in turn creates the model/view, then it either starts the main loop (text based version) or 
passes priority to the GUI application. The only other file is the move class which simply keeps track of each players move. 
