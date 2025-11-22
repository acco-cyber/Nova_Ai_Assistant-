package ai;

/**
 * Builds optimized prompts for different tasks
 */
public class PromptBuilder {
    
    /**
     * Generate prompt for OCR text improvement
     */
    public static String buildOCRPrompt(String ocrText) {
        return "You are an expert OCR text processor. Analyze the following extracted text and improve its accuracy. " +
               "Fix any OCR errors, format it properly, and ensure readability. Preserve the original meaning and structure.\n\n" +
               "OCR Text:\n" + ocrText + "\n\n" +
               "Provide the corrected and formatted text with proper punctuation and structure. " +
               "Only output the corrected text, no explanations.";
    }
    
    /**
     * Generate prompt for flashcard creation
     */
    public static String buildFlashcardPrompt(String content) {
        return "You are an expert educator. Create comprehensive flashcards from the following content. " +
               "Generate question-answer pairs that test key concepts, definitions, and important facts. " +
               "Make questions clear and answers concise but complete.\n\n" +
               "Content:\n" + content + "\n\n" +
               "Format each flashcard as:\n" +
               "Q: [Question]\n" +
               "A: [Answer]\n\n" +
               "Create 5-8 flashcards covering the most important concepts. Only output the flashcards, no additional text.";
    }
    
    /**
     * Generate prompt for quiz creation
     */
    public static String buildQuizPrompt(String content) {
        return "You are an expert quiz creator. Generate a comprehensive quiz from the following content. " +
               "Create questions of varying difficulty levels that test understanding, application, and analysis.\n\n" +
               "Content:\n" + content + "\n\n" +
               "Format each question as:\n" +
               "Q: [Question]\n" +
               "A: [Answer]\n\n" +
               "Create 5-7 questions that thoroughly assess comprehension of the material. " +
               "Only output the questions and answers, no additional text.";
    }
    
    /**
     * Generate prompt for text summarization
     */
    public static String buildSummaryPrompt(String content) {
        return "You are an expert text summarizer. Create a concise, comprehensive summary of the following text. " +
               "Capture the main ideas, key points, and essential information while maintaining clarity and coherence.\n\n" +
               "Text:\n" + content + "\n\n" +
               "Provide a well-structured summary that covers all important aspects in 2-3 paragraphs. " +
               "Only output the summary, no additional text.";
    }
    
    /**
     * Generate prompt for keyword extraction
     */
    public static String buildKeywordPrompt(String content) {
        return "You are an expert content analyzer. Extract and identify the most important keywords and key phrases " +
               "from the following text. Focus on technical terms, main concepts, and significant topics.\n\n" +
               "Text:\n" + content + "\n\n" +
               "Provide a list of 10-15 keywords/phrases ranked by importance. " +
               "Format as a simple comma-separated list. Only output the keywords, no explanations.";
    }
    
    /**
     * Generate prompt for chat conversation
     */
    public static String buildChatPrompt(String userMessage, String context) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("You are an AI learning assistant helping students understand complex topics. ");
        prompt.append("Be helpful, clear, and educational in your responses.\n\n");
        
        if (context != null && !context.isEmpty()) {
            prompt.append("Context:\n").append(context).append("\n\n");
        }
        
        prompt.append("User: ").append(userMessage).append("\n\n");
        prompt.append("Provide a helpful and educational response.");
        
        return prompt.toString();
    }
    
    /**
     * Generate prompt for difficulty analysis
     */
    public static String buildDifficultyPrompt(String content) {
        return "You are an expert text analyst. Analyze the reading difficulty of the following text. " +
               "Consider vocabulary complexity, sentence structure, and concept difficulty.\n\n" +
               "Text:\n" + content + "\n\n" +
               "Provide a difficulty rating (Easy/Medium/Hard) and a brief explanation. " +
               "Format: RATING: [Easy/Medium/Hard] - [Brief explanation]";
    }
}
