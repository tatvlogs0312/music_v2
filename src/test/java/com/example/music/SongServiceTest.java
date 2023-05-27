package com.example.music;

import com.example.music.service.DataService;import com.example.music.service.SongService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongServiceTest {

  @Autowired private SongService songService;

  @Autowired private DataService dataService;

  @Test
  void testGetSong() {
    var a = songService.findSongByID(29L);
    Assertions.assertNotNull(a);
  }

  @Test
  void testGetData() {
    var a = dataService.getDataNumber();
    Assertions.assertNotNull(a);
  }
}
