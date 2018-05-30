package com.kni.managementSystem.admin;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Marcin Mrukowicz on 2018-05-30.
 */
public interface AdminRepository extends PagingAndSortingRepository<Admin, Long> {

    Admin getAdminById(Long id);
}
