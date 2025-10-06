package com.BrainTeaser.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    @Column(unique = true,nullable = false)
    private String permissionName;

    @Column(nullable = true)
    private String description;
}
