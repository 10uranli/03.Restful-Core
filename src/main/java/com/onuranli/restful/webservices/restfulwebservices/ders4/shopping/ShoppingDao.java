package com.onuranli.restful.webservices.restfulwebservices.ders4.shopping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ShoppingDao {

	public static List<ProductBean> shoppingList = new ArrayList<ProductBean>();
	
	public List<ProductBean> getAllShoppingList(){
		return shoppingList;
	}
	
	public ProductBean getProduct(Integer id){
		
		for (ProductBean productBean : shoppingList) {
			if(productBean.getId().equals(id)){
				return productBean;
			}
		}
		return null;
	}
	
	public ProductBean addProduct(ProductBean bean){
			if(bean.getId() == null)
				bean.setId(shoppingList.size()+1);
			shoppingList.add(bean);
			return bean;
	}
	
	public ProductBean deleteProduct(Integer id){
		
		Iterator<ProductBean> iterator = shoppingList.iterator();
		while(iterator.hasNext()){
			ProductBean bean = iterator.next();//?
			if (bean.getId().equals(id)) {
				iterator.remove();
				return bean;
			}
		}
		return null;
		
	}
}
