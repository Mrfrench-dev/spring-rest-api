package com.example.asfranca.spring_rest_api.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details){}
