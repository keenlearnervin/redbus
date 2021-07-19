package com.tech.interview.siply.redbus.entity.dao.travel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tbl_routes")
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;
    @Id
    @Column(name = "id")
    private UUID id;
    /*
    @Column(name = "journey_id")
    private UUID journeyId;
    */
    @Column(name = "source")
    private String srcLoc;
    @Column(name = "destination")
    private String destLoc;
    @Column(name = "distance")
    private Float distance;
    @Column(name = "duration_ms")
    private Long durationInMillis;
    @Column(name = "created_at", nullable = true, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "journey_id", nullable = false)
    private Journey journey;
}
