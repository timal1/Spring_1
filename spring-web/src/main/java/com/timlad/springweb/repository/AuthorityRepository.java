package com.timlad.springweb.repository;

import com.timlad.springweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<User, Long> {
}
