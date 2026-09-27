# 📘 COMP2311 — Object-Oriented Programming

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=openjdk" alt="Java"/>
  <img src="https://img.shields.io/badge/Course-COMP2311-blue?style=for-the-badge" alt="COMP2311"/>
  <img src="https://img.shields.io/badge/Build-Maven-red?style=for-the-badge&logo=apachemaven" alt="Maven"/>
  <img src="https://img.shields.io/badge/UI-JavaFX-2496ED?style=for-the-badge" alt="JavaFX"/>
</p>

<p align="center">
  A collection of Java labs, lab-work sessions, quizzes, and course projects for<br/>
  <b>COMP2311 – Object-Oriented Programming</b>,<br/>
  covering OOP fundamentals, JavaFX desktop UIs, exception handling, and file I/O.
</p>

---

## 📖 Course Overview

COMP2311 builds on foundational Java programming and focuses on deeper
object-oriented design and desktop application development. The material
in this repository progresses from single-class exercises to full JavaFX
applications, covering:

- 🏗️ Inheritance, polymorphism, abstract classes, and interfaces
- 🔁 Recursion and recursive data processing
- 🔗 Custom data structures: singly/doubly linked-style models, cursor-style records
- 💾 File I/O — text files, binary files, and object serialization
- ⚠️ Custom exception handling
- 🖥️ Desktop GUI development with **JavaFX** (scenes, controls, event handling, styling)
- 🧩 Multi-class systems combining models, views, and business logic

> 📝 **Note:** Some of the earlier labs (solved during the course) include
> comments in Arabic — my working language at the time while learning these
> concepts. Later work follows English-only comments as a more professional
> convention.

---

## 🗂️ Repository Structure

```
Java-OOP-COMP2311/
├── src/main/java/
│   ├── Labs/                    # Official course labs (Lab01 → Lab13)
│   │   ├── Lab01/ … Lab05/      # Console-based exercises
│   │   └── Lab06/ … Lab13/      # JavaFX-based exercises (application/ subpackage)
│   │
│   ├── Labswork/                # In-class exercises solved together with the instructor
│   │   ├── Labwork_2_to_5/      # Employee hierarchy exercise
│   │   ├── Labwork_06/          # Library management system
│   │   ├── Labwork_07 → 10/     # JavaFX mini-apps (movement demo, circle app, book app, student app)
│   │
│   ├── Quizzes/                 # In-course quizzes
│   │   ├── Quiz3/                # Number conversion (JavaFX)
│   │   ├── Quiz4/                # Car rental system (JavaFX)
│   │   └── Quiz4_sec8/           # Product management system (JavaFX)
│   │
│   └── Projects/
│       └── SmartAidDistribution_Phase1/   # Console prototype — see linked repos below
│
├── src/main/resources/
├── pom.xml
└── README.md
```

---

## 📚 Lab Directory

| Lab | Topic |
|:---:|-------|
| **01** | Recursion / basic class modeling (Train & Seat) |
| **02** | Inheritance basics (Literary / Scientific student hierarchy) |
| **03** | Polymorphism & method overriding |
| **04** | Custom classes: `Time`, `Point`, student hierarchy |
| **05** | File streams — byte/bit-level I/O, custom exceptions |
| **06** | Intro to JavaFX — scenes & basic controls |
| **07** | JavaFX layouts & event handling |
| **08** | JavaFX with custom data structures (calendar-style nodes) |
| **09** | JavaFX with image assets & interactive controls |
| **10** | Object serialization + JavaFX table views |
| **11** | Exception handling in a JavaFX + console hybrid app |
| **12** | JavaFX game-style application (physics/animation basics) |
| **13** | Text processing & file-based JavaFX application |

---

## 🛠️ Technologies Used

| Tool | Purpose |
|------|---------|
| ![Java](https://img.shields.io/badge/-Java%2021-ED8B00?logo=openjdk&logoColor=white) | Core language |
| ![JavaFX](https://img.shields.io/badge/-JavaFX-2496ED?logo=java&logoColor=white) | Desktop GUI framework |
| ![Maven](https://img.shields.io/badge/-Maven-C71A36?logo=apachemaven&logoColor=white) | Build & dependency management |
| ![IntelliJ IDEA](https://img.shields.io/badge/-IntelliJ%20IDEA-000000?logo=intellijidea&logoColor=white) | Primary IDE |
| ![Git](https://img.shields.io/badge/-Git-F05032?logo=git&logoColor=white) | Version control |

---

## 🚧 Challenges & Solutions

**1. Merging many independent Eclipse projects into one Maven project**
Each lab, lab-work session, and quiz originally lived as its own standalone
Eclipse project (several sharing the same package name, `application`).
**Solution:** every lab/labwork/quiz was given a unique, path-matching
package (e.g. `Labs.Lab06.application`, `Labswork.Labwork_07.application`),
resolving all naming conflicts while keeping each JavaFX app self-contained.

**2. JavaFX resources (images, CSS) not loading after the merge**
`getClass().getResource(...)` calls started returning `null` after moving
files under `src/main/java`, since Maven only copies `src/main/resources`
to the classpath by default. **Solution:** extended `pom.xml` to also treat
`src/main/java` (excluding `.java` files) as a resource directory, so
images and stylesheets are picked up without moving every asset.

**3. Cross-package visibility after splitting single-file solutions**
Some labs originally combined multiple classes in one file to reduce file
count for submission. After splitting them into individual files across
packages, Java's default (package-private) visibility caused
`is not public` compile errors. **Solution:** made each class — and its
constructors — explicitly `public` where cross-package access was needed.

---

## ▶️ How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/A7mcdd/Java-OOP-COMP2311.git
   cd Java-OOP-COMP2311
   ```

2. **Open in IntelliJ IDEA** as a Maven project — dependencies (including
   JavaFX) resolve automatically via `pom.xml`.

3. **Run any lab/quiz/labwork**
   - Navigate to the desired class (e.g. `Labs.Lab08.application.Act1`).
   - Right-click → **Run**.
   - For console-only labs (01–05), run the file containing `main`/`Driver`.

---

## 🔗 Related Repositories

The `SmartAidDistribution` project referenced in `Projects/` has grown into
a full two-phase system, maintained separately:

- **Phase 1 (Console):** [SmartAidDistribution](https://github.com/A7mcdd/SmartAidDistribution)
- **Phase 2 (JavaFX GUI):** [SmartAidDistribution-GUI](https://github.com/A7mcdd/SmartAidDistribution-GUI)
