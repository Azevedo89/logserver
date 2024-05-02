package com.pst.asseco.logserver.repository;
 
import com.pst.asseco.logserver.model.PFSLog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
 
@Repository
public interface PFSLogRepository extends PagingAndSortingRepository<PFSLog, Long> {

       Optional<PFSLog> findById(Long id);

       @Query("SELECT l FROM PFSLog l WHERE " +
       "(:user is null or l.user = :user) AND " +
       "(:station is null or l.station = :station) AND " +
       "(:application is null or l.application = :application) AND " +
       "(:date is null or l.date = :date) AND " +
       "(:time is null or l.time = :time) AND " +
       "(:id is null or l.id = :id) AND " +
       "(:api is null or l.api = :api) AND " +
       "(:transaction is null or l.transaction = :transaction) AND " +
       "(:errorcode is null or l.errorcode = :errorcode) AND " +
       "(:sessionid is null or l.sessionid = :sessionid)")
       Page<PFSLog> findByFilters(@Param("user") String user,
                                   @Param("station") String station,
                                   @Param("application") String application,
                                   @Param("date") String date,
                                   @Param("time") String time,
                                   @Param("id") String id,
                                   @Param("api") String api,
                                   @Param("transaction") String transaction,
                                   @Param("errorcode") String errorcode,
                                   @Param("sessionid") String sessionid,
                                   Pageable pageable);

}