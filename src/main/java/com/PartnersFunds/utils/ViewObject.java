package com.PartnersFunds.utils;

public class ViewObject {
    private final String viewObjectName;
    private final String eventType;

    public ViewObject(String viewObjectName, String eventType) {
        this.viewObjectName = viewObjectName;
        this.eventType = eventType;
    }

    public String generateUseEffectCode(String refName) {
        StringBuilder useEffectCode = new StringBuilder();

        if ("OnLoad".equalsIgnoreCase(eventType)) {
            // Generate a single useEffect hook to fetch data for all view objects
            useEffectCode.append("  useEffect(() => {\n");
            useEffectCode.append("    if (").append("effectRan").append(".current === false) {\n");
            useEffectCode.append("      const fetchData = async () => {\n");
            useEffectCode.append("        try {\n");
            useEffectCode.append("          const promises = [];\n");
            useEffectCode.append("          promises.push(axios.post('http://localhost:8080/page/api/").append(viewObjectName).append("', {\n");
            useEffectCode.append("            \"viewObjectName\": \"").append(viewObjectName).append("\"\n");
            useEffectCode.append("          }));\n");
            useEffectCode.append("          const responses = await Promise.all(promises);\n");
            useEffectCode.append("          set").append(viewObjectName.substring(0, 1).toUpperCase() + viewObjectName.substring(1)).append("(responses[0].").append("data);\n");
            useEffectCode.append("        } catch (error) {\n");
            useEffectCode.append("          console.error('Error fetching data:', error);\n");
            useEffectCode.append("        }\n");
            useEffectCode.append("      };\n");
            useEffectCode.append("      fetchData();\n");
            useEffectCode.append("      ").append("effectRan").append(".current = true;\n");
            useEffectCode.append("    }\n");
            useEffectCode.append("  }, []);\n");
            useEffectCode.append("\n");
        }
        if ("OnEvent".equalsIgnoreCase(eventType)) {
        	System.out.println("OnClick");
        }

        return useEffectCode.toString();
    }

    public String getViewObjectName() {
        return viewObjectName;
    }
}
