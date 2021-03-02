import com.freetuition.dao.EmployeeDAOImpl;
import com.freetuition.dao.RequestDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;

public class Driver {
	
	public static void main(String...args) {
		
	    RequestDAOImpl repo = new RequestDAOImpl();
	    
	    try {
			System.out.print(repo.getAllReqByEmployee(2,3));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Request r = new Request(1,100,"Trinity","Web-Dev 101","full-time", 200.00, "pending", new Date(),null,new Date());
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
		
//		System.out.println(repo.getAllReqByEmployee(10));
	    Employee someone = new Employee();
	    someone.setId(1);

		Login login = new Login(7,"lu","lulu");
		Employee manager = new Employee();

		Employee employee = new Employee(3,"Luigi","Mario","West","Manager",someone,"lui@west.com",888779066,"796 W Red St");
//		Employee employee = new Employee(7,"Natasha","Brick","West","CEO",null,"tasha@west.com",888776647,"377 W Green St");
//		
//		Request req = new Request(7, employee, "school", "course",800,"pending",null, manager, "pending");
//		System.out.println(req);
		
		EmployeeDAOImpl daoE = new EmployeeDAOImpl();
		try {
			daoE.createEmployee(employee, login);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}