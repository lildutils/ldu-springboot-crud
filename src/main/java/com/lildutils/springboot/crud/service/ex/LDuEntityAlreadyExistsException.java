package com.lildutils.springboot.crud.service.ex;

@SuppressWarnings("serial")
public class LDuEntityAlreadyExistsException extends RuntimeException
{
	public LDuEntityAlreadyExistsException()
	{
		super( "VM_ENTITY_ALREADY_EXISTS" );
	}

	public LDuEntityAlreadyExistsException( String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace )
	{
		super( message, cause, enableSuppression, writableStackTrace );
	}

	public LDuEntityAlreadyExistsException( String message, Throwable cause )
	{
		super( message, cause );
	}

	public LDuEntityAlreadyExistsException( String message )
	{
		super( message );
	}

	public LDuEntityAlreadyExistsException( Throwable cause )
	{
		super( cause );
	}

}
