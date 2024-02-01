@echo off

REM Set the process name for Appium
set PROCESS_NAME=appium

REM Find the process ID (PID) of the running Appium instance
for /f "tokens=2" %%i in ('tasklist ^| findstr /i "%PROCESS_NAME%"') do set PID=%%i

REM Check if Appium is running
if defined PID (
    REM Terminate the Appium instance
    taskkill /F /PID %PID%
    echo Appium instance terminated successfully.
) else (
    echo Appium is not running.
)