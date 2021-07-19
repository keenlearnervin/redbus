package com.tech.interview.siply.redbus.entity.dao.booking;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tbl_bookings")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;
    @Id
    @Column(name = "id")
    private UUID bookingId;
    @Column(name = "journey_id")
    private UUID journeyId;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "booking_seat_id")
    private Integer seatBookingId;
    @Column(name = "seats_booked")
    private Integer seatsBooked;
    @Column(name = "total_price")
    private Integer totalPrice;
    @Column(name = "notification_id")
    private UUID notificationId;
    @Column(name = "created_at", nullable = true, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
}
