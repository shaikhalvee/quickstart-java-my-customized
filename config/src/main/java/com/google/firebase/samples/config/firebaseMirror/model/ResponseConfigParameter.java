package com.google.firebase.samples.config.firebaseMirror.model;

import com.google.api.client.util.Key;

import java.util.Map;

public class ResponseConfigParameter {

	@Key
	private Map<String, ResponseConfigParameterValue> conditionalValues;

	@Key
	private ResponseConfigParameterValue defaultValue;

	@Key
	private String description;

	public Map<String, ResponseConfigParameterValue> getConditionalValues() {
		return conditionalValues;
	}

	public ResponseConfigParameter setConditionalValues(Map<String, ResponseConfigParameterValue> conditionalValues) {
		this.conditionalValues = conditionalValues;
		return this;
	}

	public ResponseConfigParameterValue getDefaultValue() {
		return defaultValue;
	}

	public ResponseConfigParameter setDefaultValue(ResponseConfigParameterValue defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public ResponseConfigParameter setDescription(String description) {
		this.description = description;
		return this;
	}

}
