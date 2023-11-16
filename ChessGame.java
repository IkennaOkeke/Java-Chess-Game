import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChessGame {
    private Board board; //holds the chessboard
    private Player[] players; //holds the players
    private int currentPlayerIndex; //tells us who's turn it is

    //creates the chessboard, players, and starts the game with White's move
    public ChessGame() {
        board = new Board();
        players = new Player[2];
        players[0] = new Player(Colour.WHITE);
        players[1] = new Player(Colour.BLACK);
        currentPlayerIndex = 0;
    }

    // responsible for starting the chess match
    public void startGame() {
        System.out.println("Welcome to Computer Science 30 Chess, by Ikenna and Alexander!\nAs per usual in Chess, avoid making impossible moves, as you will be prompted to make a new move.\nAlso, there is no castling or checkmate in this version of Chess, so you will need to capture the king in order to win.\nHave fun!");
        board.initialize();
        play();
    }

    // main loop of the game
    private void play() {
        while (!isGameOver()) {
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println("Current player: " + currentPlayer.getColour());

            //shows the board each turn
            System.out.println(board);
          
            //gets the move the player wants to make
            Move move = currentPlayer.getMove(board);

            //applies the desired move to the chessboard
            board.makeMove(move);

            //changes which player gets to move at the end
            currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        }

        //displays who wins when the game is over
        Player winner = players[(currentPlayerIndex + 1) % 2];
        System.out.println("Game over! Winner: " + winner.getColour());
    }

    //for-each loop to check if the game is over
    private boolean isGameOver() {
    for (Player player : players) {
        if (board.isKingTaken(player.getColour())) {
            return true; // King of player's colour is taken, game over
        }
    }
    return false; // Game is not over
    }
} //end ChessGame