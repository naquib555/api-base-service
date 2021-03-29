package com.qubit.app.repository;

import com.qubit.app.model.entity.MstUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MstUserRepository extends JpaRepository<MstUserEntity, Long> {

    Optional<MstUserEntity> findByNuUserId(Long userId);
    Optional<MstUserEntity> findByVcUsername(String username);
    Optional<MstUserEntity> findByVcEmail(String email);

    Boolean existsByVcUsername(String username);
    Boolean existsByVcEmail(String username);
}
