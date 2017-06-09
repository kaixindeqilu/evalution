package TZOTevalution;

import java.sql.SQLException;
import java.util.List;


public class Zexcution2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Zstep2getTen sgt = new Zstep2getTen();
		List<Zcompany> lcp = sgt.getData();
		sgt.setData(lcp);
	}

}
