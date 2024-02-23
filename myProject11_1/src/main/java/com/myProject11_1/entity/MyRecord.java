package com.myProject11_1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "my_record")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private String data;

    @Column(name="parent_id")
    private Long parentId;
}
