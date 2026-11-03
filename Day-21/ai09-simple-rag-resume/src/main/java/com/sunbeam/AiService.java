package com.sunbeam;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
import org.springframework.stereotype.Service;

@Service
public class AiService {

	private QdrantVectorStore qdrantVectorStore;
	private ChatClient chatClient;

	public AiService(QdrantVectorStore qdrantVectorStore, ChatClient.Builder builder) {
		this.qdrantVectorStore = qdrantVectorStore;

		SearchRequest searchRequest = SearchRequest.builder()
							.topK(4)
							.similarityThreshold(0.5)
							.build();

		QuestionAnswerAdvisor qaAdvisor = QuestionAnswerAdvisor.builder(qdrantVectorStore)
					.searchRequest(searchRequest)
					.build();

		this.chatClient = builder
				.defaultSystem("""
						You are the helpful assistant.
						Answer the Question based on supplied Context
						""")
				.defaultAdvisors(qaAdvisor)
				.build();
	}

	public int addPdfPages(String pdfResourceUrl) {
		PagePdfDocumentReader pdfReader = new PagePdfDocumentReader(pdfResourceUrl);
		List<Document> docs = pdfReader.read();
		qdrantVectorStore.add(docs);

		return docs.size();
	}

	public String chat(String question) {
		String response	= chatClient.prompt()
					.user(question)
					.call()
					.content();

		return response;
	}
}
