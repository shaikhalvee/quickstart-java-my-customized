package com.google.firebase.samples.config.firebaseMirror.model;

import com.google.api.client.util.Key;

public class ResponseConfigCondition {
	
	@Key
	private String description;

	@Key
	private String expression;

	@Key
	private String name;

	@Key
	private String tagColor;

	/**
	 * DO NOT USE. Implementation removed and will not be added unless requested. A description for
	 * this Condition. Length must be less than or equal to 100 characters (or more precisely, unicode
	 * code points, which is defined in java/com/google/wireless/android/config/ConstsExporter.java).
	 * A description may contain any Unicode characters
	 * @return value or {@code null} for none
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * DO NOT USE. Implementation removed and will not be added unless requested. A description for
	 * this Condition. Length must be less than or equal to 100 characters (or more precisely, unicode
	 * code points, which is defined in java/com/google/wireless/android/config/ConstsExporter.java).
	 * A description may contain any Unicode characters
	 * @param description description or {@code null} for none
	 */
	public ResponseConfigCondition setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Required.
	 * @return value or {@code null} for none
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * Required.
	 * @param expression expression or {@code null} for none
	 */
	public ResponseConfigCondition setExpression(String expression) {
		this.expression = expression;
		return this;
	}

	/**
	 * Required. A non empty and unique name of this condition.
	 * @return value or {@code null} for none
	 */
	public String getName() {
		return name;
	}

	/**
	 * Required. A non empty and unique name of this condition.
	 * @param name name or {@code null} for none
	 */
	public ResponseConfigCondition setName(String name) {
		this.name = name;
		return this;
	}

	public String getTagColor() {
		return tagColor;
	}

	public ResponseConfigCondition setTagColor(String tagColor) {
		this.tagColor = tagColor;
		return this;
	}

}
