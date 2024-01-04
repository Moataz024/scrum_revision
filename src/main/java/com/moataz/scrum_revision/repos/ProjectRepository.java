package com.moataz.scrum_revision.repos;

import com.moataz.scrum_revision.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {


    @Query("SELECT p FROM Project p WHERE p.user.fName = :user_FName AND p.user.lName = :user_LName")
    List<Project> findAllByUser(@Param("user_FName") String user_FName,@Param("user_LName") String user_LName);

}