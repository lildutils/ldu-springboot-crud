package com.lildutils.springboot.crud.service.ex;

@SuppressWarnings("serial")
public class LDuEntityNotFoundException extends RuntimeException
{
	public LDuEntityNotFoundException()
	{
		super( "VM_ENTITY_NOT_FOUND" );
	}

	public LDuEntityNotFoundException( String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace )
	{
		super( message, cause, enableSuppression, writableStackTrace );
	}

	public LDuEntityNotFoundException( String message, Throwable cause )
	{
		super( message, cause );
	}

	public LDuEntityNotFoundException( String message )
	{
		super( message );
	}

	public LDuEntityNotFoundException( Throwable cause )
	{
		super( cause );
	}

}
