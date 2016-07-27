package com.tpfinal.repository;

import com.tpfinal.domain.QualifyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IQualifyUserRepository extends JpaRepository<QualifyUser, Long> {
    public QualifyUser save(QualifyUser qualifyUser);

    public List<QualifyUser> findByIdProvider(Long idUser);
}
