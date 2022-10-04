package com.stackdevs.EMS.emsuser;

import com.stackdevs.EMS.util.BaseEntity;
import com.stackdevs.EMS.util.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Setter
public class EmsUser extends BaseEntity implements Serializable {
    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="ACCOUNT_STATUS")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    public EmsUser() {

    }
}
