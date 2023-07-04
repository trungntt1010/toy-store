package com.example.demo.Repository;

import com.example.demo.DTO.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class ProductRepository {
    @Autowired
    private Sql2o dataSource;

    private void insertProduct(Product product){
        try (Connection con = dataSource.open()) {
            String stmt =
                    """
                            SELECT video_id AS videoId
                            , player_id AS playerId
                            , watched_time AS watchedTime
                            , created_at AS createdAt
                            , updated_at AS updatedAt
                            FROM golftec_video_library.video_watching_progress
                            WHERE video_id = :videoId AND player_id = :playerId
                            """;
//            return con.createQuery(stmt)
//                    .addParameter("videoId", videoId)
//                    .addParameter("playerId", playerId)
//                    .executeAndFetchFirst(VideoWatchingProgress.class);
        }
    }
}
