Password Validation Service
===========================
This project is a stateless password validation service (as the name suggests). It is written in Java and can be used via the Java API (PasswordValidationAPI). You can use the default set of password validation rules "DefaultComprehensiveValidationSet", as is defined in the ./PasswordValidationService/resources/PasswordValidationServiceBeansContext.xml

You can also use the named API to use specific validation rules, see PasswordValidationAPI and the javadocs for more information. The PasswordValidationAPITest is a good example of how to use the named API.

If you want to add yout own rules and implement this with this framework, read the next secion on Configuration & Extensibility


Configurability & Extensibility
===============================
I have used the Spring Dependency Injection Framework to define beans that serve as "rules" against which the provided password string will be validated. With this, and the coded framework, it is very easy to compose new validation sets (of rules) to serve any custom need that you may need. With that, you can also define your own rules by extending the ValidationRule (which represents the most atomic unit of password validation in the context of the framework)

Rules can be added and removed using the dependency injection framework by modifying the xml file "./PasswordValidationService/resources/PasswordValidationServiceBeansContext.xml" which defines the beans. You will have to code your own performValidation(...) method to fit it into the framework, following the ValidationRule template.


Existing Rules (What it currently validates against)
====================================================
- Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each (composed using smaller atomic rules to maintain extensibility)
- Must be between 5 and 12 characters in length.
- Must not contain any sequence of characters immediately followed by the same sequence.

All these rules are combined into a ValidationSet called "DefaultComprehensiveValidationSet", which you get by default with the validatePassword(...) call to the API.


How To Run It
=============
I would have liked to provide this as a framework in a jar, but I want it to be easily modifiable, so I've left it as a source. You can include this project as a source in your other projects, and call PasswordValidationAPI's validatePassword(...) on objects of PasswordValidationAPI (Ideally these would comprise sessions, and would need to be authenticated etc. to maintain state of callers and track API usage etc.).


Note
====
This code is the intellectual property of nikhilsaraf and is not meant to be used commercially or on any deployed system without written consent from the author (nikhilsaraf).
