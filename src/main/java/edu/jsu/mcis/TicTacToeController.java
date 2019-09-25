package edu.jsu.mcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    boolean xTurn = true;

    /* CONSTRUCTOR */

    public TicTacToeController(int width) {

        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView();

    }

    public void start() {

        /* MAIN LOOP (repeats until game is over) */

        /*
         * Display the board using the View's "showBoard()", then use "getNextMove()" to
         * get the next move from the player. Enter the move (using the Model's
         * "makeMark()", or display an error using the View's "showInputError()" if the
         * move is invalid.
         */

        // INSERT YOUR CODE HERE
        while (model.isGameover() != true) {
            view.showBoard(model.toString());
            TicTacToeMove move = view.getNextMove(xTurn);
            boolean valid = (model.makeMark(move.getRow(), move.getCol()));
            if (valid == false) {
                view.showInputError();
            }

        }
        /* After the game is over, show the final board and the winner */

        view.showBoard(model.toString());

        view.showResult(model.getResult().toString());

    }

    public String getMarkAsString(int row, int col) {       
        return (model.getMark(row, col).toString());       
    }
   
    public TicTacToeView getView() {       
        return view;       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
