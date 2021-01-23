package com.onuranli.restful.webservices.restfulwebservices.ders8;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuredBean,Integer>{ /*Bean ve PK type  */

}
