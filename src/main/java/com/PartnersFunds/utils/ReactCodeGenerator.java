package com.PartnersFunds.utils;

import java.util.ArrayList;
import java.util.List;

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

        reactCode.append("import React, { useState, useEffect, useRef } from 'react';\n");
        reactCode.append("import { Label } from 'src/components/ui/label';\n");
        reactCode.append("import { Input } from 'src/components/ui/input';\n");
        reactCode.append("import { Textarea } from 'src/components/ui/textarea';\n");
        reactCode.append("import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from 'src/components/ui/select';\n");
        reactCode.append("import { RadioGroup, RadioGroupItem } from 'src/components/ui/radio-group';\n");
        reactCode.append("import axios from 'axios';\n");
        reactCode.append("import paperSvg from 'src/assests/paper.svg';\n");
        reactCode.append("import { Checkbox } from 'src/components/ui/checkbox';\n");
        reactCode.append("import { Button } from 'src/components/ui/button';\n");
        
        reactCode.append("const App = () => {\n");
        // Generate state hooks and ref for effect control
        for (ViewObject vo : viewObjects) {
            reactCode.append("  ").append("const [" + vo.getViewObjectName() + ", set" + vo.getViewObjectName().substring(0, 1).toUpperCase() + vo.getViewObjectName().substring(1) + "] = useState({});\n");
        }
        reactCode.append("\n");
        
        reactCode.append("  const effectRan = useRef(false);\n");

     // Generate a single useEffect hook to fetch data for all view objects
        reactCode.append("  useEffect(() => {\n");
        reactCode.append("    if (").append("effectRan").append(".current === false) {\n");
        reactCode.append("      const fetchData = async () => {\n");
        reactCode.append("        try {\n");
        reactCode.append("          const promises = [];\n");

        for (ViewObject vo : viewObjects) {
            reactCode.append("          promises.push(axios.post('http://localhost:8080/page/api/").append(vo.getViewObjectName()).append("', {\n");
            reactCode.append("            \"viewObjectName\": \"").append(vo.getViewObjectName()).append("\"\n");
            reactCode.append("          }));\n");
        }

        reactCode.append("          const responses = await Promise.all(promises);\n");

        int i = 0;
        for (ViewObject vo : viewObjects) {
            reactCode.append("          set").append(vo.getViewObjectName().substring(0, 1).toUpperCase() + vo.getViewObjectName().substring(1)).append("(responses[").append(i).append("].data[0]);\n");
            i++;
        }

        reactCode.append("        } catch (error) {\n");
        reactCode.append("          console.error('Error fetching data:', error);\n");
        reactCode.append("        }\n");
        reactCode.append("      };\n");
        reactCode.append("      fetchData();\n");
        reactCode.append("      ").append("effectRan").append(".current = true;\n");
        reactCode.append("    }\n");
        reactCode.append("  }, []);\n");
        reactCode.append("\n");

//        // Generate useEffect hooks to fetch data
//        for (ViewObject vo : viewObjects) {
//            reactCode.append("  ").append(vo.generateUseEffectCode("effectRan")).append("\n");
//        }

        // Generate the handleChange function
        reactCode.append("  const handleChange = (e) => {\nconsole.log('Hello')\n");
//        reactCode.append("    const { name, value } = e.target;\n");
//        reactCode.append("    set").append("DistiDetailsVO12").append("((prevState) => ({\n");
//        reactCode.append("      ...prevState,\n");
//        reactCode.append("      [name]: value,\n");
//        reactCode.append("    }));\n");
        reactCode.append("  };\n");
        
        // Conditionally include handleCheckboxChange function
        if (attributes.stream().anyMatch(attr -> "checkbox".equalsIgnoreCase(attr.getAttributeType()))) {
            reactCode.append("  const [checkedItems, setCheckedItems] = useState([]);\n");
            reactCode.append("  const handleCheckboxChange = (checked, option) => {\n");
            reactCode.append("    setCheckedItems(prevCheckedItems => {\n");
            reactCode.append("      if (checked) {\n");
            reactCode.append("        return [...prevCheckedItems, option];\n");
            reactCode.append("      } else {\n");
            reactCode.append("        return prevCheckedItems.filter(item => item !== option);\n");
            reactCode.append("      }\n");
            reactCode.append("    });\n");
            reactCode.append("  };\n\n");
        }
        
        
//        // Generate handleSelectChange function
//        if (attributes.stream().anyMatch(attr -> "selectfield".equalsIgnoreCase(attr.getAttributeType()))) {
//            reactCode.append("  const [selectedOption, setSelectedOption] = useState('');\n");
//            reactCode.append("  const handleSelectChange = (value) => {\n");
//            reactCode.append("    setSelectedOption(value);\n");
//            reactCode.append("  };\n\n");
//        }
//
//        // Generate handleRadioChange function
//        if (attributes.stream().anyMatch(attr -> "radiofield".equalsIgnoreCase(attr.getAttributeType()))) {
//            reactCode.append("  const [radioValue, setRadioValue] = useState('');\n");
//            reactCode.append("  const handleRadioChange = (value) => {\n");
//            reactCode.append("    setRadioValue(value);\n");
//            reactCode.append("  };\n\n");
//        }
        
        if (attributes.stream().anyMatch(attr -> "button".equalsIgnoreCase(attr.getAttributeType()))) {
            reactCode.append("  const alertFunc = async () => {\n");
            reactCode.append("    try {\n");
            reactCode.append("        await axios.post('http://localhost:8080/page/call', {\n");
            reactCode.append("        \"attribute_id\": ").append("2710").append(",\n");
            reactCode.append("        \"params\": ").append("textField3VO").append("\n");
            reactCode.append("      });\n");
            reactCode.append("    } catch (error) {\n");
            reactCode.append("      console.error('Error fetching data:', error);\n");
            reactCode.append("    }\n");
            reactCode.append("  };\n");            
        }


        // Start the return block
        reactCode.append("  return (\n");
//        reactCode.append("    <>\n");
        reactCode.append("    <div className=\"w-screen h-screen max-h-screen max-w-full flex flex-col flex-grow p-0 gap-0\">\n");
        reactCode.append("      <div className='px-4 py-3 border-b'>\n");
        reactCode.append("        <p className='text-lg font-bold text-muted-foreground'>\n");
        reactCode.append("          Page Preview\n");
        reactCode.append("        </p>\n");
        reactCode.append("      </div>\n");
        reactCode.append("      <div className='bg-accent flex flex-col flex-grow items-center justify-center p-4 overflow-y-auto' style={{ backgroundImage: `url(${paperSvg})` }}>\n");
        reactCode.append("        <div className='max-w-[620px] flex flex-col gap-4 flex-grow bg-background h-full w-full rounded-2xl p-8 overflow-y-auto'>\n");
        reactCode.append("          <div className='flex flex-col gap-2 w-full'>\n");

        // Generate React code for each UI attribute
        for (UIAttribute attribute : attributes) {
            reactCode.append("            ").append(attribute.generateReactCode()).append("\n");
        }
//        reactCode.append("          </div>\n");
        reactCode.append("        </div>\n");
        reactCode.append("      </div>\n");
        reactCode.append("    </div>\n");
//        reactCode.append("    </>\n");
        reactCode.append("  );\n");
        reactCode.append("};\n\n");

        // End the component
        reactCode.append("export default App;\n");

        return reactCode.toString();
    }
}
