package com.pst.asseco.logserver.controller;
 
import com.pst.asseco.logserver.model.PFSLog;
import com.pst.asseco.logserver.repository.PFSLogRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/logs")
public class PFSLogController {
 
    @Autowired
    private PFSLogRepository pfsLogRepository;

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
     
}
