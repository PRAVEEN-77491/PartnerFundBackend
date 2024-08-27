package com.PartnersFunds.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.PartnersFunds.Entities.PageAttributesEntity;
import com.PartnersFunds.Entities.PagesEntity;
import com.PartnersFunds.Entities.ViewObjectsEntity;
import com.PartnersFunds.Repo.PageAttributesRepo;
import com.PartnersFunds.Repo.ViewObjectsRepo;

@Component
public class PageCodeGeneration {

	@Autowired
	PageAttributesRepo pageAttributeRepo;
	@Autowired
	ViewObjectsRepo viewObjectsRepo;

	Logger logger = LoggerFactory.getLogger(getClass());

	public void generateCode(List<Integer> attributeIds, PagesEntity codePagesEntity) {
		String pageGeneratedCode=null;
		// Temporary List to track added ViewObjects
		List<String> addedViewObjects = new ArrayList<>();
		logger.info("Filtering attributes based on the provided IDs");
		List<PageAttributesEntity> filteredAttributes = codePagesEntity.getPageAttributes().stream()
				.filter(attr -> attributeIds.contains(attr.getAttribute_id())).collect(Collectors.toList());

		// Update the existing collection in place
		codePagesEntity.getPageAttributes().clear(); // This clears the collection but keeps the reference intact
		codePagesEntity.getPageAttributes().addAll(filteredAttributes); // Re-add the filtered attributes

		System.out.println(codePagesEntity);

		ReactCodeGenerator generator = new ReactCodeGenerator();
		List<Object[]> attributesEOVO = pageAttributeRepo.findAllEOVOByAttributeIds(attributeIds);

		// Create a map to store eovo values
		Map<Integer, List<String>> eovoMap = new HashMap<>();

		// Define the regex pattern to match EO and VO values
		Pattern pattern = Pattern.compile(
				"EO=\\{entityobject=\"(.*?)\", entityattribute=(.*?)\\}, VO=\\{viewobject=\"(.*?)\", viewattribute=(.*?)\\}");

		// Populate the map with eovo values
		for (Object[] attributesEntity : attributesEOVO) {
			Integer attributeId = Integer.parseInt(String.valueOf(attributesEntity[0]));
			String eovoString = (String) attributesEntity[1];

			Matcher matcher = pattern.matcher(eovoString);
			if (matcher.find()) {
				// Extract values using regex groups
				String entityObject = matcher.group(1);
				String entityAttribute = matcher.group(2);
				String viewObject = matcher.group(3);
				String viewAttribute = matcher.group(4);

				// Store in the map
				eovoMap.put(attributeId, Arrays.asList(entityObject, entityAttribute, viewObject, viewAttribute));
			}
		}

		// Process each attribute and its eovo values
		// Create UIAttribute and ViewObject based on the filtered attributes and eovo
		// values
		for (PageAttributesEntity attribute : codePagesEntity.getPageAttributes()) {
			Integer attributeId = attribute.getAttribute_id();
			List<String> eovoValues = eovoMap.get(attributeId);

			System.out.println(attribute);

			System.out.println("eovoValues===> " + eovoValues);

			if (eovoValues != null) {
				String viewObject = eovoValues.get(2);
				String viewAttribute = eovoValues.get(3);

				// Create UIAttribute and ViewObject instances
				UIAttribute uiAttribute = new UIAttribute(attribute, viewObject, viewAttribute);

				generator.addAttribute(uiAttribute);

				// Check if ViewObject has already been added
				if (!addedViewObjects.contains(viewObject)) {
					// Create and add the ViewObject
					ViewObjectsEntity voEntity = viewObjectsRepo.findByViewObjectName(viewObject).orElse(null);
					System.out.println(voEntity.getEvent_type());
					if(voEntity != null) {
						ViewObject viewObjectInstance = new ViewObject(viewObject, voEntity.getEvent_type());
						generator.addViewObject(viewObjectInstance);
						// Add to the temporary list
						addedViewObjects.add(viewObject);
					}
				}

				System.out.println("addedViewObjects =====> "+addedViewObjects);
			} else if ("button".equalsIgnoreCase(attribute.getAttribute_type())) {
		        // Handle the button attribute
		        UIAttribute buttonAttribute = new UIAttribute(attribute, null, null);
		        generator.addAttribute(buttonAttribute);
		    }
		}
		pageGeneratedCode = generator.generatePageReactCode();
		System.out.println(pageGeneratedCode);

		String fileName = "test.jsx"; // Replace with your logic to determine the file name

		// Define the output file path in the resources folder
		File outputFile = Paths.get("C:/Users/akassha2/Downloads/PartnersFundUI/PartnersFunds/src/assests/" + fileName)
				.toFile();

		// Write the generated code to the .jsx file
		try (FileWriter writer = new FileWriter(outputFile)) {
			writer.write(pageGeneratedCode);
			System.out.println("Successfully wrote to the file: " + outputFile.getPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
