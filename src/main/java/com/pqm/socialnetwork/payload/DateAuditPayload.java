package com.pqm.socialnetwork.payload;

import lombok.Data;

import java.time.Instant;

@Data
public abstract class DateAuditPayload {
    private Instant createdAt;

    private Instant updatedAt;
}
