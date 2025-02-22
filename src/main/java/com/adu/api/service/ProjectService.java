package com.adu.api.service;

import com.adu.api.model.Project;
import com.adu.api.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Flux<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Mono<Project> getProjectById(Long project_id) {
        return projectRepository.findById(project_id);
    }

    public Mono<Project> createProject(Project project) {
        return projectRepository.save(project);
    }

    public Mono<Project> updateProject(Long project_id, Project project) {
        return projectRepository.findById(project_id)
                .flatMap(existingProject -> {
                    existingProject.setUser_id(project.getUser_id());
                    existingProject.setName(project.getName());
                    existingProject.setStatus(project.getStatus());
                    existingProject.setAddress_id(project.getAddress_id());
                    existingProject.setBasemodel_id(project.getBasemodel_id());
                    existingProject.setMaterialexterior_id(project.getMaterialexterior_id());
                    existingProject.setMaterialroof_id(project.getMaterialroof_id());
                    existingProject.setMaterialwindowdoor_id(project.getMaterialwindowdoor_id());
                    existingProject.setLayoutentry_id(project.getLayoutentry_id());
                    existingProject.setMaterialsolar_id(project.getMaterialsolar_id());
                    existingProject.setLayoutkitchen_id(project.getLayoutkitchen_id());
                    existingProject.setUpgrade_id(project.getUpgrade_id());
                    existingProject.setTotal_cost(project.getTotal_cost());
                  //  existingProject.setCreated_at(project.getCreated_at());
                    existingProject.setUpdated_at(LocalDateTime.now());
                
                    return projectRepository.save(existingProject);
                });
    }

    public Mono<Void> deleteProject(Long project_id) {
        return projectRepository.deleteById(project_id);
    }
}
