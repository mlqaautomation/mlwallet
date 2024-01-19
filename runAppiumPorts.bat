@echo off
setlocal

rem Set the paths to Node.js and Appium.js
set NODE_PATH=C:\Program Files\nodejs\node.exe
set APPIUM_JS_PATH=C:\npm\node_modules\appium\build\lib\main.js

rem Set the ports to be used by Appium
set PORTS=4723 4725 4727 4729

rem Start Appium for each port
for %%p in (%PORTS%) do (
    start "" "%NODE_PATH%" "%APPIUM_JS_PATH%" -a 127.0.0.1 -p %%p --log-level error
)

echo Appium servers started successfully.
exit /b