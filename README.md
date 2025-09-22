# 🎄 Advent of Code — My Solutions

This repository contains my solutions to [Advent of Code](https://adventofcode.com/) puzzles, organized **by year** and designed to be **clear, tested, and reproducible**.

I use this project to:
- **Challenge myself** with algorithmic problems;
- **Practice software engineering fundamentals** (clean code, tests, performance, tooling);
- **Show how I think**: structure, trade-offs, and documentation.

> ✅ This repo intentionally favors **Java** to stretch my skills: stronger type system, explicitness, and a mature testing/build ecosystem (JUnit + Gradle) make it a great environment to practice maintainable solutions at scale.

---

## 🧭 Organization

Each year lives in its own directory with a consistent structure:

```
├─ 2023/
│ ├─ java/
│ │ ├─ day01/solution.java
│ │ └─ day01/resources/input.txt
│ ├─ test/
│ │ ├─ day01/...
│ │ └─ day02/...
├─ 2024/
│ └─ ...
```

**Why this layout?**
- **Per-year** folders keep AoC editions isolated.
- **`java/dayXX/solution.java`**: one place per day for code.
- **`resources/input.txt`**: personal puzzle input next to the solution.
- **`test/dayXX/`**: tests/samples without over-engineering.

> If a day needs helpers (parsers, grid utils, etc.), add extra files in the same `dayXX/` folder (e.g., `Parser.java`, `Utils.java`). Keep it local and simple.

---

## 🔧 Conventions

- **File names**: `solution.java` with a `main(String[] args)` that prints answers for Part 1 and Part 2.
- **Input**: read from `resources/input.txt` by default.

## ▶️ Running a Day (no build tools)

From the year folder, compile and run a specific day:

```bash
# Example for 2023/day01
cd 2023/java/day01

# compile
javac solution.java

# run (default: reads resources/input.txt)
java solution
```

---

## 🧪 Tests

I keep tests simple and close to the solutions. Each year has a `test/` folder mirroring the days:

```
2023/
 ├─ java/day01/solution.java
 └─ test/day01/TestDay01.java
```

How to run the test
```bash
cd 2023/test/day01
javac -cp ../../java/day01 TestDay01.java
java -cp .:../../java/day01 TestDay01
```
---

## 💡 Why Java for this repo?

I chose **Java** as my main language here because:

* 🧱 It forces me to **think in structure and types**, instead of quick hacks.
* 🧪 Its ecosystem (JUnit, Gradle) makes it natural to practice **testing and engineering habits**.
* 🚀 It’s verbose compared to Python, which makes it a **better challenge** for writing clean abstractions and reusable code.
* 🌍 Java runs anywhere with a JDK, so solutions stay portable.

This isn’t about the fastest one-liner solutions—it’s about **growing as a software engineer** while solving fun puzzles.

