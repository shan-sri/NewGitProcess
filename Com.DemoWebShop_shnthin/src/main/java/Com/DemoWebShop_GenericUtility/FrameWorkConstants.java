package Com.DemoWebShop_GenericUtility;

public interface FrameWorkConstants {

	JavaUtility javaUtility = new JavaUtility();

	static final String propertyPath = "./src/test/resources/testData/data.properties";

	static final String excelpath = "./src/test/resources/testData/Book1.xlsx";

	static final String screenshotpath = "./screenshots/" + javaUtility.dateAndTime() + ".png";

	static final String reportsPath = "./reports/" + javaUtility.dateAndTime() + ".html";
}
