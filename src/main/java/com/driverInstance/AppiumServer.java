package com.driverInstance;

import com.utility.Utilities;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


import java.io.File;
import java.io.IOException;
import com.utility.LoggingUtils;

public class AppiumServer{

   public AppiumServer(){

   }
   public static LoggingUtils logger = new LoggingUtils();
   private static AppiumDriverLocalService service;
   public static String osName=System.getProperty("os.name").toLowerCase();
   private static final String NODE_PATH_LINUX = "/usr/bin/node";
   private static final String APPIUM_JS_PATH_LINUX = "/usr/bin/appium";
   private static final String NODE_PATH_WINDOWS = "C:\\Program Files\\nodejs\\node.exe";
   private static final String APPIUM_JS_PATH_WINDOWS = "C:\\npm\\node_modules\\appium\\build\\lib\\main.js";
   private static final String IP_ADDRESS = "127.0.0.1";
   private static final int[] PORTS = { 4723, 4725, 4727, 4729, 4731, 4733, 4735, 4737, 4739, 4741 };
   //   private static String getAppiumJSPath() {
   //      return "C:\\npm\\node_modules\\appium\\build\\lib\\main.js";
   //   }
   public static void startServer() throws IOException {
      uninstallAppiumServer();
      String nodePath = "";
      String appiumJSPath = "";

      if (osName.toLowerCase().contains("linux")) {
         nodePath = NODE_PATH_LINUX;
         appiumJSPath = APPIUM_JS_PATH_LINUX;

      } else if (osName.toLowerCase().contains("windows")) {
         nodePath = NODE_PATH_WINDOWS;
         appiumJSPath = APPIUM_JS_PATH_WINDOWS;

      } else {
         // Handle the case where the OS is not supported
         throw new UnsupportedOperationException("Unsupported OS: " + osName);
      }
         service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                 .usingDriverExecutable(new File(nodePath))
                 .withAppiumJS(new File(appiumJSPath))
                 .withIPAddress(IP_ADDRESS)
                 .usingAnyFreePort()
                 .usingDriverExecutable(new File(nodePath))
                 .withArgument(GeneralServerFlag.LOG_LEVEL, "error"));

      if (service.isRunning()) {
         service.stop();
      } else {
         String projectDirectory = System.getProperty("user.dir");
         String batFilePath = projectDirectory + "\\runAppiumPorts.bat";
         Runtime.getRuntime().exec("cmd /c start " + batFilePath);
         service.start();
         // Run the runAppiumPorts.bat file
         service.clearOutPutStreams();
         logger.info("[EVENT] Appium Server Started Successfully.");
      }
   }

   private static void uninstallAppiumServer(){
      try {
         String cmd1 = "adb uninstall io.appium.uiautomator2.server";
         String cmd2 = "adb uninstall io.appium.uiautomator2.server.test";
         Runtime.getRuntime().exec(cmd1);
         Runtime.getRuntime().exec(cmd2);
      } catch (IOException e) {
         logger.info("Failed to uninstall Appium server." + e);
      }
   }
   public static void stopServer(){
      DriverManager.getAppiumDriver().quit();
      service.stop();
      Utilities.waitTime(3000);
      logger.info("[EVENT] Appium Server Stopped Successfully.");
   }
}
