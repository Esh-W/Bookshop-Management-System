@echo off
setlocal
cd /d "%~dp0"

java -jar City_Bookshop.jar
if errorlevel 1 (
  echo.
  echo Failed to start City Bookshop.
  echo Make sure Java 17 or later is installed and available in PATH.
  pause
)
