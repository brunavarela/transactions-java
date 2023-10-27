package br.com.bruna.learningspring.service;

import br.com.bruna.learningspring.dto.CreateDepositDto;
import br.com.bruna.learningspring.dto.UserDto;
import br.com.bruna.learningspring.model.User;

import java.util.List;

public interface UserService {

    User createUser (final UserDto userData);

    List<User> readUsers();

    User retrieveUser(final long id);

    User updateUser(final UserDto userData, final long id);

    void deleteUser(final long id);

    User createDeposit(final CreateDepositDto depositData, final long id);
}
