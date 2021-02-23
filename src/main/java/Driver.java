



import java.sql.Date;

import com.freetuition.dao.CardRepository;
import com.freetuition.dao.CardRepositoryImpl;
import com.freetuition.model.Card;

public class Driver {
	
	public static void main(String...args) {
		
//	    RequestRepo repo = new RequestRepo();
//		
//		Request r = new Request(1,100,"Northwestern","Web-Dev 101","full-time", 600.00, "pending", new Date(),null,new Date());
//		
//		repo.insert(r);
//		
//		System.out.println(repo.findAll());
		
		
		
		//Testing with cards
		CardRepository cardService = new CardRepositoryImpl();
		
//		Card card1 = new Card(2, "Wated Dragon", true, new Date(323733883838L));
//		
//		cardService.insert(card1);
		
		System.out.println(cardService.findAll());
	}
	
}