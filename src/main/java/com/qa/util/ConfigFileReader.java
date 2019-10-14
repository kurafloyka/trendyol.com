package com.qa.util;

public class ConfigFileReader {
	static String getReportConfigPath() {
		return System.getProperty("user.dir") + "/src/main/java/com/qa/config/extent-config.xml";
	}
}
