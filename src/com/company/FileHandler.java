package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class FileHandler {

    public static void appendLine(String fileName, String data) {
        // write text to end of the file
        boolean append = true;
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, append))) {
            pr.println(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readLineAt(String fileName, int start) {
        // grab the line from position "start" in the file
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(start);
            return rf.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void writeLineAt(String fileName, String data, int start) {
        // overwrite a line from position "start" in the file
        // doesn't check that the start position is actually
        // the beginning of the file. This will not behave well
        // unless every line is the same length

        // use random file access instead of buffered reader



        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName)); BufferedReader br = new BufferedReader(new FileReader(fileName))){
            ArrayList<String> contents = new ArrayList();
            String line = br.readLine();
            contents.add(line);

            for (int i =0; i<FileHandler.countLines(fileName); i++){
                contents.add(line);
                line = br.readLine();
            }
            contents.add(line);


            for (int i =0; i< contents.size(); i++){
                System.out.println(contents.get(i));
            }

            contents.set(start, data);

            for (int i =0; i<contents.size(); i++)
                pw.println(contents.get(i));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int countLines(String fileName) {
        int count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line = br.readLine();
            while (line != null){
                count++;
                line = br.readLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        // return the number of lines in the file
        return count;
    }


}


