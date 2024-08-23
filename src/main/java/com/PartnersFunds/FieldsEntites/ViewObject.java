package com.PartnersFunds.FieldsEntites;

//Class to represent a View Object
public class ViewObject {
	private String viewObjectName;
	private String sqlQuery;
	private String eventType;

	public ViewObject(String viewObjectName, String sqlQuery, String eventType) {
		this.viewObjectName = viewObjectName;
		this.sqlQuery = sqlQuery;
		this.eventType = eventType;
	}

	public String generateReactFetchCode() {
		StringBuilder fetchCode = new StringBuilder();

		fetchCode.append("const fetch").append(viewObjectName).append("Data = async () => {\n");
		fetchCode.append("  try {\n");
		fetchCode.append("    const response = await fetch('/api/").append(viewObjectName.toLowerCase())
				.append("');\n");
		fetchCode.append("    const data = await response.json();\n");
		fetchCode.append("    set").append(viewObjectName).append("(data);\n");
		fetchCode.append("  } catch (error) {\n");
		fetchCode.append("    console.error('Error fetching ").append(viewObjectName).append(" data:', error);\n");
		fetchCode.append("  }\n");
		fetchCode.append("};\n");

		return fetchCode.toString();
	}

	public String generateReactStateCode() {
		return "const [" + viewObjectName + ", set" + viewObjectName + "] = useState([]);\n";
	}

	public String generateUseEffectCode() {
		StringBuilder useEffectCode = new StringBuilder();

		if ("onload_event".equalsIgnoreCase(eventType)) {
			useEffectCode.append("useEffect(() => {\n");
			useEffectCode.append("  fetch").append(viewObjectName).append("Data();\n");
			useEffectCode.append("}, []);\n");
		}

		return useEffectCode.toString();
	}

	public String getViewObjectName() {
		return viewObjectName;
	}
}
