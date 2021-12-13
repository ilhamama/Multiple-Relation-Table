package com.amajidi.personal.multiplerelationtable.Entity;

import javax.persistence.Entity;

import com.amajidi.personal.multiplerelationtable.Entity.Base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "shop")
public class Shop extends BaseEntity {
    private String name;
    private String category;
}
