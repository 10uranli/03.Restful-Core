package com.onuranli.restful.webservices.restfulwebservices.ders4;
/*
 * DB jpa ileride olacağı için şimdilik kendimiz static bir veri deposu yapalım
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component//spring yönetimine bırakabilmek amacıyla, autowired yapılacak
public class InsuranceDao {

	private static List<InsuredBean> insuredList = new ArrayList<>();
	//InsuranceDao objesi oluştuğunda liste dolacaktır.
	static{
		insuredList.add(new InsuredBean(1, "Onur", "Anli", new Date()));
		insuredList.add(new InsuredBean(2, "Ali", "Veli", new Date()));
	}
	
	public List<InsuredBean> findAll(){
		return insuredList;
	}
	
	public InsuredBean findById(Integer id){
		for (InsuredBean insuredBean : insuredList) {
			if(insuredBean.getId().equals(id)){
				return insuredBean;
			}
		}
		return null;
	}
	
	public InsuredBean save(InsuredBean insuredBean){
		if(insuredBean.getId().equals(null))
			insuredBean.setId(insuredList.size() + 1);
		insuredList.add(insuredBean);
		return insuredBean;
	}
	
	public InsuredBean deleteById(Integer id){

		Iterator<InsuredBean> iterator = insuredList.iterator();
		while (iterator.hasNext()) {
			InsuredBean insuredBean = iterator.next();
			if (insuredBean.getId().equals(id)) {
				iterator.remove();
				return insuredBean;
			}
		}
		return null;
	}
}
