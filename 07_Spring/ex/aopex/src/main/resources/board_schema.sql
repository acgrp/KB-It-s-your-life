-- ============================================================
-- 게시글 테이블
-- ============================================================
CREATE TABLE IF NOT EXISTS board (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(200)  NOT NULL,
    content     TEXT,
    writer      VARCHAR(100)  NOT NULL,
    reg_date    DATETIME      NOT NULL DEFAULT NOW(),
    update_date DATETIME      NOT NULL DEFAULT NOW()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================================
-- 첨부파일 테이블
-- 파일을 파일 시스템이 아닌 DB의 BLOB 컬럼으로 관리
-- ============================================================
CREATE TABLE IF NOT EXISTS board_attachment (
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    board_id     BIGINT        NOT NULL,
    filename     VARCHAR(300)  NOT NULL,      -- 원본 파일명
    content_type VARCHAR(200),               -- MIME type (e.g. image/png)
    file_size    BIGINT        NOT NULL DEFAULT 0,
    file_data    LONGBLOB      NOT NULL,     -- 파일 바이너리 데이터 (BLOB 저장 핵심)

    CONSTRAINT fk_attach_board
        FOREIGN KEY (board_id) REFERENCES board(id)
        ON DELETE CASCADE                    -- 게시글 삭제 시 첨부파일 자동 삭제
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- MySQL 기본 max_allowed_packet 은 16MB. 큰 파일 업로드 시 아래 설정 필요:
-- SET GLOBAL max_allowed_packet = 67108864;  -- 64MB
