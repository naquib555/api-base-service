package com.qubit.app.model.entity;

import com.qubit.app.model.RoleName;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MST_ROLE")
public class MstRoleEntity {
    private Long nuRoleCode;
    private RoleName vcRoleName;

    @Id
    @Column(name = "NU_ROLE_CODE", nullable = false, precision = 0)
    public Long getNuRoleCode() {
        return nuRoleCode;
    }

    public void setNuRoleCode(Long roleId) {
        this.nuRoleCode = roleId;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "VC_ROLE_NAME", nullable = false, length = 50)
    public RoleName getVcRoleName() {
        return vcRoleName;
    }

    public void setVcRoleName(RoleName roleName) {
        this.vcRoleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MstRoleEntity that = (MstRoleEntity) o;
        return nuRoleCode == that.nuRoleCode &&
                Objects.equals(vcRoleName, that.vcRoleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nuRoleCode, vcRoleName);
    }
}
