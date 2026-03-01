Tutorial 1

Reflection 1
There are multiple ways clean code can be implemented. 
The Ones I tried to implement were fewer comments, and variable naming thing. 
The variable naming thing I did where I tried to keep the names uniform, always "productId" in the ones where it's needed.
Another place I did that was in the edit branch where I had to physically stop myself from using the variable name "i" for the for-loop and use "repoIndex" instead.
As for fewer comments, I think they're already clear enough not to need comments, which is the point 
So far, I haven't seen any mistakes in the source code yet.

Reflection 2
1. After doing the unit test, I feel quite relieved. There were a few errors about dependencies and whatnot but once I went past that it was fine.
   How many unit tests should be made for a class depends on how many function are in that class, and how many possible outcomes each of those functions have.
   The more functions and possible outcomes, the more unit tests should be made. Ideally, you'd want to cover all of them.
   To make sure unit tests are enough to verify our program, we need to cover all functions and cases, as well as make sure our expected answers are actually correct.
   Even if you have 100% code coverage, it doesn't mean that your code is correct. It just means the situations you tested matched with the answers you prepared.
   For example, you want a pointer to go from index 0,1,2,4,8,..., but you only tested the first 3 steps. the answers, you prepared are correct too,
   but in actuality it goes from 0,1,2,3,4,.... Or you could accidentally provide the wrong number as the expected value as a result of human error,
   but a wrong program that happens to fit into that still shows true. In both cases, the program could still be wrong while having the code covered.

2. Well, I think it depends on if the instance variables inside the test itself have the same name. If it's only the variables in the setup, I think it's fine
   because I would want them to have the same starting point. But if it includes names of the variables in the test, then it would be a problem because
   they would be testing different things. Having the same name would be misleading. The names of those variables should be changed to better fit the
   actual thing they test.
   
---------------------------------------------------------------------------

Tutorial 2
Reflection

1. The thing is, I didn't find any issues during the exercise, so I didn't really fix anything 
   either? I'll send the screenshot of the sonarCLoud on the submission for this lab

2. I think it has. CI/CD is basically automating the process of integration and deployment.
   there are the ci.yml, scorecard.yml, and sonarCloud.yml files that does the CI part
   by doing the testing. while the last one is for automatically deploying the application.
   In those files, they do the testing and deployment on the conditions set in those files.
   In this case, it is done on push, or on a pull or a certain time for some of them.
   since the code is being tested and deployed automatically, then I think it fits the
   definition of CI/CD, which is to do those things automatically. 

---------------------------------------------------------------------------

1. Single Responsibility Principle
   So it turns out I was supposed to make the controller for car in the ProductController at 
   first, then apply SRP to it. So the class ProductController is responsible only for being the 
   controller for products and the car part should be split into another file CarController.
   I thought that was a typo but apparently not. Anyway, my CarController is already split since
   I first made it.
   
   doing this can have benefits like quicker error identification. For example, while testing I 
   found that there was an error where after I finished filling in the form to create a car, it 
   redirected to the wrong place. because I separated the controllers for product and car, I can
   directly go to CarController.java and fix the function responsible. If I hadn't, then I 
   would've gone to ProductController.java instead with a longer list of functions that I have 
   to comb through before finding the responsible for the wrong redirection

2. Open-Closed Principle
   The Open-Closed principle states that things should be open to extension but closed for 
   modification. In other words, if there are additional things in the future, then it should
   not change the behavior of the current object but instead extend from it. 
    
   In here I tried
   to implement it by making the class CarRepository into an interface instead, so that if 
   in the future I wanted to another kind of car, I could just implement from the interface.
   if I don't do it, then if I wanted to add another type of car I'd have to change the 
   behavior of the current class or make another class with mostly the same content but
   with minor differences.

3. Liskov Substitution Principle
   The Liskov Substitution Principle states that A child must be able to substitute its 
   parent without changing the behavior. In here there aren't any classes that extend,
   only implement from an interface. This shouldn't change any behavior as long as there
   aren't any exception throwing so it should be fine in here. 

4. Interface Segregation Principle
   The Interface Segregation Principle (ISP) is a principle that states that a class should
   only need to implement the functions it actually needs. so if a class implements a certain
   interface with 5 methods but actually only needs 3 of them, then the interface should be
   split between the needed 3 and the other 2. Then the class would only implement the 3
   methods it needs. By doing this we can avoid redundant code, code that we implement but 
   is actually useless, only implemented so that all methods of the interface are implemented.
   If we don't there will be a bunch of code that doesn't really do anything. In here, all
   methods of the interface are implemented with actual, useful functions, so I think that
   the Interface Segregation Principle has been fulfilled.

5. Dependency Inversion Principle
depend on abstraction instead of concrete classes
Done on CarController.java : CarServiceImpl (concrete) → CarService (interface, abstract)

Doing this can make testing easier. For example if I already had some data stored in and I 
wanted to check if the delete function works, then using mocks it would create a dummy that
won't affect the actual data. Not doing this could risk changing existing data that may or
may not be useful.