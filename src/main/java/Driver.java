



import java.util.Date;

import com.freetuition.dao.RequestDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Request;
import com.freetuition.model.RequestApproved;

public class Driver {
	
	public static void main(String...args) {
		
	    RequestDAOImpl repo = new RequestDAOImpl();
		
		Request r = new Request(1,100,"Trinity","Web-Dev 101","full-time", 200.00, "pending", new Date(),null,new Date());
//		
//		repo.insert(r);
	    
//	    RequestApproved ap = new RequestApproved(1,150,100,null);
//		
//		repo.approveRequest(r,ap);

//		System.out.println(repo.allReqByEmployee(10));
		
		
//		//Testing with cards
//		CardRepository cardService = new CardRepositoryImpl();
//		
//		Card card1 = new Card(2, "Wated Dragon", true, new Date(323733883838L));
//		
//		cardService.insert(card1);
//		
//		try {
//			System.out.println(repo.findAll("fake"));
//		} catch (BusinessException e) {
//
//		}
		
		System.out.println(repo.getAllReqByEmployee(10));
	}
	
}