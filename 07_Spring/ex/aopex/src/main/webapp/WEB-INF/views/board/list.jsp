<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <style>
        body { font-family: sans-serif; padding: 20px; max-width: 900px; margin: 0 auto; }
        h2  { border-bottom: 2px solid #333; padding-bottom: 8px; }
        table { width: 100%; border-collapse: collapse; margin-top: 16px; }
        th, td { border: 1px solid #ddd; padding: 8px 12px; text-align: left; }
        th { background: #f5f5f5; }
        .attach-tag { font-size: 12px; color: #666; margin-left: 6px; }

        /* 등록 폼 */
        #writeForm { border: 1px solid #ccc; border-radius: 6px; padding: 16px; margin-top: 24px; }
        #writeForm input, #writeForm textarea { width: 100%; box-sizing: border-box; margin-bottom: 8px; padding: 6px; }
        #writeForm textarea { height: 80px; }
        #writeForm button  { background: #1976d2; color: #fff; border: none;
                             padding: 8px 20px; border-radius: 4px; cursor: pointer; }
    </style>
</head>
<body>
<h2>📋 게시판 (첨부파일 BLOB 저장)</h2>
<p>파일은 서버 디스크가 아닌 <strong>MySQL BLOB 컬럼</strong>에 저장됩니다.</p>

<table id="boardTable">
    <thead>
    <tr>
        <th style="width:50px">번호</th>
        <th>제목</th>
        <th style="width:100px">작성자</th>
        <th style="width:120px">등록일</th>
        <th style="width:80px">첨부</th>
    </tr>
    </thead>
    <tbody id="boardBody">
    <tr><td colspan="5" style="text-align:center">불러오는 중...</td></tr>
    </tbody>
</table>

<!-- 게시글 등록 폼 -->
<div id="writeForm">
    <h3>글쓰기</h3>
    <input  type="text"     id="title"   placeholder="제목"/>
    <input  type="text"     id="writer"  placeholder="작성자"/>
    <textarea id="content"  placeholder="내용"></textarea>

    <!-- 파일 선택 (multiple 허용) → BLOB으로 DB에 저장됨 -->
    <label>첨부파일 (여러 개 선택 가능):
        <input type="file" id="files" multiple>
    </label>
    <br><br>
    <button onclick="createPost()">등록</button>
</div>

<script>
    const ctx = "${pageContext.request.contextPath}";

    /* ─── 목록 조회 ─── */
    function loadList() {
        fetch(ctx + "/board")
            .then(r => r.json())
            .then(boards => {
                const tbody = document.getElementById("boardBody");
                if (!boards.length) {
                    tbody.innerHTML = "<tr><td colspan='5' style='text-align:center'>게시글이 없습니다.</td></tr>";
                    return;
                }
                tbody.innerHTML = boards.map(b => {
                    const attachBadge = b.attachments && b.attachments.length
                        ? `<span class="attach-tag">📎 ${b.attachments.length}</span>` : "";
                    return `<tr>
                        <td>${b.id}</td>
                        <td><a href="${ctx}/board/view.jsp?id=${b.id}" onclick="viewPost(event,${b.id})">${b.title}</a>${attachBadge}</td>
                        <td>${b.writer}</td>
                        <td>${b.regDate ? b.regDate.substring(0,10) : ""}</td>
                        <td><button onclick="deletePost(${b.id})" style="background:#e53935;color:#fff;border:none;padding:4px 10px;border-radius:3px;cursor:pointer">삭제</button></td>
                    </tr>`;
                }).join("");
            });
    }

    /* ─── 게시글 등록 (multipart/form-data → BLOB 저장) ─── */
    function createPost() {
        const title   = document.getElementById("title").value.trim();
        const content = document.getElementById("content").value.trim();
        const writer  = document.getElementById("writer").value.trim();
        const files   = document.getElementById("files").files;

        if (!title || !writer) { alert("제목과 작성자를 입력하세요."); return; }

        const formData = new FormData();
        formData.append("title",   title);
        formData.append("content", content);
        formData.append("writer",  writer);
        // 파일이 있으면 추가 (서버는 byte[]로 읽어 BLOB에 저장)
        for (let i = 0; i < files.length; i++) {
            formData.append("files", files[i]);
        }

        fetch(ctx + "/board", { method: "POST", body: formData })
            .then(r => {
                if (!r.ok) { alert("등록 실패"); return null; }
                return r.json();
            })
            .then(b => {
                if (!b) return;
                document.getElementById("title").value   = "";
                document.getElementById("content").value = "";
                document.getElementById("writer").value  = "";
                document.getElementById("files").value   = "";
                loadList();
                alert("등록되었습니다. (첨부파일은 DB BLOB에 저장됨)");
            });
    }

    /* ─── 게시글 삭제 ─── */
    function deletePost(id) {
        if (!confirm("삭제하시겠습니까?")) return;
        fetch(ctx + "/board/" + id, { method: "DELETE" })
            .then(() => loadList());
    }

    loadList();
</script>
</body>
</html>
