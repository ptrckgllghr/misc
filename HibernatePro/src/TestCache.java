import mv.pojo.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestCache {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session1 = factory.openSession();
		Product p1 = (Product) session1.load(Product.class, 1);
		System.out.println("Loaded Product - Description: " + p1.getDescription());
		System.out.println("Object Loaded successfully.....");
		session1.close();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Session session2 = factory.openSession();
		Product p2 = (Product) session2.load(Product.class, 1);
		System.out.println("Loaded Product - Description: " + p2.getDescription());
		System.out.println("Object Loaded successfully.....");
		session2.close();
		
		Session session3 = factory.openSession();
		Product p3 = (Product) session3.load(Product.class, 1);
		System.out.println("Loaded Product - Description: " + p3.getDescription());
		System.out.println("Object Loaded successfully.....");
		session3.close();
	}
}
