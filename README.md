# Activity Feedback Application

![Android](https://img.shields.io/badge/Platform-Android-green.svg)
![Java](https://img.shields.io/badge/Language-Java-orange.svg)
![Firebase](https://img.shields.io/badge/Backend-Firebase-yellow.svg)

## Overview

Activity Feedback Application is an Android app designed to facilitate feedback collection between professors and students. The application enables professors to create custom feedback forms with various question types and allows students to submit their responses. This solution streamlines the process of gathering and analyzing student feedback for educational activities.

## Features

### For Professors
- **User Authentication**: Secure login and registration system with role-based access
- **Dashboard**: View all created feedback forms with status indicators
- **Form Creation**: Create custom feedback forms with different question types:
  - Text questions
  - Multiple-choice questions
  - Rating scales
- **Form Management**: Activate/deactivate forms and delete forms as needed
- **Results Analysis**: View and analyze student submissions for each form

### For Students
- **User Authentication**: Secure login and registration system
- **Dashboard**: View available active feedback forms
- **Form Submission**: Submit responses to professor-created feedback forms
- **Submission Tracking**: Prevention of duplicate submissions for the same form

## Technology Stack

- **Frontend**: Native Android (Java)
- **Backend**: Firebase
  - Firebase Authentication for user management
  - Firebase Realtime Database for data storage
- **Minimum SDK**: Android API level that supports LocalDateTime (API 26+)

## Installation

1. Clone the repository:
   git clone https://github.com/AAYUSHMOHOD/AD_PBL.git


2. Open the project in Android Studio

3. Configure Firebase:
- Create a Firebase project at [Firebase Console](https://console.firebase.google.com/)
- Add an Android app to your Firebase project
- Download the `google-services.json` file and place it in the app directory
- Replace `DATABASE_URL` in `FirebaseHelper.java` with your Firebase database URL

4. Build and run the application on an Android device or emulator

## Project Structure

### Key Components

- **Activities**:
- `LoginActivity.java`: Handles user authentication
- `RegisterActivity.java`: Manages user registration
- `ProfessorDashboardActivity.java`: Main interface for professors
- `StudentDashboardActivity.java`: Main interface for students
- `FormCreationActivity.java`: Interface for creating feedback forms
- `FormSubmissionActivity.java`: Interface for students to submit forms
- `FormResultsActivity.java`: Display form submission results for professors

- **Models**:
- `User.java`: Represents application users (professors and students)
- `Form.java`: Represents feedback forms
- `Question.java`: Represents individual questions in forms
- `Submission.java`: Represents student submissions

- **Adapters**:
- `FormListAdapter.java`: Displays forms in recycler views
- `QuestionAdapter.java`: Manages question display and input
- `ResultsAdapter.java`: Displays form results

- **Utils**:
- `FirebaseHelper.java`: Centralizes Firebase operations
- `DateTimeConverter.java`: Handles date/time conversions

## Screenshots

### Authentication
<img src="https://github.com/AAYUSHMOHOD/AD_PBL/blob/master/Demo/Screenshot_20250406-173037.png" width="200" alt="Registration Screen">

### Form Creation
<img src="https://github.com/AAYUSHMOHOD/AD_PBL/blob/master/Demo/Screenshot_20250406-173249.png" width="200" alt="Create Form - Step 1">
<img src="https://github.com/AAYUSHMOHOD/AD_PBL/blob/master/Demo/Screenshot_20250406-173441.png" width="200" alt="Create Form - Step 2">
<img src="https://github.com/AAYUSHMOHOD/AD_PBL/blob/master/Demo/Screenshot_20250406-173502.png" width="200" alt="Create Form - Step 3">

### Dashboards
<img src="https://github.com/AAYUSHMOHOD/AD_PBL/blob/master/Demo/Screenshot_20250406-173711.png" width="200" alt="Professor Dashboard">
<img src="https://github.com/AAYUSHMOHOD/AD_PBL/blob/master/Demo/Screenshot_20250406-173739.png" width="200" alt="Student Dashboard">

### Form Submission
<img src="https://github.com/AAYUSHMOHOD/AD_PBL/blob/master/Demo/Screenshot_20250406-173800.png" width="200" alt="Submit Form - Step 1">
<img src="https://github.com/AAYUSHMOHOD/AD_PBL/blob/master/Demo/Screenshot_20250406-173803.png" width="200" alt="Submit Form - Step 2">

## Contributing

Contributions to improve the application are welcome. Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Contact

AAYUSHMOHOD - [GitHub Profile](https://github.com/AAYUSHMOHOD)

Project Link: [https://github.com/AAYUSHMOHOD/AD_PBL](https://github.com/AAYUSHMOHOD/AD_PBL)

---
*Last updated: 2025-04-06*
