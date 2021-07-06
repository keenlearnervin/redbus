package com.tech.interview.siply.redbus.entity.dao.travel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tbl_journeys")
@AllArgsConstructor
@NoArgsConstructor
public class Journey {
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "bus_id")
    private UUID busId;
    @Column(name = "driver_id")
    private UUID driverId;
    @Column(name = "route_id")
    private UUID routeId;
    @Column(name = "available_capacity")
    private Integer availableSeats;
    @Column(name = "expected_departure", columnDefinition = "TIME")
    private LocalTime expDepartureTime;
    @Column(name = "expected_arrival", columnDefinition = "TIME")
    private LocalTime expArrivalTime;
    /*
    @Column(name = "actual_departure", columnDefinition = "TIME")
    private Date actDepartureTime;
    @Column(name = "actual_arrival", columnDefinition = "TIME")
    private Date actArrivalTime;
    @Column(name = "cancellations")
    private Integer totalCancellations;
    @Column(name = "status")
    private BookingStatus bookingStatus;*/
    @OneToMany(targetEntity = PickUpLocation.class, mappedBy = "journey")
    private Set<PickUpLocation> pickUpLocationList;
    @OneToMany(targetEntity = DropLocation.class, mappedBy = "journey")
    private Set<DropLocation> dropLocationList;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
}
