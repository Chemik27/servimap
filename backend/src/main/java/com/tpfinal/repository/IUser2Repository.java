package com.tpfinal.repository;

import com.tpfinal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by tino on 27/07/2016.
 */
public interface IUser2Repository extends JpaRepository<User, Long> {


}
