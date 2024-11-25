package Service;

import model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User getUser(int id);

    List<User> getUsers();
}
