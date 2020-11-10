package com.daftarirn.cloud.Models;

import org.json.JSONArray;

public class QwikModel {

    String loginTime;
    Boolean deviceValid;
    String id;
    String macId;
    String authId;

    public QwikModel() {

    }

    public QwikModel(String loginTime, Boolean deviceValid, String id, String macId, String authId) {
        this.loginTime = loginTime;
        this.deviceValid = deviceValid;
        this.id = id;
        this.macId = macId;
        this.authId = authId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public Boolean getDeviceValid() {
        return deviceValid;
    }

    public void setDeviceValid(Boolean deviceValid) {
        this.deviceValid = deviceValid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMacId() {
        return macId;
    }

    public void setMacId(String macId) {
        this.macId = macId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }
}
