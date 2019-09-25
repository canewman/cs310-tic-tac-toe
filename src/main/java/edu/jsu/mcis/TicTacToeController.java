package edu.jsu.mcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    boolean xTurn = true;

    /* CONSTRUCTOR */

    public TicTacToeController(int width) {

        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this ,width);

    }

    public String getMarkAsString(int row, int col) {       
        return (model.getMark(row, col).toString());       
    }
   
    public TicTacToeView getView() {       
        return view;       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton)e.getSource();
        int row = Character.getNumericValue(button.getName().charAt(6));
        int column = Character.getNumericValue(button.getName().charAt(7));

        model.makeMark(row, column);
        view.updateSquares();

        if(model.isGameover())
        {
            view.disableSquares();                        
        }

        view.showResult(model.getResult().toString());

    }

}
