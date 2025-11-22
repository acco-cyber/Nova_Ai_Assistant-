public class MockAPI {
    private static final String[] DEFAULT_RESPONSES = {
            "I understand what you're saying. Please continue.",
            "That's an interesting perspective. Could you elaborate?",
            "I'm here to listen and help. What else would you like to discuss?",
            "Let me think about that for a moment...",
            "I see what you mean. Would you like to explore that further?",
            "That's a fascinating topic. What aspects interest you most?",
            "I appreciate you sharing that with me. How does it make you feel?",
            "Let's explore that idea together. What are your thoughts?",
            "I'm curious to hear more about your perspective on this.",
            "That's a good point. How did you come to that conclusion?"
    };

    private static int lastIndex = -1;

    public static String getFallbackResponse(String input) {
        // Choose a response that wasn't used last time
        int index;
        do {
            index = (int) (Math.random() * DEFAULT_RESPONSES.length);
        } while (index == lastIndex);

        lastIndex = index;
        return DEFAULT_RESPONSES[index];
    }
}