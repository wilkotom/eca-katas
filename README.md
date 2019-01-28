# Practice your Programming With Katas

You will find the starter code / unit tests for each session of the course here.

## Java Users:

The unit testing framework I'm using is JUnit 4. You can download the relevant JAR file [here](https://github.com/junit-team/junit4/releases/tag/r4.12).

For recent releases of JUnit, you will also need [Hamcrest](https://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest/2.1/hamcrest-2.1.jar).

The most basic way of running the tests is something like:

```
$ CLASSPATH=junit-4.12.jar:hamcrest-2.1.jar:. javac *.java
$ CLASSPATH=junit-4.12.jar:hamcrest-2.1.jar:. java TestRunner
```

However your IDE may have better support.
