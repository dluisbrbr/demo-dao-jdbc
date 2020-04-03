package application;

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
		
		System.out.println("\n=== TESTE 1: seller FindByDepartment");
		Department dep = new Department(2,"Electronics");
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for ( Seller obj : list) {
			System.out.println(obj);
		}

	}

}
