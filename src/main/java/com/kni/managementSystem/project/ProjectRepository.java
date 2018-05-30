package com.kni.managementSystem.project;

import com.kni.managementSystem.contributor.Contributor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by Marcin Mrukowicz on 2018-01-31.
 */
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    Project findOneByName(String name);
    List<Project> findAllByContributors(Set<Contributor> contributor);

    @Query("Select p from Project p, Contributor c where c in p.contributors")
    List<Project> findAllByContributor(Contributor contributor);

}
