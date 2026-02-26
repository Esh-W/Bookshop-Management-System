@echo off
setlocal
cd /d "%~dp0"

where javaw >nul 2>&1
if errorlevel 1 (
  echo.
  echo Java was not found.
  echo Install Java 17 or later, then run this file again.
  pause
  exit /b 1
)

start "" javaw -jar City_Bookshop.jar
exit /b 0
