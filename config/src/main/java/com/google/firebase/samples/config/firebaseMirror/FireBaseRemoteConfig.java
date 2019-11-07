package com.google.firebase.samples.config.firebaseMirror;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.services.firebaseremoteconfig.v1.model.RemoteConfig;

import java.io.IOException;
import java.util.regex.Pattern;

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
 * @time: 3:00 PM
 * ****************************************************************
 */
public class FireBaseRemoteConfig extends AbstractGoogleJsonClient {
    public static final String DEFAULT_ROOT_URL = "https://firebaseremoteconfig.googleapis.com/";
    public static final String DEFAULT_SERVICE_PATH = "";
    public static final String DEFAULT_BATCH_PATH = "batch";
    public static final String DEFAULT_BASE_URL = "https://firebaseremoteconfig.googleapis.com/";

    // HttpTransport: abstract class, for build & process request
    // JsonFactory: abstract class, for json parsing building etc. {JsonParse, JsonGenerate, JsonObjectParse}
    // HttpRequestInitializer: interface, can pass GoogleCredentials through this.
    public FireBaseRemoteConfig(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer requestInitializer) {
        this(new FireBaseRemoteConfig.Builder(httpTransport, jsonFactory, requestInitializer));
    }

    FireBaseRemoteConfig(FireBaseRemoteConfig.Builder builder) {
        super(builder);
    }

    // FireBaseRemoteConfigRequest as httpClientRequest
    protected void initialize(AbstractGoogleClientRequest<?> httpClientRequest) throws IOException {
        super.initialize(httpClientRequest);
    }

    public FireBaseRemoteConfig.Projects projects() {
        return new FireBaseRemoteConfig.Projects();
    }

    static {
        Preconditions.checkState(GoogleUtils.MAJOR_VERSION.intValue() == 1 && GoogleUtils.MINOR_VERSION.intValue() >= 15, "You are currently running with version %s of google-api-client. You need at least version 1.15 of google-api-client to run version 1.23.0 of the Firebase Remote Config API library.", new Object[]{GoogleUtils.VERSION});
    }


    // HttpRequestInitializer: interface, can pass GoogleCredentials through this.
    public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

        /*
        Builder {
            final com.google.api.client.http.HttpTransport transport;
            com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer;
            com.google.api.client.http.HttpRequestInitializer httpRequestInitializer;
            final com.google.api.client.util.ObjectParser objectParser;
            java.lang.String rootUrl;
            java.lang.String servicePath;
            java.lang.String batchPath;
            java.lang.String applicationName;
            boolean suppressPatternChecks;
            boolean suppressRequiredParameterChecks;
         */

        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory, HttpRequestInitializer requestInitializer) {
            super(httpTransport, jsonFactory, DEFAULT_ROOT_URL, DEFAULT_SERVICE_PATH, requestInitializer, false);
            this.setBatchPath(DEFAULT_BATCH_PATH);
        }

        public FireBaseRemoteConfig build() {
            return new FireBaseRemoteConfig(this);
        }

        public FireBaseRemoteConfig.Builder setRootUrl(String rootUrl) {
            return (FireBaseRemoteConfig.Builder)super.setRootUrl(rootUrl);
        }

        public FireBaseRemoteConfig.Builder setServicePath(String servicePath) {
            return (FireBaseRemoteConfig.Builder)super.setServicePath(servicePath);
        }

        public FireBaseRemoteConfig.Builder setBatchPath(String batchPath) {
            return (FireBaseRemoteConfig.Builder)super.setBatchPath(batchPath);
        }

        public FireBaseRemoteConfig.Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            return (FireBaseRemoteConfig.Builder)super.setHttpRequestInitializer(httpRequestInitializer);
        }

        public FireBaseRemoteConfig.Builder setApplicationName(String applicationName) {
            return (FireBaseRemoteConfig.Builder)super.setApplicationName(applicationName);
        }

        public FireBaseRemoteConfig.Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
            return (FireBaseRemoteConfig.Builder)super.setSuppressPatternChecks(suppressPatternChecks);
        }

        public FireBaseRemoteConfig.Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
            return (FireBaseRemoteConfig.Builder)super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
        }

        public FireBaseRemoteConfig.Builder setSuppressAllChecks(boolean suppressAllChecks) {
            return (FireBaseRemoteConfig.Builder)super.setSuppressAllChecks(suppressAllChecks);
        }

        // FirebaseRemoteConfigRequestInitializer initializes firebase remote config req initializer
        public FireBaseRemoteConfig.Builder setFireBaseRemoteConfigRequestInitializer(FireBaseRemoteConfigRequestInitializer fireBaseRemoteConfigRequestInitializer) {
            return (FireBaseRemoteConfig.Builder)super.setGoogleClientRequestInitializer(fireBaseRemoteConfigRequestInitializer);
        }

        // set googleClientRequestInitializer. google client req initializer is implemented by firebase remote config req initializer
        public FireBaseRemoteConfig.Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            return (FireBaseRemoteConfig.Builder)super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
        }
    }

    // project under this config
    public class Projects {
        public Projects() {}

        // get remote config class set which is under projects class.
        public FireBaseRemoteConfig.Projects.GetRemoteConfig getRemoteConfig(String project) throws IOException {
            // initialize GetRemoteConfig class with string
            FireBaseRemoteConfig.Projects.GetRemoteConfig getRemoteConfigHandler = new FireBaseRemoteConfig.Projects.GetRemoteConfig(project);
            FireBaseRemoteConfig.this.initialize(getRemoteConfigHandler);
            return getRemoteConfigHandler;
        }

        public FireBaseRemoteConfig.Projects.UpdateRemoteConfig updateRemoteConfig(String project, RemoteConfig remoteConfig) throws IOException {
            FireBaseRemoteConfig.Projects.UpdateRemoteConfig updateRemoteConfigHandler = new FireBaseRemoteConfig.Projects.UpdateRemoteConfig(project, remoteConfig);
            FireBaseRemoteConfig.this.initialize(updateRemoteConfigHandler);
            return updateRemoteConfigHandler;
        }

        public class UpdateRemoteConfig extends FireBaseRemoteConfigRequest<RemoteConfig> {
            private static final String REST_PATH = "v1/{+project}/remoteConfig";
            private final Pattern PROJECT_PATTERN = Pattern.compile("^projects/[^/]+$");
            @Key
            private String project;
            @Key
            private Boolean validateOnly;

            // a get request for getting remote config template
            // project = "projects/my-project-id"
            protected UpdateRemoteConfig(String project, RemoteConfig remoteConfig) {
                // FireBaseRemoteConfig fireBaseRemoteConfigJsonClient, String requestMethod, String uriTemplate, Object jsonContent, Class<T> responseClass
                // later need to understand about this jsonContent
                super(FireBaseRemoteConfig.this, "PUT", "v1/{+project}/remoteConfig", remoteConfig, RemoteConfig.class);
                this.project = (String)Preconditions.checkNotNull(project, "Required parameter project must be specified.");
                if(!FireBaseRemoteConfig.this.getSuppressPatternChecks()) {
                    Preconditions.checkArgument(this.PROJECT_PATTERN.matcher(project).matches(), "Parameter project must conform to the pattern ^projects/[^/]+$");
                }

            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig set$Xgafv(String xgafv) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.set$Xgafv(xgafv);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setAccessToken(String accessToken) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setAccessToken(accessToken);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setAlt(String alt) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setAlt(alt);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setBearerToken(String bearerToken) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setBearerToken(bearerToken);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setCallback(String callback) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setCallback(callback);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setFields(String fields) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setFields(fields);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setKey(String key) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setKey(key);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setOauthToken(String oauthToken) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setOauthToken(oauthToken);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setPp(Boolean pp) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setPp(pp);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setPrettyPrint(Boolean prettyPrint) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setPrettyPrint(prettyPrint);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setQuotaUser(String quotaUser) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setQuotaUser(quotaUser);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setUploadType(String uploadType) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setUploadType(uploadType);
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setUploadProtocol(String uploadProtocol) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.setUploadProtocol(uploadProtocol);
            }

            public String getProject() {
                return this.project;
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setProject(String project) {
                if(!FireBaseRemoteConfig.this.getSuppressPatternChecks()) {
                    Preconditions.checkArgument(this.PROJECT_PATTERN.matcher(project).matches(), "Parameter project must conform to the pattern ^projects/[^/]+$");
                }

                this.project = project;
                return this;
            }

            public Boolean getValidateOnly() {
                return this.validateOnly;
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig setValidateOnly(Boolean validateOnly) {
                this.validateOnly = validateOnly;
                return this;
            }

            public FireBaseRemoteConfig.Projects.UpdateRemoteConfig set(String fieldName, Object value) {
                return (FireBaseRemoteConfig.Projects.UpdateRemoteConfig)super.set(fieldName, value);
            }
        }

        public class GetRemoteConfig extends FireBaseRemoteConfigRequest<RemoteConfig> {
            private static final String REST_PATH = "v1/{+project}/remoteConfig";
            private final Pattern PROJECT_PATTERN = Pattern.compile("^projects/[^/]+$");
            @Key
            private String project;

            // a get request for getting remote config template
            // project = "projects/my-project-id"
            protected GetRemoteConfig(String project) {
                // FireBaseRemoteConfig fireBaseRemoteConfigJsonClient, String requestMethod, String uriTemplate, Object jsonContent, Class<T> responseClass
                // later need to understand about this jsonContent
                super(FireBaseRemoteConfig.this, "GET", REST_PATH, (Object)null, RemoteConfig.class);
                this.project = (String)Preconditions.checkNotNull(project, "Required parameter project must be specified.");
                if(!FireBaseRemoteConfig.this.getSuppressPatternChecks()) {
                    Preconditions.checkArgument(this.PROJECT_PATTERN.matcher(project).matches(), "Parameter project must conform to the pattern ^projects/[^/]+$");
                }

            }

            public HttpResponse executeUsingHead() throws IOException {
                return super.executeUsingHead();
            }

            public HttpRequest buildHttpRequestUsingHead() throws IOException {
                return super.buildHttpRequestUsingHead();
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig set$Xgafv(String xgafv) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.set$Xgafv(xgafv);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setAccessToken(String accessToken) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setAccessToken(accessToken);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setAlt(String alt) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setAlt(alt);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setBearerToken(String bearerToken) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setBearerToken(bearerToken);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setCallback(String callback) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setCallback(callback);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setFields(String fields) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setFields(fields);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setKey(String key) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setKey(key);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setOauthToken(String oauthToken) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setOauthToken(oauthToken);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setPp(Boolean pp) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setPp(pp);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setPrettyPrint(Boolean prettyPrint) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setPrettyPrint(prettyPrint);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setQuotaUser(String quotaUser) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setQuotaUser(quotaUser);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setUploadType(String uploadType) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setUploadType(uploadType);
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setUploadProtocol(String uploadProtocol) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.setUploadProtocol(uploadProtocol);
            }

            public String getProject() {
                return this.project;
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig setProject(String project) {
                if(!FireBaseRemoteConfig.this.getSuppressPatternChecks()) {
                    Preconditions.checkArgument(this.PROJECT_PATTERN.matcher(project).matches(), "Parameter project must conform to the pattern ^projects/[^/]+$");
                }

                this.project = project;
                return this;
            }

            public FireBaseRemoteConfig.Projects.GetRemoteConfig set(String fieldName, Object value) {
                return (FireBaseRemoteConfig.Projects.GetRemoteConfig)super.set(fieldName, value);
            }
        }
    }
}
