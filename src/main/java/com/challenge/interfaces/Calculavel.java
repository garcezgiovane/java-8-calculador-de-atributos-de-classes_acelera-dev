package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {
	BigDecimal somar( Object classe ) throws IllegalArgumentException, IllegalAccessException;
	BigDecimal subtrair( Object classe ) throws IllegalArgumentException, IllegalAccessException;
	BigDecimal totalizar( Object classe ) throws IllegalArgumentException, IllegalAccessException;
}
