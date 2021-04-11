package com.hideoutlabs.inahurry.repository;

import com.hideoutlabs.inahurry.model.Role;
import com.hideoutlabs.inahurry.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository  extends JpaRepository<Users, Long> {
  //  public <S extends Role> List<S> saveAll(Iterable<S> entities);
}
