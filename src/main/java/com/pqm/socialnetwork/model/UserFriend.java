package com.pqm.socialnetwork.model;

import com.pqm.socialnetwork.model.audit.DateAudit;
import jakarta.persistence.*;

@Entity
@Table(name = "user_friend")
public class UserFriend extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long userId;

    private Long friendId;

    private String type;

    private String status;

    private String note;


}
