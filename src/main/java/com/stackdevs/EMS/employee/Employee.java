package com.stackdevs.EMS.employee;

import com.stackdevs.EMS.emsuser.EmsUser;
import com.stackdevs.EMS.util.BaseEntity;
import com.stackdevs.EMS.util.enums.EMSGENDER;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee extends BaseEntity implements Serializable {

    protected Employee() {
    }
    private static final long serialVersionUID = 100L;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastName;

    @Column(name="EMAIL",unique = true)
    @Basic(optional = false)
    @Email
    private String email;

    @Column(name="GENDER")
    @Enumerated(EnumType.STRING)
    private EMSGENDER gender;

    @Column(name="IMAGE_URL")
    private String imageUrl;

    @Column(name = "DATE_OF_BIRTH")
    @DateTimeFormat(pattern = "dd-MM-yyyy",iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @Column(name = "CREATED_BY")
    private Long createdBy;

    @ManyToOne(targetEntity = EmsUser.class)
    @JoinColumn(name="CREATED_BY", updatable = false,insertable = false)
    private EmsUser user;
}
