@echo off
cd /d C:\Projects_Automation\My_Demo_Frame_work

echo Cleaning old test reports...
rmdir /s /q test-output

echo Cleaning project...
mvn clean > output.log 2>&1

echo Installing dependencies...
mvn install >> output.log 2>&1

echo Running tests...
mvn test >> output.log 2>&1

echo Build and test execution completed!
echo Check output.log for details.
pause
