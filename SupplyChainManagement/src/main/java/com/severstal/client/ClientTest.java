package com.severstal.client;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.severstal.model.Product;
import com.severstal.service.ProductService;
import com.severstal.service.impl.ProductServiceImpl;

public class ClientTest {
	//public static Logger logger=Logger.getLogger(ClientTest.class);
	public static void main(String[] args) {
		//logger.info("Log4j addition");
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		ProductService productService=context.getBean("productService",ProductServiceImpl.class);
		//createProduct(productService);
		
		System.out.println(fetchAllProduct(productService));
		context.close();
	}
	private static void createProduct(ProductService productService) {
		Product product =new Product();
		product.setProductPrice(2000);
		product.setProductShape("round");
		product.setProductType("TongStun");
		
		
		productService.addProduct(product);
	}
	private static List<Product> fetchAllProduct(ProductService productService) {
	
		return productService.fetchALlProduct();
		
	}
	
	
	
	
}
