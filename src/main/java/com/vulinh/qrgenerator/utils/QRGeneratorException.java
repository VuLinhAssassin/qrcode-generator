package com.vulinh.qrgenerator.utils;

/**
 * We need to remove all checked exceptions completely :3
 */
public class QRGeneratorException extends RuntimeException {

    /*
     * Thank you 'Save Action' plugin for IntelliJ xD
     */
    private static final long serialVersionUID = 7338284437656199209L;

    public QRGeneratorException(String message, Throwable exception) {
        super(message, exception);
    }
}