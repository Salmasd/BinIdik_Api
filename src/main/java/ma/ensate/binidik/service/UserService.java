package ma.ensate.binidik.service;

import ma.ensate.binidik.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> findById(int id);
    public void RemoveUser(Integer id);
    public List<User> getAllUsers();
    public long getCountOfUsers();
    public User addUser(User user);
    Optional<User> findByEmail(String email);
}
