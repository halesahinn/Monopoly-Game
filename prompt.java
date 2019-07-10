
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class prompt {
	
		public static void print(Player player, String msg)  {
			
			PrintWriter output = null;
			try {
				output = new PrintWriter(new FileWriter("monopoly-output.txt", true), true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			    
			
			
			output.println("[Iteration " + (player.getTotalMove() + 1) + "] [" + player.getCurrentPosition() + "] [$" + player.getMoney().getMoney() + "] " + msg);
		    
			    output.close();
		
		
		}

	
	

}
