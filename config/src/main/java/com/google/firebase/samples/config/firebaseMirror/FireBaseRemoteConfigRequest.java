package com.google.firebase.samples.config.firebaseMirror;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/**
 * *****************************************************************
 * Copyright  2016.
 * All Rights Reserved to
 * Kona Software Lab Ltd.
 * Redistribution or Using any part of source code or binary
 * can not be done without permission of Kona Software Lab Ltd.
 * *****************************************************************
 *
 * @author: Shaikh Islam
 * @email: shaikh.islam@konasl.com
 * @date: 7/11/2019
 * @time: 3:06 PM
 * ****************************************************************
 */
public abstract class FireBaseRemoteConfigRequest<T> extends AbstractGoogleJsonClientRequest<T> {
    @Key("$.xgafv")
    private String $Xgafv;
    @Key("access_token")
    private String accessToken;
    @Key
    private String alt;
    @Key("bearer_token")
    private String bearerToken;
    @Key
    private String callback;
    @Key
    private String fields;
    @Key
    private String key;
    @Key("oauth_token")
    private String oauthToken;
    @Key
    private Boolean pp;
    @Key
    private Boolean prettyPrint;
    @Key
    private String quotaUser;
    @Key
    private String uploadType;
    @Key("upload_protocol")
    private String uploadProtocol;

    public FireBaseRemoteConfigRequest(FireBaseRemoteConfig fireBaseRemoteConfigJsonClient, String requestMethod, String uriTemplate, Object jsonContent, Class<T> responseClass) {
        super(fireBaseRemoteConfigJsonClient, requestMethod, uriTemplate, jsonContent, responseClass);
    }

    public String get$Xgafv() {
        return this.$Xgafv;
    }

    public FireBaseRemoteConfigRequest<T> set$Xgafv(String xgafv) {
        this.$Xgafv = xgafv;
        return this;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public FireBaseRemoteConfigRequest<T> setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getAlt() {
        return this.alt;
    }

    public FireBaseRemoteConfigRequest<T> setAlt(String alt) {
        this.alt = alt;
        return this;
    }

    public String getBearerToken() {
        return this.bearerToken;
    }

    public FireBaseRemoteConfigRequest<T> setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
        return this;
    }

    public String getCallback() {
        return this.callback;
    }

    public FireBaseRemoteConfigRequest<T> setCallback(String callback) {
        this.callback = callback;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    public FireBaseRemoteConfigRequest<T> setFields(String fields) {
        this.fields = fields;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public FireBaseRemoteConfigRequest<T> setKey(String key) {
        this.key = key;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    public FireBaseRemoteConfigRequest<T> setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
        return this;
    }

    public Boolean getPp() {
        return this.pp;
    }

    public FireBaseRemoteConfigRequest<T> setPp(Boolean pp) {
        this.pp = pp;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public FireBaseRemoteConfigRequest<T> setPrettyPrint(Boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    public FireBaseRemoteConfigRequest<T> setQuotaUser(String quotaUser) {
        this.quotaUser = quotaUser;
        return this;
    }

    public String getUploadType() {
        return this.uploadType;
    }

    public FireBaseRemoteConfigRequest<T> setUploadType(String uploadType) {
        this.uploadType = uploadType;
        return this;
    }

    public String getUploadProtocol() {
        return this.uploadProtocol;
    }

    public FireBaseRemoteConfigRequest<T> setUploadProtocol(String uploadProtocol) {
        this.uploadProtocol = uploadProtocol;
        return this;
    }

    public final FireBaseRemoteConfig getAbstractGoogleClient() {
        return (FireBaseRemoteConfig)super.getAbstractGoogleClient();
    }

    public FireBaseRemoteConfigRequest<T> setDisableGZipContent(boolean disableGZipContent) {
        return (FireBaseRemoteConfigRequest)super.setDisableGZipContent(disableGZipContent);
    }

    public FireBaseRemoteConfigRequest<T> setRequestHeaders(HttpHeaders requestHeaders) {
        return (FireBaseRemoteConfigRequest)super.setRequestHeaders(requestHeaders);
    }

    public FireBaseRemoteConfigRequest<T> set(String fieldName, Object value) {
        return (FireBaseRemoteConfigRequest)super.set(fieldName, value);
    }
}
