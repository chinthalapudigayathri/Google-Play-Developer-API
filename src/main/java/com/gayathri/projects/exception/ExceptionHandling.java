package com.gayathri.projects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*@ControllerAdvice is a global exception handler which handles IOException or invalid app id, it returns a clean json
* instead of entire error stack trace
* It makes the class global for all controllers.
* Listens to Exceptions thrown by @Controller and @RestController
 */
@ControllerAdvice
public class ExceptionHandling
{
    /* the method with this annotation handles any exception within type Exception
    * ResponseEntity is a return type, it returns HTTP responses
    * Accepts thrown exception as paramtere
    * */
@ExceptionHandler(Exception.class)
public ResponseEntity<String> handlesException(Exception e)
{
return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
}

}
