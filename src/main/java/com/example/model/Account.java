package com.example.model;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="t_account")
@S  etter
@RequiredArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="Sex")
    public String sex;

    public String oldPs;

    public String newPs;


}
