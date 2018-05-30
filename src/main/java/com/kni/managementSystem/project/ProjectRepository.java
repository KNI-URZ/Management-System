package com.kni.managementSystem.project;

import com.kni.managementSystem.contributor.Contributor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * Created by Marcin Mrukowicz on 2018-01-31.
 */
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    Project findOneByName(String name);
    List<Project> findAllByContributors(Set<Contributor> contributor);
    List<Project> findAllByIsArchived(Boolean archive);

    @Query("Select p from Project p where (:contributor in elements(p.contributors))")
    List<Project> findAllByContributor(@Param("contributor") Contributor contributor);

}
