package com.example.music.repository.custom.implement;

import com.example.music.model.DataDTO;
import com.example.music.repository.custom.DataRepository;
import com.example.music.utils.CommonUtils;
import com.example.music.utils.LogUtils;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DataRepositoryImpl implements DataRepository {

  private final EntityManager entityManager;

  @Override
  public DataDTO getData() {
    String sql =
        "WITH cte_data AS (SELECT CAST(COUNT(*)  AS CHAR) FROM song AS songNumber\n"
            + "                  UNION ALL \n"
            + "                  SELECT CAST(COUNT(*)  AS CHAR) FROM artist AS artistNumber\n"
            + "                  UNION ALL \n"
            + "                  SELECT CAST(COUNT(*)  AS CHAR) FROM albums AS albumsNumber\n"
            + "                  UNION ALL\n"
            + "                  SELECT CAST(COUNT(*)  AS CHAR) FROM user AS userNumber)\n"
            + "SELECT * FROM cte_data";
    Query query = entityManager.createNativeQuery(sql);
    List<String> result = query.getResultList();
    DataDTO dataDTO = new DataDTO();
    for (int i = 0; i < result.size(); i++) {
      if (i == 0) {
        dataDTO.setSongNumber(Long.parseLong(result.get(0)));
      } else if (i == 1) {
        dataDTO.setArtistNumber(Long.parseLong(result.get(1)));
      } else if (i == 2) {
        dataDTO.setAlbumsNumber(Long.parseLong(result.get(2)));
      } else if (i == 3) {
        dataDTO.setUserNumber(Long.parseLong(result.get(3)));
      } else {
        LogUtils.error("error");
      }
    }
    return dataDTO;
  }
}
