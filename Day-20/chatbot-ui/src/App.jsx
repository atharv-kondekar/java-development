import { useState } from "react";
import ReactMarkdown from "react-markdown";
import "./App.css";

const SERVER_URL = "http://localhost:8080";

function App() {
  const [username, setUsername] = useState(
    localStorage.getItem("username") || ""
  );

  const [page, setPage] = useState(username ? "chat" : "login");

  if (page === "login") {
    return (
      <LoginPage
        onLogin={(name) => {
          localStorage.setItem("username", name);
          setUsername(name);
          setPage("chat");
        }}
      />
    );
  }

  return (
    <ChatPage
      username={username}
      onLogout={() => {
        localStorage.removeItem("username");
        setUsername("");
        setPage("login");
      }}
    />
  );
}

function LoginPage({ onLogin }) {
  const [name, setName] = useState("");

  function handleSubmit(e) {
    e.preventDefault();

    const trimmedName = name.trim();

    if (!trimmedName) {
      return;
    }

    onLogin(trimmedName);
  }

  return (
    <div className="page">
      <div className="card">
        <h1>Simple Chatbot</h1>
        <p>Enter your name to continue.</p>

        <form onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="Your name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            autoFocus
          />

          <button type="submit">Start Chat</button>
        </form>
      </div>
    </div>
  );
}

function ChatPage({ username, onLogout }) {
  const [question, setQuestion] = useState("");
  const [messages, setMessages] = useState([]);
  const [loading, setLoading] = useState(false);

  async function sendMessage(e) {
    e.preventDefault();

    const trimmedQuestion = question.trim();

    if (!trimmedQuestion || loading) {
      return;
    }

    setMessages((prev) => [
      ...prev,
      {
        type: "user",
        text: trimmedQuestion,
      },
    ]);

    setQuestion("");
    setLoading(true);

    try {
      const url =
        `${SERVER_URL}/ai/ask?user=${encodeURIComponent(username)}` +
        `&userInput=${encodeURIComponent(trimmedQuestion)}`;

      const response = await fetch(url);

      if (!response.ok) {
        throw new Error("Server returned an error");
      }
      const answer = await response.text();
      setMessages((prev) => [
        ...prev,
        {
          type: "bot",
          text: answer,
        },
      ]);
    } catch (error) {
      setMessages((prev) => [
        ...prev,
        {
          type: "bot",
          text: "ERROR: " + error.name + " -> " + error.message,
        },
      ]);
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="chat-page">
      <header className="chat-header">
        <div>
          <h1>Chatbot</h1>
          <span>Hi, {username}</span>
        </div>

        <button className="logout-button" onClick={onLogout}>
          Logout
        </button>
      </header>

      <main className="chat-container">
        <div className="messages">
          {messages.length === 0 && (
            <div className="empty-state">
              Ask me something!
            </div>
          )}

          {messages.map((message, index) => (
            <div
              key={index}
              className={`message ${message.type}`}
            >
              <ReactMarkdown>{message.text}</ReactMarkdown>
            </div>
          ))}

          {loading && (
            <div className="message bot">
              Typing...
            </div>
          )}
        </div>

        <form className="message-form" onSubmit={sendMessage}>
          <input
            type="text"
            placeholder="Type your question..."
            value={question}
            onChange={(e) => setQuestion(e.target.value)}
            disabled={loading}
          />

          <button type="submit" disabled={loading}>
            Send
          </button>
        </form>
      </main>
    </div>
  );
}

export default App;
