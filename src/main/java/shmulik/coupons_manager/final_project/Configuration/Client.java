public interface Client {

    User login(String name, String password)
            throws UserNotFoundException;

}