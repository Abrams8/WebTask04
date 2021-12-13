package by.epam.tr.task04.dao;

public class DAOException extends Exception{

    public DAOException(String message, Exception e){
        super(message, e);
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(Exception e){
        super(e);
    }

    public DAOException(){
        super();
    }
}
