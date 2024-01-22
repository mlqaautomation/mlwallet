@echo off
setlocal

rem Set the paths to Node.js and Appium.js
set NODE_PATH=C:\Program Files\nodejs\node.exe
set APPIUM_JS_PATH=C:\npm\node_modules\appium\build\lib\main.js

rem Set the ports to be used by Appium
set PORTS=4723 4725 4727 4729

rem Set the log file directory
set LOG_DIR=C:\AppiumLogs

rem Create the log file directory if it doesn't exist
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"

rem Start Appium for each port
for %%p in (%PORTS%) do (
    start "" /B "%NODE_PATH%" "%APPIUM_JS_PATH%" -a 127.0.0.1 -p %%p --log-level error > nul
       if %errorlevel% equ 0 (
           echo Appium started successfully for port %%p >> "%LOG_DIR%\AppiumStartLogs.txt"
       ) else (
           echo Failed to start Appium for port %%p >> "%LOG_DIR%\AppiumStartLogs.txt"
        )
)

exit /b