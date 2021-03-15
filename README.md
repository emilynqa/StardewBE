# CRUD-PROJECT-STARDEW


This is the README for my CRUD application project for the QA Academy. This project was created by myself from start to finish, and this README will outline the process I went through in creating this. 

**STARDEW VALLEY VILLAGER TRACKER**


**Contents**

1. Resources
2. Brief
3. Scrum Board
4. Database Structure
5. Data Stack
6. Testing
7. Front End
8. Future Developments
9. Author

**1 - Resources**

Presentation - https://docs.google.com/presentation/d/1daD5StNXLoTP6cjvHclqBRZhFb3tUjk7bXDsgnM4RdQ/edit?usp=sharing

Scrum Board - https://enixonqa.atlassian.net/jira/software/c/projects/STAR/boards/3/roadmap?shared=&atlOrigin=eyJpIjoiYWUyMTUyNjVhNjJlNDQ0ZmEwOTYxNTUxOWQ2N2E0NTEiLCJwIjoiaiJ9

Front end - https://github.com/emilynqa/StardewFrontEnd

Images - 

**2 - Brief**

The overall objective with the project was as follows (note - this has been taken directly from the project spec)
- "To create a CRUD (Create, Read, Update, and Delete) application, with the utilisation of supporting tools, methodologies, and technologies, that encapsulate all core modules covered during training"

**3 - Scrum Board**

When it came to planning this project, I used Jira to create a scrum board, which can be accessed at the link above. It definitely differs from the average scrum sprint,
I've been planning this project for 2 weeks which is the normal time for a sprint, so had to create a sprint with a lot of elements that depended on other elements being completed first (eg, testing in the same sprint that the application was being made in), which is normally against the scrum rules, but I had to tweak them a little in this case.

**4 - Database Structure**

![image](https://user-images.githubusercontent.com/78799585/111088242-2cad4c80-851e-11eb-964d-8c66eb27a614.png)

The screenshot above is an example of the Entity Relationship Diagram (ERD) used in my project. 

**5 - Data Stack**

Database

I utilisd 2 different databases for my project, MySQL, and H2 Database. MySQL is the main database, used to have data persistence in my project, so I can turn off the web server, and it won't delete all my data when I do so. H2 was used for making a test profile, so tests would get the same results every time, because the databased used was always new and populated with known values

Back-end 

For the back-end of the project, I used Java and the Spring Boot Framework, alongside JUnit, MockMVC, and Mockito for testing. 

Front-end

The front-end of the project was made using a mixture of HTML, CSS, and JavaScript, alongside Bootstrap for help with some of the design, and Selenium for automated testing of the front end. HTML sets out the structure of the webpage and defines any components you may have in it, the styling is done using CSS and Bootstrap, and the logic, the interactions with the back end, is done using JavaScript. 

**6 - Testing**

As mentioned earlier, testing was done using JUnit, MockMVC, Mockito, and Selenium. 
The image below shows the coverage of the tests - which came out to be 88.9%. 

Integration testing - testing how different elements work together as a group, was done using MockMVC (which performs mock HTTP requests), and JUnit.

Unit Testing - testing how different elements work independently, was done using Mockito. Mockito works by mocking any dependencies you're using in a class, so in this case, it mocked my repository, which means you can test a class independantly without having to rely on the dependencies. 

Front-End Testing - Testing how the user interacts with the webpage, was done using Selenium. 

![image](https://user-images.githubusercontent.com/78799585/111088743-8f9fe300-8520-11eb-82a1-a7f44336615b.png)

**7 - Front-End**

These images are screenshots of the final front-end design. The first shows the webpage with some pre-populated villagers, and the second shows a modal that pops up when you press the update button. The background image was taken from the offical Stardew Valley wiki. 

![image](https://user-images.githubusercontent.com/78799585/111089009-ce826880-8521-11eb-92b6-45acb3185adf.png)

![image](https://user-images.githubusercontent.com/78799585/111089022-db06c100-8521-11eb-8fca-24b898a3aa68.png)

**8 - Future Developments**

There are definitely some developments to be made if I had more time to continue this project, and I will definitely be trying to fix them as a little personal project outside of work. Some of these things include; 

- Cleaning up the CSS to make the overall design of the project more cohesive

- Fixing up the selenium tests (Theres a lot of repeated code that could definitely be cut down)

**9 - Author and Acknowledgements**

I'd like to give a massive thank you to the QA Trainers, specifically Jordan and Aswene, for their help, as well as other members of my cohort.

Written by Emily Nixon











