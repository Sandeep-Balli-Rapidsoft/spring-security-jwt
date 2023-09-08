package jwt.models;

import org.springframework.http.HttpStatus;

public class Response<T> {
	private String message;

	private String username;

	private HttpStatus httpStatus;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Response(String message, String username, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.username = username;
		this.httpStatus = httpStatus;
	}

}
