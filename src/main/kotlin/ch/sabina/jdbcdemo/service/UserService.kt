package ch.sabina.jdbcdemo.service

import org.springframework.stereotype.Service
import ch.sabina.jdbcdemo.repository.*
import org.springframework.beans.factory.annotation.Autowired
import ch.sabina.jdbcdemo.model.*

@Service
class UserService: UserInterface {
    @Autowired
    private lateinit var userRepository: UserRepository

    override fun getAllUserList(): List<User> {
        return userRepository.getAllUserList()
    }

    override fun getUserByID(id: Int): User? {
        return userRepository.getUserByID(id)
    }

    override fun addNewUser(userModel: User) {
        userRepository.addNewUser(userModel)
    }

    override fun updateUser(userModel: User, id: Int) {
        userRepository.updateUser(userModel, id)
    }

    override fun deleteUser(id: Int) {
        userRepository.deleteUser(id)
    }
}