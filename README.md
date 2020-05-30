# Amazon Automation - ReadMe File

Features included in Amazon POM Automation Framework:

1. Maven is used for build execution	.
2. TestNG is implemented.
3. POM is used for Framework design.
4. Reporting: Extent Report is used for reporting in which screenshots is also get attached for failed test case.
verifyYourAccountsPageTitle() is failing intentionally in YourAccountPageTitleTest.java 
5. Test Data is read from Data excel file under: src/test/resources/TestData/Data.xlsx
6. Application URL, Browser and global implicit wait is read from config.poperties file located under: src/main/resources
7.Logging: Log4j is used for logging.
8. Project can be executed from cmd as well using maven plugins.
Command to execute all test cases is:  mvn clean test -DsuiteXmlFile=testng.xml
9. Log4j Logs: Log4j logs are maintained under Log4jLogs folder and it is maintaining both system and manual logs.
10. Extent Report: Extent Reports and screenshots are maintained in TestReport_Extent folder.
Failed Screenshots are maintained in FailedTestCaseScreenshots folder under TestReport_Extent folder.
11. All locators are maintained in AmazonConstants.java file in Utilities folder.
12. ConfigReader under Utilities is used for reading the properties file.
13. DataUtil under utilities  is used for Excel reading functions.
14. CommonFunctions.java under Common package is used for generic functions.





