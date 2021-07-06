package com.tech.interview.siply.redbus.entity.dao.notifications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_sms_notifications")
public class SmsNotification extends Notification {
    @Column(name = "phone_no", nullable = false)
    private String phoneNumber;
}
