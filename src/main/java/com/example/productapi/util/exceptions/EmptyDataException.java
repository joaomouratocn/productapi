package com.example.productapi.util.exceptions;

public class EmptyDataException extends RuntimeException{
    public EmptyDataException(){super("Data is empty");}
}