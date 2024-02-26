package com.pqm.socialnetwork.model;

import com.pqm.socialnetwork.model.audit.UserDateAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_post")
public class UserPost extends UserDateAudit {
    @Id
    private long id;
    @Column(name = "message")
    private String message;

}
