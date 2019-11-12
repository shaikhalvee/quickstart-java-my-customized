package com.google.firebase.samples.config.firebaseMirror.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

import java.util.Map;

public class ResponseConfigParameter extends GenericJson {
	/**
	 * Optional - a map of (condition_name, value). The condition_name of the highest priority (the
	 * one listed first in the conditions array) determines the value of this parameter.
	 * The value may be {@code null}.
	 */
	@Key
	private Map<String, ResponseConfigParameterValue> conditionalValues;

	/**
	 * Optional - value to set the parameter to, when none of the named conditions evaluate to true.
	 * The value may be {@code null}.
	 */
	@Key
	private ResponseConfigParameterValue defaultValue;

	/**
	 * Optional. A description for this Parameter. Length must be less than or equal to 100 characters
	 * (or more precisely, unicode code points, which is defined in
	 * java/com/google/wireless/android/config/ConstsExporter.java). A description may contain any
	 * Unicode characters
	 * The value may be {@code null}.
	 */
	@Key
	private String description;

	/**
	 * Optional - a map of (condition_name, value). The condition_name of the highest priority (the
	 * one listed first in the conditions array) determines the value of this parameter.
	 * @return value or {@code null} for none
	 */
	public Map<String, ResponseConfigParameterValue> getConditionalValues() {
		return conditionalValues;
	}

	/**
	 * Optional - a map of (condition_name, value). The condition_name of the highest priority (the
	 * one listed first in the conditions array) determines the value of this parameter.
	 * @param conditionalValues conditionalValues or {@code null} for none
	 */
	public ResponseConfigParameter setConditionalValues(Map<String, ResponseConfigParameterValue> conditionalValues) {
		this.conditionalValues = conditionalValues;
		return this;
	}

	/**
	 * Optional - value to set the parameter to, when none of the named conditions evaluate to true.
	 * @return value or {@code null} for none
	 */
	public ResponseConfigParameterValue getDefaultValue() {
		return defaultValue;
	}

	/**
	 * Optional - value to set the parameter to, when none of the named conditions evaluate to true.
	 * @param defaultValue defaultValue or {@code null} for none
	 */
	public ResponseConfigParameter setDefaultValue(ResponseConfigParameterValue defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}

	/**
	 * Optional. A description for this Parameter. Length must be less than or equal to 100 characters
	 * (or more precisely, unicode code points, which is defined in
	 * java/com/google/wireless/android/config/ConstsExporter.java). A description may contain any
	 * Unicode characters
	 * @return value or {@code null} for none
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Optional. A description for this Parameter. Length must be less than or equal to 100 characters
	 * (or more precisely, unicode code points, which is defined in
	 * java/com/google/wireless/android/config/ConstsExporter.java). A description may contain any
	 * Unicode characters
	 * @param description description or {@code null} for none
	 */
	public ResponseConfigParameter setDescription(String description) {
		this.description = description;
		return this;
	}

	@Override
	public ResponseConfigParameter set(String fieldName, Object value) {
		return (ResponseConfigParameter) super.set(fieldName, value);
	}

	@Override
	public ResponseConfigParameter clone() {
		return (ResponseConfigParameter) super.clone();
	}

}
