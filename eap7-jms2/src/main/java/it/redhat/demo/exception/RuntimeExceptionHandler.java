package it.redhat.demo.exception;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import it.redhat.demo.mdb.CounterSingleton;

@Provider
public class RuntimeExceptionHandler implements ExceptionMapper<RuntimeException> {
	
	@Inject
	private CounterSingleton counter;

	@Override
	public Response toResponse(RuntimeException exception) {
		return Response.ok("3").build();
	}

}
