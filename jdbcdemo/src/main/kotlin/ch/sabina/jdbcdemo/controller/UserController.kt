package ch.sabina.jdbcdemo.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ch.sabina.jdbcdemo.model.*
import ch.sabina.jdbcdemo.service.*

@RestController
class UserController {
    @Autowired
    private lateinit var userService: UserService

    //    Getting the User List
    @GetMapping(path = ["/users"])
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity(userService.getAllUserList(), HttpStatus.OK)
    }

    // Getting a User by ID
    @GetMapping(path = ["/user/{id}"])
    fun getUserByID(@PathVariable("id") id: Int): ResponseEntity<User> {
        return ResponseEntity(userService.getUserByID(id), HttpStatus.OK)
    }

    // Inserting a new User
    @PostMapping(path = ["/user/new"])
    fun addNewUser(@RequestBody userModel: User): String {
        ResponseEntity(userService.addNewUser(user), HttpStatus.CREATED)
        return "${userModel.name} has been added to database"
    }

    // Updating a User
    @PutMapping(path = ["/user/{id}"])
    fun updateUser(@RequestBody userModel: User, @PathVariable("id") id: Int): ResponseEntity<UserModel> {
        System.out.println("$id = $userModel")
        userService.updateUser(userModel, id)
        return ResponseEntity(userModel, HttpStatus.OK)
    }

    // Deleting a User
    @DeleteMapping(path = ["/user/{id}"])
    fun deleteUser(@PathVariable("id") id: Int): String {
        userService.deleteUser(id)
        return "$id User has been deleted."
    }
}