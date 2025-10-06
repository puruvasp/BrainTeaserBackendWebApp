package com.BrainTeaser.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userProfileId;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable =false)
    private String firstName;

    @Column(nullable =false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

}
