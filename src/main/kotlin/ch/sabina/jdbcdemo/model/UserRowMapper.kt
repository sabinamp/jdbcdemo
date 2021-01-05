package ch.sabina.jdbcdemo.model

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.sql.SQLException

class UserRowMapper : RowMapper<User> {

    //RowMapper is an interface that is provided by the Spring JDBC
    //It uses the query() function of the JdbcTemplate class
    //override mapRow(row: ResultSet, rowNumber: Int): User?
    @Throws(SQLException::class)
    override fun mapRow(row: ResultSet, rowNumber: Int): User? {
        return User(row.getInt("id"),
                row.getString("name"),
                row.getString("email"),
                row.getString("contact_number"))
    }
}