package com.example.music.model;

import com.example.music.model.song.SongDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LikeSongDTO {
  List<SongDTO> songDTOS;
}
