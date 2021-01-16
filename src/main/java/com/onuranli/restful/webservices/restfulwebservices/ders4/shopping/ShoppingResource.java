package com.onuranli.restful.webservices.restfulwebservices.ders4.shopping;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ShoppingResource {
	
	@Autowired
	private ShoppingDao shoppingDao;
	
	@PostMapping( path = "/ShoppingList")
	public ResponseEntity<Object> addProduct(@RequestBody ProductBean bean){
		ProductBean addProduct = shoppingDao.addProduct(bean);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addProduct.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@GetMapping(path = "/ShoppingList")
	public List<ProductBean> getAllShoppingList(){
		return shoppingDao.getAllShoppingList();
		
	}
	
	@RequestMapping(method =RequestMethod.GET, path = "/ShoppingList/{id}")
	public ProductBean getProduct(@PathVariable Integer id){
		ProductBean product = shoppingDao.getProduct(id);
		if(product == null){
			throw new ProductNotFoundException("Product Not Found ID: " + id);
		}
		return product;
		
	}
	
	@DeleteMapping(path = "/ShoppingList/{id}")
	public  ResponseEntity<Object> deleteProduct(@PathVariable Integer id){
		ProductBean product = shoppingDao.deleteProduct(id);
		if(product == null){
			throw new ProductNotFoundException("Not deleted!! Product Not Found ID: " + id);
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
}
