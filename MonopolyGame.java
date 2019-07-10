

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class MonopolyGame {
	
	
		Die die = new Die();
		Board board;
		static int initMoney=0;
		
		public MonopolyGame(int totalPlayer) {
			board = new Board(totalPlayer);
		}
		
		public static void main(String[] args) throws IOException {
			
			PrintWriter output = null;
			try {
				output = new PrintWriter(new FileWriter("monopoly-output.txt", true), true);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			    
			output.println("\tMonopoly\n");
			Scanner scanner = new Scanner(System.in);
			int totalPlayer = 0;
			while (totalPlayer < 2 || totalPlayer > 8) {
				try {
					
				    output.println("How many people are playing?");
				    System.out.println("How many people are playing?");
				    System.out.print("Players (2 - 8): ");
					output.println("Players (2 - 8): ");
					totalPlayer = scanner.nextInt();
					output.println("There will be "+totalPlayer+" players.");
					output.println("How much money for each at start?");
					System.out.println("How much money for each at start?");
					initMoney = scanner.nextInt();
					output.println("Each player will have "+initMoney+" for start.");
				}
				catch(Exception e) {
					System.err.println("Error: Number too large.");
					continue;
				}
				if((totalPlayer > 8) ||(totalPlayer<2)) {
					System.err.println("Error: Invalid player count.");
				}
			}
			scanner.close();
			MonopolyGame game = new MonopolyGame(totalPlayer);
			game.startGame(totalPlayer);
			 System.out.println("All iteration movements and the results are in monopoly-output.txt file.\n And new ones adds up the old ones below.");
		output.close();
		} 
		public void startGame(int totalPlayer) throws FileNotFoundException {
			PrintWriter output = null;
			try {
				output = new PrintWriter(new FileWriter("monopoly-output.txt", true), true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			output.println("Game start!");
			output.println("========");
			int bank=1;
			while (bank<board.totalPlayer){
				if((!board.getCurrentPlayer().getMoney().isBankRuptcy())&&(!board.getCurrentPlayer().playerOut())){
					int face = board.getCurrentPlayer().rollDie(die);
					board.movePlayer(board.getCurrentPlayer(), face);
				}else if((board.getCurrentPlayer().getMoney().isBankRuptcy())&&(!board.getCurrentPlayer().playerOut())){
					prompt.print(board.getCurrentPlayer(), board.getCurrentPlayer().getName()+" removed from the game because of bankruptcy.");
					board.getCurrentPlayer().setOut(true);
					bank++;
				}
				board.nextTurn();
			}
			
			output.println("========");
			
			output.println("Game over!");
			output.close();
		}

		
		
					
					
}


