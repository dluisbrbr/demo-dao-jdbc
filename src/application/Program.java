package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.ISellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		ISellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1: seller FindById");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 2: seller FindByDepartment");
		Department dep = new Department(2,"Electronics");
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for ( Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 3: seller FindAll");
		List<Seller> list2 = sellerDao.findAll();
		
		for ( Seller obj : list2) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 4: seller insert");
		Seller newseller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4670.0, dep);
		sellerDao.insert(newseller);
		System.out.println("Inserted! New id : " + newseller.getId());
		

		System.out.println("\n=== TESTE 5: seller update");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Updated completed.");
		
		
		System.out.println("\n=== TESTE 6: seller delete");
		sellerDao.deleteById(1);
		System.out.println("Delete completed.");
		
	}

}
