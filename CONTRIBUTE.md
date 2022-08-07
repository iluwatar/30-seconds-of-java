# How to contribute

In general, we are interested in well implemented standalone code snippets. There are some tasks that we would like to
see implemented in the [issue list](https://github.com/iluwatar/30-seconds-of-java/issues). Please raise a new issue
if there's an interesting snippet you would like to see in this library but can't implement yourself. Please comment on the issue that you are implementing it so that others do not work on the same thing.

For new snippets the general implementation steps are:

* Create new class inside section-package for example`algorithm.BubbleSortSnippet.java` with the new code snippet. 
* Add a test for the new code snippet in `algorithm.BubbleSortSnippetTest.java`.
* If you want to create new section then create new package, class and tests for it.
* Finally, insert the new snippet into this `README.md`.
* Submit pull request against `master` branch.

In case you are a first-time contributor and would like to become familiar with working in Github, check out the tutorial in this [repository](https://github.com/firstcontributions/first-contributions).

## Building the project

Building the project's `master` branch is straightforward.

```
./gradlew clean
./gradlew build
```


## Checkstyle

The project uses Checkstyle and sometimes the build can fail due to rule violations, e.g.

```
> Task :checkstyleTest FAILED
[ant:checkstyle] [WARN] /home/ilkka/30-seconds-of-java/src/test/java/math/GenerateRandomNumbersSnippetTest.java:24: 'package' should be separated from previous statement. [EmptyLineSeparator]

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':checkstyleTest'.
> Checkstyle rule violations were found. See the report at: file:///home/ilkka/30-seconds-of-java/build/reports/checkstyle/test.html
  Checkstyle files with violations: 1
  Checkstyle violations by severity: [warning:1]
```

The violations are easy check and fix using the indicated report file. IDEs also have Checkstyle plugins for better developer experience.

## License check

The project is configured to check that the source code files have proper license headers. When new source code files are added, they should also contain the license headers. It's easy to copy-paste them from other files or even better to use the Gradle license formatting plugin e.g. `./gradlew licenseFormat` to add missing license headers.
