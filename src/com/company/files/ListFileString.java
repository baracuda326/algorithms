package com.company.files;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ListFileString {
    public static void main(String[] args) {
        String s = "my.song.mp3 11b\\ngreatSong.flac 1000b\\nnot3.txt 5b\\nvideo.mp4 200b\\ngame.exe 100b\\nmov!e.mkv 10000b";
        System.out.println(solution(s));
        System.out.println(solution2(s));
        System.out.println(solution3(s));
        System.out.println(solution4(s));
    }

    public static String solution(String str) {
        int music = 0;
        int video = 0;
        int other = 0;
        int image = 0;
        String[] line = str.split("\\\\n");
        for (int i = 0; i < line.length; i++) {
            String[] line2 = line[i].split(" ");
            int index = line2[1].lastIndexOf("b");
            if (line2[0].endsWith("mp3") || line2[0].endsWith("flac") || line2[0].endsWith("aac")) {
                music += Integer.parseInt(line2[1].substring(0, index));
            } else if (line2[0].endsWith("mkv") || line2[0].endsWith("mp4") || line2[0].endsWith("avi")) {
                video += Integer.parseInt(line2[1].substring(0, index));
            } else if (line2[0].endsWith("jpg") || line2[0].endsWith("bmp") || line2[0].endsWith("gif")) {
                image += Integer.parseInt(line2[1].substring(0, index));
            } else {
                other += Integer.parseInt(line2[1].substring(0, index));
            }
        }
        return "music " + music + "b\n"
                + "image " + image + "b\n"
                + "movie " + video + "b\n"
                + "other " + other + "b\n";
    }

    public static String solution2(String str) {
        int music = 0;
        int video = 0;
        int other = 0;
        int image = 0;
        String[] line = str.split("\\\\n");
        Set musics = new HashSet(Arrays.asList("mp3", "flac", "aac"));
        Set movie = new HashSet(Arrays.asList("mkv", "mp4", "avi"));
        Set images = new HashSet(Arrays.asList("jpg", "bmp", "gif"));
        for (int i = 0; i < line.length; i++) {
            String[] line2 = line[i].split(" ");
            int indexDot = line2[0].lastIndexOf(".");
            int index = line2[1].lastIndexOf("b");
            if (musics.contains(line2[0].substring(indexDot + 1))) {
                music += Integer.parseInt(line2[1].substring(0, index));
            } else if (movie.contains(line2[0].substring(indexDot + 1))) {
                video += Integer.parseInt(line2[1].substring(0, index));
            } else if (images.contains(line2[0].substring(indexDot + 1))) {
                image += Integer.parseInt(line2[1].substring(0, index));
            } else {
                other += Integer.parseInt(line2[1].substring(0, index));
            }
        }
        return "music " + music + "b\n"
                + "image " + image + "b\n"
                + "movie " + video + "b\n"
                + "other " + other + "b\n";
    }

    public static String solution3(String str) {
        int music = 0;
        int video = 0;
        int other = 0;
        int image = 0;
        String[] line = str.split("\\\\n");
        for (int i = 0; i < line.length; i++) {
            String[] line2 = line[i].split(" ");
            int index = line2[1].lastIndexOf("b");
            if (line2[0].endsWith("mp3") || line2[0].endsWith("flac") || line2[0].endsWith("aac")) {
                music += Integer.parseInt(line2[1].substring(0, index));
                continue;
            }
            if (line2[0].endsWith("mkv") || line2[0].endsWith("mp4") || line2[0].endsWith("avi")) {
                video += Integer.parseInt(line2[1].substring(0, index));
                continue;
            }
            if (line2[0].endsWith("jpg") || line2[0].endsWith("bmp") || line2[0].endsWith("gif")) {
                image += Integer.parseInt(line2[1].substring(0, index));
                continue;
            }
            other += Integer.parseInt(line2[1].substring(0, index));
        }
        return "music " + music + "b\n"
                + "image " + image + "b\n"
                + "movie " + video + "b\n"
                + "other " + other + "b\n";
    }

    public static String solution4(String str) {
        int music = 0;
        int video = 0;
        int other = 0;
        int image = 0;
        String[] line = str.split("\\\\n");
        Set musics = new HashSet(Arrays.asList("mp3", "flac", "aac"));
        Set movie = new HashSet(Arrays.asList("mkv", "mp4", "avi"));
        Set images = new HashSet(Arrays.asList("jpg", "bmp", "gif"));
        for (int i = 0; i < line.length; i++) {
            String[] line2 = line[i].split(" ");
            int indexDot = line2[0].lastIndexOf(".");
            int index = line2[1].lastIndexOf("b");
            if (musics.contains(line2[0].substring(indexDot + 1))) {
                music += Integer.parseInt(line2[1].substring(0, index));
                continue;
            }
            if (movie.contains(line2[0].substring(indexDot + 1))) {
                video += Integer.parseInt(line2[1].substring(0, index));
                continue;
            }
            if (images.contains(line2[0].substring(indexDot + 1))) {
                image += Integer.parseInt(line2[1].substring(0, index));
                continue;
            }
            other += Integer.parseInt(line2[1].substring(0, index));
        }
        return "music " + music + "b\n"
                + "image " + image + "b\n"
                + "movie " + video + "b\n"
                + "other " + other + "b\n";
    }
}
