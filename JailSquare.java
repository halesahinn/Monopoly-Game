import java.io.FileNotFoundException;

public class JailSquare extends Square {
	Die die;
	public JailSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) throws FileNotFoundException {
		if((!player.isJail())&&(player.getCurrentPosition()==10)){
			prompt.print(player, player.getName() + " has been visiting Jail");
		}
}
}