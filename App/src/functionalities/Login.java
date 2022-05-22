package functionalities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Login {

	private String username;
	private String password;

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	private String readFile(String path) throws IOException {
		byte[] data = Files.readAllBytes(Paths.get(path));
		return new String(data);
	}

	public boolean tryLogin() {

		String jsonFileContent = null;

		try {
			jsonFileContent = readFile("credentials.json");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		java.lang.reflect.Type credentialsListType = new TypeToken<ArrayList<LoginCredentials>>() {
		}.getType();
		List<LoginCredentials> _credentials = new Gson().fromJson(jsonFileContent, credentialsListType);

		return !_credentials.stream()
				.filter(login -> login.getUsername().equals(username) && login.getPassword().equals(password)).findAny()
				.isEmpty();
	}
}
