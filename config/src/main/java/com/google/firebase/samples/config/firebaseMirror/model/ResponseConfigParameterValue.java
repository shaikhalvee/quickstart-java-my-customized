package com.google.firebase.samples.config.firebaseMirror.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public class ResponseConfigParameterValue extends GenericJson {
	/**
	 * if true, omit the parameter from the map of fetched parameter values
	 * The value may be {@code null}.
	 */
	@Key
	private Boolean useInAppDefault;

	/**
	 * the string to set the parameter to
	 * The value may be {@code null}.
	 */
	@Key
	private String value;

	/**
	 * if true, omit the parameter from the map of fetched parameter values
	 * @return value or {@code null} for none
	 */
	public Boolean getUseInAppDefault() {
		return useInAppDefault;
	}

	/**
	 * if true, omit the parameter from the map of fetched parameter values
	 * @param useInAppDefault useInAppDefault or {@code null} for none
	 */
	public ResponseConfigParameterValue setUseInAppDefault(java.lang.Boolean useInAppDefault) {
		this.useInAppDefault = useInAppDefault;
		return this;
	}

	/**
	 * the string to set the parameter to
	 * @return value or {@code null} for none
	 */
	public String getValue() {
		return value;
	}

	/**
	 * the string to set the parameter to
	 * @param value value or {@code null} for none
	 */
	public ResponseConfigParameterValue setValue(java.lang.String value) {
		this.value = value;
		return this;
	}

	@Override
	public ResponseConfigParameterValue set(String fieldName, Object value) {
		return (ResponseConfigParameterValue) super.set(fieldName, value);
	}

	@Override
	public ResponseConfigParameterValue clone() {
		return (ResponseConfigParameterValue) super.clone();
	}

}
