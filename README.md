# Selenium Testing Project

This is KejaPro QA project for the UI.
## Prerequisites

- **Java JDK**: Install Java Development Kit (JDK) 8 or later.
- **Maven**: Install Apache Maven for managing dependencies and running the tests.
- **Selenium WebDriver**: This project uses ChromeDriver for running the tests.

## Setting Up the Project

### 1. Clone the Repository

```bash
git clone https://github.com/muilipato/Kejapro-QA.git
cd kejapro-QA
```
### Install Dependencies
   Ensure that Maven is properly installed. Then, navigate to the project directory and run:

```bash
mvn clean install
```
This will download all the necessary dependencies as defined in the pom.xml.

### WebDriver Setup
   You need to have ChromeDriver installed on your machine. Ensure you place the driver in a known location and update the path in your test files (in this case, in the Main.java class):

```java
System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
```

### Running the Tests
You can run the tests using Maven. The following steps outline how to do that.

### Run All Tests
   Use the following Maven command to run all tests:

```bash
mvn test
```
### Run Specific Tests
   To run a specific test, you can use the -Dtest parameter:

```bash
mvn -Dtest=Main test
```
This command will execute only the tests defined in the Main class.