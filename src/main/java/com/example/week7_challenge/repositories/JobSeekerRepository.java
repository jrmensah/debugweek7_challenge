package com.example.week7_challenge.repositories;

import com.example.week7_challenge.Controller.JobSeeker;
import org.springframework.data.repository.CrudRepository;

public interface JobSeekerRepository extends CrudRepository<JobSeeker,Long>
{
////	@Query("SELECT v FROM JobSeeker v WHERE v.firstName='NEW'")
////	List<JobSeeker> findAllByFirstName(String firstName);
////	@Query("SELECT v FROM JobSeeker v WHERE v.lastName='NEW'")
////	List<JobSeeker> findAllByLastName(String lastName);
////	@Query("SELECT v FROM JobSeeker v WHERE v.skilledType='NEW'")
////	List<JobSeeker> findAllBySkilledType(String skilledType);
////
////	//List<JobSeeker> findAllByProfessional_Level(String professional_Level);
////	@Query("SELECT v FROM JobSeeker v WHERE v.companyName='NEW'")
////	List<JobSeeker> findAllByCompanyName(String companyName);
//
//	//List<JobSeeker> findAllByUniversityName(String universityName);
////}
//
//    JobSeeker findByFirstName(String firstName);
//    JobSeeker findByLastName(String lastName);
//    JobSeeker findBySkilledType(String skilledType);
//    JobSeeker findByProfessional_Level(String professional_Level);
//    JobSeeker findByCompanyName(String companyName);
//    JobSeeker findByUniversityName(String UniversityName);
}