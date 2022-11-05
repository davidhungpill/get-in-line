package com.fastcampus.getinline.controller.error;

import com.fastcampus.getinline.constants.ErrorCode;
import com.fastcampus.getinline.dto.APiErrorResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class BaseErrorController implements ErrorController {

    @GetMapping(path="/error", produces= MediaType.TEXT_HTML_VALUE)
    public ModelAndView errorHtml(HttpServletResponse response){
        HttpStatus status = HttpStatus.valueOf(response.getStatus());
        ErrorCode errorCode = status.is4xxClientError() ? ErrorCode.BAD_REQUEST : ErrorCode.INTERNAL_ERROR;
        return new ModelAndView("error",
                Map.of("statusCode", status.value(),
                "errorCode", errorCode,
                "message", errorCode.getMessage(status.getReasonPhrase())
                ),
                status
        );
    }

    @GetMapping("/error")
    public ResponseEntity<APiErrorResponse> error(HttpServletResponse response){
        HttpStatus status = HttpStatus.valueOf(response.getStatus());
        ErrorCode errorCode = status.is4xxClientError() ? ErrorCode.BAD_REQUEST : ErrorCode.INTERNAL_ERROR;
        return ResponseEntity
                .status(status)
                .body(APiErrorResponse.of(
                        false,
                        errorCode
                        )
                );
    }
}
