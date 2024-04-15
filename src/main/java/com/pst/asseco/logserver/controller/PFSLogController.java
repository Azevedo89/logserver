package com.pst.asseco.logserver.controller;
 
import com.pst.asseco.logserver.model.PFSLog;
/* import com.pst.asseco.logserver.model.LoginRequest;
 */import com.pst.asseco.logserver.repository.PFSLogRepository;
/* import com.pst.asseco.logserver.service.AuthService;
 */
/* import jakarta.annotation.security.PermitAll;
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/* import org.springframework.http.HttpStatus;
 */import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
/* import java.util.Map;
 *//* import java.util.HashMap;
 */ 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
/* import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; */
 

@RestController
public class PFSLogController {
 
    @Autowired
    private PFSLogRepository pfsLogRepository;
 
    /* @Autowired
    private AuthService authService; */
 
    @GetMapping("/logs")
    public ResponseEntity<Page<PFSLog>> getUsersWithPagination(@RequestParam String user, Pageable pageable) {
        System.out.println("Valor de user recebido: " + user);
        Page<PFSLog> usersPage = pfsLogRepository.findByUser(user, pageable);
        return ResponseEntity.ok(usersPage);
    }
 
    @GetMapping("/logsByDate")
    public ResponseEntity<Page<PFSLog>> getLogsByDate(
        @RequestParam(required = false) Date date, Pageable pageable) {
            System.out.println("Valor de data recebido: " + date);
            Page<PFSLog> logsPage = pfsLogRepository.findByDate(date, pageable);
            return ResponseEntity.ok(logsPage);
    }
 
    @GetMapping("/logsByTime")
    public ResponseEntity<Page<PFSLog>> getLogsByTime(
        @RequestParam(required = false) String time, Pageable pageable) {
            System.out.println("Valor de hora recebido: " + time);
            Page<PFSLog> logsPage = pfsLogRepository.findByTime(time, pageable);
            return ResponseEntity.ok(logsPage);
    }
 
    @GetMapping("/logsByStation")
    public ResponseEntity<Page<PFSLog>> getLogsByStation(
        @RequestParam(required = false) String station, Pageable pageable) {
            System.out.println("Valor de estação recebido: " + station);
            Page<PFSLog> logsPage = pfsLogRepository.findByStation(station, pageable);
            return ResponseEntity.ok(logsPage);
    }
 
    @GetMapping("/logsByApplication")
    public ResponseEntity<Page<PFSLog>> getLogsByApplication(
        @RequestParam(required = false) String application, Pageable pageable) {
            System.out.println("Valor de aplicação recebido: " + application);
            Page<PFSLog> logsPage = pfsLogRepository.findByApplication(application, pageable);
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
   
    /* @PostMapping("/login")
    @PermitAll
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        boolean isAuthenticated = authService.authenticate(request.getEmail(), request.getPassword());
        if (isAuthenticated) {
            Map<String, Object> responseData =new HashMap<>();
            responseData.put("success", true);
            responseData.put("message", "Login successful");
            return ResponseEntity.ok(responseData);
        } else {
            Map<String, Object> errorData = new HashMap<>();
            errorData.put("success", false);
            errorData.put("message", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorData);
        }
    } */
}