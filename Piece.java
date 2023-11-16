import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Piece {
    private Colour colour;

    //sets private colour to colour of piece
    public Piece(Colour colour) {
        this.colour = colour;
    }

    //gets the colour of the piece
    public Colour getColour() {
        return colour;
    }

    //gets all possible moves for a piece at its current position
    public abstract List<Move> getPossibleMoves(Position position, Board board);
    //gets the symbol representing the piece
    public abstract String getSymbol();
} //end Piece