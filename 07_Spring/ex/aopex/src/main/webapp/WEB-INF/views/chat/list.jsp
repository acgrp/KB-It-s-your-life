<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>채팅방 목록</title>
    <style>
        body { font-family: sans-serif; padding: 20px; }
        .room-item {
            display: flex; align-items: center; gap: 10px;
            border: 1px solid #ddd; border-radius: 6px;
            padding: 10px; margin-bottom: 8px;
        }
        .room-name { flex: 1; font-weight: bold; }
        .enter-btn { background: #4CAF50; color: white; border: none; padding: 6px 14px; border-radius: 4px; cursor: pointer; }
        .delete-btn { background: #f44336; color: white; border: none; padding: 6px 10px; border-radius: 4px; cursor: pointer; }
        #createBox { margin-bottom: 20px; }
    </style>
</head>
<body>
<h2>채팅방 목록</h2>

<div id="createBox">
    <input type="text" id="roomName" placeholder="방 이름 입력">
    <button onclick="createRoom()">방 만들기</button>
</div>

<div id="roomList"></div>

<script>
    const contextPath = "${pageContext.request.contextPath}";

    function loadRooms() {
        fetch(contextPath + "/chat/rooms")
            .then(function(res) { return res.json(); })
            .then(function(rooms) {
                const list = document.getElementById("roomList");
                list.innerHTML = "";
                if (rooms.length === 0) {
                    list.innerHTML = "<p>아직 방이 없습니다. 위에서 방을 만들어보세요.</p>";
                    return;
                }
                rooms.forEach(function(room) {
                    if (!room.roomId) return;
                    const roomLabel = room.roomName && room.roomName.trim() ? room.roomName : "이름없는 방";
                    const userCount = room.userList ? room.userList.length : 0;

                    const div = document.createElement("div");
                    div.className = "room-item";

                    const nameSpan = document.createElement("span");
                    nameSpan.className = "room-name";
                    nameSpan.textContent = roomLabel + " (" + userCount + "명)";

                    const enterBtn = document.createElement("button");
                    enterBtn.className = "enter-btn";
                    enterBtn.textContent = "입장하기";
                    enterBtn.onclick = function() { enterRoom(room.roomId); };

                    const deleteBtn = document.createElement("button");
                    deleteBtn.className = "delete-btn";
                    deleteBtn.textContent = "삭제";
                    deleteBtn.onclick = function() { deleteRoom(room.roomId); };

                    div.appendChild(nameSpan);
                    div.appendChild(enterBtn);
                    div.appendChild(deleteBtn);
                    list.appendChild(div);
                });
            });
    }

    function enterRoom(roomId) {
        if (!roomId || roomId === 'undefined') {
            alert("유효하지 않은 방 주소입니다.");
            return;
        }
        location.href = contextPath + "/chat/room/" + roomId;
    }

    function createRoom() {
        const name = document.getElementById("roomName").value.trim();
        if (!name) {
            alert("방 이름을 입력하세요.");
            return;
        }
        fetch(contextPath + "/chat/rooms", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name: name })
        })
            .then(function(res) { return res.json(); })
            .then(function(room) {
                document.getElementById("roomName").value = "";
                if (room && room.roomId) {
                    location.href = contextPath + "/chat/room/" + room.roomId;
                } else {
                    loadRooms();
                }
            });
    }

    function deleteRoom(roomId) {
        fetch(contextPath + "/chat/rooms/" + roomId + "/delete", { method: "POST" })
            .then(function() { loadRooms(); });
    }

    loadRooms();
</script>
</body>
</html>