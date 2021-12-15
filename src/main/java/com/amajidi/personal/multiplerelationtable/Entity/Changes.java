package com.amajidi.personal.multiplerelationtable.Entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "changes")
public class Changes {
    @Id
    private String id;
    
    private String entity;
    private String entityId;
    private Instant createdDate;
    private String before;
    private String after;
    private String status;
}
