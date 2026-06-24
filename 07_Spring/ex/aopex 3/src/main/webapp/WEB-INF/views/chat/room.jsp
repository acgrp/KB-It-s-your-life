<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>채팅방</title>
    <script src="https://cdn.jsdelivr.net/npm/@stomp/stompjs@7.0.0/bundles/stomp.umd.min.js"></script>
</head>
<body>
<h2>채팅방</h2>
<div id="chatBox" style="border:1px solid #ccc; height:300px; overflow-y:auto;"></div>
<input type="text" id="message" placeholder="메시지 입력">
<button id="send">전송</button>
<button id="leave">나가기</button>

<script>
    const contextPath = "${pageContext.request.contextPath}";
    const roomId = "${roomId}";
    const sender = prompt("닉네임을 입력하세요") || "익명";

    const wsProtocol = location.protocol === "https:" ? "wss://" : "ws://";
    const stompClient = new StompJs.Client({
        brokerURL: wsProtocol + location.host + contextPath + "/chat-app"
    });

    stompClient.onConnect = () => {
        stompClient.subscribe("/topic/chat/" + roomId, (payload) => {
            showMessage(JSON.parse(payload.body));
        });
        stompClient.publish({
            destination: "/app/chat/" + roomId,
            body: JSON.stringify({ type: "ENTER", roomId: roomId, sender: sender })
        });
    };

    stompClient.onWebSocketError = (e) => console.error("WS Error", e);
    stompClient.onStompError = (f) => console.error("Stomp Error", f.headers['message']);

    function showMessage(message) {
        const box = document.getElementById("chatBox");
        const p = document.createElement("p");

        if (message.type === "TALK") {
            p.textContent = message.sender + ": " + message.message;
        } else {
            p.textContent = message.message;
        }

        box.appendChild(p);
        box.scrollTop = box.scrollHeight;
    }

    document.getElementById("send").addEventListener("click", () => {
        const input = document.getElementById("message");
        if (!input.value) return;
        stompClient.publish({
            destination: "/app/chat/" + roomId,
            body: JSON.stringify({ type: "TALK", roomId: roomId, sender: sender, message: input.value })
        });
        input.value = "";
    });

    document.getElementById("leave").addEventListener("click", () => {
        stompClient.publish({
            destination: "/app/chat/" + roomId,
            body: JSON.stringify({ type: "LEAVE", roomId: roomId, sender: sender })
        });
        stompClient.deactivate();
        location.href = contextPath + "/chat/list";
    });

    stompClient.activate();
</script>
</body>
</html>