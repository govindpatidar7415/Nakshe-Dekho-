package com.wipro.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.model.Project;

public interface ProjectService {

	// Save a new project
	public Project saveProject(Project project);

	// Retrieve all projects
	public List<Project> getAllProjects();

	public Page<Project> searchProjectPagination(Integer pageNo, Integer pageSize, String ch);

	public Page<Project> getAllProjectsPagination(Integer pageNo, Integer pageSize);

	public Boolean deleteProject(int id);

	public Project getProjectById(int id);

	public Project updateProject(Project project, MultipartFile image);

	List<Project> getAllActiveProjects(String category);

	/*
	 * // Delete a project by its ID Boolean deleteProject(Integer id);
	 * 
	 * // Retrieve a project by its ID Project getProjectById(Integer id);
	 * 
	 * // Update an existing project Project updateProject(Project project,
	 * MultipartFile file);
	 * 
	 * // Retrieve all active projects by category List<Project>
	 * getAllActiveProjects(String category);
	 * 
	 * // Search projects by a term (title or category) List<Project>
	 * searchProject(String ch);
	 * 
	 * // Paginated search for projects with an optional search term Page<Project>
	 * searchProjectPagination(Integer pageNo, Integer pageSize, String ch);
	 * 
	 * // Paginated search for active projects by category Page<Project>
	 * getAllActiveProjectPagination(Integer pageNo, Integer pageSize, String
	 * category);
	 * 
	 * // Search projects by name with pagination List<Project>
	 * searchProjectsByName(String searchQuery);
	 * 
	 * // Paginated retrieval of all projects Page<Project>
	 * getAllProjectsPagination(Integer pageNo, Integer pageSize);
	 * 
	 * // Paginated search for active projects with filters (category, search term)
	 * Page<Project> searchActiveProjectPagination(Integer pageNo, Integer pageSize,
	 * String category, String ch);
	 * 
	 * // Retrieve paginated list of all projects without search filters
	 * Page<Project> getAllProjectPagination(Integer pageNo, Integer pageSize);
	 * 
	 * // Paginated retrieval of all active projects (optionally filtered by
	 * category)
	 */}
