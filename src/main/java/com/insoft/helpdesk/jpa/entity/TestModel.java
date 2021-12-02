package com.insoft.helpdesk.jpa.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TEST_TABLE")
@Data
public class TestModel {

    @Id
    @Column(name = "idx", length = 64)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(name = "data", length = 255)
    private String data;
}
