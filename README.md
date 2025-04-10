# ✨Sample Annotation Processor

Welcome to the Sample Annotation Processor project!<br>
This application demonstrates how to create a custom annotation processor that works at compile time to validate your code.

## 🚀Technologies Used:
* Java 21 
* Gradle
* Spring Boot 3.4.4

## 🛠️How To Run?
1. Clone the repository:
```sh
git clone https://github.com/Uzunalov/annotation.git
```
2. Build the project:<br>
   Running the build will fail with 2 compile-time errors by design.
   <br>These are triggered by the annotation processor.
   <br>To fix the errors, update the fields in
   [MySampleClass.java](sample-service/src/main/java/com/uzunalov/sampleservice/MySampleClass.java) accordingly.
```sh
./gradlew build
```

## 📌 Notes
* This project is for educational purposes to demonstrate how compile-time validation works using annotation processors.
* You can extend the logic in MySampleProcessor.java to perform other validations, like naming conventions or type checks.