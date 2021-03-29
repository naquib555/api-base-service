package com.qubit.app.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "MST_USER")
public class MstUserEntity {
    private Long nuUserId;
    private String vcUsername;
    private String vcPassword;
    private String vcEmail;
    private String vcPhoneNo;
    private String chActive;
    private LocalDateTime dtCreatedDate;
    private LocalDateTime dtModDate;
    private String vcCreatedBy;
    private String vcModifiedBy;
    private Set<MstRoleEntity> roles = new HashSet<>();

    public MstUserEntity() {
    }

    public MstUserEntity(String vcUsername, String vcPassword, String vcEmail, String vcPhoneNo, String vcCreatedBy, Set<MstRoleEntity> roles) {
        this.vcUsername = vcUsername;
        this.vcPassword = vcPassword;
        this.vcEmail = vcEmail;
        this.vcPhoneNo = vcPhoneNo;
        this.dtCreatedDate = LocalDateTime.now();
        this.dtModDate = LocalDateTime.now();
        this.vcCreatedBy = vcCreatedBy;
        this.roles = roles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NU_USER_ID", nullable = false)
    public Long getNuUserId() {
        return nuUserId;
    }

    public void setNuUserId(Long nuUserId) {
        this.nuUserId = nuUserId;
    }

    @Basic
    @Column(name = "VC_USER_NAME", nullable = false, length = 50)
    public String getVcUsername() {
        return vcUsername;
    }

    public void setVcUsername(String vcUsername) {
        this.vcUsername = vcUsername;
    }

    @Basic
    @Column(name = "VC_PASSWORD", nullable = false, length = 100)
    public String getVcPassword() {
        return vcPassword;
    }

    public void setVcPassword(String vcPassword) {
        this.vcPassword = vcPassword;
    }

    @Basic
    @Column(name = "VC_EMAIL", nullable = true, length = 100)
    public String getVcEmail() {
        return vcEmail;
    }

    public void setVcEmail(String vcEmail) {
        this.vcEmail = vcEmail;
    }

    @Basic
    @Column(name = "VC_PHONE_NO", nullable = true, length = 50)
    public String getVcPhoneNo() {
        return vcPhoneNo;
    }

    public void setVcPhoneNo(String vcPhoneNo) {
        this.vcPhoneNo = vcPhoneNo;
    }

    @Basic
    @Column(name = "DT_CREATED_DATE", nullable = false)
    public LocalDateTime getDtCreatedDate() {
        return dtCreatedDate;
    }

    public void setDtCreatedDate(LocalDateTime dtCreatedDate) {
        this.dtCreatedDate = dtCreatedDate;
    }

    @Basic
    @Column(name = "DT_MOD_DATE", nullable = false)
    public LocalDateTime getDtModDate() {
        return dtModDate;
    }

    public void setDtModDate(LocalDateTime dtModDate) {
        this.dtModDate = dtModDate;
    }

    @Basic
    @Column(name = "VC_CREATED_BY", nullable = true, length = 50)
    public String getVcCreatedBy() {
        return vcCreatedBy;
    }

    public void setVcCreatedBy(String vcCreatedBy) {
        this.vcCreatedBy = vcCreatedBy;
    }

    @Basic
    @Column(name = "VC_MODIFIED_BY", nullable = true, length = 50)
    public String getVcModifiedBy() {
        return vcModifiedBy;
    }

    public void setVcModifiedBy(String vcModifiedBy) {
        this.vcModifiedBy = vcModifiedBy;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "DT_USER_ROLE",
            joinColumns = @JoinColumn(name = "NU_USER_CODE"),
            inverseJoinColumns = @JoinColumn(name = "NU_ROLE_CODE"))
    public Set<MstRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<MstRoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MstUserEntity that = (MstUserEntity) o;
        return Objects.equals(nuUserId, that.nuUserId) &&
                Objects.equals(vcUsername, that.vcUsername) &&
                Objects.equals(vcPassword, that.vcPassword) &&
                Objects.equals(vcEmail, that.vcEmail) &&
                Objects.equals(vcPhoneNo, that.vcPhoneNo) &&
                Objects.equals(chActive, that.chActive) &&
                Objects.equals(dtCreatedDate, that.dtCreatedDate) &&
                Objects.equals(dtModDate, that.dtModDate) &&
                Objects.equals(vcCreatedBy, that.vcCreatedBy) &&
                Objects.equals(vcModifiedBy, that.vcModifiedBy) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nuUserId, vcUsername, vcPassword, vcEmail, vcPhoneNo, chActive, dtCreatedDate, dtModDate, vcCreatedBy, vcModifiedBy, roles);
    }
}
