# JavaFX Employee Performance Dashboard

> A complete JavaFX GUI project built with Scene Builder — Java 3 Lab & Lecture Series

![Java](https://img.shields.io/badge/Java-17+-blue) ![JavaFX](https://img.shields.io/badge/JavaFX-enabled-blue) ![Scene Builder](https://img.shields.io/badge/Scene%20Builder-visual%20layout-teal) ![Educational](https://img.shields.io/badge/Educational-2026-orange)

---

## About the Project

This project is a full JavaFX desktop application built as part of the **Java 3 Lab and Lecture** series, instructed by **Aya Al-Harazin** (Teaching Assistant, 2026).

It demonstrates how to:
- Design a GUI visually using **Scene Builder**
- Connect it to a Java controller using `@FXML`
- Apply **CSS styling**
- Handle events, read/write files, and load FXML using `FXMLLoader`

Students follow along from scratch — from installing Scene Builder all the way to building a working, styled, and functional HR review dashboard.

---

## Features

| Feature | Description |
|---|---|
| 🖼 Scene Builder GUI | Full layout built visually with `BorderPane`, `HBox`, `VBox`, `MenuBar`, and more |
| 🎨 CSS Styling | Custom `style.css` with named styleClasses applied to all components |
| 📂 File Handling | Upload comments from a file using `FileChooser` and save reviews to `emps.txt` |
| 🔔 Alert Dialogs | Reusable `showAlert()` helper for INFO and WARNING alert types |
| 🔡 Dynamic Font Slider | Slider controls TextArea font size live via `setStyle()` |
| ✅ Input Validation | Validates DatePicker and TextArea before saving any data |

---

## Project Structure

```
javafx-employee-dashboard-java3/
  src/week6/
    TestController.java   ← main controller
    test.fxml             ← Scene Builder layout
    style.css             ← custom stylesheet
    sami.jpg              ← employee photo
    emps.txt              ← saved HR reviews (auto-created)
  README.md
```

---

## Controller Methods

| Method | What it does |
|---|---|
| `initialize()` | Loads employee image via `FileInputStream` and opens `emps.txt` in append mode with `PrintWriter` |
| `exitHandle()` | Closes the `Stage` window and safely flushes and closes the `PrintWriter` |
| `aboutHandle()` | Shows an INFORMATION alert with app version and developer name |
| `sliderHandle()` | Reads slider value on drag and applies it as live CSS font-size to the TextArea |
| `uploadHandle()` | Opens `FileChooser`, reads the selected file line by line using `Scanner`, loads content into TextArea |
| `saveHandle()` | Validates input, writes date + comment to `emps.txt`, clears fields, and shows success alert |
| `validate()` | Returns `false` if DatePicker is `null` or TextArea is blank |
| `showAlert()` | Reusable helper that creates INFO or WARNING alerts with title, header, and content |

---

## Getting Started

1. **Clone the repo**
   ```bash
   git clone https://github.com/aya-alharazin/javafx-employee-dashboard-java3.git
   ```

2. **Open the project** in IntelliJ IDEA or NetBeans

3. **Add JavaFX SDK** to your project libraries
   ```
   File → Project Structure → Libraries → + JavaFX SDK path
   ```

4. **Place the employee photo** inside `src/week6/` named `sami.jpg`

5. **Run the main Application class** — the dashboard window will open

6. **To edit the layout visually**, right-click `test.fxml` → Open in Scene Builder

---

## Tech Stack

`Java 17+` `JavaFX` `Scene Builder` `FXML` `CSS` `FileChooser` `PrintWriter` `Scanner` `Alert` `FXMLLoader` `Initializable` `IntelliJ IDEA / NetBeans`

---

## Author

**Aya Al-Harazin**  
Teaching Assistant · Java 3 Lab & Lecture · 2026

> This repository is part of the Java 3 course lecture and lab series. Students are welcome to use this as a reference while building their own projects.

---

*Made with care for Java 3 students · Aya Al-Harazin · 2026*
