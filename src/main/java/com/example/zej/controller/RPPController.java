package com.example.zej.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zej.model.RPP;
import com.example.zej.repo.RPPRepo;
import com.example.zej.service.RPPService;
import com.example.zej.utils.MessageModel;

@RestController
@RequestMapping("/rpp")
public class RPPController {

  @Autowired
  RPPService rppService;

  @Autowired
  RPPRepo rppRepo;

  @GetMapping
  public ResponseEntity<Object> findAll() {
    MessageModel messageModel = new MessageModel();
    messageModel.setMessage("Berhasil mengambil data RPP");
    messageModel.setData(rppRepo.findAll());
    return ResponseEntity.ok(messageModel);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> findById(@PathVariable Long id) {
    MessageModel messageModel = new MessageModel();
    var rpp = rppRepo.findById(id);
    if (rpp.isEmpty()) {
      messageModel.setMessage("RPP tidak ditemukan");
      messageModel.setData(null);
      return ResponseEntity.status(404).body(messageModel);
    }
    messageModel.setMessage("Berhasil mengambil data RPP");
    messageModel.setData(rpp.get());
    return ResponseEntity.ok(messageModel);
  }

  @PostMapping
  public ResponseEntity<Object> create(@RequestBody RPP rpp) {
    MessageModel messageModel = new MessageModel();
    messageModel.setMessage("Berhasil membuat RPP");
    messageModel.setData(rppRepo.save(rpp));
    return ResponseEntity.ok(messageModel);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody RPP rpp) {
    MessageModel messageModel = new MessageModel();
    var existing = rppRepo.findById(id);
    if (existing.isEmpty()) {
      messageModel.setMessage("RPP tidak ditemukan");
      messageModel.setData(null);
      return ResponseEntity.status(404).body(messageModel);
    }
    var toUpdate = existing.get();
    org.springframework.beans.BeanUtils.copyProperties(rpp, toUpdate, "id");
    rppRepo.save(toUpdate);
    messageModel.setMessage("Berhasil mengupdate RPP");
    messageModel.setData(toUpdate);
    return ResponseEntity.ok(messageModel);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
    MessageModel messageModel = new MessageModel();
    if (!rppRepo.existsById(id)) {
      messageModel.setMessage("RPP tidak ditemukan");
      messageModel.setData(null);
      return ResponseEntity.status(404).body(messageModel);
    }
    rppRepo.deleteById(id);
    messageModel.setMessage("Berhasil menghapus RPP");
    messageModel.setData(null);
    return ResponseEntity.ok(messageModel);
  }
  
}
