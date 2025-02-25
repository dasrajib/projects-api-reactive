package com.adu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("projects")
public class Project  {

    @Id
    private Long project_id;
    private Long user_id;
    private Long address_id;
    private Long base_model_id;
    private Long material_exterior_id;
    private Long material_roof_id;
    private Long material_window_door_id;
    private Long layout_entry_id;
    private Long material_solar_id;
    private Long layout_kitchen_id;
    private Long upgrade_id;
    private String name;
    private String status;
    private float total_cost;
    private LocalDateTime updated_at;
    private LocalDateTime created_at;


}
