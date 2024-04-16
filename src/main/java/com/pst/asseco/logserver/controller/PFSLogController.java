package com.pst.asseco.logserver.controller;
 
import com.pst.asseco.logserver.model.PFSLog;
import com.pst.asseco.logserver.repository.PFSLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PFSLogController {
 
    @Autowired
    private PFSLogRepository pfsLogRepository;

    @GetMapping("/logs")
    public ResponseEntity<Page<PFSLog>> getLogsFiltered(
        @RequestParam(required = false) String user,
        @RequestParam(required = false) Date date,
        @RequestParam(required = false) String time,
        @RequestParam(required = false) String station,
        @RequestParam(required = false) String application,
        Pageable pageable) {

        System.out.println("Filtros aplicados: user=" + user + ", date=" + date + ", time=" + time + ", station=" + station + ", application=" + application);

        Page<PFSLog> logsPage = pfsLogRepository.findByFilters(user, date, time, station, application, pageable);

        return ResponseEntity.ok(logsPage);
    }
 
    @GetMapping("/logs/{id}")
    public ResponseEntity<PFSLog> getLogDetails(@PathVariable Long id){
        Optional<PFSLog> log = pfsLogRepository.findById(id);
        if (log.isPresent()){
            return ResponseEntity.ok(log.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }

}
