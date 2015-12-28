package jwd.wafepa.repository;

import java.util.List;

import jwd.wafepa.model.Activity;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository 
extends JpaRepository<Activity, Long> {

//	@Query("select a from Activity a where a.name = :name")
//	List<Activity> findByName(@Param("name") String name);
	
	List<Activity> findByNameLike(String name);
}
