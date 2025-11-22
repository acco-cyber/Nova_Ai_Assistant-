import java.io.*;

public class NovaBot {
    private final String name;
    private final EmotionEngine emotion;
    private final MockAPI mockAPI;
    private final ai.GroqAPIClient groqClient;

    public NovaBot(String name) {
        this.name = name;
        this.emotion = new EmotionEngine();
        this.mockAPI = new MockAPI();

        // Try to initialize Groq client with environment variable
        String apiKey = System.getenv("GROQ_API_KEY");
        if (apiKey != null && !apiKey.trim().isEmpty()) {
            try {
                this.groqClient = new ai.GroqAPIClient(apiKey);
                System.out.println("🔌 Groq API enabled for Nova responses");
            } catch (Exception e) {
                System.err.println("⚠️ Failed to initialize Groq API: " + e.getMessage());
                this.groqClient = null;
            }
        } else {
            System.out.println("ℹ️ Groq API not configured (set GROQ_API_KEY environment variable to enable)");
            this.groqClient = null;
        }
    }

    public String getResponse(String userInput) {
        if (userInput.equalsIgnoreCase("bye")) {
            return emotion.emote("Goodbye! Take care! 👋");
        }

        // Update emotion based on user input
        emotion.update(userInput);

        // Try Groq API first if available
        if (groqClient != null && groqClient.isEnabled()) {
            try {
                String reply = groqClient.chat(userInput);
                if (reply != null && !reply.trim().isEmpty()) {
                    return emotion.emote(reply);
                }
            } catch (Exception e) {
                System.err.println("❌ Groq API call failed, falling back to mock: " + e.getMessage());
            }
        }

        // Fallback to mock API
        return emotion.emote(mockAPI.getFictionalAIResponse(userInput, emotion.getCurrentEmotion()));
    }
}