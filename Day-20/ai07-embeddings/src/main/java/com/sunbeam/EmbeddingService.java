package com.sunbeam;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;

@Service
public class EmbeddingService {
	private EmbeddingModel embeddingModel;

	public EmbeddingService(EmbeddingModel embeddingModel) {
		this.embeddingModel=embeddingModel;
	}

	public float[] embed(String text) {
		float [] vector = embeddingModel.embed(text);
		return vector;
	}

	// if two vectors are similar -> similarity is close to +1
	// if two vectors are opposite -> similarity is close to -1
	// if two vectors are unrelated -> similarity is close to 0
	double cosineSimilarity(float[] a, float[] b) {
	    double dot = 0;
	    double normA = 0;
	    double normB = 0;

	    for (int i = 0; i < a.length; i++) {
	        dot += a[i] * b[i];
	        normA += a[i] * a[i];
	        normB += b[i] * b[i];
	    }

	    return dot / (Math.sqrt(normA) * Math.sqrt(normB));
	}
}
