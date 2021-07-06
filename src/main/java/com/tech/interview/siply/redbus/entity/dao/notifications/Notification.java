package com.tech.interview.siply.redbus.entity.dao.notifications;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tbl_notifications")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Notification {
    @Column(name = "id")
    @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private final UUID id = UUID.randomUUID();

    @Column(name = "content")
    private String content;

    /*
    @Column(name = "sms_notification_id")
    private long smsNotificationId;

    @Column(name = "email_notification_id")
    private long emailNotificationId;
*/
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;
}
