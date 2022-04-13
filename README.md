# Data-driven-testing using k6
# Introduction
This template will help you to implement a data driven testing with k6 framework. k6 is a modern load testing tool,and we have used following Libraries
http,encoding and htmlReport by simply import in this template. We have also used papaparse because we used CSV file as our test data. So the template will basically help you to have an integrated data driven testing framework using k6
# What is data driven testing framework
A data driven testing framework is a technique in which you keep input test data separate from the actual test script.This DDT framework is totally dependent on the input test data. There are majorly two components in the data-driven testing framework. First is the test script and second test data. The test data set is created in external sources such as an excel file, csv file, xml file, or any database (In this template we are using excel file in .csv format). After that we connect the test script with test data to retrieve multiple sets of data to perform the application under test.
# About the project
Basically k6 was previously called load impact and is an open-source load testing tool for testing the performance of APIs, microservices, and websites also. Using k6, you can test the reliability and performance of your systems and catch performance regressions and problems earlier and in this project we use post request to test the performance of login functality with different user.
# Technologies Used
> Programming language - Javascript

> Automation tool - grafana-k6

> IDE - Visual Studio Code(vs-code)
# Libraries Used
# SharedArray
    import { SharedArray } from "k6/data"
# http
    import http from "k6/http";
# papaparse
    import papaparse from "https://jslib.k6.io/papaparse/5.1.1/index.js"
# encoding
    import encoding from 'k6/encoding';
# check
    import { check } from 'k6';
# htmlReport
    import { htmlReport } from "https://raw.githubusercontent.com/benc-uk/k6-reporter/main/dist/bundle.js";
# textSummary
    import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';
# Steps for execution
Clone the repository on your local system. vs-code will resolve all the required dependencies and then Download k6.
# install k6
# Mac
Install with Homebrew by running:
    
    brew install k6
# Windows
If you use the Chocolatey package manager you can install the unofficial k6 package with:
      
      choco install k6
Otherwise, you can manually download and install the [latest official .msi package.](https://dl.k6.io/msi/k6-latest-amd64.msi)
# Linux
For Debian-based Linux distributions like Ubuntu, you can install k6 from the private deb repo like this:
* sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys C5AD17C747E3415A3642D57D77C6C491D6AC1D69
* echo "deb https://dl.k6.io/deb stable main" | sudo tee /etc/apt/sources.list.d/k6.list
* sudo apt-get update
* sudo apt-get install k6

> open terminal in project location and type k6 run FileName.js

> Now the tests will be execute on your machine.

> We have used a login functioanlity and excel test data in this template but you can change it accordingly.

> For a better understanding please refer to this blog:- [click here](https://blog.knoldus.com/api-load-testing-with-k6-in-a-data-driven-framework/)
