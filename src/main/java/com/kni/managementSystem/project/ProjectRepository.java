package com.kni.managementSystem.project;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Marcin Mrukowicz on 2018-01-31.
 */
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
}
