package com.qubit.app.repository;

import com.qubit.app.model.RoleName;
import com.qubit.app.model.entity.MstRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MstRoleRepository extends JpaRepository<MstRoleEntity, Long> {
    Optional<MstRoleEntity> findByVcRoleName(RoleName roleName);
}
