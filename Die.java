
public class Die{
	
 private static int faceValue;
 public Die(){

 }

	public static int getValue() {
		faceValue = (int) (Math.random() * (6 - 1)) + 1;
		
		return faceValue;
		
	}

}
