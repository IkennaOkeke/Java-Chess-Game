import java.util.ArrayList;
import java.util.List;

class Queen extends Piece {
    public Queen(Colour colour) {
        super(colour);
    }

    @Override
    //gets a list of all the possible moves that can be made by a queen in its given position
    public List<Move> getPossibleMoves(Position position, Board board) {
        //stores possible moves
        List<Move> possibleMoves = new ArrayList<>();

        //adds all the moves of a rook to the possible queen moves
        Rook rook = new Rook(getColour());
        possibleMoves.addAll(rook.getPossibleMoves(position, board));

        //adds all the moves of a bishop to the possible queen moves
        Bishop bishop = new Bishop(getColour());
        possibleMoves.addAll(bishop.getPossibleMoves(position, board));

        return possibleMoves;
    }

    //unicode characters to represent the queen
    @Override
    public String getSymbol() {
        return getColour() == Colour.WHITE ? "\033[37m Q" : "\033[30m Q";
    }
} //end Queen