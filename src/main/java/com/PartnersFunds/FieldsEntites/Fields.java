package com.PartnersFunds.FieldsEntites;

import java.util.HashMap;
import java.util.Map;

import com.PartnersFunds.Entities.PageAttrPropertiesEntity;
import com.PartnersFunds.Entities.PageAttributesEntity;

public class Fields {
	public static String generateTextField(PageAttributesEntity attribute, String viewObjectName,
			String viewObjectAttr) {
//		System.out.println("attribute =====> " + attribute);
		StringBuilder reactCode = new StringBuilder();
		// Create a map to store property names and values
		Map<String, String> propertiesMap = new HashMap<>();

		// Populate the map with property names and values
		for (PageAttrPropertiesEntity prop : attribute.getPageAttrPropertiesEntity()) {
			propertiesMap.put(prop.getProperty_name(), prop.getProperty_value());
		}

		// Start building the React code
		reactCode.append("<div className='flex flex-col gap-2 w-full'>\n");

		// Add label with styles and required indication
		if (propertiesMap.containsKey("label")) {
			reactCode.append("  <Label style={{\n");
			reactCode.append("    color: '").append(propertiesMap.get("labelcolor")).append("',\n");
			reactCode.append("    fontSize: '").append(propertiesMap.get("labelsize")).append("px',\n");
			reactCode.append("  }}>\n");
			reactCode.append("    ").append(propertiesMap.get("label"));
			if (propertiesMap.containsKey("required") && propertiesMap.get("required").equals("true")) {
				reactCode.append(" <span className='text-red-600 font-bold'>*</span>");
			}
			reactCode.append("\n  </Label>\n");
		}

		// Add input field with properties
		reactCode.append("  <Input\n");
		if (propertiesMap.containsKey("placeholder")) {
			reactCode.append("    placeholder='").append(propertiesMap.get("placeholder")).append("'\n");
		}
		if (propertiesMap.containsKey("textcolor")) {
			reactCode.append("    style={{ color: '").append(propertiesMap.get("textcolor")).append("',\n");
		}
		if (propertiesMap.containsKey("textsize")) {
			reactCode.append("      fontSize: '").append(propertiesMap.get("textsize")).append("px',\n");
		}
		if (propertiesMap.containsKey("height")) {
			reactCode.append("      height: '").append(propertiesMap.get("height")).append("px',\n");
		}
		if (propertiesMap.containsKey("width")) {
			reactCode.append("      width: '").append(propertiesMap.get("width")).append("px',\n");
		}
		reactCode.append("    }}\n");
		reactCode.append("    name='").append(attribute.getAttribute_name()).append("'\n");
		if (viewObjectName != null && viewObjectAttr != null) {
			reactCode.append("    value={").append(viewObjectName).append(".").append(viewObjectAttr).append("}\n");
		}
		reactCode.append("    onChange={handleChange}\n");
		reactCode.append("  />\n");
		return reactCode.toString();
	}

	public static String generateTextAreaField(PageAttributesEntity attribute, String viewObjectName,
			String viewObjectAttr) {
		StringBuilder reactCode = new StringBuilder();
		// Create a map to store property names and values
		Map<String, String> propertiesMap = new HashMap<>();

		// Populate the map with property names and values
		for (PageAttrPropertiesEntity prop : attribute.getPageAttrPropertiesEntity()) {
			propertiesMap.put(prop.getProperty_name(), prop.getProperty_value());
		}

		// Start building the React code
		reactCode.append("<div className='flex flex-col gap-2 w-full'>\n");

		// Add label with styles
		if (propertiesMap.containsKey("label")) {
			reactCode.append("  <Label>\n");
			reactCode.append("    ").append(propertiesMap.get("label"));
			reactCode.append("\n  </Label>\n");
		}

		// Add textarea field with properties
		reactCode.append("  <Textarea\n");
		if (propertiesMap.containsKey("placeholder")) {
			reactCode.append("    placeholder='").append(propertiesMap.get("placeholder")).append("'\n");
		}
		if (propertiesMap.containsKey("rows")) {
			reactCode.append("    rows={").append(propertiesMap.get("rows")).append("}\n");
		}
		reactCode.append("    style={{\n");
		if (propertiesMap.containsKey("fontcolor")) {
			reactCode.append("      color: '").append(propertiesMap.get("fontcolor")).append("',\n");
		}
		if (propertiesMap.containsKey("fontsize")) {
			reactCode.append("      fontSize: '").append(propertiesMap.get("fontsize")).append("',\n");
		}
		if (propertiesMap.containsKey("height")) {
			reactCode.append("      height: '").append(propertiesMap.get("height")).append("',\n");
		}
		if (propertiesMap.containsKey("width")) {
			reactCode.append("      width: '").append(propertiesMap.get("width")).append("',\n");
		}
		reactCode.append("    }}\n");
		if (viewObjectName != null && viewObjectAttr != null) {
			reactCode.append("    value={").append(viewObjectName).append(".").append(viewObjectAttr).append("}\n");
		}
		reactCode.append("    onChange={handleChange}\n");
		reactCode.append("  />\n");
		reactCode.append("</div>\n");

		return reactCode.toString();
	}

}