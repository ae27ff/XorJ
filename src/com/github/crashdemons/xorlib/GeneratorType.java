/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.crashdemons.xorlib;

/**
 *
 * @author crash
 */

public enum GeneratorType {
    CONSTANT,INCREMENTAL,RANDOM;
    
    public static final int COUNT = GeneratorType.values().length;
}
