package com.mhrimch.hospitalapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "PATIENTS")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class Patient {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private int score;
    private boolean is_Ill;


}
