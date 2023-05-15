package com.example.music;

import com.example.music.service.SongService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongServiceTest {

  @Autowired private SongService songService;

  @Test
  void testGetSong() {
    var a = songService.findSongByID(29L);
    Assertions.assertNotNull(a);
  }
}
