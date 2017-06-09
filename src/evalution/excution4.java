package evalution;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

public class excution4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
	    step4setNumberToB step4 = new step4setNumberToB();
	    /*
	    List<String> fls = step4.getB();
	    List<Integer> fli = step4.getID(fls);
	    List<List<Integer>> flli = step4.readNumberToo(fli);
	    */
	    step4.setB();
	}

}
