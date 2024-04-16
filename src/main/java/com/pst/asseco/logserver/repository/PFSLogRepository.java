package com.pst.asseco.logserver.repository;
 
import com.pst.asseco.logserver.model.PFSLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;
 
@Repository
public interface PFSLogRepository extends PagingAndSortingRepository<PFSLog, Long> {
    Optional<PFSLog> findById(Long id);

    @Query("SELECT l FROM PFSLog l WHERE " +
           "(:user is null or l.user = :user) AND " +
           "(:date is null or l.date = :date) AND " +
           "(:time is null or l.time = :time) AND " +
           "(:station is null or l.station = :station) AND " +
           "(:application is null or l.application = :application)")
    Page<PFSLog> findByFilters(@Param("user") String user,
                               @Param("date") Date date,
                               @Param("time") String time,
                               @Param("station") String station,
                               @Param("application") String application,
                               Pageable pageable);

}