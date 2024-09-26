package com.hideoutlabs.inahurry.repository;


import com.hideoutlabs.inahurry.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly=true)
public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findByUsername(String username);

    Optional<Users> findById(Long id);


  @Query("SELECT u FROM Users u WHERE u.username = :username")
  public Users getUserByUsername(@Param("username") String username);

    @Query("SELECT u FROM Users u WHERE u.email = :email")
    Optional<Users> findUserByEmail(@Param("email") String email);



}

