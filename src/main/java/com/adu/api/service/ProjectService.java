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
                    existingProject.setBase_model_id(project.getBase_model_id());
                    existingProject.setMaterial_exterior_id(project.getMaterial_exterior_id());
                    existingProject.setMaterial_roof_id(project.getMaterial_roof_id());
                    existingProject.setMaterial_window_door_id(project.getMaterial_window_door_id());
                    existingProject.setLayout_entry_id(project.getLayout_entry_id());
                    existingProject.setMaterial_solar_id(project.getMaterial_solar_id());
                    existingProject.setLayout_kitchen_id(project.getLayout_kitchen_id());
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
