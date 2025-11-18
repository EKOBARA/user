package com.example.user.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userProfileId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String LastName;

    @Column(length = 20)
    private String gender;

    @Column(length = 500)
    private String address;

    @Column(length = 100)
    private String occupation;

    @Column(name = "martial_status", length = 20)
    private String martialStatus;

    @Column(length = 50)
    private String nationality;
}
