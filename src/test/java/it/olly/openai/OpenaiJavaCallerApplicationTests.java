package it.olly.openai;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.OpenAiEmbeddingOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenaiJavaCallerApplicationTests {
	
	@Autowired
	EmbeddingModel embeddingModel;
	
	@Autowired
	ChatModel chatModel;


	/**
	 * https://docs.spring.io/spring-ai/reference/api/embeddings/openai-embeddings.html
	 */
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
	
	/**
	 * https://docs.spring.io/spring-ai/reference/api/chat/openai-chat.html
	 */
	@Test
	void simpleTestChat() {
		System.out.println("DOING simpleTestChat...");
		/*ChatResponse chatResponse = chatModel.call(
			    new Prompt(
			        "Generate the names of 5 famous pirates.",
			        OpenAiChatOptions.builder()
			            .withModel("gpt-4-o")
			            .withTemperature(0.4f)
			        .build()));*/
		String question = "Generate the names of 5 famous pirates.";
		String response = chatModel.call(question);
		System.out.println(question+" -> "+response);
		System.out.println("simpleTestChat DONE");
	}

}
