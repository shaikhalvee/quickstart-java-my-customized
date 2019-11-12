package com.google.firebase.samples.config.firebaseMirror.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public class ResponseConfigCondition extends GenericJson {
	
	@Key
	private String description;

	/**
	 * Required.
	 * The value may be {@code null}.
	 */
	@Key
	private java.lang.String expression;

	/**
	 * Required. A non empty and unique name of this condition.
	 * The value may be {@code null}.
	 */
	@Key
	private java.lang.String name;

	/**
	 * Optional. The display (tag) color of this condition. This serves as part of a tag (in the
	 * future, we may add tag text as well as tag color, but that is not yet implemented in the UI).
	 * This value has no affect on the semantics of the delivered config and it is ignored by the
	 * backend, except for passing it through write/read requests. Not having this value or having the
	 * "CONDITION_DISPLAY_COLOR_UNSPECIFIED" value (0) have the same meaning:  Let the UI choose any
	 * valid color when displaying the condition.
	 * The value may be {@code null}.
	 */
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
	public ResponseConfigCondition setDescription(java.lang.String description) {
		this.description = description;
		return this;
	}

	/**
	 * Required.
	 * @return value or {@code null} for none
	 */
	public java.lang.String getExpression() {
		return expression;
	}

	/**
	 * Required.
	 * @param expression expression or {@code null} for none
	 */
	public ResponseConfigCondition setExpression(java.lang.String expression) {
		this.expression = expression;
		return this;
	}

	/**
	 * Required. A non empty and unique name of this condition.
	 * @return value or {@code null} for none
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * Required. A non empty and unique name of this condition.
	 * @param name name or {@code null} for none
	 */
	public ResponseConfigCondition setName(java.lang.String name) {
		this.name = name;
		return this;
	}

	/**
	 * Optional. The display (tag) color of this condition. This serves as part of a tag (in the
	 * future, we may add tag text as well as tag color, but that is not yet implemented in the UI).
	 * This value has no affect on the semantics of the delivered config and it is ignored by the
	 * backend, except for passing it through write/read requests. Not having this value or having the
	 * "CONDITION_DISPLAY_COLOR_UNSPECIFIED" value (0) have the same meaning:  Let the UI choose any
	 * valid color when displaying the condition.
	 * @return value or {@code null} for none
	 */
	public java.lang.String getTagColor() {
		return tagColor;
	}

	/**
	 * Optional. The display (tag) color of this condition. This serves as part of a tag (in the
	 * future, we may add tag text as well as tag color, but that is not yet implemented in the UI).
	 * This value has no affect on the semantics of the delivered config and it is ignored by the
	 * backend, except for passing it through write/read requests. Not having this value or having the
	 * "CONDITION_DISPLAY_COLOR_UNSPECIFIED" value (0) have the same meaning:  Let the UI choose any
	 * valid color when displaying the condition.
	 * @param tagColor tagColor or {@code null} for none
	 */
	public ResponseConfigCondition setTagColor(java.lang.String tagColor) {
		this.tagColor = tagColor;
		return this;
	}

	@Override
	public ResponseConfigCondition set(String fieldName, Object value) {
		return (ResponseConfigCondition) super.set(fieldName, value);
	}

	@Override
	public ResponseConfigCondition clone() {
		return (ResponseConfigCondition) super.clone();
	}
}
