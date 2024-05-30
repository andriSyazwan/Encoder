# Encoder
This project is an encoder that transforms plaintext into an obfuscated string using a character-based shift algorithm. The encoder selects an offset character from a reference table to shift all characters by a specified amount, creating a unique encoded message. Any character not in the reference table remains unchanged. The same offset character is used to decode the message back to its original form. This solution showcases OOP principles through the implementation of encoding and decoding methods.

## Story of Possible Uses
This project can be particularly useful for system administrators who need to encrypt and decrypt password files for better privacy and security. It showcases a simple yet effective way to encode and decode text, ensuring that sensitive information is protected.

## Quick Start Guide
1. **Clone the repository**:
    ```bash
    git clone https://github.com/andriSyazwan/Encoder.git
    ```
2. **Configure JDK**:
    - Ensure that JDK 21 is installed and configured. You might need to set the JAVA_HOME environment variable to point to your JDK 21 installation.
3. **Open the Project**:
    - Open the project in your preferred IDE (IntelliJ IDEA is recommended).
4. **Build and Update Maven Project**:
    - In IntelliJ, right-click on the project and select `Maven` > `Reload Project`.
5. **Run the Application**:
    - Run the `SpecialEncodingApp` class.
    - Follow the instructions in the terminal to encode or decode text.
6. **Enjoy**:
    - Feel like a hacker as you play around with encoding and decoding text.

## Development Description
- **Test-Driven Development (TDD)**: The application was developed using TDD to ensure robustness and reliability.
- **JUnit**: Used for writing and running tests to verify the functionality of the application.

## Functions and Features
- **Randomizer for Encoding**: Utilizes a random number generator to encode text.
- **Case Handling**: Accepts lowercase inputs but always returns uppercase encoded text.
- **Object-Oriented Programming (OOP)**: The application is built with OOP principles in mind.
- **Exception Handling**: Contains a class inherited from RunTimeException that detects invalid inputs.

## Demonstration of OOP
- **Encapsulation**: 
    - Private attributes and methods are used within the `Solution` class to ensure data integrity and hide implementation details.
- **Abstraction**:
    - Provides getter methods to access object attributes without exposing internal implementations.
- **Inheritance**:
    - Main methods implement an interface, allowing for flexible and extendable code.
- **Polymorphism**:
    - Method overriding is used to provide different implementations of the same method, enabling various usages.

## Future Considerations
- **File Handling**:
    - Extend the scanner to accept files, encode the text within the file, and output a file with the encoded text. This will enhance the usability of the application for batch processing.

## Appendix
### For The Developers From DXC Grading Me
This project was an intriguing puzzle that I thoroughly enjoyed solving. I took the opportunity to merge OOP principles with a Data Structures and Algorithms challenge, turning it into a delightful coding adventure. Here's a quick rundown of the journey:

- **Planning**: 2 hours of strategizing (and a bit of daydreaming)
- **Developing Test Cases**: 3 hours of rigorous testing (and debugging)
- **Implementation**: 1 hour of focused coding (with coffee breaks, of course)
- **Setting Up the Repository**: 2 hours of organizing and beautifying this page (because who doesn't love a well-organized project?)

In total, this project represents about 8-10 hours of dedication, perseverance, and a sprinkle of humor. I hope you appreciate the effort that went into this, and I look forward to the possibility of joining your team. Thank you for considering my application.

P.S. If you need someone who can code with a smile and solve problems with a touch of fun, I'm your person. Let's decode some great solutions together!
### Notes
![Problem Brief Notes](Problem%20Brief%20Notes.png)
![Features and Functionality Notes](Features%20and%20Functionality%20notes.png)
![Test and Development Notes](Test%20and%20Development%20notes.png)

---

Feel free to reach out if you have any questions or need further assistance. Enjoy using the Encoder!
