package com.PartnersFunds.FieldsEntites;

import java.util.List;
import com.PartnersFunds.Entities.PageAttributesEntity;
import com.PartnersFunds.Entities.PagesEntity;

public class CodeGeneratorTemplate {

	public static String generateReactComponent(PagesEntity pagesEntity, List<PageAttributesEntity> updatedAttributes) {
		StringBuilder reactComponent = new StringBuilder();

		reactComponent.append("import React from 'react';\n");
		reactComponent.append("import { useState } from 'react';\n\n");
		reactComponent.append("import { Label } from '../ui/label';\n\n");
		reactComponent.append("import { Input } from '../ui/input';\n\n");

		reactComponent.append("const PageComponent = () => {\n");
		reactComponent.append("  const [formData, setFormData] = useState({});\n\n");

		reactComponent.append("  const handleChange = (e) => {\n");
		reactComponent.append("    setFormData({ ...formData, [e.target.name]: e.target.value });\n");
		reactComponent.append("  };\n\n");

		reactComponent.append("  const handleSubmit = () => {\n");
		reactComponent.append("    // Save form data\n");
		reactComponent.append("  };\n\n");

		reactComponent.append("  return (\n");
		reactComponent.append("    <div>\n");
		reactComponent.append("      <h1>").append(pagesEntity.getPage_title()).append("</h1>\n");

		for (PageAttributesEntity attribute : updatedAttributes) {
			System.out.println(attribute);
			switch (attribute.getAttribute_type()) {
			case "textfield":
				reactComponent.append(TextField.generateTextField(attribute));
				break;
			case "textarea":
				reactComponent.append(TextField.generateTextAreaField(attribute));
				break;
			case "dropdown":
				reactComponent.append(reactComponent.append("checkBox TBD"));
//				for (PageAttrPropertiesEntity property : attribute.getPageAttrPropertiesEntity()) {
//					reactComponent.append("        <option value='").append(property.getProperty_value()).append("'>")
//							.append(property.getProperty_value()).append("</option>\n");
//				}
//				reactComponent.append("      </select>\n");
				break;
			}
		}

//		reactComponent.append("      <button onClick={handleSubmit}>Save</button>\n");
		reactComponent.append("    </div>\n");
		reactComponent.append("  );\n");
		reactComponent.append("};\n\n");

		reactComponent.append("export default PageComponent;\n");

		return reactComponent.toString();
	}

	
}
