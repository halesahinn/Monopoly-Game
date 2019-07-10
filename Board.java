import java.io.FileNotFoundException;

public class Board {
	private int turnIteration = 0;
	int iterationNumber=0;
	int totalPlayer = 0;
	Player[] players;
	static Square[] squares = new Square[41];
	
	public Board(int totalPlayer) {
		players = new Player[totalPlayer];
		this.totalPlayer = totalPlayer;
		for(int i = 0;i < players.length;i++){
			players[i] = new Player(i, "Player " + (i + 1));
		}
		LotsSquare.readFile();
		for(int i = 1;i < squares.length;i++){
			if(i == 1){
				squares[i] = new GoSquare("GO");
			}/*else if((i==2)||(i==4)||(i==7)||(i==9)||(i==10)||(i==12)
					||(i==14)||(i==15)||(i==17)||(i==19)||(i==20)||(i==22)
					||(i==24)||(i==25)||(i==27)||(i==28)||(i==30)||(i==32)||(i==33)
					||(i==35)||(i==38)||(i==40)){
				squares[i]= new LotsSquare(newName,price,rent);
			}*/else if(i == 5){
				squares[i] = new IncomeTaxSquare("Income Tax Square");
			}else if(i == 6){
				squares[i] = new RailroadSquare("Railroad1 Square");
			}else if(i == 11){
				squares[i] = new JailSquare("Jail");
			}else if(i == 13){
				squares[i] = new UtilitySquare("Electric Utility Square");
			}else if(i == 16){
				squares[i] = new RailroadSquare("Railroad2 Square");
			}else if(i == 21){
				squares[i] = new FreeParkingSquare("Free Parking");
			}else if(i == 26){
				squares[i] = new RailroadSquare("Railroad3 Square");
			}else if(i == 29){
				squares[i] = new UtilitySquare("Water Utility Square");
			}else if(i == 31){
				squares[i] = new GoJailSquare("Go to Jail");
			}else if(i == 36){
				squares[i] = new RailroadSquare("Railroad4 Square");
			}else if(i == 39){
				squares[i] = new LuxuryTaxSquare("Luxury Tax Square");
			}else if((i==3)||(i==8)||(i==18)||(i==23)||(i==34)||(i==37)){
				squares[i] = new OrdinarySquare("Ordinary Square");
			}
			
		}
	}


	public Square movePlayer(Player player, int face) throws FileNotFoundException {
		return movePlayer(player, face,true);
	}
	public Square movePlayer(Player player, int face, boolean count) throws FileNotFoundException {
		
		int newPosition=0;
		int counter=0;
		int pstn =0;
		if(player.bankruptcy()){ return squares[player.getCurrentPosition()]; }
		 if((player.isJail())&&(player.getCurrentPosition()==10)&&(player.getMoney().getMoney()>50)){
			    counter++;
				prompt.print(player, player.getName() + " is in Jail and lose 50 money to roll dice!");
				player.getMoney().substractMoney(50);
				prompt.print(player,player.getName() + " goes to " + squares[player.getCurrentPosition()].getName());
				if(player.isRolledDouble()){
					prompt.print(player, player.getName() + " has been out of jail by rolling double!");
					player.setPosition(player.getCurrentPosition()+face);
					player.setJail(false);
			    }else if(player.getMoney().getMoney()>500){
			    	prompt.print(player, player.getName() + " has been out of jail by paying 500 money!");
			    	player.setPosition(player.getCurrentPosition());
					player.setJail(false);
					player.getMoney().substractMoney(500);
			    }else if(counter==3){
			    	prompt.print(player, player.getName() + " has been out of jail because of there is been 3 turn!");
			    	player.setPosition(player.getCurrentPosition());
					player.setJail(false);
			    }else{
				prompt.print(player, player.getName() + "  still in jail!");
				player.setPosition(player.getCurrentPosition());
				player.setJail(true);
		        }
				if(player.getMoney().isBankRuptcy()){
					prompt.print(player, player.getName() + " has been bankruptcy!");
					player.setBankruptcy(true);
				}else{
					if(count){
						player.nextTurn();
					}
				}
				return squares[player.getCurrentPosition()];
		}else{
			pstn = player.getCurrentPosition() + face;
			if((pstn)>40){
				pstn = pstn-40;
			}
		 newPosition = normalizePosition(pstn);
		player.setPosition(newPosition);
		prompt.print(player,player.getName() + " goes to " + squares[player.getCurrentPosition()].getName());
		squares[newPosition].doAction(player, this);
	
		if(player.getMoney().isBankRuptcy()){
			prompt.print(player, player.getName() + " has been bankruptcy!");
			player.setBankruptcy(true);
		}else{
			if(count){
				player.nextTurn();
			}
		}
		return squares[newPosition];
	}
	}
		
	public int normalizePosition(int position) {
		return position % squares.length;
	}
	
	public Player getCurrentPlayer() {
		return players[turnIteration];
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void nextTurn() {
		if(++turnIteration >= players.length){
			turnIteration = 0;
			iterationNumber++;
		}
	}
	
	public Player getPlayer(int id) {
		return players[id];
	}
	
	public int getTotalSquare() {
		return squares.length;
	}
	}
