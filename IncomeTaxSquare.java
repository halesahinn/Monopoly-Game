import java.io.FileNotFoundException;

public class IncomeTaxSquare extends Square {
	public IncomeTaxSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) throws FileNotFoundException {
		prompt.print(player, player.getName() + " is at Income Tax Square... loosing %10 of his/her money");
		player.getMoney().substractMoney(player.getMoney().getMoney()*10/100);
	}

}
