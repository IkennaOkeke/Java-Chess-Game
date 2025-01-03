import java.util.ArrayList;
import java.util.List;


class Pawn extends Piece {
    public Pawn(Colour colour) {
        super(colour);
    }

    @Override
  //gets a list of all the possible moves that can be made by a king in its given position
    public List<Move> getPossibleMoves(Position position, Board board) {
    //stores possible moves
    List<Move> possibleMoves = new ArrayList<>();

    int direction = (getColour() == Colour.WHITE) ? -1 : 1; //direction pawn can move in depending on colour
    int startRow = (getColour() == Colour.WHITE) ? 6 : 1; //starting row for pawns depending on colour
    int currentRow = position.getRow(); //finds current row
    int currentCol = position.getCol(); //finds current column


    //one step forward move
    Position oneStepForward = new Position(currentRow + direction, currentCol);
    //checks if position is valid and empty
    if (board.isValidPosition(oneStepForward) && board.isEmptyPosition(oneStepForward)) {
      //add to possible moves
        possibleMoves.add(new Move(position, oneStepForward));

    }

    //two step forward move from starting position
    if (currentRow == startRow) { //only occurs when pawn is in its starting row
        Position twoStepsForward = new Position(currentRow + (2 * direction), currentCol);
        //checks if position is valid and empty
        if (board.isValidPosition(twoStepsForward) && board.isEmptyPosition(twoStepsForward)) {
            //add to possible moves
            possibleMoves.add(new Move(position, twoStepsForward));
        }
    }

    // Diagonal captures
    Position leftCapture = new Position(currentRow + direction, currentCol - 1);
    Position rightCapture = new Position(currentRow + direction, currentCol + 1);
    //checks to see if the position is empty and if its own colour piece is not there and if it is valid
    if (board.isValidPosition(leftCapture) && !board.isEmptyPosition(leftCapture) &&
            board.getPieceAt(leftCapture).getColour() != getColour()) { 
        //add to possible moves
        possibleMoves.add(new Move(position, leftCapture));
    }
    //checks to see if the position is empty and if its own colour piece is not there and if it is valid
    if (board.isValidPosition(rightCapture) && !board.isEmptyPosition(rightCapture) &&
            board.getPieceAt(rightCapture).getColour() != getColour()) {
        //add to possible moves
        possibleMoves.add(new Move(position, rightCapture));
    }

    return possibleMoves;
}
    //unicode characters to represent the pawn
    @Override
    public String getSymbol() {
        return getColour() == Colour.WHITE ? "\033[37m P" : "\033[30m P";
    }
    
} //end Pawn