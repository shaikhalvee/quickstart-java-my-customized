package com.google.firebase.samples.config.firebaseMirror;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.googleapis.services.json.CommonGoogleJsonClientRequestInitializer;

import java.io.IOException;

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
public class FireBaseRemoteConfigRequestInitializer extends CommonGoogleJsonClientRequestInitializer {
    public FireBaseRemoteConfigRequestInitializer() {
    }

    public FireBaseRemoteConfigRequestInitializer(String key) {
        super(key);
    }

    public FireBaseRemoteConfigRequestInitializer(String key, String userIp) {
        super(key, userIp);
    }

    public final void initializeJsonRequest(AbstractGoogleJsonClientRequest<?> googleJsonClientRequest) throws IOException {
        super.initializeJsonRequest(googleJsonClientRequest);
        this.initializeFireBaseRemoteConfigRequest((FireBaseRemoteConfigRequest)googleJsonClientRequest);
    }

    protected void initializeFireBaseRemoteConfigRequest(FireBaseRemoteConfigRequest<?> fireBaseRemoteConfigRequest) throws IOException {
    }
}
