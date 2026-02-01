package br.com.alura.screen_music.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ConsultaGemini {

    public static String obterInformacao(String texto) {

        try {
            Client client = new Client();

            GenerateContentResponse response =
                    client.models.generateContent(
                            "gemini-3-flash-preview",
                            "Elabore um resumo de informações sobre o autor: " + texto,
                            null
                    );
            return response.text();

        } catch (Exception e) {
            return "Erro ao tentar chamar api gemini" + e.getMessage();
        }
    }
}
