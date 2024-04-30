package com.pst.asseco.logserver.model;

import java.util.Map;

public class PFSLogApiData {

    private Map <String, String> apiData;

        // Construtor
        public PFSLogApiData() {
        }
    
        // Getter para apiData
        public Map<String, String> getApiData() {
            return apiData;
        }
    
        // Setter para apiData
        public void setApiData(Map<String, String> apiData) {
            this.apiData = apiData;
        }

    
}
