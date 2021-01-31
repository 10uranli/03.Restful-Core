package com.onuranli.restful.webservices.restfulwebservices.ders8;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;/*operasyonları dogrudan kullanabilmek icin*/
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//rest service controller
@RestController
public class InsuranceJPAResource {

	@Autowired
	private InsuranceRepository insuranceRepository;

	
	@GetMapping("/Insures")
	public List<InsuredBean> retrieveAllInsured(){
		return insuranceRepository.findAll();
	}
	//GET /users/id
	@GetMapping("/Insures/{id}")
	public Optional<InsuredBean> retrieveInsured(@PathVariable Integer id){
		Optional<InsuredBean> findById = insuranceRepository.findById(id);
		
		if(!findById.isPresent())/*null kontrolü yerine koydum*/
			throw new InsureNotFoundException("id : " + id + " nolu sigortalı bulunamadı");
		return findById;
	}
	
	@DeleteMapping("/Insures/{id}")
	public void deleteInsure(@PathVariable Integer id){
		insuranceRepository.deleteById(id);
	}
	

	@PostMapping("/Insures")
	public ResponseEntity<Object> createInsured(@Valid @RequestBody InsuredBean insuredBean){
		InsuredBean savedInsure = insuranceRepository.save(insuredBean); //normal save
		//uri ve response status dönmek için
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedInsure.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	//GET /users/id
		@GetMapping("/Insures/{id}/insurances")
		public List<InsuranceBean> retrieveAllInsurances(@PathVariable Integer id){
			Optional<InsuredBean> user = insuranceRepository.findById(id);
			
			if(!user.isPresent())/*null kontrolü yerine koydum*/
				throw new InsureNotFoundException("id : " + id + " nolu sigortalı bulunamadı");

			return user.get().getInsurance();
		}
		
	
	
}
