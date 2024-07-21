package com.example.productapi.util;

public class EmptyDataException extends RuntimeException{
    public EmptyDataException(){super("Data is empty");}
}