package com.challenge.desafio;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {

	@Override
	public BigDecimal somar( Object classe ) throws IllegalArgumentException, IllegalAccessException {
		return somarAtributosDeClasse( classe, Somar.class );
	}

	@Override
	public BigDecimal subtrair( Object classe ) throws IllegalArgumentException, IllegalAccessException {
		return somarAtributosDeClasse( classe, Subtrair.class );
	}

	@Override
	public BigDecimal totalizar( Object classe ) throws IllegalArgumentException, IllegalAccessException {
		return somar( classe ).subtract( subtrair( classe ) );
	}
	
	private BigDecimal somarAtributosDeClasse( Object obj, Class<? extends Annotation> classe ) throws IllegalArgumentException, IllegalAccessException {
		BigDecimal valor = BigDecimal.ZERO;
		for( Field field : obj.getClass().getDeclaredFields() ) {
			if( field.isAnnotationPresent( classe ) && field.getType().equals( BigDecimal.class ) ) {
				field.setAccessible( Boolean.TRUE );
				valor = valor.add( field.get( obj ) == null ? BigDecimal.ZERO : ( BigDecimal ) field.get( obj ) );
			}
		}
		return valor;
	}
}