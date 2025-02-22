package com.adu.api.controller;

import com.adu.api.model.Project;
import com.adu.api.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
@Tag(name = "Projects Management", description = "APIs for managing projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    @Operation(summary = "Get all projects")
    public Flux<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{project_id}")
    @Operation(summary = "Get project by ID")
    public Mono<Project> getProjectById(@PathVariable Long project_id) {
        return projectService.getProjectById(project_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new project")
    public Mono<Project> createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @PutMapping("/{project_id}")
    @Operation(summary = "Update an existing project")
    public Mono<Project> updateProject(@PathVariable Long project_id, @RequestBody Project project) {
        return projectService.updateProject(project_id, project);
    }

    @DeleteMapping("/{project_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a project")
    public Mono<Void> deleteProject(@PathVariable Long project_id) {
        return projectService.deleteProject(project_id);
    }
}
