package com.example.music.model.artist;

import com.example.music.utils.CommonUtils;import java.util.concurrent.atomic.AtomicInteger;import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ArtistOfSongDTO {
  private Long artistId;
  private Long songId;
  private String name;
  private String avatar;

  public ArtistOfSongDTO(Object[] x){
    //a.id,a.name,a.url_avatar,as2.song_id
    AtomicInteger index = new AtomicInteger(0);
    this.artistId = CommonUtils.convertValueToLong(x,index.getAndIncrement());
    this.name = CommonUtils.convertValueToString(x,index.getAndIncrement());
    this.avatar = CommonUtils.convertValueToString(x,index.getAndIncrement());
    this.songId = CommonUtils.convertValueToLong(x,index.getAndIncrement());
  }
}
