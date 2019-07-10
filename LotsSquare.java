import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LotsSquare extends Square {
	int owner = -1;
 

    public static void readFile() {
    try {
    	
        File file = new File("prices.txt");
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String line = null;
        String[] word;
        int counter=0;
        String newName=null;
        int rent = 0;
        int price;
        int i=0;
            while (counter<22) {
                line = reader.readLine();
                word = line.split(",",3);
                newName="Square"+word[0];	  
          		price=Integer.parseInt(word[1]);
          		rent=Integer.parseInt(word[2]);
          		i=Integer.parseInt(word[0]);
          		getNew(i,newName,price,rent);
          		counter++;
            }

        reader.close();
    } catch (IOException e) {
        System.err.println("Problem reading the file prices.txt");
    }}

    public static void getNew(int j,String name, int price, int rent){
		Board.squares[j]=new LotsSquare(name,price,rent);
	}
    public LotsSquare(String name,int price,int rent){
    	super(name,price,rent);
    	
    }
	public static void setThis(int j,String name, int price, int rent){
		
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public int getPrice() {
		return this.price;
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
				prompt.print(player, player.getName() + " don't want or cannot buy " + getName());
			}
		}else{
			if(owner != player.getID()){
				prompt.print(player, player.getName() + " lost " + rent + " money to " + board.getPlayer(owner).getName());
				player.getMoney().substractMoney(rent);
				board.getPlayer(owner).getMoney().addMoney(rent);
			}
		}
	}
}
