package by.epam.tr.task04.сontroller;

import by.epam.tr.task04.сontroller.impl.*;
import by.epam.tr.task04.сontroller.impl.GoToRegestrationPageCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private Map<String, Command> commands = new HashMap<String, Command>();

    public CommandProvider() {
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
        commands.put("GO_TO_MY_ORDERS_PAGE", new GoToMyOrdersPageCommand());
        commands.put("SAVE_ACCAUNT_CHANGES", new SaveAccauntChangesCommand());
        commands.put("MAKE_ORDER", new MakeOrderCommand());
        commands.put("DELETE_ORDER", new DeleteOrderCommand());
        commands.put("PAY_ORDER", new PayOrderCommand());
        commands.put("GO_TO_ADMIN_ORDERS_PAGE", new GoToAdminOrdersPageCommand());
        commands.put("GO_TO_ADMIN_USERS_PAGE", new GoToAdminUsersPageCommand());
        commands.put("GO_TO_ADMIN_CARS_PAGE", new GoToAdminCarsPageCommand());
        commands.put("ADD_USER_TO_BLACK_LIST", new AddUserToBlackListCommand());
        commands.put("GET_ALL_USERS", new GetAllUsersCommand());
        commands.put("GET_BLACK_LIST", new GetBlackListCommand());
        commands.put("DELETE_USER_FROM_BLACK_LIST", new DeleteUserFromBlackListCommand());
        commands.put("GET_ALL_CONFIRMED_ORDERS", new GetAllConfirmedOrdersCommand());
        commands.put("GET_ALL_UNCONFIRMED_ORDERS", new GetAllUnconfirmedOrdersCommand());
        commands.put("GET_ALL_CLOSED_ORDERS", new GetAllClosedOrdersCommand());
        commands.put("CONFIRM_ORDER", new ConfirmOrderCommand());
        commands.put("CLOSE_ORDER", new CloseOrderCommander());
        commands.put("GO_TO_MY_ORDERS_HISTORY_PAGE", new GoToMyOrdersHistoryPageCommand());

    }

    public final Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        return command;
    }
}
