import java.io.FileNotFoundException;

public abstract class Square {
int price;
String name;
int rent;
	
	public Square(String name) {
		this.name = name;
	}
	public Square(String name, int price, int rent){
		this.name=name;
		this.price=price;
		this.rent=rent;

	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getRent() {
		return rent;
	}
	public abstract void doAction(Player player, Board board) throws FileNotFoundException;
	}