CraigList cucumber-selenide-maven
=================
CucumberJVM template project using [Selenide](http://selenide.org/) framework for running tests in parallel. Two options how to run:
 1. One "Runner" class per thread (use profile `parallel`). By "Runner" class is meant *RunCukesCheeseTest* class in this example.
    * **NOTE** - in order to use this approach, you will need to create separate "runner" class per one thread. Tests belonging to one "runner" class will be executed sequentially.
    * More on this read [here](https://opencredo.com/running-cucumber-jvm-tests-in-parallel/).
 2. Using [cucumber-jvm-parallel-plugin](https://github.com/temyers/cucumber-jvm-parallel-plugin) (use profile `parallelPlugin`)
    * *cucumber-jvm-parallel-plugin* will automatically generates "runner" classes.
    * More on this read [here](http://automationrhapsody.com/running-cucumber-tests-in-parallel/).
### Command for execution
```
mvn clean verify -P [singleThreaded,nogrid,grid,parallel,parallelPlugin]
```
* Maven profiles:
    * *singleThreaded* - execute tests sequentially, omits parallel execution
    * *nogrid* - execute tests locally
    * *grid* - execute tests on Selenium Grid. Grid Hub can be set in pom in `seleniumGridURL` property
* Thread count can be set via `-Dthreads` argument
* Selenium Grid URL - `-DseleniumGridURL`

For example, invoking `mvn clean verify -P nogrid,parallelPlugin -Dthreads=10` will execute tests in parallel 10 threads on local machine and using *cucumber-jvm-parallel-plugin* plugin.

#### Sample command for Selenium Grid execution
```
mvn clean verify -Dbrowser=firefox -Dthreads=3 -P parallelPlugin,grid -DseleniumGridURL=""
```

### Reporting
Reports are generated by [maven-cucumber-reporting](https://github.com/damianszczepanik/maven-cucumber-reporting) plugin and can be found under *target/site/cucumber-reports/cucumber-html-reports*


## Selenide
### Advantages of Selenide
 * Simple DSL
 * Automatic waiting for elements
 * No need in `PageFactory.initElements`
 
### Things To Consider
* Screenshots generated only when Condition in `should*` methods fail
* `should*` automatically waits for condition (useful when working with web sockets)

#### [Screenshots](https://selenide.org/documentation/screenshots.html)
Selenide takes screenshots automatically on every test failure. This is very useful for error analysis.

By default Selenide puts screenshots to folder build/reports/tests.

Can I tell Selenide to put screenshots to a specific folder?
Yes. You can use property -Dselenide.reports=test-result/reports to set any directory to store screenshots to.

Another option is to set this folder directly from your code:

Configuration.reportsFolder = "test-result/reports"; 



