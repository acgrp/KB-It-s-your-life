<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세</title>
    <style>
        body  { font-family: sans-serif; padding: 20px; max-width: 800px; margin: 0 auto; }
        .meta { color: #666; font-size: 13px; margin-bottom: 16px; }
        .content-box { border: 1px solid #ddd; border-radius: 6px; padding: 16px; min-height: 100px; }
        .attach-list { margin-top: 20px; }
        .attach-item { display: flex; align-items: center; gap: 10px;
                       border: 1px solid #eee; border-radius: 4px;
                       padding: 8px 12px; margin-bottom: 6px; }
        .attach-name { flex: 1; }
        .download-btn { background: #1976d2; color: #fff; border: none;
                        padding: 5px 14px; border-radius: 4px; cursor: pointer; text-decoration: none; }
        .delete-btn   { background: #e53935; color: #fff; border: none;
                        padding: 5px 10px; border-radius: 4px; cursor: pointer; }
        .back-btn     { background: #555; color: #fff; border: none;
                        padding: 7px 18px; border-radius: 4px; cursor: pointer; margin-top: 20px; }
    </style>
</head>
<body>
<h2>📄 게시글 상세</h2>

<div id="postDetail">불러오는 중...</div>

<button class="back-btn" onclick="history.back()">← 목록으로</button>

<script>
    const ctx    = "${pageContext.request.contextPath}";
    // URL 파라미터에서 id 추출 (e.g. ?id=3)
    const params = new URLSearchParams(location.search);
    const postId = params.get("id");

    function formatSize(bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return (bytes / 1024).toFixed(1) + " KB";
        return (bytes / (1024 * 1024)).toFixed(1) + " MB";
    }

    function loadPost() {
        if (!postId) { document.getElementById("postDetail").textContent = "잘못된 접근입니다."; return; }

        fetch(ctx + "/board/" + postId)
            .then(r => r.json())
            .then(b => {
                const attachHtml = b.attachments && b.attachments.length
                    ? `<div class="attach-list">
                        <strong>📎 첨부파일 (DB BLOB 저장)</strong>
                        ${b.attachments.map(a => `
                            <div class="attach-item">
                                <span class="attach-name">${a.filename} (${formatSize(a.fileSize)})</span>
                                <!-- 다운로드: 컨트롤러가 BLOB 바이트를 스트림으로 응답 -->
                                <a class="download-btn"
                                   href="${ctx}/board/attach/${a.id}"
                                   download="${a.filename}">⬇ 다운로드</a>
                                <button class="delete-btn"
                                        onclick="deleteAttach(${a.id})">삭제</button>
                            </div>`).join("")}
                       </div>`
                    : "<p style='color:#888'>첨부파일 없음</p>";

                document.getElementById("postDetail").innerHTML = `
                    <h3>${b.title}</h3>
                    <p class="meta">작성자: ${b.writer} &nbsp;|&nbsp; 등록일: ${b.regDate ? b.regDate.substring(0,10) : ""}</p>
                    <div class="content-box">${b.content}</div>
                    ${attachHtml}`;
            });
    }

    function deleteAttach(attachId) {
        if (!confirm("첨부파일을 삭제하시겠습니까?")) return;
        fetch(ctx + "/board/attach/" + attachId, { method: "DELETE" })
            .then(() => loadPost());
    }

    loadPost();
</script>
</body>
</html>
