package com.pst.asseco.logserver.model;

import java.util.Map;

public class PFSLogApiData {

    private Map <String, String> apidata;
    private Map <String, String> correlationId;
    private Map <String, String> bankaversion;
    private Map <String, String> errormessage;
    private Map <String, String> encryption;
    private Map <String, String> licencekey;
    private Map <String, String> errorcode;
    private Map <String, String> expiration;
    private Map <String, String> remoteaddr;
    private Map <String, String> https;

    // Constructors

    public PFSLogApiData() {
    }
    
    // Getters and Setters

    public Map<String, String> getApiData() {
        return apidata;
    }
    
    public void setApiData(Map<String, String> apidata) {
        this.apidata = apidata;
    }

    public Map<String, String> getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(Map<String, String> correlationId) {
        this.correlationId = correlationId;
    }

    public Map<String, String> getBankaversion() {
        return bankaversion;
    }

    public void setBankaversion(Map<String, String> bankaversion) {
        this.bankaversion = bankaversion;
    }

    public Map<String, String> getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(Map<String, String> errormessage) {
        this.errormessage = errormessage;
    }

    public Map<String, String> getEncryption() {
        return encryption;
    }

    public void setEncryption(Map<String, String> encryption) {
        this.encryption = encryption;
    }

    public Map<String, String> getLicencekey() {
        return licencekey;
    }

    public void setLicencekey(Map<String, String> licencekey) {
        this.licencekey = licencekey;
    }

    public Map<String, String> getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Map<String, String> errorcode) {
        this.errorcode = errorcode;
    }

    public Map<String, String> getExpiration() {
        return expiration;
    }

    public void setExpiration(Map<String, String> expiration) {
        this.expiration = expiration;
    }

    public Map<String, String> getRemoteaddr() {
        return remoteaddr;
    }

    public void setRemoteaddr(Map<String, String> remoteaddr) {
        this.remoteaddr = remoteaddr;
    }

    public Map<String, String> getHttps() {
        return https;
    }

    public void setHttps(Map<String, String> https) {
        this.https = https;
    }

}
