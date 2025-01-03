import java.util.ArrayList;
import java.util.List;

class Rook extends Piece {
    public Rook(Colour colour) {
        super(colour);
    }

    //gets a list of all the possible moves that can be made by a rook in its given position
    @Override
    public List<Move> getPossibleMoves(Position position, Board board) {
        //stores possible moves
        List<Move> possibleMoves = new ArrayList<>();

        //define arrays for row and column directions a rook can move in
        int[] rowDirections = { -1, 1, 0, 0 };
        int[] colDirections = { 0, 0, -1, 1 };

        //iterates through the row and column directions
        for (int i = 0; i < 4; i++) {
            int row = position.getRow() + rowDirections[i];
            int col = position.getCol() + colDirections[i];
            Position newPosition = new Position(row, col);

            //checks if the position is valid
            while (board.isValidPosition(newPosition)) {
                //checks to see if the position is empty
                if (board.isEmptyPosition(newPosition)) {
                    //add to possible moves
                    possibleMoves.add(new Move(position, newPosition));
                } else {
                    //prevents piece from taking its own colour
                    if (board.getPieceAt(newPosition).getColour() != getColour()) {
                        //add to possible moves
                        possibleMoves.add(new Move(position, newPosition));
                    }
                    break;
                }

                //moves on to the next position
                row += rowDirections[i];
                col += colDirections[i];
                newPosition = new Position(row, col);
            }
        }

        return possibleMoves;
    }

    //unicode characters to represent the rook
    @Override
    public String getSymbol() {
        return getColour() == Colour.WHITE ? "\033[37m R" : "\033[30m R";
    }
}  //end Rook