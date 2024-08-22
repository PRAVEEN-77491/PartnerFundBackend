package com.PartnersFunds.FieldsEntites;

import java.util.HashMap;
import java.util.Map;

public class TextAreaField {
    public static void main(String[] args) {
        Map<String, Object> property = new HashMap<>();
        property.put("label", "Label text");
        property.put("labelcolor", "black");
        property.put("labelsize", 16);
        property.put("required", true);
        property.put("placeholder", "Enter value");
        property.put("textcolor", "gray");
        property.put("textsize", 14);
        property.put("height", 30);
        property.put("width", 200);

        StringBuilder reactCode = new StringBuilder();

        // Add imports
        reactCode.append("import React, { useState, useEffect } from 'react';\n");
        reactCode.append("import { Label } from '../ui/label';\n\n");
        reactCode.append("import {  Input } from '../ui/input';\n\n");

        // Add component definition
        reactCode.append("const Fields = () => {\n");
        reactCode.append("  const [values, setValues] = useState('');\n");
        reactCode.append("  const [submitValues, setSubmitValues] = useState(false);\n\n");

        // Add JSX code
        reactCode.append("  return (\n");
        reactCode.append("    <div className='flex flex-col gap-2 w-full'>\n");
        reactCode.append("      <Label style={{\n");

        for (Map.Entry<String, Object> entry : property.entrySet()) {
            if (entry.getKey().startsWith("label")) {
                reactCode.append("        ").append(entry.getKey()).append(": '").append(entry.getValue()).append("',\n");
            }
        }

        reactCode.append("      }}>\n");
        reactCode.append("        ");

        for (Map.Entry<String, Object> entry : property.entrySet()) {
            if (entry.getKey().equals("label")) {
                reactCode.append(entry.getValue());
            }
        }

        if ((boolean) property.get("required")) {
            reactCode.append(" <span className='text-red-600 font-bold'> *</span>");
        }

        reactCode.append("\n      </Label>\n");
        reactCode.append("      <Input placeholder='");

        for (Map.Entry<String, Object> entry : property.entrySet()) {
            if (entry.getKey().equals("placeholder")) {
                reactCode.append(entry.getValue());
            }
        }

        reactCode.append("' style={{\n");

        for (Map.Entry<String, Object> entry : property.entrySet()) {
            if (entry.getKey().startsWith("text")) {
                reactCode.append("        ").append(entry.getKey()).append(": ").append(entry.getValue()).append(",\n");
            }
        }

        reactCode.append("        height: ").append(property.get("height")).append("px,\n");
        reactCode.append("        width: ").append(property.get("width")).append("px,\n");
        reactCode.append("      }}\n");
        reactCode.append("        onChange={(e) => setValues(e.target.value)}\n");
        reactCode.append("        onBlur={(e) => {\n");
        reactCode.append("          if (!submitValues) return;\n");
        reactCode.append("          submitValues(id, e.target.value)\n");
        reactCode.append("        }}\n");
        reactCode.append("        value={values}\n");
        reactCode.append("      />\n");
        reactCode.append("    </div>\n");
        reactCode.append("  );\n");
        reactCode.append("};\n\n");

        // Add export statement
        reactCode.append("export default Fields;\n");

        System.out.println(reactCode.toString());
    }
}