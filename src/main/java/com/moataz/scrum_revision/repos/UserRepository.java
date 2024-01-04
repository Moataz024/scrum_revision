package com.moataz.scrum_revision.repos;

import com.moataz.scrum_revision.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.fName = :fName AND u.lName = :lName")
    User findUserByFNameAndLName(@Param("fName") String fName,@Param("lName") String lName);

}