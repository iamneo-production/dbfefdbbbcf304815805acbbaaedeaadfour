package com.examly.springapp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.examly.springapp.controller.BookController;
import com.examly.springapp.service.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class) // Specify the controller class to test
@AutoConfigureMockMvc
public class SpringappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService; // Mock the service, if needed

	@Before
	public void setUp() {
		// You can set up mock behavior for the service here if necessary
	}

	@Test
	public void testGetAllBooksStatus() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/books")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testAddBookStatus() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/books")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"title\":\"Sample Book\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void controllerfolder() {
		String directoryPath = "src/main/java/com/examly/springapp/controller"; // Replace with the path to your
																				// directory
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void controllerfile() {
		String filePath = "src/main/java/com/examly/springapp/controller/BookController.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testModelFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your directory
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testModelFile() {
		String filePath = "src/main/java/com/examly/springapp/model/Book.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testServiceFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/service";
		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());

	}

	@Test
	public void testServieFile() {

		String filePath = "src/main/java/com/examly/springapp/service/BookService.java";

		// Replace with the path to your file

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

}
