package com.onuranli.restful.webservices.restfulwebservices.ders4;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;/*operasyonları dogrudan kullanabilmek icin*/
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//rest service controller
@RestController
public class InsuranceResource {

	@Autowired
	private InsuranceDao insuranceDao;
	
	//GET /users
	
	@GetMapping("/Insures")
	public List<InsuredBean> retrieveAllInsured(){
		return insuranceDao.findAll();
	}
	//GET /users/id
	@GetMapping("/Insures/{id}")
	public InsuredBean retrieveInsured(@PathVariable Integer id){
		InsuredBean findById = insuranceDao.findById(id);
		
		if(findById == null)
			throw new InsureNotFoundException("id : " + id + " nolu sigortalı bulunamadı");
		return findById;
	}
	@RequestMapping(method = RequestMethod.GET, path = "/InsuresWStream/{id}")
	public Optional<InsuredBean> retrieveInsuredWithStream(@PathVariable Integer id){
		Optional<InsuredBean> bean = insuranceDao.findByStream(id);

		if(!bean.isPresent())
			throw new InsureNotFoundException("id : " + id + " nolu sigortalı bulunamadı");
		return bean;
	}
	//POST Created return : created uri 
//	@PostMapping("/Insures")
//	public void createInsured(@RequestBody InsuredBean insuredBean){
//		insuranceDao.save(insuredBean); //normal save
//		//uri ve response status dönmek için
//	}
//	
	@PostMapping("/Insures")
	public ResponseEntity<Object> createInsured(@Valid @RequestBody InsuredBean insuredBean){
		InsuredBean savedInsure = insuranceDao.save(insuredBean); //normal save
		//uri ve response status dönmek için
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedInsure.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/* @PutMapping("/update") put update eder tum objeyi.Bos yollarsan ornegin null olur diger degerler
	* @PatchMapping gonderilen alani digerlerine dokunmaz*/

	@DeleteMapping("/Insures/{id}")
	public void deleteInsure(@PathVariable Integer id){
		InsuredBean insure = insuranceDao.deleteById(id);
		if(insure == null)
			throw new InsureNotFoundException("id-" + id);
	}
	
	//HATEOAS için eklendi
	@GetMapping("/InsuresHateoas/{id}")//Normal get operasyonu ile yazılabilirdi.
	public EntityModel<InsuredBean> retrieveInsuredWithHateoas(@PathVariable Integer id){
		InsuredBean findById = insuranceDao.findById(id);
		
		if(findById == null)
			throw new InsureNotFoundException("id : " + id + " nolu sigortalı bulunamadı");
		
		
		EntityModel<InsuredBean> resource = new EntityModel<InsuredBean>(findById);
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllInsured());//linkTo ile hangi 
		
		resource.add(linkTo.withRel("all-insures"));//withRel ile all linkine referans verilir
		//HATEOAS
		return resource;
	}
}
