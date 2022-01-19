package by.epam.tr.task04.service;

import by.epam.tr.task04.service.impl.CarServiceImpl;
import by.epam.tr.task04.service.impl.OrderServiceImpl;
import by.epam.tr.task04.service.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();
    private final CarService carService = new CarServiceImpl();

    private ServiceFactory(){}

    public CarService getCarService() {
        return carService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public UserService getUserService() {
        return userService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
