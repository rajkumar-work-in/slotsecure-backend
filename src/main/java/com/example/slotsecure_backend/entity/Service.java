package com.example.slotsecure_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "services")
@Data
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @ManyToOne
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendorId")
    private Vendor vendor;

    @Column(nullable = false)
    private String serviceName;

    @Column(nullable = false)
    private Double serviceCost;

    @Column(nullable = false)
    private Integer duration;
}