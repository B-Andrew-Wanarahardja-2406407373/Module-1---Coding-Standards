Tutorial 1

Reflection 1
There are multiple ways clean code can be implemented. 
The Ones i tried to implement were less comments, and variable naming thing. 
The variable naming thing i did where i tried to keep the names uniform, always "productId" in the ones where it's needed.
Another place i did that was in the edit branch where i had to physically stop myself from using the variable name "i" for the for-loop and use "repoIndex" instead.
As for less comments, i think they're already clear enough to not to need comments, which is the point 
So far, i haven't seen any mistakes in the source code yet.

Reflection 2
1. After doing the unit test, i feel quite relieved. There were a few errors about dependecies and whatnot but once i went past that it was fine.
   How many unit tests should be made for a class depends on how many function are in that class, and how many possible outcomes each of those functions have.
   The more functions and possible outcomes, the more unit tests should be made. Ideally, you'd want to cover all of them.
   To make sure unit tests are enough to verify our program, we need to cover all functions and cases, as well as make sure our expected answers are actually correct.
   Even if you have 100% code coverage, it doesn't mean that your code is correct. It just means the situations you tested matched with the answers you prepared.
   For example, you want a pointer to go from index 0,1,2,4,8,..., but you only tested the first 3 steps. the answers, you prepared are correct too,
   but in actuality it goes from 0,1,2,3,4,.... Or you could accidentally provided the wrong number as the expected value as a result of human error,
   but a wrong program that happens to fit into that still shows true. In both cases, the program could still be wrong while having the code covered.

2. Well, I think it depends on if the instance variables inside the test itself have the same name. If it's only the variables in the setup, I think it's fine
   because i would want them to have the same starting point. But if it includes names of the variables in the test, then it would be a problem because
   they would be testing different things. Having the same name would be misleading. The names of those variables should be changed to better fit the
   actual thing they test.
   
---------------------------------------------------------------------------

Tutorial 2
Reflection

1. The thing is, i didn't find any issues during the exercise so i didn't really fix anything 
   either? I'll send the screenshot of the sonarCLoud on the submission for this lab

2. I think it has. CI/CD is basically automating the process of integration and deployment.
   there are the ci.yml, scorecard.yml, and sonarCloud.yml files that does the CI part
   by doing the testing. while the last one is for automatically deploying the application.
   In those files, they do the testing and deployment on the conditions set in those files.
   In this case, it is done on push, or on a pull or a certain time for some of them.
   since the code is being tested and deployed automatically, then I think it fits the
   definition of CI/CD, which is to do those things automatically. 

