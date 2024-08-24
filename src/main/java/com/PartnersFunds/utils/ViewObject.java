package com.PartnersFunds.utils;

public class ViewObject {
    private String viewObjectName;

    public ViewObject(String viewObjectName) {
        this.viewObjectName = viewObjectName;
    }

//    public String generateReactStateCode() {
//        return "const [" + viewObjectName + ", set" + viewObjectName.substring(0, 1).toUpperCase() + viewObjectName.substring(1) + "] = useState({});\n";
//    }
//
//    public String generateUseEffectCode(String refName) {
//        StringBuilder useEffectCode = new StringBuilder();
//
//        if ("onload_event".equalsIgnoreCase(eventType)) {
//            useEffectCode.append("useEffect(() => {\n");
//            useEffectCode.append("  if (").append(refName).append(".current === false) {\n");
//            useEffectCode.append("    const fetchData = async () => {\n");
//            useEffectCode.append("      try {\n");
//            useEffectCode.append("        const payload = {\n");
////            useEffectCode.append("          \"attid\": 2391, // Adjust this value accordingly\n");
//            useEffectCode.append("          \"viewObjectName\": \"").append(viewObjectName).append("\"\n");
//            useEffectCode.append("        };\n");
//            useEffectCode.append("        const response = await axios.post('http://localhost:8080/page/api/").append(viewObjectName).append("', payload);\n");
//            useEffectCode.append("        set").append(viewObjectName.substring(0, 1).toUpperCase() + viewObjectName.substring(1)).append("(response.data);\n");
//            useEffectCode.append("      } catch (error) {\n");
//            useEffectCode.append("        console.error('Error fetching data:', error);\n");
//            useEffectCode.append("      }\n");
//            useEffectCode.append("    };\n");
//            useEffectCode.append("    fetchData();\n");
//            useEffectCode.append("    ").append(refName).append(".current = true;\n");
//            useEffectCode.append("  }\n");
//            useEffectCode.append("}, []);\n");
//        }
//        if ("onclick".equalsIgnoreCase(eventType)) {
//            useEffectCode.append("const sasdssdshandleClick = async () => {\n");
//            useEffectCode.append("  try {\n");
//            useEffectCode.append("    const payload = {\n");
//            useEffectCode.append("      \"viewObjectName\": \"").append(viewObjectName).append("\"\n");
//            useEffectCode.append("    };\n");
//            useEffectCode.append("    const response = await axios.post('http://localhost:8080/page/api/").append(viewObjectName).append("', payload);\n");
//            useEffectCode.append("    set").append(viewObjectName.substring(0, 1).toUpperCase() + viewObjectName.substring(1)).append("(response.data);\n");
//            useEffectCode.append("  } catch (error) {\n");
//            useEffectCode.append("    console.error('Error fetching data:', error);\n");
//            useEffectCode.append("  }\n");
//            useEffectCode.append("};\n");
//        }
//
//        return useEffectCode.toString();
//    }
//
    public String getViewObjectName() {
        return viewObjectName;
    }
}
