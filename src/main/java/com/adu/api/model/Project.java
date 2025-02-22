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
@Table("Projects")
public class Project  {

    @Id
    private Long project_id;
    private Long user_id;
    private Long address_id;
    private Long basemodel_id;
    private Long materialexterior_id;
    private Long materialroof_id;
    private Long materialwindowdoor_id;
    private Long layoutentry_id;
    private Long materialsolar_id;
    private Long layoutkitchen_id;
    private Long upgrade_id;
    private String name;
    private String status;
    private float total_cost;
    private LocalDateTime updated_at;
    private LocalDateTime created_at;


}
