package com.google.firebase.samples.config.firebaseMirror.model;

import com.google.api.client.util.Key;

public class ResponseConfigParameterValue {

	@Key
	private Boolean useInAppDefault;

	@Key
	private String value;

	public Boolean getUseInAppDefault() {
		return useInAppDefault;
	}

	public ResponseConfigParameterValue setUseInAppDefault(java.lang.Boolean useInAppDefault) {
		this.useInAppDefault = useInAppDefault;
		return this;
	}

	public String getValue() {
		return value;
	}

	public ResponseConfigParameterValue setValue(java.lang.String value) {
		this.value = value;
		return this;
	}

}
