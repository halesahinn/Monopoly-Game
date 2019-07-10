import java.io.FileNotFoundException;

public class FreeParkingSquare extends Square {
	
		public FreeParkingSquare(String name) {
			super(name);
		}
		
		@Override
		public void doAction(Player player, Board board) throws FileNotFoundException {
			prompt.print(player, player.getName() + " is at free parking square, no action here");
			
		}
}
