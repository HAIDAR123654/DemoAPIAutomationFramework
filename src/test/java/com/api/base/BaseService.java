package com.api.base;

import static io.restassured.RestAssured.*;
import com.api.filters.LoggingFilters;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { // wrapper for the Rest Assured

	// BASE URI
	// CREATING THE REQUEST
	// HANDLING THE RESPONSE

	private static final String BASE_URL = "http://64.227.160.186:8080";

	// private final RequestSpecification requestSpecification;

	static {
		RestAssured.filters(new LoggingFilters());
	}
//===================================================================================================
	private static final ThreadLocal<RequestSpecification> requestSpec = new ThreadLocal<>();

	protected RequestSpecification getRequestSpec() {
		RequestSpecification spec = requestSpec.get();
		if (spec == null) {
			spec = initRequestSpec();
			requestSpec.set(spec);
		}
		return spec;
	}

	private RequestSpecification initRequestSpec() {
		return RestAssured.given().contentType(ContentType.JSON).baseUri(BASE_URL);
	}

	protected void clearRequestSpec() {
		requestSpec.remove();
	}

	//=====================================================================================================
//	public BaseService() {
//		requestSpecification = given().baseUri(BASE_URL);
//	}

	public void setAuthToken(String token) {
		getRequestSpec().header("Authorization", "Bearer " + token);
	}

	protected Response postRequest(Object payload, String endPoint) {
		return getRequestSpec().body(payload).post(endPoint);
		//return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
	}

	protected Response putRequest(Object payload, String endPoint) {
		return getRequestSpec().body(payload).put(endPoint);
		//return requestSpecification.contentType(ContentType.JSON).body(payload).put(endPoint);
	}

	protected Response getRequest(String endPoint) {
		return getRequestSpec().get(endPoint);
		//return requestSpecification.get(endPoint);
	}

}
