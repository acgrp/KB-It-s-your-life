package dao;

import Util.JDBUtil;
import dto.GameRecordDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameRecordDao {

    // 전적 저장
    public int insert(GameRecordDto record) {
        String sql = "INSERT INTO game_records (user_id, champion, result, kills, deaths, assists, memo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, record.getUserId());
            pstmt.setString(2, record.getChampion());
            pstmt.setString(3, record.getResult());
            pstmt.setInt(4, record.getKills());
            pstmt.setInt(5, record.getDeaths());
            pstmt.setInt(6, record.getAssists());
            pstmt.setString(7, record.getMemo());
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // 특정 유저의 전적 전체 조회
    public List<GameRecordDto> findByUserId(int userId) {
        String sql = "SELECT * FROM game_records WHERE user_id = ? ORDER BY played_at DESC";
        List<GameRecordDto> list = new ArrayList<>();

        try (Connection conn = JDBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new GameRecordDto(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getString("champion"),
                            rs.getString("result"),
                            rs.getInt("kills"),
                            rs.getInt("deaths"),
                            rs.getInt("assists"),
                            rs.getString("memo"),
                            rs.getString("played_at")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 전적 삭제
    public int delete(int id, int userId) {
        String sql = "DELETE FROM game_records WHERE id = ? AND user_id = ?";
        try (Connection conn = JDBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setInt(2, userId);
            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}