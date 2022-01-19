package by.epam.tr.task04.сontroller;

import by.epam.tr.task04.сontroller.impl.*;
import by.epam.tr.task04.сontroller.impl.GoToRegestrationPageCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private Map<String, Command> commands = new HashMap<String, Command>();

    public CommandProvider(){
        commands.put("logination", new LoginationCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("GO_TO_REGISTRATION_PAGE", new GoToRegestrationPageCommand());
        commands.put("GO_TO_LOGINATION_PAGE", new GoToLoginationPageCommand());
        commands.put("GO_TO_MAIN_PAGE", new GoToMainPageCommand());
        commands.put("GO_TO_INDEX_PAGE", new GoToIndexPageCommand());
        commands.put("GO_TO_FREE_CARS_PAGE", new GoToFreeCarsPageCommand());
        commands.put("CHANGE_LOCALE", new ChangeLocale());
        commands.put("LOG_OUT", new LogOutCommand());
        commands.put("GO_TO_ACCAUNT_INFORMATION_PAGE", new GoToAccauntInformationPage());
    }

    public final Command getCommand(String commandName){
        Command command = commands.get(commandName);
        return command;
    }
}
