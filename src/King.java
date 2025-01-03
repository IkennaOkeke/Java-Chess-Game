import java.util.ArrayList;
import java.util.List;

class King extends Piece {
    public King(Colour colour) {
        super(colour);
    }

    @Override
   //gets a list of all the possible moves that can be made by a king in its given position
    public List<Move> getPossibleMoves(Position position, Board board) {
      //stores possible moves
        List<Move> possibleMoves = new ArrayList<>();

        //define arrays for row and column directions a king can move in
        int[] rowDirections = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] colDirections = { -1, 0, 1, -1, 1, -1, 0, 1 };

        //iterates through the row and column directions
        for (int i = 0; i < 8; i++) {
            int newRow = position.getRow() + rowDirections[i];
            int newCol = position.getCol() + colDirections[i];
            Position newPosition = new Position(newRow, newCol);

            //checks if the position is valid
            if (board.isValidPosition(newPosition)) {
                //checks to see if the position is empty or if its own colour piece is not there
                if (board.isEmptyPosition(newPosition) || board.getPieceAt(newPosition).getColour() != getColour()) {
                    //add to possible moves
                    possibleMoves.add(new Move(position, newPosition));
                }
            }
        }

        return possibleMoves;
    }

    //unicode characters to represent the king
    @Override
    public String getSymbol() {
        return getColour() == Colour.WHITE ? "\033[37m K" : "\033[30m K";
    }
} //end King
