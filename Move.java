import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Move {
    private Position source;
    private Position destination;

    public Move(Position source, Position destination) {
        this.source = source;
        this.destination = destination;
    }

    // Get the source position of the move
    public Position getSource() {
        return source;
    }

    // Get the destination position of the move
    public Position getDestination() {
        return destination;
    }

  
   @Override
    //used to check if the player's desired move matches up with one of the piece's possible moves
    public boolean equals(Object obj) {
    //checks if objects are the same
    if (this == obj) {
        return true;
    }
    //checks if the object doesnt exist or exists in a different class
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    //makes object Move type
    Move otherMove = (Move) obj;
      //compares the source and destination positions of the moves
      return this.source.equals(otherMove.source) &&     this.destination.equals(otherMove.destination);
      
}

} //end Move