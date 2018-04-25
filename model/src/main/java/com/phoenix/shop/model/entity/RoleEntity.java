package com.phoenix.shop.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @Column(name = "role_id")
    private String roleId;

    @Column(name = "role_name")
    private String roleName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(final String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }
}
