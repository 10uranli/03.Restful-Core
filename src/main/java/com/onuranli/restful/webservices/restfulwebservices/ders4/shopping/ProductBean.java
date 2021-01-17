package com.onuranli.restful.webservices.restfulwebservices.ders4.shopping;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Butun detaylar")
public class ProductBean {

	@ApiModelProperty(notes = "burada validasyon hakkında bilgi verebilirsin")
	private Integer id;
	private String productName;
	private String productType;
	private Integer price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
