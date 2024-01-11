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
      static AppiumDriverLocalService service;
      public static String osName=System.getProperty("os.name").toLowerCase();
      private static String getAppiumJSPath() {
      String userName = System.getProperty("user.name");
      return userName + File.separator + "AppData" + File.separator + "Roaming" +
              File.separator + "npm" + File.separator + "node_modules" +
              File.separator + "appium" + File.separator + "build" +
              File.separator + "lib" + File.separator + "main.js";
   }
   public static void startServer() throws IOException {
      int[] ports ={4723, 4725, 4727, 4729, 4731, 4733, 4735, 4737, 4739, 4741};
      uninstallAppiumServer();
      switch (osName){
         case "linux":
               String nodePath = "/usr/bin/node"; // Path to the Node.js executable
               String appiumJSPath = "/usr/bin/appium"; // Path to the Appium main.js file
               for(int port : ports){
                   service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                          .usingDriverExecutable(new File(nodePath))
                          .withAppiumJS(new File(appiumJSPath))
                          .withIPAddress("127.0.0.1")
                          .usingPort(port)
                          .withArgument(GeneralServerFlag.LOG_LEVEL
                  ));
               }
               if (service.isRunning()) {
                  service.stop();
               } else {
                  service.start();
                  service.clearOutPutStreams();
                  logger.info("[EVENT] Appium Server Started Sucessfully.");
               }
            break;
         default:
            for(int port : ports){
               service = AppiumDriverLocalService.
                       buildService(new AppiumServiceBuilder()
                               .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                               .withAppiumJS(new File(getAppiumJSPath()))
                               .withIPAddress("127.0.0.1").usingPort(port)
                               .usingDriverExecutable (new File ("C:\\Program Files\\nodejs\\node.exe"))
                               .withArgument(GeneralServerFlag.LOG_LEVEL, "error"
                      ));
            }
            if (service.isRunning()) {
               service.stop();
            } else {
               service.start();
               logger.info(getAppiumJSPath());
               logger.info("[EVENT] Appium Server Started Successfully.");
            }
         }
   }

   private static void uninstallAppiumServer() throws IOException {
      String cmd1 = "adb uninstall io.appium.uiautomator2.server";
      String cmd2 = "adb uninstall io.appium.uiautomator2.server.test";
      Runtime.getRuntime().exec(cmd1);
      Runtime.getRuntime().exec(cmd2);
   }
   public static void stopServer(){
      DriverManager.getAppiumDriver().quit();
      service.stop();
      Utilities.waitTime(3000);
      logger.info("[EVENT] Appium Server Stopped Successfully.");
   }
}
