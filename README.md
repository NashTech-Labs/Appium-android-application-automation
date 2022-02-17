# Data driven testing using Appium
# Introduction
This template will help you to implement a data driven mobile testing framework. The most famous tool for mobile testing applications is Appium and we have used selenium Androiddriver in this template. We have also used apache poi because we used excel file as our test data. So the template will basically help you to have an integrated data driven testing framework using Appium(GUI)
# What is data driven testing framework
A data driven testing framework is a technique in which you keep input test data separate from the actual test script.This DDT framework is totally dependent on the input test data. There are majorly two components in the data-driven testing framework. First is the test script and second test data. The test data set is created in external sources such as an excel file, csv file, xml file, or any database (In this template we are using excel file in .xlsx format) . After that we connect the test script with test data to retrieve multiple sets of data to perform the application under test.
# About the project
Basically appium is a mobile testing framework which have capability to test android as well as IOs devices but in my case we test the android device and use a emulator(virtual device) along with we use phone-dialer mobile application for automation and testing purpose.  
# Technologies Used
Programming language - Java

Build tool - Maven

Automation tool - Appium
                  
                  1.Appium Server
                  2.Appium Inspector

IDE - Intellij Idea

Android Studio-

               1.Emulator(Android)
               2.Ui automator
               3.Android Version

# Main Dependencies Used
# Appium java client
    <dependency>
        <groupId>io.appium</groupId>
        <artifactId>java-client</artifactId>
        <version>7.5.1</version>
    </dependency>
# Selenium java    
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
 # Junit    
     <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
    </dependency>
# Apache poi
      <dependency>
          <groupId>org.apache.poi</groupId>
          <artifactId>poi-ooxml</artifactId>
          <version>5.0.0</version>
          <scope>test</scope>
      </dependency> 
# Steps for execution
Clone the repository on your local system.
Intellij will resolve all the required dependencies and then Download Appium.

1.To download the appium(terminal based):

Go to the terminal and execute following commands steps by steps:
 
 > brew install node      # get node.js

 > npm install -g appium  # get appium

 > npm install wd         # get appium client

 > appium &               # start appium

 > node your-appium-test.js

2.To download appium destop(GUI based):
  click on given link https://github.com/appium/appium-desktop/releases/latest
    
After download appium start appium server.

Download the android studio from here https://developer.android.com/studio

After download android studio start an android emulator

open terminal in project location and type mvn test 

Now the tests will be execute on your machine.

We have used a dialer(phone) android application and excel test data in this template but you can change it accordingly.

For a better understanding please refer to this blog:- https://blog.knoldus.com/automate-android-app-in-appium-with-data-driven-framework/
