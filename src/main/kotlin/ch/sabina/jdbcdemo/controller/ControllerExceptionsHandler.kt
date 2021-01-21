package ch.sabina.jdbcdemo.controller

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import java.io.StringWriter
import java.io.PrintWriter
import org.springframework.dao.EmptyResultDataAccessException

@ControllerAdvice
class ControllerExceptionsHandler{

    @ExceptionHandler( NoSuchElementException::class,
            EmptyResultDataAccessException::class,
            IndexOutOfBoundsException::class,
            KotlinNullPointerException::class)
    fun notFoundException(e: Exception): ResponseEntity<UserErrorResponse> {
        return generateErrorResponse(HttpStatus.NOT_FOUND, "Resource not found", e)
    }

    @ExceptionHandler( Exception::class )
    fun internalServerErrorException(e: Exception): ResponseEntity<UserErrorResponse> {
        return generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Generic internal error", e)
    }

    private fun generateErrorResponse( status: HttpStatus, message: String, e: Exception ): ResponseEntity<UserErrorResponse> {
        // converting the exception stack trace to a string
        val sw = StringWriter()
        val pw = PrintWriter(sw)
        e.printStackTrace(pw)
        val stackTraceMessage = sw.toString()

        return ResponseEntity(UserErrorResponse(status, message, stackTraceMessage), status)
    }
}