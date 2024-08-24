package com.PartnersFunds.utils;

import com.PartnersFunds.Entities.PageAttributesEntity;

public class UIAttribute {
    private PageAttributesEntity attribute;
    private String viewObjectName;
    private String viewObjectAttr;

    public UIAttribute(PageAttributesEntity attribute, String viewObjectName, String viewObjectAttr) {
        this.attribute = attribute;
        this.viewObjectName = viewObjectName;
        this.viewObjectAttr = viewObjectAttr;
    }

    public String generateReactCode() {
        StringBuilder reactCode = new StringBuilder();
        System.out.println("attribute.getAttribute_type() ====> " + attribute.getAttribute_type());
        switch (attribute.getAttribute_type().toLowerCase()) {
            case "textfield":
            	reactCode.append(Fields.generateTextField(attribute, viewObjectName, viewObjectAttr));
                break;
            case "textarea":
            	reactCode.append(Fields.generateTextAreaField(attribute, viewObjectName, viewObjectAttr));
                break;
            case "selectfield":
            	reactCode.append(Fields.generateSelectField(attribute,viewObjectName,viewObjectAttr));
            	break;
            case "radiofield":
            	reactCode.append(Fields.generateRadioButtonField(attribute, viewObjectName, viewObjectAttr));
            	break;
            case "heading":
    			reactCode.append(Fields.generateHeadingField(attribute, viewObjectName, viewObjectAttr));
    			break;
            case "checkbox":
    			reactCode.append(Fields.generateCheckboxField(attribute, viewObjectName, viewObjectAttr));
    			break;
            case "button":
    			System.out.println("<-----------------------Generate Button ------------------------>");
    			reactCode.append(Fields.generateButtonField(attribute, viewObjectName, viewObjectAttr));
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
