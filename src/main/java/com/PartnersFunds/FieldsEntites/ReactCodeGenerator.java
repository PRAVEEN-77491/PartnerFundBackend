package com.PartnersFunds.FieldsEntites;

import java.util.ArrayList;
import java.util.List;

//Main class for generating the React code for the entire page
public class ReactCodeGenerator {
	private List<UIAttribute> attributes;
	private List<ViewObject> viewObjects;

	public ReactCodeGenerator() {
		this.attributes = new ArrayList<>();
		this.viewObjects = new ArrayList<>();
	}

	public void addAttribute(UIAttribute attribute) {
		attributes.add(attribute);
	}

	public void addViewObject(ViewObject viewObject) {
		viewObjects.add(viewObject);
	}

	public String generatePageReactCode() {
		StringBuilder reactCode = new StringBuilder();

		reactCode.append("import React, { useState, useEffect } from 'react';\n\n");
		reactCode.append("import { Label } from 'src/components/ui/label';\n\n");
		reactCode.append("import { Input } from 'src/components/ui/input';\n\n");
		reactCode.append("import { Textarea } from 'src/components/ui/textarea';\n\n");

		reactCode.append("const test = () => {\n");

		// Generate state hooks for each ViewObject
		for (ViewObject vo : viewObjects) {
			reactCode.append(vo.generateReactStateCode());
		}
		reactCode.append("\n");

		// Generate useEffect hooks to fetch data for ViewObjects
		for (ViewObject vo : viewObjects) {

			reactCode.append(vo.generateUseEffectCode()).append("\n");
		}

		// Start the return block
		reactCode.append("  return (\n");
//		reactCode.append("    <div>\n");

		// Generate React code for each UI attribute
		for (UIAttribute attribute : attributes) {
			reactCode.append("      ").append(attribute.generateReactCode()).append("\n");
		}

		reactCode.append("    </div>\n");
		reactCode.append("  );\n");
		reactCode.append("};\n\n");

		// Generate fetch functions for each ViewObject
		for (ViewObject vo : viewObjects) {
			reactCode.append(vo.generateReactFetchCode()).append("\n");
		}

		reactCode.append("export default test;\n");

		// Output the generated code
		System.out.println(reactCode.toString());
		
		return reactCode.toString();
	}

//	public static void main(String[] args) {
//		// Example usage
//		ViewObject employeeDetailsViewObject = new ViewObject("EmployeeDetails",
//				"SELECT emp_id AS employee_number, name FROM employee", "onload_event");
//
//		UIAttribute employeeNumber = new UIAttribute("employeeNumber", "textfield", "EmployeeDetails", "employee_number");
//		UIAttribute employeeName = new UIAttribute("employeeName", "textfield", "EmployeeDetails", "name");
//		UIAttribute departmentSelect = new UIAttribute("department", "select", "EmployeeDetails", "department_id");
//		UIAttribute isPermanentCheckbox = new UIAttribute("isPermanent", "checkbox", "EmployeeDetails", "is_permanent");
//		UIAttribute genderRadio = new UIAttribute("gender", "radio", "EmployeeDetails", "gender");
//		UIAttribute bioTextArea = new UIAttribute("bio", "textarea", "EmployeeDetails", "bio");
//
//		ReactCodeGenerator generator = new ReactCodeGenerator();
//		generator.addViewObject(employeeDetailsViewObject);
//		generator.addAttribute(employeeNumber);
//		generator.addAttribute(employeeName);
//		generator.addAttribute(departmentSelect);
//		generator.addAttribute(isPermanentCheckbox);
//		generator.addAttribute(genderRadio);
//		generator.addAttribute(bioTextArea);
//
//		generator.generatePageReactCode();
//	}
}
