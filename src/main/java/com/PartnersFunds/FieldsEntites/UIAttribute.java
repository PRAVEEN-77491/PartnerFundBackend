package com.PartnersFunds.FieldsEntites;

import com.PartnersFunds.Entities.PageAttributesEntity;

//Class to represent an attribute on the page
public class UIAttribute {
	private PageAttributesEntity attribute;
	private String viewObjectName; // Name of the associated ViewObject
	private String viewObjectAttr; // Attribute in the ViewObject query result to map to

	public UIAttribute(PageAttributesEntity attribute, String viewObjectName, String viewObjectAttr) {
		
		this.attribute = attribute;
		this.viewObjectName = viewObjectName;
		this.viewObjectAttr = viewObjectAttr;
	}

	public String generateReactCode() {
		StringBuilder reactCode = new StringBuilder();

		switch (attribute.getAttribute_type().toLowerCase()) {
		case "textfield":
			reactCode.append(Fields.generateTextField(attribute, viewObjectName, viewObjectAttr));
			break;

		case "select":
			reactCode.append("<select name=\"").append(attribute.getAttribute_name()).append("\">\n");
			if (viewObjectName != null) {
				reactCode.append("  {").append(viewObjectName).append(".map(option => (\n");
				reactCode.append("    <option key={option.id} value={option.").append(viewObjectAttr).append("}>\n");
				reactCode.append("      {option.").append(viewObjectAttr).append("}\n");
				reactCode.append("    </option>\n");
				reactCode.append("  ))}\n");
			}
			reactCode.append("</select>");
			break;

		case "checkbox":
			reactCode.append("<input type=\"checkbox\" name=\"").append(attribute.getAttribute_name()).append("\"");
			if (viewObjectName != null && viewObjectAttr != null) {
				reactCode.append(" checked={").append(viewObjectName).append(".").append(viewObjectAttr).append("}");
			}
			reactCode.append(" />");
			break;

		case "radio":
			reactCode.append("<input type=\"radio\" name=\"").append(attribute.getAttribute_name()).append("\"");
			if (viewObjectName != null && viewObjectAttr != null) {
				reactCode.append(" checked={").append(viewObjectName).append(".").append(viewObjectAttr).append("}");
			}
			reactCode.append(" />");
			break;

		case "textarea":
			reactCode.append(Fields.generateTextAreaField(attribute, viewObjectName, viewObjectAttr));
			break;

		default:
			throw new UnsupportedOperationException("Unsupported attribute type: " + attribute.getAttribute_type());
		}

		return reactCode.toString();
	}

	public String getAttributeName() {
		return attribute.getAttribute_name();
	}

	public String getAttributeType() {
		return attribute.getAttribute_type();
	}
}