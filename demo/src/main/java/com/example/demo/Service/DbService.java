package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.util.SQLParser;

@Service
public class DbService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String createTable(String createTableQuery) {
        try {
            SQLParser.parseCreateTable(createTableQuery);
            incrementCounter("SUCCESS");
            return "Table created successfully.";
        } catch (Exception e) {
            incrementCounter("FAILURE");
            return "Error creating table: " + e.getMessage();
        }
    }

    public String insertIntoTable(String insertQuery) {
        try {
            SQLParser.parseInsert(insertQuery);
            incrementCounter("SUCCESS");
            return "Insert successful.";
        } catch (Exception e) {
            incrementCounter("FAILURE");
            return "Error inserting data: " + e.getMessage();
        }
    }

    private void incrementCounter(String key) {
        redisTemplate.opsForValue().increment(key);
    }
}