package db.javaschool.session_11.application.entities;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
public class SearchObj {
    @Getter
    @Setter
    private String query;

}
