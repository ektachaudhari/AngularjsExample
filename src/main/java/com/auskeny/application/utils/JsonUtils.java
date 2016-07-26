package com.auskeny.application.utils;

import java.lang.reflect.Type;
import java.util.List;

import com.auskeny.hibernate.pojo.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class JsonUtils {

	private static GsonBuilder builder = new GsonBuilder();
	private static Gson gsonJavaToJsonConverter = builder.create();

	/**
	 * Convert json string to JsonObject.
	 * 
	 * @param strJson
	 * @param class1
	 * @return JsonObject
	 */
	public static JsonObject getJsonObjectFromJsonString(String strJson, Class<Product> class1) {
		Gson gson = new Gson();
		return gson.fromJson(strJson, JsonObject.class);
	}

	/**
	 * Convert json string to java object.
	 * 
	 * @param strJson
	 * @param classT
	 * @return
	 */
	public static <T> T getJavaObjectFromJson(String strJson, Class<T> classT) {
		Gson gson = builder.create();
		return gson.fromJson(strJson, classT);
	}

	/**
	 * Convert java object into json.
	 * 
	 * @param t
	 * @param classT
	 * @return String Json
	 */
	public static <T> String getJsonFromJavaObject(T t, Class<T> classT) {
		return gsonJavaToJsonConverter.toJson(t, classT).toString();
	}

}
