IDEA-220969 issue reproduced
---

Simple project to reproduce IntelliJ 2019.2 performance issue.
Contains test factory generating tests that flood console output.

I'm not sure if it's exactly the same problem, but looks pretty similar from VirtualVM perspective:
Fast memory consumption growth + lots of coroutine objects in memory

My assumption is that problem appears when TestNG tests producing lot of output are executed inside IDE using Gradle runner.


### How to use?
 
    1. Check out project
    2. Open in IntelliJ IDEA 2019.2+ as gradle project
    3. Open IDE built-in gradle console
    4. Execute tasks > tests > javaFloodTest
    
    Expected result: tests are executed successfully (try executng tests with IDE platform runner to see expected results)
    Actual result: gradle worker stops / IDE runs out of memory / test execution proccess hangs etc 
    (on sample project results are different)