package com.example.myjpa.controller;

import com.example.myjpa.model.Moan;
import com.example.myjpa.repository.MoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Author YRG
 * Created by on 2018/7/18.
 * Describe
 */
@RestController
public class UserController {

    @Autowired
    MoanRepository moanRepository;

    @PostMapping(value = "save/moan")
    public int saveMoan(@Valid Moan moan) {

        moanRepository.save(moan);

        return 0;
    }
}
