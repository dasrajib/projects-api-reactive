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
<<<<<<< Updated upstream:src/main/java/com/adu/api/model/Project.java
@Table("projects")
public class Project  {
=======
@Table("address")
public class Address  {
>>>>>>> Stashed changes:src/main/java/com/adu/api/model/Address.java

    @Id
    private Long address_id;
<<<<<<< Updated upstream:src/main/java/com/adu/api/model/Project.java
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
=======
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private String county;
    private String country;
    private String zip;
>>>>>>> Stashed changes:src/main/java/com/adu/api/model/Address.java
    private LocalDateTime updated_at;
    private LocalDateTime created_at;


}
