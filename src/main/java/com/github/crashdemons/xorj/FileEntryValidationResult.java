/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.crashdemons.xorj;

/**
 *
 * @author crash
 */
public enum FileEntryValidationResult {
    NO_ERROR("No validation error occurred."),
    LENGTH_ZERO("The length of the file cannot be zero."),
    START_POSITION_LOW("The starting position cannot be less than zero."),
    START_POSITION_HIGH("The starting position cannot be beyond the length of the file."),
    START_POSITION_BEYOND_END("The starting position cannot be past than the ending position."),
    
    END_POSITION_LOW("The ending position cannot be less than zero."),
    END_POSITION_HIGH("The ending position cannot be beyond the length of the file (should be length-1).");
    
    private String message;
    
    FileEntryValidationResult(String message){
        this.message=message;
    }
    
    public String getMessage(){
        return message;
    }
    
}
