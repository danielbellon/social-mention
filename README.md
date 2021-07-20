# Refactor Challenge

## Bad practices
I think that most of the SOLID principles are being violated in the original code, in addition, there are many things that should be improved, 
below a brief explanation around detected issues:

- **Single Responsibility**: all the business and application logic are in the `SocialMentionController`, there are no clear separation of concerns
- **Open closed**: if a new feature is needed, the code can not be extended easily without a modification over the previously mentioned `SocialMentionController`, 
  that means that the original code is not maintainable
- **Dependency Inversion**: there are no control inversion in the code (because there are no application of Single Responsibility principle)
- the use of utility classes that are exposing static method can generate code that is not easy to test
- Database host and port are hardcoded into the controller, it will be pretty hard to test against other environments without modifying the
source code
- More abstraction is needed, there are some business invariants that are not represented in domain models
- There are no traceability, if issues or incidents over production happen, there are no logs over the incoming transactions
that can be helpful to determine their root cause
- Strings content are not being validated, if a string is not null but it has no content, the validation will generate an unexpected value, for instance:
  ``` java
  if (socialMention.getFacebookAccount() != null) {
    isFacebook = true;
  }
  ```
  the previous code will generate `true` even if the `facebookAccount` (which is a String) is blank
- Because of poor abstractions (enums are not being used to define the risk level), the risk level something is referred to the logical expression that generates it,
in consequence, if the risk level calculation changes, the validations will fail. For instance:
  ``` java
  // Analyze facebook post (if facebook is already low then skip this analysis)
  if (isFacebook && facebookScore > -100) {
    ...
  }
  
  ...
  
  if (isFacebook) {
    if (facebookScore == -100d) {
      return "HIGH_RISK";
    }
    ...
  }
  ```



## Proposed solutions
- First, a separation of concerns is needed, that's why a layered architecture is necessary to enhance the code maintainability
- Use Dependency Injection in order to decouple the previously detected layers and protect the business logic
- Use Dependency Inversion as well to protect the business logic
- Avoid using of static methods exposed by utility classes in order to make the code testable, instead, use dependency injection, 
  so that dependencies can be mocked.
- Enhance abstraction, for instance, create enums in order to represent the risk level in Strings 
- Add logs
- Don't hardcode the database connection params, instead, put them in a configuration file
- Strategy pattern implementation in order to decide the analyzer to be used for the incoming social mention 

