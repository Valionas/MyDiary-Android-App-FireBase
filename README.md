# MyDiary-Android-App-FireBase
My Diary
Android Project (Java)
Developed by Valentin Kolev

1.	Basic Layout Description:
The project has the functionality of a typical diary. Every user can use the CRUD operations in order to manage his tasks in the diary. 
The tasks are ordered in a list and displayed on the Home activity screen, when the user logins successfully.
For now, every item in the task lists consists of Task Name and Task Description. Users can track their ideas by using the functionality of the application.
2.	Functionality overview
The application has a Main activity, which serves as a pre-login loading screen with a book logo and project name on it. It renders with some simple animations, before it starts the Login Activity ( by default ).
The user has two options – to login or to sign up, if he/she doesn’t have an account.
The Authentication process and the Data Base functionality are created by using the provided methods from Fire Base. 
The application is registered as android application in Fire Base console. There, the admin or future developer can control the flow of the data.
The login/register functionalities have basic validation checkers for empty fields, which will prevent the user to establish successful connection with Fire Base, if he/she doesn’t follow the rules.
Every task in the application is created on the base of Model java class , which has the properties of the task and the methods , which modify it – addTask, removeTask, updateTask etc.
The tasks are clickable and once they are clicked, a dialog prompt window is shown on the screen where the user can create or update its task, depending on the chosen button (Add task from the plus sign in the bottom-right corner or Update from the Add task dialog).
The layouts follow one design , which is stored in res folder ( mostly the gradient background , which is used as a background almost everywhere)
3.	Instructions for usage
If someone wants to use the application for its own personal use, he/she should change the SHA code in the gradle options , following the Fire Base documentation. The developer/admin of the app must create its own project storage in Fire Base and establish a connection between the app and the Fire Base console, different from the provided one, which is used by the writer of this article.
4.	Purpose and future updates/ideas
The purpose of the app is to help people to track their ideas or thoughts throughout the day. By following their thoughts, people can structure their daily life easier. In the end of the day, it is completely normal to forget something and we can prevent this from happening by using My Diary app on our phones.
In the future, other developers could use Cloud Storage to add images to the different tasks or create an Account Profile layout which will also have a profile picture. 
Implementing reminders about each task is also a good target , to help users to better maintain their tasks and keep track on their personal progress.
