

import java.io.*;
import java.net.*;


public class MyFirstHTTPRequest {


    static void print(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) throws IOException {

        String url = "http://bis.manas.edu.kg/menu/";

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            response.append('\n');
        }
        in.close();

        System.out.println(response.toString());

        int tableIndex = response.indexOf("<table");

        System.out.println("Index of <table>: " + tableIndex);

        int indexOfHeadersRow = response.indexOf("<tr>", tableIndex);
        int indexOfFirstRow = response.indexOf("<tr>", indexOfHeadersRow+1);

        System.out.println("Index of headers: " + indexOfHeadersRow);
        System.out.println("Index of first row: " + indexOfFirstRow);

        System.out.println("Headers line: " + response.substring(indexOfHeadersRow, indexOfFirstRow));
        print("");

        int indexOfSecondRow = response.indexOf("<tr>", indexOfFirstRow+1);

        print("Second row index: " + indexOfSecondRow);

        print("First row: " + response.substring(indexOfFirstRow, indexOfSecondRow));
        print("");
    }

}