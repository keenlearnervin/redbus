package com.tech.interview.siply.redbus.entity.dao.travel;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_drop_off_locations")
public class DropOffLocation {
    @Column(name = "created_at", nullable = true, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dropLocId;
    @Column(name = "locName")
    private String locationName;
    @ManyToOne
    @JoinColumn(name = "journey_id", nullable = false)
    private Journey journey;
}
