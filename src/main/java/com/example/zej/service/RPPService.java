package com.example.zej.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zej.repo.RPPRepo;

@Service
public class RPPService {
  
  @Autowired
  RPPRepo rppRepo;

}
