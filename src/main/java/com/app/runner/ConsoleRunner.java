package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.app.dao.ProductRepository;
import com.app.model.Product;

@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * save method
		 * 
		 * repo.save(new Product(10,"a",3.3)); repo.save(new Product(11,"g",4.4));
		 * repo.save(new Product(12,"b",5.5));
		 */

		/*
		 * this method will do save or update based on primiry key
		 * 
		 * repo.save(new Product(12,"h",5.7));
		 */
		// this method will insert bulk data 
		/*
		 * List<Product> prds= Arrays.asList( new Product(14,"x",6.5), new
		 * Product(15,"v",6.4), new Product(16,"b",8.5), new Product(17,"m",9.5));
		 * repo.saveAll(prds);
		 */ 

		/*
		 * fetch one row Optional is class to avoid null pointer exception
		 * Optional<Product> p=repo.findById(133); if(p.isPresent()) { Product
		 * prd=p.get(); System.out.println(prd.getProdCode()); }else {
		 * System.out.println("row not found"); }
		 */

		/*
		 * fetch all rows using findAll method
		 * 
		 * List<Product> prdos=repo.findAll(); prdos.forEach(System.out::println);
		 */

		// repo.deleteById(12); delete based on id
		// repo.deleteAll();      delte all rows but one by one
		//repo.deleteAllInBatch(); delte all rows at a time

		/*sort is method to print out in acsending oreder or decsending order using 
		 * 
		 * List<Product> list= repo.findAll(Sort.by(Direction.DESC,"prodId")); 
		 * for
		 * (Product product : list) { System.out.println(product); }
		 */	

		/*this method isused to fetch dta based on pagination proccess
		 * 
		 * PageRequest p = PageRequest.of(0, 3);
		 * repo.findAll(p).forEach(System.out::println);;
		 */


		Product p=new Product(); p.setProdCost(2.2); 
		Example<Product> ex =Example.of(p); 
		repo.findAll(ex).forEach(System.out::println);

		repo.findAll(ex ,Sort.by(Direction.DESC,"prodCode")).forEach(System.out::println);
		repo.findAll(ex,PageRequest.of(1,2)).forEach(System.out::println);


	}
}
