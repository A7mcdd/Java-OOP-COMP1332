# 📘 COMP1331 — Computer and Programming

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=openjdk" alt="Java"/>
  <img src="https://img.shields.io/badge/Course-COMP1331-blue?style=for-the-badge" alt="COMP1331"/>
  <img src="https://img.shields.io/badge/Paradigm-OOP-purple?style=for-the-badge" alt="OOP"/>
  <img src="https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge" alt="Status"/>
</p>

<p align="center">
  A collection of Java lab solutions for <b>COMP1331 – Computer and Programming</b>,<br/>
  a foundational Object-Oriented Programming course,<br/>
  based on the course's official Lab Manual.
</p>

---

## 📖 Course Overview

COMP1331 introduces students to programming fundamentals and object-oriented
programming (OOP) concepts using **Java**. The course progresses from basic
syntax and control structures to full OOP design, covering:

- 🧩 Primitive data types, variables, operators, and expressions
- 🔀 Selection statements (`if`, `if-else`, `switch`)
- 🔁 Loops (`while`, `do-while`, `for`) and nested loops
- 🧮 Methods, the `Math` class, and pass-by-value semantics
- ♻️ Recursion and recursive problem solving
- 🏗️ Classes, objects, constructors, and encapsulation
- 📦 Single- and multi-dimensional arrays
- 🔤 String processing and the `StringBuilder` class
- ⚠️ Exception handling and file (text) I/O
- 🧠 Object-oriented thinking: association, aggregation, composition, and wrapper classes

Each lab in this repository corresponds to one chapter of the official
**Lab Manual** (included as a PDF for reference) and contains my own
implementation of the lab activities.

---

## 🗂️ Repository Structure

```
Java-Basics-COMP1331/
├── src/
│   ├── Labs/
│   │   ├── Lab_01/                 # Elementary Java Programming
│   │   │   ├── Act1.java
│   │   │   ├── Act2.java
│   │   │   └── ...
│   │   ├── Lab_02/                 # Selections
│   │   ├── Lab_03/                 # Loops
│   │   ├── Lab_04/                 # Methods
│   │   ├── Lab_05/                 # Recursion
│   │   ├── Lab_06/                 # Objects and Classes (Part I)
│   │   │   ├── Act1/
│   │   │   ├── Act2/
│   │   │   └── Act3/
│   │   ├── Lab_07/                 # Objects and Classes (Part II)
│   │   ├── Lab_08/                 # Single-Dimensional Arrays
│   │   ├── Lab_09/                 # Multidimensional Arrays
│   │   ├── Lab_10/                 # Strings
│   │   ├── Lab_11/                 # Exception Handling & Text I/O
│   │   └── Lab_12/                 # Object-Oriented Thinking
│   └── Projects/
│       └── VehicleRentalSystem/    # Course mini-project
├── COMP1331--Lab_Manual.pdf        # Official lab manual (reference)
└── README.md
```

> 💡 Activities that require more than one class (e.g., a class + a driver/test
> program) are organized into their own `ActX/` sub-folder, while single-file
> activities live directly inside the lab folder.

---

## 📚 Lab Directory & Syllabus

| Lab | Topic | Key Concepts Covered |
|:---:|-------|-----------------------|
| **01** | Elementary Java Programming | Java syntax, `System.out`, `Scanner`, variables, expressions, basic computation |
| **02** | Selections | `if` / `if-else` / nested `if`, relational & logical operators, `switch` statements |
| **03** | Loops | `while`, `do-while`, `for`, nested loops, `break` & `continue` |
| **04** | Methods | Method definition & invocation, return values, pass-by-value, the `Math` class |
| **05** | Recursion | Recursive methods, base cases, recursive problem decomposition |
| **06** | Objects and Classes (Part I) | Class design, constructors, instance data fields, UML class diagrams |
| **07** | Objects and Classes (Part II) | `static` vs. instance members, encapsulation, getters/setters, the `this` keyword, `Date` & `Random` |
| **08** | Single-Dimensional Arrays | Array declaration/creation, traversal, array arguments & return values |
| **09** | Multidimensional Arrays | 2D/3D arrays, ragged arrays, arrays of objects, matrix operations |
| **10** | Strings | `String` methods, comparison, substrings, `StringBuilder`, custom string classes |
| **11** | Exception Handling & Text I/O | `try-catch`, the `File` class, `PrintWriter`, reading/writing text files |
| **12** | Object-Oriented Thinking | Class abstraction & encapsulation, association/aggregation/composition, wrapper classes, `BigInteger` |

---

## 🛠️ Technologies Used

| Tool | Purpose |
|------|---------|
| ![Java](https://img.shields.io/badge/-Java-ED8B00?logo=openjdk&logoColor=white) | Core programming language |
| ![JDK](https://img.shields.io/badge/-JDK-007396?logo=java&logoColor=white) | Java Development Kit (compiling & running) |
| ![IntelliJ IDEA](https://img.shields.io/badge/-IntelliJ%20IDEA-000000?logo=intellijidea&logoColor=white) | Primary IDE used for development |
| ![Eclipse](https://img.shields.io/badge/-Eclipse-2C2255?logo=eclipseide&logoColor=white) | IDE referenced in the official lab manual |
| ![Git](https://img.shields.io/badge/-Git-F05032?logo=git&logoColor=white) | Version control |
| ![GitHub](https://img.shields.io/badge/-GitHub-181717?logo=github&logoColor=white) | Hosting & showcasing the repository |

---

## 🚧 Challenges & Solutions

**1. Managing multiple classes per activity**
Several activities (e.g., `Rectangle`, `Fan`, `Account`, `LinearEquation`) required a
dedicated class plus a separate driver/test class. Keeping both in the same
flat folder made navigation confusing. **Solution:** each multi-file activity
was given its own sub-folder (`Act1/`, `Act2/`, ...) containing the class and
its driver, which keeps the project organized and mirrors how larger Java
projects are structured in practice.

**2. Correctly applying encapsulation and the `this` keyword**
Early on, it was easy to confuse instance variables with local parameters of
the same name (e.g., inside constructors). **Solution:** consistently using
`private` fields with dedicated getter/setter methods, and using `this.field`
to disambiguate constructor parameters, made the classes safer and easier to
debug — reinforcing good OOP habits for later, more complex labs.

**3. Handling files and exceptions robustly**
Reading/writing text files (Lab 11) introduced checked exceptions and edge
cases like out-of-range array indices or missing files. **Solution:** wrapping
risky operations in `try-catch` blocks and validating input before processing
made the programs fail gracefully instead of crashing, which carried over
as a good practice into the course's final `VehicleRentalSystem` project.

---

## ▶️ How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/A7mcdd/Java-Basics-COMP1331.git
   cd Java-Basics-COMP1331
   ```

2. **Open in an IDE**
    - **IntelliJ IDEA:** `File → Open` → select the project folder.
    - **Eclipse:** `File → Import → Existing Projects into Workspace` → select the project folder.

3. **Run any activity**
    - Navigate to the desired lab folder (e.g., `src/Labs/Lab_04/Act2.java`).
    - Right-click the file → **Run**, or use the IDE's green ▶️ run button.
    - For multi-class activities, run the file containing the `Driver` / `main` method.

4. **(Optional) Run from the command line**
   ```bash
   javac src/Labs/Lab_04/Act2.java
   java -cp src Labs.Lab_04.Act2
   ```

---

<p align="center">📄 Based on the official <b>COMP1331 Lab Manual</b>.</p>