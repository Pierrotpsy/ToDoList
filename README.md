# ToDoList

This is a simple web application using a Maven build on a Tomcat v9.0 server and a local MySQL database.

The goal of the project was to create a simple app capable of displaying to do items and managing them.

## Implemented features

The application is capable of :
- Implementing JAAS authentication and authorization through login to secure application access and functionalities to specific users. There are two roles : **Teacher** and **Student**.
![No image](https://github.com/Pierrotpsy/ToDoList-WebApp/blob/main/Media/JAAS.PNG)
- Retrieving a list of to do items from a database and displaying it (**Teacher** & **Student**). 
![No image](https://github.com/Pierrotpsy/ToDoList-WebApp/blob/main/Media/Student.PNG)
![No image](https://github.com/Pierrotpsy/ToDoList-WebApp/blob/main/Media/Teacher.PNG)
- Editing an existing to do item (**Teacher** only).
![No image](https://github.com/Pierrotpsy/ToDoList-WebApp/blob/main/Media/Edit.PNG)
- Adding a new to do item (**Teacher** only).
![No image](https://github.com/Pierrotpsy/ToDoList-WebApp/blob/main/Media/Add.PNG)
- Deleting a to do item (**Teacher** only).
![No image](https://github.com/Pierrotpsy/ToDoList-WebApp/blob/main/Media/Delete.PNG)
- Implementing cookies to remember the last user's username at next login.
![No image](https://github.com/Pierrotpsy/ToDoList-WebApp/blob/main/Media/cookie.PNG)
- Allowing the user to log out at any time.
- Remembering the user's username throughout his use of the app.
![No image](https://github.com/Pierrotpsy/ToDoList-WebApp/blob/main/Media/usernameAndlogout.PNG)

## Non-implemented features
All the features asked for in the project description have been implemented.

## Further development
- Making the GUI better through better `css` and `html` files. This would go a long way towards making this project good, as all the functionalities are already there.

- Adding HTTPS. I tried doing this, but encountered an HTTP buffer error. I tried fixing it but it didn't work. Definitely an improvement that can be made easily enough with more time to debug everything.

- Adding a state to the tasks, kind of like the *Kanban* method. I would have to modify the database to achieve this though, which is why I didn't implement it here. But it would be cool for students to complete tasks, which would then be shown to the teachers who could decide if they want to delete them or not.

- Add a system of instances to allow teachers to possess several to do lists and manage the students accesses directly on the webapp.
