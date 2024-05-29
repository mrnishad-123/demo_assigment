package com.example.demo.DbController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.DbService;


@RestController
@RequestMapping("/api/db")
public class DbController {

    
	 @Autowired
	  private DbService dbService;

    @PostMapping("/create")
    public String createTable(@RequestBody String createTableQuery) {
        return dbService.createTable(createTableQuery);
    }

    @PostMapping("/insert")
    public String insertIntoTable(@RequestBody String insertQuery) {
        return dbService.insertIntoTable(insertQuery);
    }
}
