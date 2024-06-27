package it.olly.openai;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.openai.OpenAiEmbeddingOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenaiJavaCallerApplicationTests {
	
	@Autowired
	EmbeddingModel embeddingModel;

	
	@Test
	void simpleTestEmbeddings() {
		System.out.println("DOING simpleTestEmbeddings...");
		/*EmbeddingResponse embeddingResponse = embeddingModel.call(
			    new EmbeddingRequest(List.of("Hello World", "World is big and salvation is near"),
			        OpenAiEmbeddingOptions.builder()
			            .withModel("Different-Embedding-Model-Deployment-Name")
			        .build()));*/
		List<String> texts = List.of("Hello World");
		List<List<Double>> embeddings = embeddingModel.embed(texts);
		System.out.println("Got embeddings");
		for (int i=0;i<texts.size();i++) {
			System.out.println(texts.get(i)+" -> "+embeddings.get(i));
		}
		System.out.println("simpleTestEmbeddings DONE");
	}

}
