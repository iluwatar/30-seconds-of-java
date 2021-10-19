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
