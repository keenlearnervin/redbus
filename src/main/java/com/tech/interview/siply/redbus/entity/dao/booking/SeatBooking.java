package com.tech.interview.siply.redbus.entity.dao.booking;

import com.tech.interview.siply.redbus.constant.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_booking_seats")
@AllArgsConstructor
@NoArgsConstructor
public class SeatBooking {
    @Id
    @Column(name = "id")
    private int seatBookingId;

    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "seat_number")
    private int seatNo;

    @Column(name = "price")
    private int seatPrice;

    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @Column(name = "created_at")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
