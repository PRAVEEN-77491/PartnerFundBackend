package com.PartnersFunds.utils;

import java.util.HashMap;
import java.util.List;
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
			reactCode.append("    value={").append(viewObjectName).append(".").append(viewObjectAttr.toUpperCase())
					.append("}\n");
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
			reactCode.append("    value={").append(viewObjectName).append(".").append(viewObjectAttr.toUpperCase())
					.append("}\n");
		}
		reactCode.append("    onChange={handleChange}\n");
		reactCode.append("  />\n");
//		reactCode.append("</div>\n");

		return reactCode.toString();
	}

	public static String generateSelectField(PageAttributesEntity attribute, String viewObjectName,
			String viewObjectAttr) {

		StringBuilder reactCode = new StringBuilder();
		// Create a map to store property names and values
		Map<String, String> propertiesMap = new HashMap<>();

		// Populate the map with property names and values
		for (PageAttrPropertiesEntity prop : attribute.getPageAttrPropertiesEntity()) {
			propertiesMap.put(prop.getProperty_name(), prop.getProperty_value());
		}

		// Start building the React code
		reactCode.append("<div className='flex flex-col gap-2 w-full' style={{\n");
		if (propertiesMap.containsKey("width")) {
			reactCode.append("  width: '").append(propertiesMap.get("width")).append("',\n");
		}
		reactCode.append("}}>\n");

		// Add label with styles
		if (propertiesMap.containsKey("label")) {
			reactCode.append("  <Label style={{\n");
			if (propertiesMap.containsKey("fontsize")) {
				reactCode.append("    fontSize: '").append(propertiesMap.get("fontsize")).append("',\n");
			}
			if (propertiesMap.containsKey("height")) {
				reactCode.append("    height: '").append(propertiesMap.get("height")).append("px',\n");
			}
			reactCode.append("  }}>\n");
			reactCode.append("    ").append(propertiesMap.get("label"));
			if (propertiesMap.containsKey("required") && propertiesMap.get("required").equals("true")) {
				reactCode.append("<span className='text-red-600 font-bold'> *</span>");
			}
			reactCode.append("\n  </Label>\n");
		}

		// Add select field with properties
		reactCode.append("  <Select\n");
		if (viewObjectName != null && viewObjectAttr != null) {
			reactCode.append("    value={").append(viewObjectName).append(".").append(viewObjectAttr.toUpperCase())
					.append("}\n");
		}
		reactCode.append("    onValueChange={handleChange}\n");
		reactCode.append("  >\n");
		reactCode.append("    <SelectTrigger>\n");
		reactCode.append("      <SelectValue placeholder='");
		if (propertiesMap.containsKey("placeholder")) {
			reactCode.append(propertiesMap.get("placeholder"));
		}
		reactCode.append("'/>\n");
		reactCode.append("    </SelectTrigger>\n");
		reactCode.append("    <SelectContent>\n");
		if (propertiesMap.containsKey("options")) {
			String[] optionss = propertiesMap.get("options").split(",");

			for (String option : optionss) {
				reactCode.append("      <SelectItem key='").append(option.replaceAll("^\\[|\\]$", "").trim())
						.append("' value='").append(option.replaceAll("^\\[|\\]$", "").trim()).append("'>\n");
				reactCode.append("        ").append(option.replaceAll("^\\[|\\]$", "").trim()).append("\n");
				reactCode.append("      </SelectItem>\n");
			}
		}
		reactCode.append("    </SelectContent>\n");
		reactCode.append("  </Select>\n");
		reactCode.append("</div>\n");

		return reactCode.toString();
	}

	public static String generateRadioButtonField(PageAttributesEntity attribute, String viewObjectName,
			String viewObjectAttr) {

		// Create a map to store property names and values
		Map<String, String> propertiesMap = new HashMap<>();

		// Populate the map with property names and values
		for (PageAttrPropertiesEntity prop : attribute.getPageAttrPropertiesEntity()) {
			propertiesMap.put(prop.getProperty_name(), prop.getProperty_value());
		}

		StringBuilder reactCode = new StringBuilder();

		// Start building the React code
		reactCode.append("<div className='flex flex-col gap-2 w-full'>\n");

		// Add label with styles and required indication
		if (propertiesMap.containsKey("labelHeader")) {
			reactCode.append("  <Label style={{\n");
			reactCode.append("    color: '").append(propertiesMap.get("headercolor")).append("',\n");
			reactCode.append("    fontSize: '").append(propertiesMap.get("fontsize")).append("px',\n");
			reactCode.append("    fontWeight: '").append(propertiesMap.get("fontweight")).append("'\n");
			reactCode.append("  }}>\n");
			reactCode.append("    ").append(propertiesMap.get("labelHeader"));
			if (propertiesMap.containsKey("required") && propertiesMap.get("required").equals("true")) {
				reactCode.append(" <span className='text-red-600 font-bold'>*</span>");
			}
			reactCode.append("\n  </Label>\n");
		}

		// Add RadioGroup and RadioGroupItem fields with properties
		reactCode.append("  <RadioGroup\n");
		if (viewObjectName != null && viewObjectAttr != null) {
			reactCode.append("    defaultValue={").append(viewObjectName).append(".")
					.append(viewObjectAttr.toUpperCase()).append("}\n");
		}
		reactCode.append("    onValueChange={handleChange}\n");
		reactCode.append("    style={{\n");
		reactCode.append("      color: '").append(propertiesMap.get("radiocolor")).append("',\n");
		reactCode.append("      fontSize: '").append(propertiesMap.get("fontsize")).append("px',\n");
		reactCode.append("      fontWeight: '").append(propertiesMap.get("fontweight")).append("'\n");
		reactCode.append("    }}\n");
		reactCode.append("  >\n");

		// Assuming options are provided as a comma-separated string in propertiesMap
		if (propertiesMap.containsKey("options")) {
			String[] options = propertiesMap.get("options").split(",");
			for (int i = 0; i < options.length; i++) {
				String option = options[i].trim();
				reactCode.append("    <div key={").append(i).append("} className='flex items-center space-x-2'>\n");
				reactCode.append("      <RadioGroupItem value='").append(option.replaceAll("^\\[|\\]$", "").trim())
						.append("' id={`radio-").append(i).append("`} />\n");
				reactCode.append("      <Label htmlFor={`radio-").append(i).append("`}>")
						.append(option.replaceAll("^\\[|\\]$", "").trim()).append("</Label>\n");
				reactCode.append("    </div>\n");
			}
		}

		reactCode.append("  </RadioGroup>\n");
		reactCode.append("</div>\n");
        reactCode.append("            </div>\n");
        reactCode.append("            </div>\n");

		return reactCode.toString();
	}

	public static String generateHeadingField(PageAttributesEntity attribute, String ViewObjectName,
			String ViewObjectAttr) {
		// Create a map to store property names and values
		Map<String, String> propertiesMap = new HashMap<>();

		// Populate the map with property names and values
		for (PageAttrPropertiesEntity prop : attribute.getPageAttrPropertiesEntity()) {
			propertiesMap.put(prop.getProperty_name(), prop.getProperty_value());
		}

		StringBuilder reactCode = new StringBuilder();

		// Start building the React code
		reactCode.append("<div className='flex flex-col gap-2 w-full'>\n");

		// Add Label with styles
		reactCode.append("  <Label style={{\n");

		if (propertiesMap.containsKey("fontsize")) {
			reactCode.append("    fontSize: '").append(propertiesMap.get("fontsize")).append("px',\n");
		}

		if (propertiesMap.containsKey("fontweight")) {
			reactCode.append("    fontWeight: '").append(propertiesMap.get("fontweight")).append("',\n");
		}

		if (propertiesMap.containsKey("fontcolor")) {
			reactCode.append("    color: '").append(propertiesMap.get("fontcolor")).append("',\n");
		}

		// Remove the last comma if any style property exists
		if (propertiesMap.containsKey("fontsize") || propertiesMap.containsKey("fontweight")
				|| propertiesMap.containsKey("fontcolor")) {
			reactCode.setLength(reactCode.length() - 2);
		}

		reactCode.append("\n  }}>\n");

		if (propertiesMap.containsKey("label")) {
			reactCode.append("    ").append(propertiesMap.get("label")).append("\n");
		}

		reactCode.append("  </Label>\n");
		reactCode.append("</div>\n");

		return reactCode.toString();
	}
	
	public static String generateCheckboxField(PageAttributesEntity attribute, String viewObjectName,
			String viewObjectAttr) {

		StringBuilder reactCode = new StringBuilder();
		// Create a map to store property names and values
		Map<String, String> propertiesMap = new HashMap<>();

		// Populate the map with property names and values
		for (PageAttrPropertiesEntity prop : attribute.getPageAttrPropertiesEntity()) {
			propertiesMap.put(prop.getProperty_name(), prop.getProperty_value());
		}

		// Start building the React code
	    reactCode.append("            <Label style={{\n");
	    reactCode.append("              fontSize: '").append(propertiesMap.getOrDefault("fontsize", "16px")).append("',\n");
	    reactCode.append("              height: '").append(propertiesMap.getOrDefault("height", "50px")).append("',\n");
	    reactCode.append("              fontWeight: '").append(propertiesMap.getOrDefault("fontweight", "200")).append("',\n");
	    reactCode.append("            }}>\n");
	    reactCode.append("              ").append(propertiesMap.getOrDefault("label", "Checkbox")).append("\n");
	    if (propertiesMap.containsKey("required") && propertiesMap.get("required").equals("true")) {
	        reactCode.append("              <span className='text-red-600 font-bold'> *</span>\n");
	    }
	    reactCode.append("            </Label>\n");

	    if (propertiesMap.containsKey("options")) {
	        String[] options = propertiesMap.get("options").split(",");
	        
	        System.out.println(options);
	        for (int i = 0; i < options.length; i++) {
	            reactCode.append("            <div key={").append(i).append("} className='flex items-center space-x-2'>\n");
	            reactCode.append("              <Checkbox id={'checkbox-").append(viewObjectAttr).append("-").append(i).append("'}\n");
	            reactCode.append("                onCheckedChange={(checked) => handleCheckboxChange(checked, '").append(options[i].replaceAll("^\\[|\\]$", "").trim()).append("')}\n");
	            if (propertiesMap.containsKey("fontweight")) {
	                reactCode.append("                style={{ fontWeight: '").append(propertiesMap.get("fontweight")).append("' }}\n");
	            }
	            reactCode.append("              />\n");
	            reactCode.append("              <Label htmlFor={'checkbox-").append(viewObjectAttr).append("-").append(i).append("'}\n");
	            if (propertiesMap.containsKey("fontweight")) {
	                reactCode.append("                style={{ fontWeight: '").append(propertiesMap.get("fontweight")).append("' }}\n");
	            }
	            reactCode.append("              >").append(options[i].replaceAll("^\\[|\\]$", "").trim()).append("</Label>\n");
	            reactCode.append("            </div>\n");
	        }
	    }
	    
	    
		
	    return reactCode.toString();
	}

	public static String generateButtonField(PageAttributesEntity attribute,String viewObjectName, String viewObjectAttr) {

	    // Create a map to store property names and values
	    Map<String, String> propertiesMap = new HashMap<>();

	    // Populate the map with property names and values
	    for (PageAttrPropertiesEntity prop : attribute.getPageAttrPropertiesEntity()) {
	        propertiesMap.put(prop.getProperty_name(), prop.getProperty_value());
	    }

	    StringBuilder reactCode = new StringBuilder();

	    // Start building the React code
	    reactCode.append("<div className='flex flex-col gap-2 w-full'>\n");
	    reactCode.append("  <Button onClick={alertFunc}\n");
	    reactCode.append("    style={{\n");

	    // Add styles dynamically
	    if (propertiesMap.containsKey("color")) {
	        reactCode.append("      backgroundColor: '").append(propertiesMap.get("color")).append("',\n");
	    }
	    if (propertiesMap.containsKey("fontcolor")) {
	        reactCode.append("      color: '").append(propertiesMap.get("fontcolor")).append("',\n");
	    }
	    if (propertiesMap.containsKey("fontsize")) {
	        reactCode.append("      fontSize: '").append(propertiesMap.get("fontsize")).append("px',\n");
	    }
	    if (propertiesMap.containsKey("height")) {
	        reactCode.append("      height: '").append(propertiesMap.get("height")).append("px',\n");
	    }
	    if (propertiesMap.containsKey("width")) {
	        reactCode.append("      width: '").append(propertiesMap.get("width")).append("px',\n");
	    }

	    // Remove the last comma if any style property exists
	    if (propertiesMap.containsKey("color") || propertiesMap.containsKey("fontcolor") || propertiesMap.containsKey("fontsize") || propertiesMap.containsKey("height") || propertiesMap.containsKey("width")) {
	        reactCode.setLength(reactCode.length() - 2);
	    }

	    reactCode.append("\n    }}\n");
	    reactCode.append("  >\n");

	    // Add button label
	    if (propertiesMap.containsKey("label")) {
	        reactCode.append("    ").append(propertiesMap.get("label")).append("\n");
	    }

	    reactCode.append("  </Button>\n");
	    reactCode.append("</div>\n");
	    reactCode.append("</div>\n");

	    return reactCode.toString();
	}


}