package tictactoe;

import java.util.Scanner;
public class TicTacToe1 {
    
    private Player player1, player2;
    private Board board;
    private int playerCount;

    public static void main(String args[]){
        TicTacToe1 t = new TicTacToe1();
        t.startGame();
    }

    public void startGame(){
        Scanner s = new Scanner(System.in);
        //Take players input
        player1 = takePlayerInput(++playerCount);
        player2 = takePlayerInput(++playerCount);
        while(player1.getSymbol() == player2.getSymbol()){
            System.out.println("symbol is already taken!!1 please enter new symbol again");
            player2.setSymbol(s.next().charAt(0));
        }
        //Create the board
        board = new Board(player1.getSymbol(), player2.getSymbol());
        // play the game
        boolean player1Turn = true;
        int status = Board.INCOMPLETE;
        while(status == Board.INCOMPLETE || status == Board.INVALIDMOVE){
            if(player1Turn){
                System.out.println("Player 1 - "+ player1.getName() + "'s turn");
                System.out.println("enter x: ");
                int x = s.nextInt();
                System.out.println("enter :y ");
                int y = s.nextInt();

                status = board.move(player1.getSymbol(),x,y);
                if(status == Board.INVALIDMOVE){
                    System.out.println("Invalid move !!! please try  again");
                    // so we dont toggel turns
                    continue;
                }
            }else{
                System.out.println("Player 2 - "+ player2.getName() + "'s turn");
                System.out.println("enter x: ");
                int x = s.nextInt();
                System.out.println("enter :y ");
                int y = s.nextInt();

                status =board.move(player2.getSymbol(),x,y);
                if(status == Board.INVALIDMOVE){
                    System.out.println("Invalid move !!! please try  again");
                    // so we dont toggel turns
                    continue;
                }
            }

            // set turns
            player1Turn = !player1Turn;
            board.print();
            
        }

        if(status == Board.PLAYER1WINS){
            System.out.println("Player 1 - "+ player1.getName() + "WINS!!!!");
        }else if(status == Board.PLAYER2WINS){
            System.out.println("Player 2 - "+ player2.getName() + "WINS!!!!");
        }else{
            System.out.println("Draw");
        }
        
    }

    private Player takePlayerInput(int num){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter player" + num + "name: ");
        String name = s.nextLine();
        System.out.println("Enter player" + num + "symbol: ");
        char symbol = s.next().charAt(0);
        Player p = new Player(name, symbol);
        
        return p;
        
    }
}

