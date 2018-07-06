package com.fds.poramin.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fds.poramin.userservice.constant.UserRoleName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role extends BaseModel implements GrantedAuthority {

    @Id
    @Column
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private UserRoleName name;

    @Override
    public String getAuthority() {
        return name.name();
    }

}
