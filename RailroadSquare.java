import java.io.FileNotFoundException;

public class RailroadSquare extends Square{

	int price;
	int owner = -1;

	public RailroadSquare(String name) {
		super(name);
		this.price = 200;
	}
	
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public int getPrice() {
		return price;
	}
	@Override
	public void doAction(Player player, Board board) throws FileNotFoundException {
		if(owner < 0){
			prompt.print(player, player.getName() + ", Do you want to buy " + getName() + "?"); 
			if((Die.getValue()>4)&&(player.getMoney().getMoney()>price)){
				prompt.print(player, player.getName() + " buys " + getName() + " for " + price);
				owner = player.getID();
				player.getMoney().substractMoney(price);
			}else{
				prompt.print(player, player.getName() + " dont want or cannot buy " + getName());
			}
		}else{
			if(owner != player.getID()){
				Die die = null;
				int lost = (5*player.rollDie(die))+25;
				prompt.print(player, player.getName() + " lost 5 times rolled dice + 25 " + lost + " money to " + board.getPlayer(owner).getName());
				player.getMoney().substractMoney(lost);
				board.getPlayer(owner).getMoney().addMoney(lost);
			}
		}
	}

}
