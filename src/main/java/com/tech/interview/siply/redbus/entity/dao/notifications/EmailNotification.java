package com.tech.interview.siply.redbus.entity.dao.notifications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_email_notifications")
public class EmailNotification extends Notification {
    @Column(name = "email_id", nullable = false)
    private String emailId;
}
