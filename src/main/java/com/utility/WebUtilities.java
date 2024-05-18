package com.utility;

import KPX_WEB.yamlReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

import com.driverInstance.DriverManager;

public class WebUtilities extends ExtentReporter{
    protected final WebDriver driver = DriverManager.getDriver();
    private final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
    public final yamlReader reader = new yamlReader();
    private JavascriptExecutor js;

    public void click(WebElement locator, String elementName) throws Exception {
        try {
            if (isDisplayed(locator)) {
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                element.click();
                logger.info("Clicked on element: " + elementName);
                ExtentReporter.extentLoggerPass("Clicked on element: " + elementName, "");
            }
        } catch (Exception e) {
            ExtentReporter.extentLoggerFail("Failed to click element: " + elementName, "Caused: " + e);
            logger.error("Failed to click element: " + elementName);
            throw new AssertionError("Failed to click element: " + elementName);
        }
    }

    public void type(WebElement locator, String elementName, String text) throws Exception {
        try {
            if(isDisplayed(locator)) {
                WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
                element.sendKeys(text);
                logger.info("Typed into field: " + elementName + ", Value: "+ text);
                ExtentReporter.extentLogger("Typed into field: " + elementName , "Typed Value: "+ text);
            }
        } catch (NoSuchElementException e) {
            logger.error("Failed to type into field: "+ elementName + ", Value: "+ text);
            ExtentReporter.extentLoggerFail("Failed to type into field: "+ elementName , " Typed Value:: "+ text);

            throw new AssertionError("Failed to type into field: "+ elementName + ", Value: "+ text);
        }
    }

    public void typeEnter(WebElement locator, String elementName, String text) throws Exception {
        try {
            if(isDisplayed(locator)) {
                WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
                element.sendKeys(text + Keys.ENTER);
                logger.info("Typed into field: " + elementName + ", Value: "+ text);
                ExtentReporter.extentLogger("Typed into field: " + elementName , "Typed Value: "+ text);
            }
        } catch (NoSuchElementException e) {
            logger.error("Failed to type into field: "+ elementName + ", Value: "+ text);
            ExtentReporter.extentLoggerFail("Failed to type into field: "+ elementName , "Typed Value: "+ text);
            throw new AssertionError("Failed to type into field: "+ elementName + ", Value: "+ text);
        }
    }

    public boolean isVisible(WebElement locator, String elementName) throws Exception {
        try{
            wait.until(ExpectedConditions.visibilityOf(locator));
            logger.info("Element: " + elementName + ", is visible");
            return true;
        }catch (NoSuchElementException e){
            ExtentReporter.extentLoggerFail("Element: " + elementName + "not visible", "Caused: ");
            logger.error("Element: " + elementName + "not visible");
            throw new AssertionError("Element: " + elementName + " not visible" );
        }
    }

    /**
     * boolean return type for conditions
     *
     * @param locator
     * @return
     * @throws NoSuchElementException
     */
    public boolean isDisplayed(WebElement locator) {
        try {
            wait.until(ExpectedConditions.visibilityOf(locator));
            return locator.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    public String getText(WebElement locator) throws Exception {
        String val = null;
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
            val = element.getText();
        }catch(Exception e){
            ExtentReporter.extentLoggerFail("Cannot get text for element" + e.getMessage(), "Caused: "+ e);
            logger.error("Cannot get text for element" + e.getMessage());
            throw new AssertionError("Cannot get text for element" + e.getMessage());
        }
        return val;

    }

    public void assertEqual(String actual, String expected) throws Exception {
        try{
            Assert.assertEquals(actual, expected);
            logger.info(actual +  " and " + expected + " are matched");
            ExtentReporter.extentLogger("Assertion: "+actual +  " and " + expected + " are matched" , "asserted values " + actual + " and " + expected);
        }catch(Exception e){
            logger.error("Assertion error: "+ e.getMessage());
            ExtentReporter.extentLoggerFail("Assertion error: "+ e.getMessage(), "Caused: "+ e);
            throw new AssertionError("Assertion error: "+ e.getMessage());
        }
    }
    public void assertEqual(double actual, double expected) throws Exception {
        try{
            Assert.assertEquals(actual, expected);
            logger.info(actual +  " and " + expected + " are matched");
            ExtentReporter.extentLogger("Assertion: "+actual +  " and " + expected + " are matched" , "asserted values " + actual + " and " + expected);
        }catch(Exception e){
            logger.error("Assertion error: "+ e.getMessage());
            ExtentReporter.extentLoggerFail("Assertion error: "+ e.getMessage(), "Caused: "+ e);
            throw new AssertionError("Assertion error: "+ e.getMessage());
        }
    }

//    public void waitImplicitly(int seconds){
//        try{
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
//            logger.info("Waiting implicitly for: " + seconds + " seconds");
//        }catch(Exception e){
//            logger.error("waitImplicitly error: "+ e.getMessage());
//        }
//    }
    public void waitSleep(int miliSeconds){
        try{
            Thread.sleep(miliSeconds);
            logger.info("Waiting for: " + miliSeconds + " miliSeconds");
        }catch(Exception e){
            logger.error("wait error: "+ e.getMessage());
        }
    }

    public void switchToNextTab() {
        String currentWindowHandle = getDriver().getWindowHandle();
        Set<String> windowHandles = getDriver().getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                getDriver().switchTo().window(windowHandle);
                logger.info("Switch to " + currentWindowHandle);
                ExtentReporter.extentLogger("Switch Next Tab" , "Window ID: "+currentWindowHandle);
                break;
            }
        }
    }
    public void switchToNextTabClose() throws Exception {
        String currentWindowHandle = getDriver().getWindowHandle();
        Set<String> windowHandles = getDriver().getWindowHandles();

        // Check if there are multiple windows/tabs open
        if (windowHandles.size() <= 1) {
            logger.info("No next tab/window to switch to or close");
            ExtentReporter.extentLogger("No Tab to Switch", "No Tab to Switch");
            return;
        }

        boolean foundNextWindow = false;

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                try {
                    getDriver().switchTo().window(windowHandle);
                    getDriver().close();
                    logger.info("Closed window: " + windowHandle);
                    ExtentReporter.extentLogger("Closed window: " + windowHandle, "");
                    foundNextWindow = true;
                } catch (NoSuchWindowException e) {
                    logger.error("Failed to switch to/close window: " + windowHandle);
                    ExtentReporter.extentLoggerFail("Failed to switch to/close window: " + windowHandle, "");
                }
                break;
            }
        }

        if (!foundNextWindow) {
            logger.error("No next tab/window found to switch to or close");
            ExtentReporter.extentLoggerFail("No next tab/window found to switch to or close", "");
        }

        // Switch driver focus back to the original window/tab
        getDriver().switchTo().window(currentWindowHandle);
    }

    public void switchToPreviousTab() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        String previousWindowHandle = null;

        for (String windowHandle : windowHandles) {
            if (windowHandle.equals(currentWindowHandle)) {
                break;
            }
            previousWindowHandle = windowHandle;
        }

        if (previousWindowHandle != null) {
            driver.switchTo().window(previousWindowHandle);
            logger.info("Switch to " + previousWindowHandle);
            ExtentReporter.extentLogger("Switch Previous Tab " ,"Previous Tab ID: "+ currentWindowHandle);
        } else {
            throw new IllegalStateException("No previous tab found");
        }
    }
    public void scrollToBottomOfPageWEB() {
        try{
            js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }catch (Exception e){
            logger.info("Error: "+e);
        }

    }

    public  void scrollToTopOfPageWEB() {
        try{
            js= (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,-250)", "");
        }catch (Exception e ){
            logger.info("Error: "+e);
        }
    }
    public void scrollToSpecificScrollPosition(int scrollPosition) {
        try{
            js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, arguments[0])", scrollPosition);
            logger.info("Scrolling into position: "+ scrollPosition);
        }catch (Exception e){
            logger.info("Error "+ e);
        }

    }
    public void scrollToElement(WebElement element) {
        try{
            js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.info("Scrolling into element: "+ element);
        }catch (Exception e){
            logger.info("Error "+ e);
        }

    }
    public List<WebElement> staleException_Click(WebElement locator) {
        List<WebElement> outcome = null;
        int repeat = 0;
        while (repeat <= 6) {
            try {
                List<WebElement> ele = getDriver().findElements((By) locator);
                break;
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
            repeat++;
        }
        return outcome;
    }
    public void scrollDown(int scrollPercentage) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        long totalHeight = (long) jsExecutor.executeScript("return document.body.scrollHeight");
        long scrollHeight = totalHeight * scrollPercentage / 100;

        jsExecutor.executeScript("window.scrollTo(0, " + scrollHeight + ")");
    }

    public void scrollUp(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0)");
    }


    // Get the generated KPTN
    public String getGeneratedKPTN() {
        WebElement kptnElement = driver.findElement(By.id("kptnElementId")); // Replace "kptnElementId" with the actual ID or locator of the element displaying the KPTN
        String generatedKPTN = kptnElement.getText();
        return generatedKPTN;
    }

    // Perform actions using the generated KPTN
    public void performActionWithGeneratedKPTN() {
        // Perform actions to generate the KPTN
        // ...

        String generatedKPTN = getGeneratedKPTN();
        System.out.println("Generated KPTN: " + generatedKPTN);

        // Use the generated KPTN in your subsequent code
        // ...
    }


    public void clearInput(WebElement locator, String elementName) throws Exception {
        try {
            if (isDisplayed(locator)) {
                WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
                element.clear();
                logger.info("Cleared input field: " + elementName);
                ExtentReporter.extentLogger("Cleared input field: " + elementName, "");
            }
        } catch (NoSuchElementException e) {
            logger.error("Failed to clear input field: " + elementName);
            ExtentReporter.extentLoggerFail("Failed to clear input field: " + elementName, "Caused: " + e);
            throw new AssertionError("Failed to clear input field: " + elementName);
        }
    }

    public void clearField(WebElement locator) throws Exception {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            locator.clear();
            logger.info("Element " + locator + " field cleared");
        }catch (Exception e)
        {
            ExtentReporter.extentLoggerFail("clearField", ""+ e);
            logger.error("Failed to clear element " + locator);
        }
    }
    public boolean isChecked(WebElement locator){
        try{
            return locator.isSelected();
        }catch (Exception e){
            logger.error(""+e);
            return false;
        }
    }
    public String getValue(WebElement locator) throws Exception {
        String val = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
            val = element.getAttribute("value");
        } catch (Exception e) {
            ExtentReporter.extentLoggerFail("Cannot get value for element" + e.getMessage(), "Caused: " + e);
            logger.error("Cannot get value for element" + e.getMessage());
            throw new AssertionError("Cannot get value for element" + e.getMessage());
        }
        return val;

    }
    public double parseTotalValue(String total) {
        total = total.replaceAll(",", ""); // Remove commas if present
        String numericPart = total.replaceAll("[^0-9.]", ""); // Extract numeric part by removing non-numeric characters
        return Double.parseDouble(numericPart);
    }

}


