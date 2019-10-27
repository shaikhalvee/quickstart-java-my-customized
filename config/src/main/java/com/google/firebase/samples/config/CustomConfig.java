package com.google.firebase.samples.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.firebaseremoteconfig.v1.model.RemoteConfig;
import com.google.api.services.firebaseremoteconfig.v1.model.RemoteConfigParameter;
import com.google.api.services.firebaseremoteconfig.v1.model.RemoteConfigParameterValue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Retrieve and publish templates for Firebase Remote Config using the REST API.
 */
public class CustomConfig {

	private final static String PROJECT_ID = "fcmandroidtestapp";
	private final static String BASE_URL = "https://firebaseremoteconfig.googleapis.com";
	private final static String REMOTE_CONFIG_ENDPOINT = "/v1/projects/" + PROJECT_ID + "/remoteConfig";
	private final static String[] SCOPES = { "https://www.googleapis.com/auth/firebase.remoteconfig" };

	/**
	 * Retrieve a valid access token that can be use to authorize requests to the Remote Config REST
	 * API.
	 *
	 * @return Access token.
	 * @throws IOException
	 */
	// [START retrieve_access_token]
	private static String getAccessToken() throws IOException {
		GoogleCredential googleCredential = GoogleCredential
				.fromStream(new FileInputStream("service-account.json"))
				.createScoped(Arrays.asList(SCOPES));
		googleCredential.refreshToken();
		return googleCredential.getAccessToken();
	}
	// [END retrieve_access_token]

	/**
	 * Read contents of InputStream into String.
	 *
	 * @param inputStream InputStream to read.
	 * @return String containing contents of InputStream.
	 * @throws IOException
	 */
	private static String inputStreamToString(InputStream inputStream) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		Scanner scanner = new Scanner(inputStream);
		while (scanner.hasNext()) {
			stringBuilder.append(scanner.nextLine());
		}
		return stringBuilder.toString();
	}

	/**
	 * Create HttpURLConnection that can be used for both retrieving and publishing.
	 *
	 * @return Base HttpURLConnection.
	 * @throws IOException
	 */
	private static HttpURLConnection getCommonConnection(String endpoint) throws IOException {
		URL url = new URL(endpoint);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		String token = getAccessToken();
		httpURLConnection.setRequestProperty("Authorization", "Bearer " + token);
		httpURLConnection.setRequestProperty("Content-Type", "application/json; UTF-8");
		System.out.println(token);
		return httpURLConnection;
	}

	/**
	 * Get current Firebase Remote Config template from server and store it locally.
	 *
	 * @throws IOException
	 */
	private static void getTemplate() throws IOException {

		HttpURLConnection httpURLConnection = getCommonConnection(BASE_URL + REMOTE_CONFIG_ENDPOINT);
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");

		int code = httpURLConnection.getResponseCode();
		if (code == 200) {
			InputStream inputStream = new GZIPInputStream(httpURLConnection.getInputStream());
//			try {
//				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//				RemoteConfig remoteConfig = (RemoteConfig) objectInputStream.readObject();
//				handleRemoteConfig(remoteConfig);
//			} catch (ClassNotFoundException ex) {
//				System.err.println(ex.getCause().getMessage());
//			}

//			String response = inputStreamToString(inputStream);
			JsonElement inputStreamJsonElement = JsonParser.parseReader(new InputStreamReader(inputStream));
//			JsonElement jsonElement = JsonParser.parseString(response);

			Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
//			String jsonStr = gson.toJson(jsonElement);
			String jsonStr = gson.toJson(inputStreamJsonElement);
			RemoteConfig remoteConfig = gson.fromJson(jsonStr, RemoteConfig.class);
			System.out.println("remote config class: " + remoteConfig.getClass().getCanonicalName());
			handleRemoteConfig(remoteConfig);

			File file = new File("config.json");
			PrintWriter printWriter = new PrintWriter(new FileWriter(file));
			printWriter.print(jsonStr);
			printWriter.flush();
			printWriter.close();

			System.out.println("Template retrieved and has been written to config.json");

			// Print ETag
			String etag = httpURLConnection.getHeaderField("ETag");
			System.out.println("ETag from server: " + etag);
		} else {
			System.out.println(inputStreamToString(httpURLConnection.getErrorStream()));
		}
	}

	private static void handleRemoteConfig(RemoteConfig remoteConfig) {
		Map<String, RemoteConfigParameter> parameterMap = new HashMap<>();
		RemoteConfigParameterValue parameterValue = new RemoteConfigParameterValue();
		ObjectMapper objectMapper = new ObjectMapper();
//		parameterValue = objectMapper.convertValue(remoteConfig.getParameters())
		parameterMap = objectMapper.convertValue(remoteConfig.getParameters(), new TypeReference<Map<String, RemoteConfigParameter>>() {});
		System.out.println("parameterMap: " + parameterMap.toString());
		System.out.println("parameter Class:" + parameterMap.getClass().getName());
		RemoteConfigParameter remoteConfigParameter = parameterMap.get("my_value");
		String value = remoteConfigParameter.getDefaultValue().getValue();
		System.out.println("value: " + value);
	}

	/**
	 * Get electronic tag only
	 *
	 * @throws IOException
	 */
	private static String getEtag() throws IOException {
		HttpURLConnection httpURLConnection = getCommonConnection(BASE_URL + REMOTE_CONFIG_ENDPOINT);
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
		int code = httpURLConnection.getResponseCode();
		if (code == 200) {
			return httpURLConnection.getHeaderField("ETag");
		} else {
			System.out.println(inputStreamToString(httpURLConnection.getErrorStream()));
			return "invalid";
		}
	}

	/**
	 * Publish local template to Firebase server.
	 *
	 * @throws IOException
	 */
	private static void publishTemplate() throws IOException {
		String etag = getEtag();

		System.out.println("Publishing template...");
		HttpURLConnection httpURLConnection = getCommonConnection(BASE_URL + REMOTE_CONFIG_ENDPOINT);
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestMethod("PUT");
		httpURLConnection.setRequestProperty("If-Match", etag);
		httpURLConnection.setRequestProperty("Content-Encoding", "gzip");

		String configStr = readConfig();

		GZIPOutputStream gzipOutputStream = new GZIPOutputStream(httpURLConnection.getOutputStream());
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(gzipOutputStream);
		outputStreamWriter.write(configStr);
		outputStreamWriter.flush();
		outputStreamWriter.close();

		int code = httpURLConnection.getResponseCode();
		if (code == 200) {
			System.out.println("Template has been published.");
		} else {
			System.out.println(inputStreamToString(httpURLConnection.getErrorStream()));
		}

	}

	/**
	 * Read the Firebase Remote Config template from config.json file.
	 *
	 * @return String with contents of config.json file.
	 * @throws FileNotFoundException
	 */
	private static String readConfig() throws FileNotFoundException {
		File file = new File("config.json");
		Scanner scanner = new Scanner(file);

		StringBuilder stringBuilder = new StringBuilder();
		while (scanner.hasNext()) {
			stringBuilder.append(scanner.nextLine());
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args) throws IOException {
		RemoteConfig remoteConfig = new RemoteConfig();
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String val = input.nextLine();
			if (val.equals("publish")) {
				publishTemplate();
			} else if (val.equals("get")) {
				getTemplate();
			} else {
				System.exit(0);
			}
		}
	}

}
