class Board {
    private Piece[][] grid;

    public Board() {
        grid = new Piece[8][8];
    }

    //places all of the chess pieces in their corresponding starting positions
    public void initialize() {
        //places pawns
        for (int col = 0; col < 8; col++) {
            grid[1][col] = new Pawn(Colour.BLACK);
            grid[6][col] = new Pawn(Colour.WHITE);
        }

        //places rooks
        grid[0][0] = new Rook(Colour.BLACK);
        grid[0][7] = new Rook(Colour.BLACK);
        grid[7][0] = new Rook(Colour.WHITE);
        grid[7][7] = new Rook(Colour.WHITE);

        //places knights
        grid[0][1] = new Knight(Colour.BLACK);
        grid[0][6] = new Knight(Colour.BLACK);
        grid[7][1] = new Knight(Colour.WHITE);
        grid[7][6] = new Knight(Colour.WHITE);

        //places bishops
        grid[0][2] = new Bishop(Colour.BLACK);
        grid[0][5] = new Bishop(Colour.BLACK);
        grid[7][2] = new Bishop(Colour.WHITE);
        grid[7][5] = new Bishop(Colour.WHITE);

        //places queens
        grid[0][3] = new Queen(Colour.BLACK);
        grid[7][3] = new Queen(Colour.WHITE);

        //places kings
        grid[0][4] = new King(Colour.BLACK);
        grid[7][4] = new King(Colour.WHITE);
    }

    //makes a move on the chessboard
    public void makeMove(Move move) {
        //finds where the piece the player is trying to move is currently placed
        Position source = move.getSource();
      
        //finds where the player wants to move the piece
        Position destination = move.getDestination();

        //moves the piece to the desired location
        Piece piece = grid[source.getRow()][source.getCol()];
        grid[source.getRow()][source.getCol()] = null;
        grid[destination.getRow()][destination.getCol()] = piece;
    }

    //checks if where the player wants to move is within the chessboard
    public boolean isValidPosition(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    //checks if the position the player wants to go to is empty
    public boolean isEmptyPosition(Position position) {
    if (grid[position.getRow()][position.getCol()] == null) {
      return true;
    }
    return false;
    }

    //removes a taken piece at a certain position
    public Piece getPieceAt(Position position) {
        if (isValidPosition(position)) {
            return grid[position.getRow()][position.getCol()];
        }
        return null;
    }

    //checks if a king of its specific colour the has been taken (if true, the game ends)
    public boolean isKingTaken(Colour colour) {
    for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
            Piece piece = grid[row][col];
            if (piece instanceof King && piece.getColour() == colour) {
                return false; // King of the specific colour is still on the board
            }
        }
    }
    return true; // king of the specific colour has been taken
    }
  
    @Override
    //used to display the chessboard's rows(numbers) and columns(letters)
    public String toString() {
        StringBuilder display = new StringBuilder();

        //adds the board's columns
        display.append("   A  B  C  D  E  F  G  H\n");

        //adds the board's rows
        for (int row = 0; row < 8; row++) {
            display.append(row + 1).append(" ");
            for (int col = 0; col < 8; col++) {
                Piece piece = grid[row][col];
                if ((row + col) % 2 == 1) {
                    display.append("\033[102m");
                }
                else {
                    display.append("\033[43m");
                }
                display.append(piece != null ? piece.getSymbol() : "\033[90m ·").append(" ");
                display.append("\033[0m");
            }
            display.append("\n");
        }

        return display.toString();
    }
} //end Board
