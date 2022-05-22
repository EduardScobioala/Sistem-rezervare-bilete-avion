package functionalities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class CreateCredentials {

	static List<LoginCredentials> getCredentials() {
		List<LoginCredentials> credentials = new ArrayList<LoginCredentials>();

		// Add credentials to the list
		credentials.add(new LoginCredentials("admin", "admin"));
		credentials.add(new LoginCredentials("eduard", "god_mode"));

		return credentials;
	}

	public static void main(String[] args) throws IOException {

		List<LoginCredentials> credentials = getCredentials();

		// Save data in a JSON file
		Gson obj = new Gson();

		// Write to file
		BufferedWriter writer = new BufferedWriter(new FileWriter("credentials.json"));
		writer.write(obj.toJson(credentials));

		writer.close();
	}
}
