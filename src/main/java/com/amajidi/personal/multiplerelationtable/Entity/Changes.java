package com.amajidi.personal.multiplerelationtable.Entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.amajidi.personal.multiplerelationtable.Enum.ChangeStatus;
import com.amajidi.personal.multiplerelationtable.Enum.EntityName;

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
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    private EntityName entity;

    private String entityId;
    private Instant createdDate;
    private String before;
    private String after;

    @Enumerated(EnumType.STRING)
    private ChangeStatus status;
}
