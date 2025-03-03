# CAPTCHA Solver using Selenium, Tesseract OCR, and OpenCV

This project automates CAPTCHA solving using **Selenium WebDriver**, **Tesseract OCR** in **Java**. It extracts CAPTCHA images from a webpage and then applies Optical Character Recognition (OCR) to extract the text.

## 🚀 Features

- Uses **Selenium WebDriver** to navigate web pages and capture CAPTCHA images.

- Utilizes **Tesseract OCR** for text extraction from CAPTCHA images.

- Saves CAPTCHA images with timestamps for debugging.

---

## 📂 Project Structure

```
📦 Captcha-Solver
├── 📂 captchaImages      # Folder where CAPTCHA images are saved
├── 📜 pom.xml            # Maven dependencies
├── 📜 README.md          # Documentation
├── 📜 Test_Captcha.java  # Main Java file for solving CAPTCHA
```

---

## 🛠️ Prerequisites

### **Install Tesseract OCR**

- Download and install Tesseract OCR from: [Tesseract GitHub](https://github.com/UB-Mannheim/tesseract/wiki)
- Set the `TESSDATA_PREFIX` environment variable to the **tessdata** folder.

### \*\* Install Java & Maven\*\*

- Java 11 or later.
- Apache Maven (for managing dependencies).

---

## 🏗️ Installation & Setup

### **1️⃣ Clone this Repository**

```sh
git clone https://github.com/s2910/captcha-solver.git
cd captcha-solver
```

### **2️⃣ Install Dependencies**

```sh
mvn clean install
```

### **3️⃣ Run the CAPTCHA Solver**

```sh
mvn exec:java -Dexec.mainClass="Test_Captcha_tessract"
```

---

## 📌 Usage

1. Launches the IRCTC website and navigates to the **login page**.

2. Captures the **CAPTCHA image**.

3. **Extracts text** using **Tesseract OCR**.

4. **Fills the CAPTCHA field**&#x20;

---

## 📦 Dependencies

Add the following dependencies in `pom.xml`:

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.9.0</version>
    </dependency>

    <!-- Tess4J (Tesseract OCR for Java) -->
    <dependency>
        <groupId>net.sourceforge.tess4j</groupId>
        <artifactId>tess4j</artifactId>
        <version>4.5.5</version>
    </dependency>
```

---

## 📜 License

This project is licensed under the **MIT License**.

---

## ✨ Future Improvements

- Integrate **Machine Learning (CNNs)** for better CAPTCHA recognition.
- Support **reCAPTCHA v2/v3 bypass**.
- Improve **image denoising** for distorted CAPTCHAs.

---

## 💡 Contributing

Feel free to **fork** this project, **submit issues**, or create a **pull request**. Contributions are welcome! 🎯

---

