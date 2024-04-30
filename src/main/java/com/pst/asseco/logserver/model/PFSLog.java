package com.pst.asseco.logserver.model;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
 
import java.util.Date;
 
@Entity
@Table(name = "t_pfslog")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
public class PFSLog {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "correlationId")
    private String correlationId;

    @Column(name = "encryption")
    private String encryption;
 
    @Column(name = "date")
    private Date date;
 
    @Column(name = "time")
    private String time;
 
    @Column(name = "io")
    private String io;
 
    @Column(name = "user")
    private String user;
 
    @Column(name = "station")
    private String station;
 
    @Column(name = "system")
    private String system;
 
    @Column(name = "application")
    private String application;
 
    @Column(name = "bankaversion")
    private String bankaversion;
 
    @Column(name = "sessionid")
    private String sessionid;
 
    @Column(name = "api")
    private String api;
 
    @Column(name = "transaction")
    private String transaction;
 
    @Column(name = "licencekey")
    private String licencekey;
 
    @Column(name = "errorcode")
    private String errorcode;
 
    @Column(name = "errormessage")
    private String errormessage;

    @Column(name = "expiration")
    private String expiration;

    @Column(name = "remoteaddr")
    private String remoteaddr;

    @Column(name = "servername")
    private String servername;

    @Column(name = "https")
    private String https;

    @Column(name = "apidata")
    private String apidata;

    // Constructor

    /* public PFSLog() {
    } */
 
    // Getters and Setters

    public String getApidata() {
        return apidata;
    }

    public void setApidata(String apidata) {
        this.apidata = apidata;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getCorrelationId() {
        return correlationId;
    }
 
    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public Date getDate() {
        return date;
    }
 
    public void setDate(Date date) {
        this.date = date;
    }
 
    public String getTime() {
        return time;
    }
 
    public void setTime(String time) {
        this.time = time;
    }
 
    public String getIo() {
        return io;
    }
 
    public void setIo(String io) {
        this.io = io;
    }
 
    public String getUser() {
        return user;
    }
 
    public void setUser(String user) {
        this.user = user;
    }
 
    public String getStation() {
        return station;
    }
 
    public void setStation(String station) {
        this.station = station;
    }
 
    public String getSystem() {
        return system;
    }
 
    public void setSystem(String system) {
        this.system = system;
    }
 
    public String getApplication() {
        return application;
    }
 
    public void setApplication(String application) {
        this.application = application;
    }
 
    public String getBankaversion() {
        return bankaversion;
    }
 
    public void setBankaversion(String bankaversion) {
        this.bankaversion = bankaversion;
    }
 
    public String getsessionid() {
        return sessionid;
    }
 
    public void setsessionid(String sessionid) {
        this.sessionid = sessionid;
    }
 
    public String getApi() {
        return api;
    }
 
    public void setApi(String api) {
        this.api = api;
    }
 
    public String getTransaction() {
        return transaction;
    }
 
    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
 
    public String getLicencekey() {
        return licencekey;
    }
 
    public void setLicencekey(String licencekey) {
        this.licencekey = licencekey;
    }
 
    public String getErrorcode() {
        return errorcode;
    }
 
    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }
 
    public String getErrormessage() {
        return errormessage;
    }
 
    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public String getEncryption() {
        return encryption;
    }
 
    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    public String getExpiration() {
        return expiration;
    }
 
    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getRemoteaddr() {
        return remoteaddr;
    }
 
    public void setRemoteaddr(String remoteaddr) {
        this.remoteaddr = remoteaddr;
    }

    public String getServername() {
        return servername;
    }
 
    public void setServername(String servername) {
        this.servername = servername;
    }

    public String getHttps() {
        return https;
    }
 
    public void setHttps(String https) {
        this.https = https;
    }
 
}