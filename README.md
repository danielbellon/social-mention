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
that can be helpull to determine their root cause

## Proposed solutions
- First, a separation of concerns is needed, that's why a layered architecture is necessary to enhance the code maintainability
- Use Dependency Injection in order to decouple the previously detected layers and protect the business logic
- Use Dependency Inversion as well to protect the business logic
- Avoid using of static methods exposed by utility classes in order to make the code testable, instead, use dependency injection, 
  so that dependencies can be mocked.
- Enhance abstraction, for instance, create enums in order to represent the risk level in Strings 
- Add logs
- Don't hardcode the database connection params

