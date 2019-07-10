import java.io.FileNotFoundException;

public class OrdinarySquare extends Square {
	public OrdinarySquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) throws FileNotFoundException {
		prompt.print(player, player.getName() + " is at non specified square, no action here");
		
	}
}