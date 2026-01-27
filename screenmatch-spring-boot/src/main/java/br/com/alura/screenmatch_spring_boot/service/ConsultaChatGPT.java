package br.com.alura.screenmatch_spring_boot.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    private final static String apiKey = System.getenv("OPENAI_API_KEY");

    public static String obterTraducao(String texto) {
        try {
            OpenAiService service = new OpenAiService(apiKey);

            CompletionRequest requisicao = CompletionRequest.builder()
                    .model("gpt-3.5-turbo-instruct")
                    .prompt("Traduza para o português o texto:" + texto)
                    .maxTokens(1000)
                    .temperature(0.7)
                    .build();

            var resposta = service.createCompletion(requisicao);
            System.out.println(resposta);
            System.out.println(resposta.getChoices());
            System.out.println(resposta.getChoices().get(0));
            System.out.println(resposta.getChoices().get(0).getText());
            //return resposta.getChoices().get(0).getText();
            return "Alguma coisa...";
        } catch (Exception e) {
            System.out.println("Erro da requisição da api: " + e.getMessage());
            return "Erro ao tentar obter a tradução";
        }
    }
}
