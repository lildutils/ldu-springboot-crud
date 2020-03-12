package com.lildutils.springboot.crud.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LDuJpaCrudRepository<TMODEL, TID> extends JpaRepository<TMODEL, TID>
{

}
