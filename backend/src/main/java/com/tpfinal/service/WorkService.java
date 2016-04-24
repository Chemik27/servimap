package com.tpfinal.service;

import com.tpfinal.domain.Work;
import com.tpfinal.repository.IWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {

    @Autowired
    IWorkRepository workRepository;

    public Page<Work> findAll(PageRequest pageRequest) {
        return workRepository.findAll(pageRequest);
    }
}
