import java.util.Scanner;

public class Toe {

    public int[][] board = new int[3][3];

    //private int player = 1;

    private boolean again = false;
    
    public Toe() {
        Scanner scan = new Scanner(System.in);
        do {
            while(detectWinState() == 0) {
                System.out.printf("Input x, y, player#%n");
                nextMove(scan.nextInt(), scan.nextInt(), scan.nextInt());
            }
            System.out.printf("Player %d wins! Play again? (Y/N) ", detectWinState());
            String playAgain = scan.next();
            if (playAgain.toLowerCase().equals("Y") || playAgain.toLowerCase().equals("Yes")) again = true;
            else again = false;
        } while (again);
        scan.close();
    }

    private void establishGraphics() {
        
    }

    public void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) System.out.printf("%d ", board[i][j]);
            System.out.printf("%n");
        }
    }

    /**
     * 
     * @param x counted from left to right from 0
     * @param y counted from top to bottom from 0
     * @param player 1 for 'X' and 2 for "O"
     */
    public void nextMove(int x, int y, int player) {
        if (board[x][y] == 0) board[x][y] = player;
        else System.out.printf("Player %d has already played there", board[x][y]);
        displayBoard();
    }

    private int detectWinState() {
        for (var i = 0; i < board.length; i++) { 
            if (board[i][0] == board[i][1] && 
                board[i][1] == board[i][2] &&  
                board[i][0] != 0) return board[i][0]; 
            if (board[0][i] == board[1][i] && 
                board[1][i] == board[2][i] &&  
                board[0][i] != 0) return board[0][i];
        }
        if (board[0][0] == board[1][1] && 
            board[1][1] == board[2][2] &&  
            board[0][0] != 0) return board[0][0]; 
        if (board[0][2] == board[1][1] && 
            board[1][1] == board[2][0] && 
            board[0][2] != 0) return board[0][2];
        return 0;
    }
}











/**
 * 
 * boolean bob = true;
 * while (bob) bob = !bob;
 * bob != true; ret true
 * !bob == true; ret false
 * bob == !false; ret true
 * 
 * 
 * 
 */