package com.pst.asseco.logserver.controller;
 
import com.pst.asseco.logserver.model.PFSLog;
import com.pst.asseco.logserver.repository.PFSLogRepository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
        @RequestParam(required = false) String date,
        @RequestParam(required = false) String time,
        @RequestParam(required = false) String id,
        @RequestParam(required = false) String api,
        @RequestParam(required = false) String transaction,
        @RequestParam(required = false) String errorcode,
        @RequestParam(required = false) String sessionid,
        @RequestParam(required = false) String errormessage,
        @RequestParam(required = false) String apidata, 
        Pageable pageable) {

            System.out.println("Filtros aplicados: user=" + user + ", station=" + station + ", application=" + application 
                            + ", date=" + date + ", time=" + time + ", id=" + id 
                            + ", api=" + api + ", transaction=" + transaction + ", errorcode=" + errorcode 
                            + ", sessionid=" + sessionid + ", errormessage=" + errormessage
                            + ", apidata=" + apidata); 

            Page<PFSLog> logsPage = pfsLogRepository.findByFilters(user, station, application, date, time, id, api, transaction, errorcode, sessionid, errormessage, apidata, pageable); // Passando apidata para o método do repositório
            System.out.println("query ok");
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

    @GetMapping("/oldest-date")
    public ResponseEntity<LocalDate> getOldestDate() {
        String sql = "SELECT MIN(date) FROM t_pfslog"; 
        LocalDate oldestDate = jdbcTemplate.queryForObject(sql, LocalDate.class); 
        return ResponseEntity.ok(oldestDate); 
    }

    @GetMapping("/latest-date")
    public ResponseEntity<LocalDate> getLatestDate() {
        String sql = "SELECT MAX(date) FROM t_pfslog"; 
        LocalDate oldestDate = jdbcTemplate.queryForObject(sql, LocalDate.class); 
        return ResponseEntity.ok(oldestDate); 
    }

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getDashboardData() {
        Map<String, Object> dashboardData = new HashMap<>();
        dashboardData.put("logsCount", getLogsCount());
        dashboardData.put("usersCount", getLogsCountUser());
        dashboardData.put("apiTypes", getDistinctApiTypes());
        dashboardData.put("transactionTypes", getDistinctTransactionsTypes());
        dashboardData.put("oldestDate", getOldestDate());
        dashboardData.put("latestDate", getLatestDate());
        return ResponseEntity.ok(dashboardData);
    }

    @GetMapping("/stations")
    public List<String> getDistinctStations() {
        String sql = "SELECT DISTINCT station FROM t_pfslog";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @GetMapping("/applications")
    public List<String> getDistinctApplications() {
        String sql = "SELECT DISTINCT application FROM t_pfslog";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @GetMapping("/apis")
    public List<String> getDistinctApis() {
        String sql = "SELECT DISTINCT api FROM t_pfslog";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @GetMapping("/transactions")
    public List<String> getDistinctTransactions() {
        String sql = "SELECT DISTINCT transaction FROM t_pfslog";
        return jdbcTemplate.queryForList(sql, String.class);
    }
     
}
