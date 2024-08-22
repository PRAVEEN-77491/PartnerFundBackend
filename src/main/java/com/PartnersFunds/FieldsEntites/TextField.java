package com.PartnersFunds.FieldsEntites;

import java.util.HashMap;
import java.util.Map;

import com.PartnersFunds.Entities.PageAttrPropertiesEntity;
import com.PartnersFunds.Entities.PageAttributesEntity;

public class TextField {
	public static String generateTextField(PageAttributesEntity attribute) {
//		System.out.println("attribute =====> " + attribute);
		StringBuilder textField = new StringBuilder();
		// Create a map to store property names and values
		Map<String, String> propertiesMap = new HashMap<>();

		// Populate the map with property names and values
		for (PageAttrPropertiesEntity prop : attribute.getPageAttrPropertiesEntity()) {
			propertiesMap.put(prop.getProperty_name(), prop.getProperty_value());
		}

		// Check if the required property is present
		if (propertiesMap.containsKey("required")) {
			textField.append("      <div className='flex flex-col gap-2 w-full'>\n");
			textField.append("        <Label style={{\n");
			textField.append("          color: '").append(propertiesMap.get("labelcolor")).append("',\n");
			textField.append("          fontSize: ").append(propertiesMap.get("labelsize")).append(",\n");
			textField.append("        }}>\n");
			textField.append("          ").append(propertiesMap.get("label"));
			if (propertiesMap.get("required").equals("true")) {
				textField.append(" <span className='text-red-600 font-bold'>*</span>");
			}
			textField.append("\n        </Label>\n");
			textField.append("        <Input\n");
			textField.append("          placeholder='").append(propertiesMap.get("placeholder")).append("'\n");
			textField.append("          style={{\n");
			textField.append("            color: '").append(propertiesMap.get("textcolor")).append("',\n");
			textField.append("            fontSize: ").append(propertiesMap.get("textsize")).append("px,\n");
			textField.append("            height: ").append(propertiesMap.get("height")).append("px,\n");
			textField.append("            width: ").append(propertiesMap.get("width")).append("px,\n");
			textField.append("          }}\n");
			textField.append("          name='").append(attribute.getAttribute_name()).append("'\n");
			textField.append("          onChange={handleChange}\n");
			textField.append("        />\n");
			textField.append("      </div>\n");
		}

		return textField.toString();
	}

	public static String generateTextAreaField(PageAttributesEntity attribute) {
		StringBuilder textAreaField = new StringBuilder();
		// Create a map to store property names and values
		Map<String, String> propertiesMap = new HashMap<>();

		// Populate the map with property names and values
		for (PageAttrPropertiesEntity prop : attribute.getPageAttrPropertiesEntity()) {
			propertiesMap.put(prop.getProperty_name(), prop.getProperty_value());
		}

		// Check if the required property is present
//		if (propertiesMap.containsKey("required")) {
			textAreaField.append("      <div className='flex flex-col gap-2 w-full'>\n");
			textAreaField.append("        <Label>\n");
			textAreaField.append("          ").append(propertiesMap.get("label"));
//			if (propertiesMap.get("required").equals("true")) {
//				textAreaField.append(" <span className='text-red-600 font-bold'>*</span>");
//			}
			textAreaField.append("\n        </Label>\n");
			textAreaField.append("        <Textarea\n");
			textAreaField.append("          placeholder='").append(propertiesMap.get("placeholder")).append("'\n");
			textAreaField.append("          rows={").append(propertiesMap.get("rows")).append("}\n");
			textAreaField.append("          style={{\n");
			textAreaField.append("            fontcolor: '").append(propertiesMap.get("fontcolor")).append("',\n");
			textAreaField.append("            fontSize: ").append(propertiesMap.get("fontsize")).append(",\n");
			textAreaField.append("            height: ").append(propertiesMap.get("height")).append(",\n");
			textAreaField.append("            width: ").append(propertiesMap.get("width")).append(",\n");
			textAreaField.append("          }}\n");
//			textAreaField.append("          value={inputValue}\n");
			textAreaField.append("          onChange={handleChange}\n");
			textAreaField.append("        />\n");
			textAreaField.append("      </div>\n");
//		}

		return textAreaField.toString();
	}

}