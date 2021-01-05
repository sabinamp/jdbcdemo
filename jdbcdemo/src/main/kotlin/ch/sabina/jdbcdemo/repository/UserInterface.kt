package ch.sabina.jdbcdemo.repository

import ch.sabina.jdbcdemo.model

interface UserInterface {
    fun getAllUserList(): List<User>
    fun getUserByID(id: Int): User?
    fun addNewUser(userModel: User)
    fun updateUser(userModel: User)
    fun deleteUser(id: Int)
}