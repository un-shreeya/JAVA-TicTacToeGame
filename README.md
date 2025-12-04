# JAVA TicTacToe - Dark Mode with Sound Effects
------------------------------------------------

+ A two-player Tic Tac Toe game in Java Swing +

Folder Structure:
-----------------
TicTacToe/          

- `src/` - contains the Java source file
  
- `sounds/` - contains `.wav` files used for effects

    -click.wav
  
    -win.wav
  
- sounds/ folder should be in the same directory as src/


Features in this code:
---------------------
1. Two-player Tic Tac Toe:  Players take turns clicking buttons.

2. Win detection:  Winning three buttons turn green.

3. Draw detection:  Alerts if the board fills without a winner.

4. Dark Mode:  Buttons are black (Color.BLACK) with white text (Color.WHITE) ; Persistent across rounds.

5. Sound effects:  click.wav plays when X or O is placed, win.wav plays when someone wins

6. Reset:  After a win or draw, the board resets to dark mode automatically.

![Tic Tac Toe Main Screen](https://github.com/un-shreeya/JAVA-TicTacToeGame/blob/4a8e0e97c990f58a99a55814a29ca1c7cc685aa0/Screenshot%202025-12-04%20155641.png)

![Tic Tac Toe Win Highlight](https://github.com/un-shreeya/JAVA-TicTacToeGame/blob/4a8e0e97c990f58a99a55814a29ca1c7cc685aa0/Screenshot%202025-12-04%20155947.png)

## How to Run
--------------
1. Ensure the `sounds/` folder is in the same directory as `src/`.
2. Compile: `javac src/TicTacToe.java`
3. Run: `java -cp src TicTacToe`


Author:
-------
Shreeya
