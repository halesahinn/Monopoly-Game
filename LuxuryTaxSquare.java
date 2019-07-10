import java.io.FileNotFoundException;

public class LuxuryTaxSquare extends Square {
	public LuxuryTaxSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) throws FileNotFoundException {
		prompt.print(player, player.getName() + " is at Luxury Tax Square... loosing 75 of his/her money");
		player.getMoney().substractMoney(75);
	}

}


