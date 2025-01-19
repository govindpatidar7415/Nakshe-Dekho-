package com.wipro.demo.services.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.model.Project;
import com.wipro.demo.repository.ProjectRepository;
import com.wipro.demo.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Page<Project> searchProjectPagination(Integer pageNo, Integer pageSize, String ch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Project> getAllProjectsPagination(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteProject(int id) {
		Project project = projectRepository.findById(id).orElse(null);

		if (!ObjectUtils.isEmpty(project)) {
			projectRepository.delete(project);
			return true;
		}
		return false;
	}

	@Override
	public Project getProjectById(int id) {
		Project project = projectRepository.findById(id).orElse(null);
		return project;
	}

	@Override
	public Project updateProject(Project project, MultipartFile image) {

		Project dbProject = getProjectById(project.getId());

		String imageName = image.isEmpty() ? dbProject.getImage() : image.getOriginalFilename();

		dbProject.setTitle(project.getTitle());
		dbProject.setDescription(project.getDescription());
		dbProject.setCategory(project.getCategory());
		dbProject.setPrice(project.getPrice());
		dbProject.setStock(project.getStock());
		dbProject.setImage(imageName);
		dbProject.setIsActive(project.getIsActive());
		dbProject.setDiscount(project.getDiscount());

		// 5=100*(5/100); 100-5=95
		Double disocunt = project.getPrice() * (project.getDiscount() / 100.0);
		Double discountPrice = project.getPrice() - disocunt;
		dbProject.setDiscountPrice(discountPrice);

		Project updateProject = projectRepository.save(dbProject);

		if (!ObjectUtils.isEmpty(updateProject)) {

			if (!image.isEmpty()) {

				try {
					File saveFile = new ClassPathResource("static/img").getFile();

					Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "project_img" + File.separator
							+ image.getOriginalFilename());
					Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return project;
		}
		return null;
	}
	@Override
	public List<Project> getAllActiveProjects(String category) {
		List<Project> projects = null;
		if (ObjectUtils.isEmpty(category)) {
			projects = projectRepository.findByIsActiveTrue();
		} else {
			projects = projectRepository.findByCategory(category);
		}

		return projects;
	}
}
