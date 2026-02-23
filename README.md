# Bookshop Management System

A Java Swing desktop application for managing a bookshop. The project uses NetBeans/Ant and stores data in text files.

## Features
- User login and account creation
- Manage books and categories
- Role-based users (Manager, Cashier)
- Simple file-based storage

## Project Structure
- `src/` Java source code (GUI, services, models)
- `build.xml` Ant build script
- `books.txt`, `categories.txt`, `users.txt` data files

## Requirements
- Java JDK 8 or later
- NetBeans (recommended) or Apache Ant

## Run (NetBeans)
1. Open the project folder in NetBeans.
2. Right-click the project and choose **Run**.

## Run (Ant)
From the project root:
```
ant
ant clean
ant run
```

## Notes
- Data is stored in plain text files in the project root.
- The main entry point is `src/main/Main.java`.
