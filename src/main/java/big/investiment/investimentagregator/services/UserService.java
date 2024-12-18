package big.investiment.investimentagregator.services;


import big.investiment.investimentagregator.dto.UpdateUserDto;
import big.investiment.investimentagregator.dto.UserCreateDto;
import big.investiment.investimentagregator.models.User;
import big.investiment.investimentagregator.repositories.UserRepository;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(UserCreateDto userCreateDto) {
        var entity = User.builder()
                .username(userCreateDto.username())
                .password(userCreateDto.password())
                .email(userCreateDto.email())
                .creationTimeStamp(Instant.now()) // `creationTimeStamp` será gerado automaticamente
                .build();
        var savedUser = userRepository.save(entity);
        return  savedUser.getUserId();

    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(String userId) {
        var id = UUID.fromString(userId);
        var userExist = userRepository.existsById(id);
        if (userExist) {
            userRepository.deleteById(id);
        }
    }
    public void updateUserId (String id, UpdateUserDto updateUserDto) {
        var userId = UUID.fromString(id);
        var userEntity = userRepository.findById(userId);
        if (userEntity.isPresent()) {
            var user = userEntity.get();

            if( updateUserDto.username() != null) {
                user.setUsername(updateUserDto.username());
            }
            if( updateUserDto.password() != null) {
                user.setPassword(updateUserDto.password());
            }
              userRepository.save(user);

        }

    }
}
