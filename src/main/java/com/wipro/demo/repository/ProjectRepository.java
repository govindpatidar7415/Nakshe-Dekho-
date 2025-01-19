package com.wipro.demo.repository;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	List<Project> findByIsActiveTrue();

	List<Project> findByCategory(String category);

	List<Project> findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2);


	Page<Project> findByIsActiveTrue(Pageable pageable);

	Page<Project> findByCategory(Pageable pageable, String category);

	List<Project> findByTitleContainingIgnoreCase(String searchQuery);

	Page<Project> findByisActiveTrueAndTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2,
			Pageable pageable);

	Page<Project> findByTitleContainingIgnoreCaseOrCategoryContainingIgnoreCase(String ch, String ch2,
			Pageable pageable);
	
	
}

