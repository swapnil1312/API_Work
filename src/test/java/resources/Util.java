package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Util {

	public static RequestSpecification reqspec;

	public String getPropertyValue(String key) throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/java/resources/global.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}

	public RequestSpecification setup() throws IOException {

		PrintStream log = new PrintStream(new FileOutputStream("loging.txt"));

		reqspec = new RequestSpecBuilder().setBaseUri(getPropertyValue("baseUrl")).addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return reqspec;
	}

	public String getJsonValue(String response, String expectedKey) {
		JsonPath js = new JsonPath(response);
		return js.getString(expectedKey);
	}

}
