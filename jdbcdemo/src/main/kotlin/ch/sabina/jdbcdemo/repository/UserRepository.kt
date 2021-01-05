package ch.sabina.jdbcdemo.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import ch.sabina.jdbcdemo.model

@Repository
class UserRepository: UserInterface {
    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate


    override fun getAllUserList(): List<User> {
        val selectAllSql = "SELECT * FROM users"
        //jdbcTemplate.query() will execute the query and fetch the data
        return jdbcTemplate.query(selectAllSql, UserRowMapper())
    }

    override fun getUserByID(id: Int): User? {
        val selectAllSql = "SELECT * FROM users WHERE id = ?"
        return jdbcTemplate.queryForObject(selectAllSql, UserRowMapper(), id)
    }

    override fun addNewUser(userModel: User) {
        val addQuery = "INSERT INTO users (name, email, contact_number) values (?,?,?)"
        jdbcTemplate.update(addQuery,userModel.name,userModel.email,userModel.contact_number)
    }

    override fun updateUser(userModel: User, id: Int) {
        val updateQuery = "UPDATE users SET name=?,email=?, contact_number=? WHERE id=?"
        jdbcTemplate.update(updateQuery, userModel.name, userModel.email, userModel.contact_number, id)
    }

    override fun deleteUser(id: Int) {
        val deleteQuery = "DELETE FROM users WHERE id=?"
        jdbcTemplate.update(deleteQuery, id)
    }
}