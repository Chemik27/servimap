package com.tpfinal.repository;

import com.tpfinal.domain.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IWorkRepository extends JpaRepository<Work, Long> {

    public List<Work> findByName(String name);

    public Work findByIdUser(Long idUser);
}
