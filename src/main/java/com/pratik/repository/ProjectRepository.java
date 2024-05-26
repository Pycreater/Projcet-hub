package com.pratik.repository;

import com.pratik.model.Project;
import com.pratik.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

//    List<Project> findByOwner(User user);

    List<Project> findByNameContainingAndTeamContains(String partialName, User user);

//    @Query("SELECT p FROM Project p join p.team t where t=:user")
//    List<Project> findProjectByTeamProjects(@Param("user") User user);

    List<Project> findByTeamContainingOrOwner(User user, User owner);
}
