package com.stackdevs.EMS.emsuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmsUserRepository extends JpaRepository<EmsUser,Long> {
}
