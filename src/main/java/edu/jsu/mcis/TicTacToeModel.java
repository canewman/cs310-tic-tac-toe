package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE"),
        ERROR("ERROR");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE
        for(int row = 0; row < width; row++)
        {
            for(int col = 0; col < width; col++)
            {
                board[row][col] = Mark.EMPTY;
            }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE
        if((isValidSquare(row, col) == true) && (isSquareMarked(row, col) == false))
        {
            if(isXTurn())
            {            
                board[row][col] = Mark.X;
            }
            else
            {
                board[row][col] = Mark.O;
            }
            if(this.xTurn)      //change turn
            {
                this.xTurn = false;
            }
            else
            {
                this.xTurn = true;
            }
            return true;
        }
        else
        {
            return false;
        }
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE
        if((row > width-1) || (col > width-1))
        {
            return false;
        }
        else if((row < 0) || (col < 0))
        {
            return false;
        }
        else
        {
            return true;
        } 
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        // INSERT YOUR CODE HERE
        if(board[row][col] == Mark.EMPTY)
        {
            return false;
        }
        else
        {
            return true;
        }       
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE
        return board[row][col]; 
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
       
       
        if(isMarkWin(Mark.O))
        {
            return Result.O;
        }
        else if(isMarkWin(Mark.X))
        {
            return Result.X;
        }
        else if(isTie())
        {
            return Result.TIE;
        }       
        else return Result.NONE;
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE
        boolean winnerCheckRow = true; 
        boolean checkHolderRow[] = new boolean[width];
        boolean winnerCheckButSmallerRow = true;
        
        boolean winnerCheckColumn = true;
        boolean checkHolderColumn[] = new boolean[width];
        boolean winnerCheckButSmallerColumn = true;
        
        boolean winnerCheckDiag = true;
        boolean checkHolderDiag[] = new boolean[width];
        boolean winnerCheckButSmallerDiag = true;        
      
        for(int i = 0; i < width; i++)/*---------------ROW CHECKER---------------*/
        {
            
            for (int k = 0; k < width; k++)//checks if previous letter equals 
            {                                     //next letter and stores those bools into array                     
                if(board[i][k].equals(mark) == false)  {
                    winnerCheckRow = false;			
                }                
                checkHolderRow[k] = winnerCheckRow;
                winnerCheckRow = true;
            }
                                
           for (boolean n : checkHolderRow) {
                if (false == n) {
                   winnerCheckButSmallerRow = false;
                }                      
             }
            if (winnerCheckButSmallerRow)
            {               
                    return true;                
            }
            winnerCheckButSmallerRow = true;
        }
        
         for(int i = 0; i < width; i++)/*--------------COLUMN CHECKER--------------*/
        {
            
            for (int k = 0; k < width; k++)//checks if previous letter equals 
            {                                     //next letter and stores those bools into array                     
                if(board[k][i].equals(mark) == false)  {
                    winnerCheckColumn = false;			
                }   
                checkHolderColumn[k] = winnerCheckColumn;
                winnerCheckColumn = true;
            }
                                
           for (boolean n : checkHolderColumn) {
                if (false == n) {
                   winnerCheckButSmallerColumn = false;
                }                      
             }
            if (winnerCheckButSmallerColumn)
            {                
                    return true;                
            }
            winnerCheckButSmallerColumn = true;
        }
        
                            /*-----------------DIAGONAL CHECKER top2bot----------------*/
        int x = 0;
        int y = 0;
         for(int k = 0; k < width; k++)
        {
            if(board[x][y].equals(mark) == false)
            {
                winnerCheckDiag = false;
            }
            checkHolderDiag[y] = winnerCheckDiag;
            winnerCheckDiag = true;
            x++;
            y++;
        }     
         
        for (boolean n : checkHolderDiag) {
             if (false == n) {
                winnerCheckButSmallerDiag = false;
             }                      
          }
         if (winnerCheckButSmallerDiag)
         {                
                 return true;                
         }
         winnerCheckButSmallerDiag = true;

                              /*-----------------DIAGONAL CHECKER bot2top----------------*/
        x = width-1;
        y = 0;
        for (int i = 0; i < width; i++)
        {
           if(board[x][y].equals(mark) == false)
           {
               winnerCheckDiag = false;
           }
           checkHolderDiag[y] = winnerCheckDiag;
           winnerCheckDiag = true;
           x--;
           y++;
        }                            
       for (boolean n : checkHolderDiag) {
            if (false == n) {
               winnerCheckButSmallerDiag = false;
            }                      
         }
        if (winnerCheckButSmallerDiag)
        {                
                return true;                
        }
        winnerCheckButSmallerDiag = true;     


        return false; 

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE
        boolean tie = true;
        
        for(int i = 0; i < width; i++)
        {
            for(int k = 0; k < width; k++)
            {
                if(board[i][k] == Mark.EMPTY)
                {
                    tie = false;
                }                   
            }
        }

        return tie; 
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {        
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE       
        StringBuilder output = new StringBuilder("");          
        output.append("\n\n ");
        for(int k = 0; k < width; k++)
        {
            output.append(k);
        }
        output.append("\n");
        for(int i =0; i < width; i++)
        {
            output.append(i + " ");
            for(int k = 0; k < width; k++)
            {
                output.append(board[i][k]);
            }
            output.append("\n");
        }
        output.append("\n");        
        
        return output.toString();
        
    }
    
}
