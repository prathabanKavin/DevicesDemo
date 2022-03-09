package com.kavin.DevicesDemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="status", nullable = false)
    private String status;

    @Column(name="model", nullable = false)
    private String model;

    @Column(name="enrolledTime", nullable = false)
    private String enrolledTime;
}
