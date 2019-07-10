import java.io.FileNotFoundException;

public class GoJailSquare extends Square {
	public GoJailSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) throws FileNotFoundException {
		prompt.print(player, player.getName() + " has go to Jail");
		player.setJail(true);
		board.movePlayer(player, -20, true);
		
		
		
	}
}