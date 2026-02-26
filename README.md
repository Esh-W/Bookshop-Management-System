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
- `data/` data files (`books.txt`, `categories.txt`, `users.txt`)

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

## Run without Ant (Windows / PowerShell)
If Ant is not installed, run from existing compiled classes:
```
$cp = "build/classes;lib/flatlaf-3.7.jar;lib/flatlaf-extras-3.7.jar;lib/jsvg-2.0.0.jar;lib/jsvg-1.4.0.jar"
java -cp $cp main.Main
```

## Release Checklist
- Build successfully in NetBeans (**Clean and Build**).
- Verify login, add category, add book, and account creation flows.
- Confirm files in `data/` are writable on the target machine.
- Ensure JDK is installed on the target machine.
- Package from NetBeans output (`dist/`) for distribution.

## Distribution Run (Windows)
- Open the `dist/` folder.
- Double-click `run.bat` to launch the app.
- Or run manually: `java -jar City_Bookshop.jar` (from inside `dist/`).

## Data Backup & Restore
- Backup: copy the full `data/` folder (`books.txt`, `categories.txt`, `users.txt`) to a safe location.
- Restore: close the app, replace the target machine's `data/` folder with the backup, then reopen the app.
- Recommended: keep dated backups (for example, one backup per day).

## Notes
- Data is stored in plain text files in the `data/` folder.
- The main entry point is `src/main/Main.java`.
