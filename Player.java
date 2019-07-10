import java.io.FileNotFoundException;

public class Player {
	 private int totalMove = 0;
     private boolean isJail = false;
     private boolean rolledDouble=false;
   	 private int id;
	 private String name;
	 private int position = 0;
	 private boolean bankruptcy = false;
	 private boolean playerOut = false;
	 public int counter =0;
	 Money money = new Money(MonopolyGame.initMoney);
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName(){
		
		return name;
	}
	public int getTotalMove() {
		return totalMove;
	}

	public int rollDie(Die die) throws FileNotFoundException {
		this.rolledDouble=false;
		int face1 = Die.getValue();
		prompt.print(this,getName()+" rolls die and its first face value is "+ face1);
	
		int face2 = Die.getValue();
		prompt.print(this,getName()+" rolls die and its second face value is "+ face2);
		if(face1==face2){
			this.rolledDouble=true;
		}
		int faceValueSum = face1+face2;
		prompt.print(this,getName()+" total face value is "+ faceValueSum);
		return faceValueSum;
	}
	public int getCurrentPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		
		this.position = position;
		
	}
	
	public void nextTurn() {
		totalMove++;
	}
	
	public Money getMoney() {
		return money;
	}
	public void setJail(boolean is){
		isJail=is;
	}
	public boolean isRolledDouble(){
		counter++;
		if(counter==3){
			this.setPosition(30);
		}
		return rolledDouble;
	}
	
    public boolean isJail(){
    	return isJail;
    }
	public int getID() {
		return id;
	}
	
	public void setBankruptcy(boolean bankruptcy) {
		this.bankruptcy = bankruptcy;
	}
	public void setOut(boolean playerOut){
		this.playerOut=playerOut;
	}
	public boolean playerOut() {
		return this.playerOut;
	}
	public boolean bankruptcy() {
		return this.bankruptcy;
	}
}