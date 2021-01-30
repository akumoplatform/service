package com.akumo.site.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = "contact")
public class Contact implements Serializable {

    private static final long serialVersionUID = 9158047526699427693L;

    @Id
    private String id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String subject;

    @Column
    private String message;

}
