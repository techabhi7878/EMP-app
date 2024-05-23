package com.amp.Emprepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amp.Entity.Address;

public interface AddRepo extends JpaRepository<Address, Integer> {

}
