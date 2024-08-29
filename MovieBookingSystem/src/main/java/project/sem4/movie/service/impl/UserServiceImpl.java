package project.sem4.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.sem4.movie.entities.Users;
import project.sem4.movie.repository.UserRepository;
import project.sem4.movie.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    @Override
    public Users getUserById(int user_id) {
        Optional<Users> optionalUser = userRepository.findById(user_id);
        return optionalUser.orElse(null);
    }

    @Override
    public Users pushUser(Users newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public Users updateUser(Users updateUser, int user_id) {
        Optional<Users> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();
            // Update user attributes here
            existingUser.setUsername(updateUser.getUsername());
            existingUser.setEmail(updateUser.getEmail());
            existingUser.setPassword(updateUser.getPassword());
            existingUser.setRole(updateUser.getRole());
            // Set other attributes as needed

            return userRepository.save(existingUser);
        }
        return null; // User with given ID not found
    }

    @Override
    public void deleteUserById(int user_id) {
        userRepository.deleteById(user_id);
    }
}
