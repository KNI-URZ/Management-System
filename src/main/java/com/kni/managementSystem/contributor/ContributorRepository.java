package com.kni.managementSystem.contributor;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Marcin Mrukowicz on 2018-01-31.
 */
public interface ContributorRepository extends PagingAndSortingRepository<Contributor, Long> {
    Contributor save(Contributor contributor);
}
