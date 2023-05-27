package com.example.music.service.impl;

import com.example.music.model.DataDTO;
import com.example.music.repository.custom.DataRepository;
import com.example.music.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

  private final DataRepository dataRepository;

  @Override
  public DataDTO getDataNumber() {
    DataDTO dataDTO = dataRepository.getData();
    return dataDTO;
  }
}
