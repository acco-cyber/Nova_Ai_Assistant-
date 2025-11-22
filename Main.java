package com.novaswing;

import java.util.Scanner;

/**
 * Main class to demonstrate AI API integration
 */
public class Main {
    private static AIService aiService;
    private static Config config;

    public static void main(String[] args) {
        System.out.println("🤖 Nova Swing AI - Powered by OpenAI API");
        System.out.println("==========================================");

        // Initialize configuration and AI service
        config = new Config();

        if (!config.isApiKeyConfigured()) {
            System.out.println("⚠️  OpenAI API key not configured!");
            System.out.println("Please set your API key using one of these methods:");
            System.out.println("1. Set environment variable: OPENAI_API_KEY=your-key-here");
            System.out.println("2. Create config.properties file with: openai.api.key=your-key-here");
            System.out.println("3. Set system property: -Dopenai.api.key=your-key-here");
            System.out.println();
            System.out.println("You can get an API key from: https://platform.openai.com/api-keys");
            System.out.println();
        }

        aiService = new AIService(config.getOpenAIApiKey());

        // Test connection if API key is configured
        if (config.isApiKeyConfigured()) {
            System.out.println("🔗 Testing API connection...");
            if (aiService.testConnection()) {
                System.out.println("✅ API connection successful!");
            } else {
                System.out.println("❌ API connection failed. Please check your API key.");
                return;
            }
        }

        // Interactive chat loop
        runInteractiveChat();
    }

    private static void runInteractiveChat() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n💬 Start chatting with Nova! (Type 'quit' to exit)");
        System.out.println("You can also set your mood by typing 'mood: [your mood]'");
        System.out.println();

        String currentMood = "happy";

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("exit")) {
                System.out.println("👋 Goodbye! Thanks for chatting with Nova!");
                break;
            }

            if (userInput.isEmpty()) {
                continue;
            }

            // Check for mood setting
            if (userInput.toLowerCase().startsWith("mood:")) {
                currentMood = userInput.substring(5).trim();
                System.out.println("Nova: I understand you're feeling " + currentMood + " today. How can I help?");
                continue;
            }

            // Get AI response
            System.out.print("Nova: ");
            String response = aiService.getAIResponse(userInput, currentMood);
            System.out.println(response);
            System.out.println();
        }

        scanner.close();
    }
}
