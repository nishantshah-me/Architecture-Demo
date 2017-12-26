package com.tts.data.database.tables;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.IntDef;



import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by manenga on 2017/11/06.
 */

@Entity(tableName = "session")
public class SessionTable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "rememberMe")
    private boolean rememberMe = false;

    /**
     * Define AccountStatus types
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({AccountStatus.None, AccountStatus.Locked})
    public @interface AccountStatus {
        int None = 0;
        int Locked = 1;
    }

    @ColumnInfo(name = "accountStatus")
    private int accountStatus;

    @ColumnInfo(name = "accountStatusDescription")
    private String accountStatusDescription;

    @ColumnInfo(name = "hasAccountLogins")
    private boolean hasAccountLogins;

    @ColumnInfo(name = "hasInvestment")
    private boolean hasInvestment;

    @ColumnInfo(name = "key")
    private String key;

    @ColumnInfo(name = "requestToken")
    private String requestToken;

    @ColumnInfo(name = "monthStartDay")
    private int monthStartDay;

    @ColumnInfo(name = "customerId")
    private String customerId;

    @ColumnInfo(name = "sessionToken")
    private String sessionToken;

    @ColumnInfo(name = "cookieDomain")
    public String cookieDomain;

    //@ColumnInfo(name = "platformInformation")
    //public PlatformInformation platformInformation;

    @ColumnInfo(name = "socketJwt")
    public String socketJwt;

    //@ColumnInfo(name = "lastUserState")
    //public LastUserState lastUserState;

    public SessionTable() {
        // required no-args constructor for gson
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountStatusDescription() {
        return accountStatusDescription;
    }

    public void setAccountStatusDescription(String accountStatusDescription) {
        this.accountStatusDescription = accountStatusDescription;
    }

    public boolean isHasAccountLogins() {
        return hasAccountLogins;
    }

    public void setHasAccountLogins(boolean hasAccountLogins) {
        this.hasAccountLogins = hasAccountLogins;
    }

    public boolean isHasInvestment() {
        return hasInvestment;
    }

    public void setHasInvestment(boolean hasInvestment) {
        this.hasInvestment = hasInvestment;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    public int getMonthStartDay() {
        return monthStartDay;
    }

    public void setMonthStartDay(int monthStartDay) {
        this.monthStartDay = monthStartDay;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
