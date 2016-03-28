package projectPragmatic;

import projectPragmatic.controllers.UserInputController;

import java.io.IOException;


/**
 * Created by Kristiyan on 26-Mar-16.
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        UserInputController userInputController = new UserInputController();
        userInputController.start();
    }
}
