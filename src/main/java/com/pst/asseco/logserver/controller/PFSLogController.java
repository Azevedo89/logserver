package com.pst.asseco.logserver.controller;
 
import com.pst.asseco.logserver.model.PFSLog;
import com.pst.asseco.logserver.repository.PFSLogRepository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/logs")
public class PFSLogController {
 
    @Autowired
    private PFSLogRepository pfsLogRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("")
    public ResponseEntity<Page<PFSLog>> getLogsFiltered(
        @RequestParam(required = false) String user,
        @RequestParam(required = false) String station,
        @RequestParam(required = false) String application,
        Pageable pageable) {

            System.out.println("Filtros aplicados: user=" + user + ", station=" + station + ", application=" + application);

            Page<PFSLog> logsPage = pfsLogRepository.findByFilters(user, station, application, pageable);

            return ResponseEntity.ok(logsPage);
        }
 
    @GetMapping("details/{id}")
    public ResponseEntity<Map<String, String>> getLogDetails(@PathVariable Long id) {
        Optional<PFSLog> logOptional = pfsLogRepository.findById(id);
        if (logOptional.isPresent()) {
            PFSLog log = logOptional.get();
            Map<String, String> details = new HashMap<>();
            
            details.put("apidata", log.getApidata());
            details.put("correlationId", log.getCorrelationId());
            details.put("bankaversion", log.getBankaversion());
            details.put("errormessage", log.getErrormessage());
            details.put("encryption", log.getEncryption());
            details.put("licencekey", log.getLicencekey());
            details.put("errorcode", log.getErrorcode());
            details.put("expiration", log.getExpiration());
            details.put("remoteaddr", log.getRemoteaddr());
            details.put("https", log.getHttps());
            
            return ResponseEntity.ok(details);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getLogsCount() {
        String sql = "SELECT COUNT(id) FROM t_pfslog"; 
        Long count = jdbcTemplate.queryForObject(sql, Long.class); 
        return ResponseEntity.ok(count); 
    }

    @GetMapping("/count-users")
    public ResponseEntity<Long> getLogsCountUser() {
        String sql = "SELECT COUNT(user) FROM t_pfslog"; 
        Long count = jdbcTemplate.queryForObject(sql, Long.class); 
        return ResponseEntity.ok(count); 
    }

    @GetMapping("/api-types")
    public ResponseEntity<List<String>> getDistinctApiTypes() {
        String sql = "SELECT DISTINCT api FROM t_pfslog"; 
        List<String> apiTypes = jdbcTemplate.queryForList(sql, String.class); 
        return ResponseEntity.ok(apiTypes); 
    }

    @GetMapping("/transactions-types")
    public ResponseEntity<List<String>> getDistinctTransactionsTypes() {
        String sql = "SELECT DISTINCT transaction FROM t_pfslog"; 
        List<String> apiTypes = jdbcTemplate.queryForList(sql, String.class); 
        return ResponseEntity.ok(apiTypes); 
    }
     
}
