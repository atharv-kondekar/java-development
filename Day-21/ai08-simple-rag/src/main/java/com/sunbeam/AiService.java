package com.sunbeam;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class AiService {

	private SimpleVectorStore vectorStore;

	public AiService(EmbeddingModel embeddingModel) {

		this.vectorStore = SimpleVectorStore
							.builder(embeddingModel)
							.build();
	}




// ------------------ Vector Store Management -------------------
	public void initStore() {

		File dbDFile = new File("store.json");
		if (dbDFile.exists()) {
			System.out.println("Vector DB file is already present");
			return;
		}

		try {
			// Load the 'sample-data.txt' from resources folder
			ClassPathResource dataFile = new ClassPathResource("sample-data.txt");

			// Get the file path of the resource-file i.e 'sample-data.txt'
			Path dataFilePath =  dataFile.getFilePath();

			// Read the file 'line by line' and convert -> 'each line into Document'
		    List<Document> dataDocs  = 	Files.lines(dataFilePath)
		    						// Remove the unnecessary spaces form beginning and end of each line
									.map(    line -> line.trim() )
									// Ignore Empty lines
									.filter( line -> !line.isEmpty())
									// Convert each non-empty line into the Document Object
									.map(    line -> new Document(line))
									// Collect all document object to the List
									.toList();

		    // Store all documents in vector database for future similarity searches
			vectorStore.add(dataDocs);

			System.out.println("Vector DB is initialized");

		} catch (Exception e) {
			throw new RuntimeException("Failed to init vector DB "+e);
		}
	}

//Execute this method automatically when the spring bean is created
	@PostConstruct
	public void loadVectorStore() {
		//create File object representing the saved Vector DB json file
		File dbFile = new File("store.json");

		// check whether the previously saved Vector DB file exists
		if (dbFile.exists()) {
			//load the existing vector file form the .json file into VECTOR STORE
			vectorStore.load(dbFile);
			System.out.println("Vector  DB is Loaded from the .json file ");
		}
	}


// Execute this method automatically before the Spring Bean is destroyed
	@PreDestroy
	public void saveVectorStore() {
	    // Create a File object for storing the Vector DB data
		File dbFile =  new File("store.json");

		// Save the current Vector DB data into the JSON file
		vectorStore.save(dbFile);

		System.out.println("Vector DB is saved on .json file");
	}

// Retrieval part
	public List<Document> search(String question , int count , double similarityThreshold) {

		SearchRequest request = SearchRequest.builder()
					.query(question)
					.similarityThreshold(similarityThreshold)
					.topK(count)
					.build();

		List<Document> result = vectorStore.similaritySearch(request);

		return result;
	}
}
