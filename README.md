#  NovaSwing AI Assistant

<div align="center">

![Java](https://img.shields.io/badge/Java-11+-007396?style=for-the-badge&logo=java&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Production%20Ready-success?style=for-the-badge)
![AI](https://img.shields.io/badge/AI-LLaMA%203.1-blue?style=for-the-badge)

**A production-grade desktop AI assistant built with Java, featuring emotional intelligence, enterprise architecture, and seamless LLM integration.**

[Features](#-features) • [Quick Start](#-quick-start) • [Architecture](#-architecture) • [Documentation](#-documentation) • [Contributing](#-contributing)

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Key Features](#-features)
- [System Architecture](#-architecture)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Configuration](#-configuration)
- [Usage Guide](#-usage-guide)
- [Project Structure](#-project-structure)
- [API Integration](#-api-integration)
- [Development](#-development)
- [Testing](#-testing)
- [Deployment](#-deployment)
- [Troubleshooting](#-troubleshooting)
- [Contributing](#-contributing)
- [License](#-license)
- [Acknowledgments](#-acknowledgments)

---

## 🎯 Overview

**NovaSwing AI** is an enterprise-grade desktop application that democratizes access to advanced AI capabilities through an intuitive graphical interface. Built with Java and integrating Groq's LLaMA 3.1 70B model, it combines cutting-edge natural language processing with emotional intelligence to deliver context-aware, empathetic responses.

### Why NovaSwing?

- ✅ **Zero-Configuration AI**: No complex setup, just plug and play
- ✅ **Emotional Intelligence**: Analyzes sentiment and adapts tone
- ✅ **Enterprise Architecture**: Clean, maintainable, SOLID-compliant code
- ✅ **Offline Fallback**: MockAPI ensures functionality without internet
- ✅ **Production Ready**: Comprehensive error handling and retry logic

---

## ✨ Features

### Core Capabilities

- 🎨 **Modern GUI Interface**
  - Clean, responsive Swing-based UI
  - Real-time message rendering
  - Conversation history with auto-scroll
  - "Thinking" indicators during processing

- 🧠 **Emotional Intelligence Engine**
  - Sentiment analysis on user input
  - Mood detection (Happy, Sad, Angry, Neutral, Confused, Grateful)
  - Adaptive response tone based on emotional context
  - Conversation mood tracking

- 🔌 **Robust API Integration**
  - RESTful communication with Groq API
  - Automatic retry with exponential backoff
  - Rate limiting protection
  - Comprehensive error handling

- 💾 **Conversation Management**
  - Context-aware responses (20-message history)
  - Session continuity
  - Clear conversation capability
  - Message timestamp tracking

- 🛡️ **Enterprise-Grade Reliability**
  - Multi-threaded async operations
  - Graceful degradation to MockAPI
  - Detailed logging system
  - Configuration validation

### Technical Highlights

```
📊 Code Statistics:
   - 9 Core Classes
   - 95+ Documented Functions
   - 1,700+ Lines of Production Code
   - 100% Java Implementation
   - 0 External Dependencies (excluding JSON)
```

---

## 🏗️ Architecture

### System Design

```
┌─────────────────────────────────────────────────────────┐
│                   Presentation Layer                    │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐ │
│  │   Main.java  │  │   ChatUI     │  │   NovaBot    │ │
│  └──────────────┘  └──────────────┘  └──────────────┘ │
└─────────────────────────────────────────────────────────┘
                            │
┌─────────────────────────────────────────────────────────┐
│                   Business Logic Layer                  │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐ │
│  │GroqAPIClient │  │EmotionEngine │  │   MockAPI    │ │
│  └──────────────┘  └──────────────┘  └──────────────┘ │
└─────────────────────────────────────────────────────────┘
                            │
┌─────────────────────────────────────────────────────────┐
│                   Data Access Layer                     │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐ │
│  │ APIRequest   │  │ APIResponse  │  │ConfigManager │ │
│  └──────────────┘  └──────────────┘  └──────────────┘ │
└─────────────────────────────────────────────────────────┘
                            │
┌─────────────────────────────────────────────────────────┐
│                      Data Models                        │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐ │
│  │   Message    │  │    Choice    │  │    Usage     │ │
│  └──────────────┘  └──────────────┘  └──────────────┘ │
└─────────────────────────────────────────────────────────┘
```

### Design Patterns Implemented

- **MVC Architecture**: Clear separation of concerns
- **Singleton Pattern**: ConfigManager, ExceptionHandler
- **Factory Pattern**: APIRequest/APIResponse builders
- **Strategy Pattern**: EmotionEngine adaptation logic
- **Observer Pattern**: GUI event handling

---

## 🔧 Prerequisites

### System Requirements

| Component | Requirement |
|-----------|-------------|
| **Java** | JDK 11 or higher |
| **Memory** | Minimum 512MB RAM |
| **OS** | Windows 10+, macOS 10.14+, Linux (any) |
| **Network** | Internet connection for API calls |

### Development Tools (Optional)

- Maven 3.6+ for building
- Git for version control
- IntelliJ IDEA / Eclipse / VS Code

---

## 🚀 Installation

### Quick Start (5 minutes)

```bash
# 1. Clone the repository
git clone https://github.com/yourusername/NovaSwingAI.git
cd NovaSwingAI

# 2. Set up your API key (see Configuration section)
# Note: API key not included in repository for security

# 3. Compile the project
javac -d bin -sourcepath src/main/java src/main/java/com/novaswing/Main.java

# 4. Run the application
java -cp bin com.novaswing.Main
```

### Maven Build (Recommended)

```bash
# Build with Maven
mvn clean package

# Run the JAR
java -jar target/novaswing-ai-1.0.0-jar-with-dependencies.jar
```

### Pre-compiled Binary

Download the latest release from [Releases](https://github.com/yourusername/NovaSwingAI/releases) and run:

```bash
java -jar NovaSwingAI.jar
```

---

## ⚙️ Configuration

### API Key Setup

**⚠️ IMPORTANT: API key not included in repository for security reasons.**

You'll need to obtain your own Groq API key:

1. **Get API Key**: Visit [Groq Console](https://console.groq.com) and create a free account
2. **Generate Key**: Navigate to API Keys section and create a new key
3. **Configure Application**: Choose one of the methods below

#### Method 1: Environment Variable (Recommended)

```bash
# Linux/macOS
export GROQ_API_KEY="your_api_key_here"

# Windows (Command Prompt)
set GROQ_API_KEY=your_api_key_here

# Windows (PowerShell)
$env:GROQ_API_KEY="your_api_key_here"
```

#### Method 2: Configuration File

Create `config.properties` in the root directory:

```properties
# Groq API Configuration
api.key=your_groq_api_key_here
api.model=llama-3.1-70b-versatile
api.endpoint=https://api.groq.com/openai/v1/chat/completions

# Model Parameters
api.temperature=0.7
api.max_tokens=4096

# Application Settings
debug.mode=false
```

#### Method 3: Hardcode (Development Only)

Edit `ConfigManager.java` (line 23):

```java
private String apiKey = "your_api_key_here"; // NOT RECOMMENDED FOR PRODUCTION
```

### Advanced Configuration

```properties
# Retry Strategy
retry.max_attempts=3
retry.backoff_multiplier=2

# Conversation Settings
conversation.max_history=20
conversation.auto_save=false

# UI Customization
ui.theme=light
ui.font_size=14
ui.window_width=800
ui.window_height=600
```

---

## 📖 Usage Guide

### Basic Usage

1. **Launch Application**
   ```bash
   java -jar NovaSwingAI.jar
   ```

2. **Type Your Message**
   - Enter any question or prompt in the input field
   - Press `Enter` or click `Send`

3. **View Response**
   - AI response appears in the chat area
   - Conversation history is maintained automatically

4. **Clear Conversation**
   - Click `Clear` button to reset the chat
   - History is wiped but session continues

### Example Interactions

```
You: What is machine learning?
Nova: Machine learning is a subset of artificial intelligence 
that enables systems to learn and improve from experience...

You: I'm feeling frustrated with my code
Nova: [Detects frustration] I understand coding can be 
challenging. Let's break down the problem together...
```

### Advanced Features

#### Emotional Context

The EmotionEngine automatically:
- Detects user mood from language patterns
- Adapts response tone (empathetic, encouraging, neutral)
- Maintains emotional context across conversation

#### Offline Mode

When API is unavailable:
- MockAPI provides intelligent fallback responses
- No functionality loss for basic queries
- Automatic retry when connection restored

---

## 📁 Project Structure

```
NovaSwingAI/
├── src/main/java/
│   ├── models/              # Data models
│   │   ├── Message.java     # 95 lines - Message structure
│   │   ├── Choice.java      # 110 lines - API response choice
│   │   └── Usage.java       # 80 lines - Token tracking
│   │
│   ├── config/              # Configuration management
│   │   └── ConfigManager.java  # 230 lines - Config loader
│   │
│   ├── utils/               # Utilities
│   │   └── ExceptionHandler.java  # 210 lines - Error handling
│   │
│   ├── api/                 # API abstraction layer
│   │   ├── APIRequest.java  # 205 lines - Request builder
│   │   └── APIResponse.java # 280 lines - Response parser
│   │
│   ├── ai/                  # Core AI integration
│   │   └── GroqAPIClient.java  # 303 lines - API client
│   │
│   └── com/novaswing/       # Application layer
│       ├── Main.java        # GUI & entry point
│       ├── NovaBot.java     # Bot orchestration
│       ├── EmotionEngine.java  # Sentiment analysis
│       ├── MockAPI.java     # Fallback responses
│       └── QuickAPITest.java   # API testing utility
│
├── bin/                     # Compiled .class files
├── lib/                     # External libraries
├── docs/                    # Documentation
│   ├── ARCHITECTURE.md      # System architecture
│   ├── CLASSES_DOCUMENTATION.md  # Class reference
│   └── FUNCTION_REFERENCE.md     # Function index
│
├── config.properties.template  # Configuration template
├── pom.xml                  # Maven build file
├── README.md               # This file
└── LICENSE                 # MIT License
```

### Code Metrics

```
Total Classes:       9 core + 2 utility
Total Methods:       95+ documented functions
Lines of Code:       1,700+ production code
Test Coverage:       Coming soon (Phase 2)
Documentation:       100% JavaDoc coverage
```

---

## 🔌 API Integration

### Groq API Overview

NovaSwing integrates with Groq's ultra-fast inference API, leveraging the LLaMA 3.1 70B model for:
- Natural language understanding
- Context-aware responses
- Multi-turn conversations
- Low-latency inference (<2s average)

### Request Flow

```
User Input → APIRequest Builder → HTTP POST → Groq API
                                              ↓
Parsed Response ← APIResponse Parser ← JSON Response
```

### Sample Request

```json
{
  "model": "llama-3.1-70b-versatile",
  "messages": [
    {"role": "system", "content": "You are a helpful assistant."},
    {"role": "user", "content": "Explain quantum computing"}
  ],
  "temperature": 0.7,
  "max_tokens": 4096
}
```

### Error Handling

| Error Code | Handling Strategy |
|------------|-------------------|
| 400 | Invalid request - log and notify user |
| 401 | Invalid API key - check configuration |
| 429 | Rate limited - exponential backoff retry |
| 500 | Server error - retry with backoff |
| 503 | Service unavailable - fallback to MockAPI |

---

## 💻 Development

### Setting Up Dev Environment

```bash
# Clone repository
git clone https://github.com/yourusername/NovaSwingAI.git

# Open in your IDE
# IntelliJ IDEA: File → Open → select project folder
# Eclipse: Import → Existing Maven Project

# Install dependencies (if using Maven)
mvn clean install
```

### Building from Source

```bash
# Compile all source files
javac -d bin -sourcepath src/main/java \
  $(find src/main/java -name "*.java")

# Create JAR
jar cvfe NovaSwingAI.jar com.novaswing.Main -C bin .

# Run
java -jar NovaSwingAI.jar
```

### Coding Standards

- **Java Style**: Oracle Java Code Conventions
- **Documentation**: JavaDoc for all public methods
- **Naming**: Descriptive camelCase
- **Comments**: Explain "why", not "what"
- **Error Handling**: Always catch and log exceptions

---

## 🧪 Testing

### Manual Testing

```bash
# Run API test utility
java -cp bin com.novaswing.QuickAPITest
```

### Test Scenarios

1. **API Connectivity**: Verify successful API calls
2. **Error Recovery**: Test with invalid API key
3. **Offline Mode**: Disconnect network, verify MockAPI
4. **Emotion Detection**: Test with emotional phrases
5. **Long Conversations**: Test 20+ message history

### Coming Soon: Automated Testing

- Unit tests with JUnit 5
- Integration tests for API layer
- UI tests with AssertJ Swing
- Performance benchmarks

---

## 🚢 Deployment

### Standalone JAR Distribution

```bash
# Build fat JAR with dependencies
mvn clean package assembly:single

# Distribute
cp target/novaswing-ai-1.0.0-jar-with-dependencies.jar release/
```

### System Requirements for End Users

- Java 11+ Runtime (JRE sufficient, JDK not required)
- 512MB available RAM
- 50MB disk space
- Internet connection (for AI features)

### Installation for End Users

1. Download `NovaSwingAI.jar`
2. Double-click to run (if file associations set)
3. Or run: `java -jar NovaSwingAI.jar`
4. Configure API key on first launch

---

## 🐛 Troubleshooting

### Common Issues

#### "API Key Not Found"
```
Solution: Set GROQ_API_KEY environment variable or configure config.properties
```

#### "Connection Refused"
```
Solution: Check internet connection and firewall settings
Allow Java to access network in firewall
```

#### "JSON Parsing Error"
```
Solution: Verify API key is valid and model name is correct
Check Groq API status: https://status.groq.com
```

#### Application Won't Launch
```
Solution: Verify Java version: java -version (must be 11+)
Check classpath and ensure all .class files in bin/
```

### Debug Mode

Enable detailed logging:

```properties
# config.properties
debug.mode=true
```

Or set environment variable:

```bash
export DEBUG_MODE=true
```

### Getting Help

- 📧 **Email**: koushikrudra225@gmail.com


---
## 🗺️ Roadmap

### Phase 1: Core Features ✅ (Completed)
- [x] Groq API integration
- [x] Emotion detection engine
- [x] GUI implementation
- [x] Offline fallback mode
- [x] Comprehensive error handling

### Phase 2: Enhanced UX (Q1 2025)
- [ ] Dark mode theme
- [ ] Message formatting (Markdown support)
- [ ] Copy-to-clipboard functionality
- [ ] Conversation export (PDF/TXT)
- [ ] Custom system prompts
- [ ] Token usage tracking

### Phase 3: Advanced Features (Q2 2025)
- [ ] Multi-model support (GPT-4, Claude, Gemini)
- [ ] Voice input/output
- [ ] File upload support (PDF, images)
- [ ] RAG (Retrieval-Augmented Generation)
- [ ] Plugin system for extensibility

### Phase 4: Enterprise Edition (Q3 2025)
- [ ] Multi-user authentication
- [ ] PostgreSQL/MongoDB integration
- [ ] Admin dashboard & analytics
- [ ] REST API for third-party integration
- [ ] Docker containerization
- [ ] Cloud deployment support

### Community Requests
Vote on features at [Discussions](https://github.com/yourusername/NovaSwingAI/discussions)

---

## 🤝 Contributing

We welcome contributions! Here's how you can help:

### Ways to Contribute

- 🐛 **Report Bugs**: Open an issue with reproduction steps
- 💡 **Suggest Features**: Share your ideas in Discussions
- 📝 **Improve Docs**: Fix typos, add examples
- 🔧 **Submit PRs**: Fix bugs or add features

### Contribution Workflow

```bash
# 1. Fork the repository
# Click "Fork" on GitHub

# 2. Clone your fork
git clone https://github.com/YOUR_USERNAME/NovaSwingAI.git

# 3. Create feature branch
git checkout -b feature/amazing-feature

# 4. Make changes and commit
git commit -m "Add amazing feature"

# 5. Push to your fork
git push origin feature/amazing-feature

# 6. Open Pull Request
# Go to GitHub and click "New Pull Request"
```

### Code Review Checklist

- [ ] Code follows project style guidelines
- [ ] All methods have JavaDoc comments
- [ ] No hardcoded credentials
- [ ] Error handling implemented
- [ ] Manual testing completed
- [ ] PR description explains changes

---

## 📄 License

This project is licensed under the **MIT License**.

```
MIT License

Copyright (c) 2024 NovaSwing AI

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```

See [LICENSE](LICENSE) file for full text.

---

## 🙏 Acknowledgments

### Technologies

- **[Groq](https://groq.com)** - Ultra-fast AI inference platform
- **[Meta AI](https://ai.meta.com/llama/)** - LLaMA 3.1 language model
- **[Oracle Java](https://www.oracle.com/java/)** - Runtime environment

### Inspiration

- OpenAI ChatGPT - Conversational AI paradigm
- Anthropic Claude - Emphasis on helpfulness and safety
- GitHub Copilot - AI-assisted development workflows

### Community

Special thanks to:
- Early beta testers for valuable feedback
- Contributors who submitted bug reports and PRs
- Stack Overflow community for problem-solving assistance

---

## 📊 Project Stats

![GitHub stars](https://img.shields.io/github/stars/yourusername/NovaSwingAI?style=social)
![GitHub forks](https://img.shields.io/github/forks/yourusername/NovaSwingAI?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/yourusername/NovaSwingAI?style=social)

![GitHub issues](https://img.shields.io/github/issues/yourusername/NovaSwingAI)
![GitHub pull requests](https://img.shields.io/github/issues-pr/yourusername/NovaSwingAI)
![GitHub last commit](https://img.shields.io/github/last-commit/yourusername/NovaSwingAI)

---



<div align="center">

**⭐ Star this project if you find it useful! ⭐**

[Back to Top](#-novaswing-ai-assistant)

</div>
 mmmmmmmmmmmmmmmmmmmmmmmm................
