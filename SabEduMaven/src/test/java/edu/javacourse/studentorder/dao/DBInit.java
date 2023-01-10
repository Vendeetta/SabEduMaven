package edu.javacourse.studentorder.dao;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DBInit {
    public static void startUp() throws Exception {
        URL url1 = DictionaryDaoImpl.class.getClassLoader().getResource("student_project_sql");
        URL url2 = DictionaryDaoImpl.class.getClassLoader().getResource("student_data.sql");
        List<String> str1 = Files.readAllLines(Path.of(url1.toURI()));
        List<String> str2 = Files.readAllLines(Path.of(url2.toURI()));
        String sql1 = str1.stream().collect(Collectors.joining());
        String sql2 = str2.stream().collect(Collectors.joining());
        try (Connection con = ConnectionBuilder.getConnection();
             Statement st = con.createStatement()) {
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);
        }
    }
}
