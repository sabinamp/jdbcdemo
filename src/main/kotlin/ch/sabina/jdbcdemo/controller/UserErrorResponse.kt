package ch.sabina.jdbcdemo.controller

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

import com.fasterxml.jackson.annotation.JsonFormat

class UserErrorResponse( hstatus: HttpStatus,
        val message: String,
        var stackTrace: String? = null
) {

    val code: Int
    val status: String

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss", locale = "de")
    val timestamp: LocalDateTime

    init {
        timestamp = LocalDateTime.now()
        code = hstatus.value()
        status = hstatus.toString()
    }
}