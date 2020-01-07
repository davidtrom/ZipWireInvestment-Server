package com.example.demo.services;

import com.example.demo.authentication.AES;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public Iterable<String> findAllEmails() {
        ArrayList<String> userEmails = new ArrayList<>();
        Iterable<User> allUsers = userRepository.findAll();
         for (User user : allUsers){
             userEmails.add(user.getEmail());
         }
         return userEmails;
    }

    public User showUser(Long userId) {
        if(userRepository.findById(userId).isPresent()) {
            return userRepository.findById(userId).get();
        }
        else return null;
    }

    public User createUser (User newUser) throws Exception {
        newUser.setFirstName(newUser.getFirstName());
        newUser.setLastName(newUser.getLastName());
        newUser.setEmail(newUser.getEmail());
        newUser.setPassword(newUser.getPassword());
        newUser.setAccounts(newUser.getAccounts());
        newUser.setRent(newUser.getRent());
        newUser.setSalary(newUser.getSalary());
        return userRepository.save(newUser);
    }

    public User update(User newUserData) throws Exception {
        User getUser = showUser(newUserData.getId());
        getUser.setFirstName(newUserData.getFirstName());
        getUser.setLastName(newUserData.getLastName());
        getUser.setEmail(newUserData.getEmail());
        getUser.setPassword(newUserData.getPassword());
        getUser.setRent(newUserData.getRent());
        getUser.setSalary(newUserData.getSalary());
        return userRepository.save(getUser);
    }

    public User updatePassword (User user){
    return null;
    }

    public User findUserByEmail (String email) {
        return userRepository.findUserByEmail(email);
    }

    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public Boolean emailAvailabilityCheck(String email) {
        Iterable <String> allUserEmails = findAllEmails();
        for(String userEmail : allUserEmails){
            if(email.equals(userEmail)){
                return false;
            }
        }
        return true;
    }

        public User verify (String email, String password) throws Exception {
            final String secretKey = "PasswordKey";
            User userToLogin = findUserByEmail(email);
            String securePassword = userToLogin.getPassword();
            String encryptedPassword = AES.encrypt(password, secretKey);
            if (encryptedPassword.equals(securePassword)) {
                return userToLogin;
            }
            return null;
        }

}
