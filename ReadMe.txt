GROUP NO.153
VAIBHAV TAPARIYA-2022556
ASHU KUMAR JHA-2022115
Now coming to code explanation, our code has basically many classes. For implementing the code, you need to first
run the driver class, which is our class for the Hello application, basically for running it, then after running it, our first scene will come into place. Now you need to use the mouse and go to play to go to the second screen.

After entering the second screen, you will see our characters. In order to start extending the stick, use the keyword "s" and
then to lower down the character, use the keyword "d," and for uppering the character, use the keyword "u."
For more information regarding game controls, please refer to the class Keyboard Controls.

Now regarding the basic gameplay, firstly, you will determine when your stick size is larger than the distance between pilars.
Also, if you are down and, before completing the pillar, you hit it while being downward, then you will also die.
Regarding scores and cherries:
Now your score will always increase by 1 after covering each pillar, and your cherrie score will increase after collecting each cherrie by 1 if you collect 1.
Revival:
Now, regarding revival, it always follows the basic rule that if you have 2 cherrries you can revive, and two cherries will always be deducted when using it.
But other than that, if you do not revive, the number of cherries that remain is not fixed since we have used a random function.
Menu bar:
You can always use home to go back to home, then again use play to come back. You also have a save button, by which you can basically save it.
Now explaining the classes in very short:
Driver:
Now it is the main class for our project, which is being used to run, and all classes are affected by it.
Endpopup:
This class, named EndPopUp, appears to be part of a JavaFX application and is responsible for creating and managing a popup dialogue that prompts the user to decide whether to revive or restart the game after a certain condition has been met.
KeyboardControls:
This class is designed to handle keyboard events, specifically key presses. It defines the behaviour for different key presses, responding to certain keys by invoking corresponding actions on a Player object.
MapController:
The MapController class manages the game map, platforms, player interactions, and cherry collection, creating a dynamic and evolving game environment. The class follows the Singleton pattern to ensure a single instance is used throughout the application.
menuController:
The code assumes that the driver class contains static methods like getPlayRoot and playscreen. It seems to be part of a larger JavaFX application where the menu controller is used to switch to the play screen. Additionally, the functionality might depend on the implementation of other classes and methods not provided in the code.
PlatformFactory:
The PlatformFactory class appears to be a factory class responsible for creating instances of rectangle objects representing platforms in a game. These platforms are likely used to create a dynamic and changing game environment where the player needs to navigate between different platforms.
playController:
The playController class is responsible for handling events related to the play screen. In particular, the switchToHomescreen method is triggered when a button (likely named homeScreenSwitcher) is clicked, and it performs the necessary actions to transition from the play screen to the home screen.
Player:
The Player class appears to represent the player character in a game, and it contains various methods related to the player's actions and interactions with the game environment.
ScoreKeeper:
The ScoreKeeper class manages the visual representation of the player's score and cherry count in a game.
Important points:
1. Sir, firstly, I completed this assignment on my MacBook, so my code was working on my laptop and a lot of other Windows laptops as well, but
In some of the laptops, the code was not working, so if even on your laptop, the code does not run, then please first remove the macOS file, which will come along with it.
but only remove it by first checking that it is running or not. If it is running, then there is no need to delete the Mac OS file.
Also, if even then things don't work, then please take my demo.
2. We have used keywords different than space and arrows; instead of them, we have used "s" ,"d" ,"u".
So please look into it. Also, I had asked TF about it, and she was okay with it.
3. We have used code completely different from our first submission because in that submission code was not working properly, so we have changed everything, like the scenes,
With earlier photos, the code was not working,so we have changed scenes also.