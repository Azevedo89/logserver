package com.pst.asseco.logserver.repository;
 
import com.pst.asseco.logserver.model.PFSLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;
 
import java.util.Date;
import java.util.Optional;
 
@Repository
public interface PFSLogRepository extends PagingAndSortingRepository<PFSLog, Long> {
    Optional<PFSLog> findById(Long id);
    Page<PFSLog> findByUser(String username, Pageable pageable);
    Page<PFSLog> findByDate(Date date, Pageable pageable);
    Page<PFSLog> findByTime(String time, Pageable pageable);
    Page<PFSLog> findByStation(String station, Pageable pageable);
    Page<PFSLog> findByApplication(String application, Pageable pageable);
}