# FilmQueryProject
This program displays film data based on input from a user.  It uses a local database to store information on each film and incorporates a limited menu to search the database.  The user interacts with the menu by selecting a menu item to create a query to find and display films by ID or keyword.

# Technoologies
Java SE8, MySQL/MAMP, JDBC, Git/Github, Eclipse IDE, ATOM, Maven

#Skills Applied
This application provided a good opportunity to practice several of the skills taught during week seven such as: JDBC, relational databases, MySQL, and Object-Relational Mapping (ORM).

#Challenges and Lessons Learned
My first problem was getting Maven to work with Eclipse. Initially, the Maven POM.xml file was showing several errors that prevented me from compiling the code.  This was resolved by clearing out the .m2 file in Maven using the following command .m2 .m2back.

Once the Maven problem was resolved, I came across several coding challenges during the course of developing this application.  One challenge involved searching for and printing the keyword search results.  If implemented incorrectly, attempting to print the the resulting list of Films could result in a null pointer error.  I chose to address this problem with a series of conditional statements and try-catch blocks.

Another problem that came up during the development was an unintentional
automatic printing of the Film List toString after selecting option "2" to search for film by keyword.  This appeared to be due to using the same variable for the initial selection (1 - 3) scanner and the scanner to input the search keyword.  The code appeared to be automatically sending that number "2" to the second instance of the scanner after a short delay.  I resolved this problem by changing the variable name in the second loop.

Finally, I experienced a problem with the try catch loop block within the
while loop of the startUserInterface method. Before I modified my code, the catch block would only end the program instead of looping back and requesting to input a number between 1 and 3.  


#Assignment
Bellow you will find a copy of the user stories and task objectives.

****************

Overview:
    You will create a command-line application that retrieves and displays film data. It will be menu-based, allowing the user to choose actions and submit query data.

User Stories
    User Story 1
    The user is presented with a menu in which they can choose to:

    Look up a film by its id.
    Look up a film by a search keyword.
    Exit the application.
    User Story 2
    If the user looks up a film by id, they are prompted to enter the film id. If the film is not found, they see a message saying so. If the film is found, its title, year, rating, and description are displayed.

    User Story 3
    If the user looks up a film by search keyword, they are prompted to enter it. If no matching films are found, they see a message saying so. Otherwise, they see a list of films for which the search term was found anywhere in the title or description, with each film displayed exactly as it is for User Story 2.

    User Story 4
    When a film is displayed, its language (English,Japanese, etc.) is also displayed.

    User Story 5
    When a film is displayed, the list of actors in its cast is displayed along with the title, year, rating, and description.

****************

