package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameRecordDto {
    private int id;
    private int userId;
    private String champion;
    private String result;
    private int kills;
    private int deaths;
    private int assists;
    private String memo;
    private String playedAt;
}