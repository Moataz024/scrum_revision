package com.moataz.scrum_revision.repos;

import com.moataz.scrum_revision.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer> {

}