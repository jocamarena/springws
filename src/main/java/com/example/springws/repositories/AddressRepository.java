package com.example.springws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stubs.com.example.springws.ws.user_service.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
