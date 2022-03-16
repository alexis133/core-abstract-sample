package com.example.demo.exception;

public class NoSuchShoeException extends Exception {

  public NoSuchShoeException(String message) {
    super(message);
  }

  public NoSuchShoeException(String message, Throwable cause) {
    super(message, cause);
  }
}
