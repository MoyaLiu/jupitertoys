# jupitertoys

### Environment

- Platform: Linux/MacOS/Windows
- Java: 8+
- Maven: 3.8.1

### Dependencies

- Selenium
- Junit

### How to run

Run all the tests by maven and generate plain text and xml default
```
mvn test

```

Or use surefire plugin to generate simple html test report:
```
mvn surefire-report:report

```

Example simple html test report:
![image](https://user-images.githubusercontent.com/69458030/144691470-ba1afa76-64ac-42bd-9051-d93c46817cd4.png)
