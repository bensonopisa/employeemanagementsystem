package com.stackdevs.EMS.util;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BASE_ENTITY_SEQ")
    @SequenceGenerator(name="BASE_ENTITY_SEQ",allocationSize = 1)
    private Long id;

    @Column(name = "CREATED_AT",insertable = false,updatable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy",iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdAt;

    @Column(name = "UPDATED_AT")
    @DateTimeFormat(pattern = "dd-MM-yyyy",iso = DateTimeFormat.ISO.DATE)
    private LocalDate updatedAt;


    @Column(name="INTRASH",insertable=false)
    private String intrash;
}
