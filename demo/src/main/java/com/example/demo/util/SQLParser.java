package com.example.demo.util;

import java.io.FileWriter;
import java.io.IOException;

public class SQLParser {

    public static void parseCreateTable(String createTableQuery) throws IOException {
        String[] parts = createTableQuery.split("\\(");
        String tableName = parts[0].split(" ")[2].trim();
        String columns = parts[1].replace(")", "").trim();

        try (FileWriter metadataWriter = new FileWriter("metadata.txt", true)) {
            metadataWriter.write(tableName + ":" + columns + "\n");
        }
    }

    public static void parseInsert(String insertQuery) throws IOException {
        String[] parts = insertQuery.split("VALUES");
        String tableName = parts[0].split(" ")[2].trim();
        String values = parts[1].replace("(", "").replace(")", "").trim();

        try (FileWriter tableWriter = new FileWriter(tableName + ".txt", true)) {
            tableWriter.write(values + "\n");
        }
    }
}