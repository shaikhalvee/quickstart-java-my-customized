package com.google.firebase.samples.config.firebaseMirror.model;

import com.google.api.client.util.Key;

import java.util.List;
import java.util.Map;

public class ResponseConfig {
	
	@Key
	private List<ResponseConfigCondition> conditions;
	
	@Key
	private java.util.Map<String, ResponseConfigParameter> parameters;

	public List<ResponseConfigCondition> getConditions() {
		return conditions;
	}

	public ResponseConfig setConditions(java.util.List<ResponseConfigCondition> conditions) {
		this.conditions = conditions;
		return this;
	}

	
	public Map<String, ResponseConfigParameter> getParameters() {
		return parameters;
	}

	public ResponseConfig setParameters(Map<String, ResponseConfigParameter> parameters) {
		this.parameters = parameters;
		return this;
	}
}
