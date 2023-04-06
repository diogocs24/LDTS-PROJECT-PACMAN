# LDTS_l02gr03 - PAC-MAN
This project consists of a classic Pac-man game. The objective of the game is to eat all of the dots placed in the maze while avoiding four colored ghosts that pursue Pac-Man. 
When Pac-Man eats all of the dots, the player advances to the next level.If Pac-Man is caught by a ghost, he will lose a life; the game ends when all lives are lost.


This project was developed (for LDTS 2022/2023) by:
- *Ana Carolina da Costa Coutinho up202108685*
- *Diogo Coutinho da Silva up202104794*
- *Letícia Mendes Coelho up202108877*

### IMPLEMENTED FEATURES
**Player-controlled Character (Pacman)**
- Arrow UP : Moves the hero up.
- Arrow LEFT : Moves the hero left.
- Arrow DOWN : Moves the hero down.
- Arrow RIGHT : Moves the hero right.

The user is able to **navigate through various menus** within the game, including the main menu, instructions, play, and pause menus.

Pacman begins each game with **three lives**, and the game ends when his lives reach zero.

There are **four Pac-Man ghosts with distinct characteristics**, including different movement patterns and colors.

The **ghosts move on their own**, without any input from the player.

**Collisions** between various objects, such as the player, ghosts, and map walls, are detected and processed.

If a ghost catches Pacman, it will **reset the player back to their starting position and states**, and decrease Pacman's lives by 1.

The **score increases** when the player eats coins.

When all coins are eaten the **player wins the game**.

**Keyboard inputs** are captured through relevant events and processed based on the current game state.

**Animations** have been added for the player and ghosts, and the **map has been designed using a custom handmade font**.

The game has **music and sound effects** for various actions, such as the start of the game, player movement, ghosts movement, coins consumption, and game over.

- **Examples with images**

**Main Menu**

![Main Menu](https://user-images.githubusercontent.com/93997120/209401670-fa66971a-bacb-437f-b1be-55d40b80397f.JPG)

**Instructions Menu**

![2](https://user-images.githubusercontent.com/93997120/209401685-c8d87ced-828a-46b4-9990-032a3f69c8fa.JPG)

**Pause**

![3](https://user-images.githubusercontent.com/93997120/209401697-f09420ac-dc06-4873-ad55-917d6b9a826c.JPG)

**Map**

![4](https://user-images.githubusercontent.com/93997120/209401722-6005ea71-f29a-4355-a624-f24f074b2eb7.JPG)

**Game Over**

![5](https://user-images.githubusercontent.com/93997120/209401733-a1484b23-c85e-41c6-9eef-b7a808d5f271.JPG)


### PLANNED FEATURES

**Bonus** - In addition, bonus items, referred to as Fruits appear near the center of the maze. These items score extra bonus points when eaten and Pac-Man gets the hability to eat a ghost.


### DESIGN
UML
![Diagrama_sem_nome drawio-3](https://user-images.githubusercontent.com/93997120/209411919-14147664-0ede-4cce-986d-453a81dd56a4.png)

### 1

**Problem in Context**

The Game class might have to use complex conditional statements to alter its behavior based on its current state. For example, it might have to check a number of different variables or flags to determine what to do next. This could lead to code that is difficult to read and maintain.

**The Pattern**

The **State design pattern** is a behavioral design pattern that allows an object to alter its behavior when its internal state changes. It can be used to create objects that behave differently depending on their current state.

**Implementation**

![game e state](https://user-images.githubusercontent.com/93997120/209413559-85cea61b-806d-4e04-a0d0-5d04c3f3ec09.jpeg)


**Consequences**

The State design pattern has several consequences:
It allows the behavior of the Game class to be more modular and easier to understand. Instead of using complex conditional statements to handle different states, the Game class can simply change the state object it is referencing to alter its behavior.
It makes it easy to add new states to the game. If we want to add a new state, all we need to do is create a new concrete class that implements the State interface and add it to the Game class.
It makes it easy to change the behavior of the game based on its current state. By changing the state object that the Game class is referencing, we can alter the behavior of the Game class without changing any of its existing code.
It makes it easier to test the Game class. Because the behavior of the Game class is defined by the state object it is referencing, we can easily test different states by creating mock objects that implement the State interface.
It makes it easier to maintain the Game class. Because the behavior of the Game class is defined by the state object it is referencing, we can make changes to a specific state without affecting the other states. This can make it easier to identify and fix bugs in the Game class.

### 2

**Problem in Context.**

We needed a way to organize the various components in our game, as they all have certain shared characteristics. In order to easily create new objects that follow the same logic as the rest of the components, we needed a system for organizing them.

**The Pattern**

The **factory pattern** is a design pattern that provides a template for creating objects in a super class, but allows subclasses to alter the type of objects that will be created. This is done by defining a factory method in the super class that creates objects, and allowing subclasses to override this method to change the type of objects that are created. The factory pattern is useful for creating objects that may vary in their implementation, but share a common interface. This allows for flexibility and ease of use, as the client code does not need to know the specific implementation of the objects it is using, only that they conform to the common interface.

**Implementation**

![element](https://user-images.githubusercontent.com/93997120/209413525-5ec90283-883f-4677-8bc2-3164fa00b7ac.jpeg)


**Consequences**

-	Single Responsibility Principle.
-	Open/Closed Principle. We can introduce new elements to our game without breaking the existing ones.
    
### 3

**Problem in Context**

To ensure that we can call a particular method in any state, we need to make sure that all states have the method defined with the same signature and structure. This allows us to use the same method call regardless of the current state, as we can be confident that the method is available and follows the expected structure.

**The Pattern**

The **template method** is a design pattern that provides a common structure for a set of related classes, allowing them to vary their behavior in certain areas while still maintaining a consistent overall structure. The template method defines a skeleton or core set of steps that must be followed, but allows individual classes to implement these steps in a way that suits their specific needs, as long as they do not alter the fundamental structure of the core. This enables the classes to share a common structure and behavior while still allowing for flexibility and customization.

**Implementation**

![State](https://user-images.githubusercontent.com/93997120/209412649-565a6d46-bbbd-4aeb-a1bd-e4615564da01.jpeg)


**Consequences**

The template method pattern allows us to reuse code by providing a common structure that can be used by multiple classes. This helps to reduce the amount of redundant code that needs to be written, as we can define the core behavior in a single location and then customize it as needed for each individual class. This allows us to maintain a consistent structure across all classes, while still allowing for flexibility and customization to meet the specific needs of each class. By using the template method pattern, we can ensure that the necessary code is available in all states, while still allowing for variations in the implementation as needed.


### 4

**Problem in Context**

In order to have a well-structured code, we decided to create an interface that addresses several issues we faced while using the lanterna library. Firstly, the lanterna library contains functions that are not relevant to our program, which violates the Interface Segregation Principle. Secondly, it lacks some functions that are essential for our interface. Additionally, using the raw lanterna library would result in our game module (a high-level module) directly depending on a low-level module, which goes against the Dependency Inversion Principle. To solve these problems, we implemented an interface that provides only the necessary functions and decouples the game module from the low-level implementation details.

**The Pattern**

To address the issues mentioned above, we have implemented the **Facade design pattern** in our code. The Facade pattern involves creating a simplified interface that provides access to a complex subsystem. By using this pattern, we are able to hide the complexities of the subsystem and only expose the features that are relevant to our program. This allows us to keep our code clean and easy to understand, while still being able to use the functionality of the underlying subsystem. Overall, the Facade pattern helps us to achieve a more structured and maintainable codebase.

These classes are:
-	Game
-	GUI
-	LanternaGUI

**Consequences**

The use of the Facade Pattern in the current design allows the following benefits:

Isolating code from the complexity of a subsystem means separating the code that performs a specific function or set of functions from the rest of the system. This can be done for a number of reasons, including to promote testability, to make it easier to replace or update a subsystem, or to reduce the amount of code that other parts of the system depend on.

Isolating code from the complexity of a subsystem can promote testability and replaceability in a number of ways.

Expand lanterna functionalities as well as respecting the Interface Segregation Principle.

### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

- **Repeated code** - The code smell of repeated code occurs when the same code or similar code is repeated multiple times in a program. This can make the code harder to read and maintain, as changes to the repeated code need to be made in multiple places.

    In the Game class, the processKey() method has four cases for each arrow key, which results in repeated code. This repetition of code can make the method harder to read and maintain.

    One way to refactor the code to eliminate the repeated code is to use a single case statement with a map of key type to action. This will allow the code to handle all arrow key types in a single case, and will make the method easier to read and maintain.

- **Lack of Polymorphism** - The code smell of lack of polymorphism occurs when a class or interface is not designed to handle multiple types of objects, but is only capable of handling a single type. This can lead to code duplication and maintenance issues, as a separate class or method would need to be created for each type of object.

    The GhostPinkyViewer class implements the ElementViewer interface, which defines the draw() method for rendering an Element on a GUI. However, the GhostPinkyViewer class only knows how to draw Ghost elements, and does not have any mechanism for handling other types of elements. This lack of polymorphism means that a separate viewer class would need to be created for each type of element, which can lead to code duplication and maintenance issues.

    One way to refactor the code to eliminate the lack of polymorphism is to use generics in the ElementViewer interface, so that it can handle multiple types of elements. This can be done by declaring the ElementViewer interface as a generic type and specifying the type of element it can handle as a type parameter. The GhostPinkyViewer and other viewer classes can then implement this interface and specify the type of element they can handle.

- **Abstract class with no abstract methods** - The code smell of an abstract class with no abstract methods occurs when an abstract class is defined without any abstract methods. This can make the code harder to understand and maintain, as it is not clear why the class is abstract or what it is intended to do.

    The Viewer class is declared as an abstract class, but does not have any abstract methods. This means that there is no reason for the Viewer class to be abstract, and it could be refactored to be a concrete class instead.

    To eliminate this code smell, the Viewer class can be refactored to either be a concrete class or to have at least one abstract method. If the Viewer class is intended to be a base class for other classes, it can be refactored to have one or more abstract methods that must be implemented by its subclasses. If the Viewer class is intended to be a standalone class, it can be refactored to be a concrete class and have concrete methods that can be called directly.

- **Magic String** - The code smell "Magic String" refers to the use of hardcoded string literals in the code that have a special meaning or significance. These magic strings can make the code harder to understand and maintain, as they are not self-explanatory and it is not clear what they represent or how they are used in the code.

    To eliminate the magic string code smell, the string literals can be replaced with named constants or an enumeration. This makes the code more self-explanatory and easier to understand, as the constants or enumeration values are more descriptive and explicitly indicate their meaning or purpose.

### Testing

- **Test Coverage**

![All](https://user-images.githubusercontent.com/93997120/209413681-93a5511d-fa46-44a6-a366-c4132dc8648d.JPG)

- **GUI**

![Gui](https://user-images.githubusercontent.com/93997120/209413674-58c61b50-4f74-43ad-a003-43b290771540.JPG)

- **Model**

![Model](https://user-images.githubusercontent.com/93997120/209413660-96beb0a2-4d25-4e0c-8e48-f04176c74272.JPG)

- **State**

![State](https://user-images.githubusercontent.com/93997120/209413653-4ece721b-b290-49e0-b285-8297e0851787.JPG)
- **Viewer**

![Viewer](https://user-images.githubusercontent.com/93997120/209413644-c3aae1a8-4960-48fc-8991-4daf4658cdff.JPG)

### Self-Evaluation

We have all put in a lot of effort and feel like the work was fairly distributed among all team members.
It helped us to apply, learn and better understand java, as well as pattern styles and development knowledge. It also helped us with our teamwork skills.

Ana Coutinho - 33.3%

Diogo Silva - 33.3%

Letícia Coelho - 33.3%
