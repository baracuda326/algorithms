package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        String s = " 779091968 23 Sep 2009 system.zip\n 284164096 14 Aug 2013 to-do-list.xml\n 714080256 19 Jun 2013 blockbuster.mpeg\n       329 12 Dec 2010 notes.html\n 444596224 17 Jan 1950 delete-this.zip\n       641 24 May 1987 setup.png\n    245760 16 Jul 2005 archive.zip\n 839909376 31 Jan 1990 library.dll";
        System.out.println(solution3(s));
    }

    public int solution(String S, int[] C) {
        int totalCost = 0;
        int currentCost = 0;
        int i = 0;
        int j = 0;
        while (i < S.length()) {
            j = i + 1;
            currentCost = 0;
            while (j < S.length() && S.charAt(i) == S.charAt(j)) {
                if (C[j - 1] > C[j]) {
                    currentCost = currentCost + C[j];
                    int temp = C[j - 1];
                    C[j - 1] = C[j];
                    C[j] = temp;
                } else {
                    currentCost = currentCost + C[j - 1];
                }
                j++;
            }
            totalCost = totalCost + currentCost;
            i = j;
        }
        return totalCost;
    }

    public int solution2(int[] A, int X, int Y, int Z) {
        if (A.length <= 0) {
            return -1;
        }
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            cars.add(new Car(A[i]));
        }
        List<FuelStation> stations = new ArrayList<>();
        stations.add(new FuelStation(false, X));
        stations.add(new FuelStation(false, Y));
        stations.add(new FuelStation(false, Z));
        for (Car car : cars) {
            for (FuelStation fuelStation : stations) {
                if (car.tankCapacity <= fuelStation.capacity && !fuelStation.isOccupied) {
                    fuelStation.isOccupied = true;
                    fuelStation.capacity = fuelStation.capacity - car.tankCapacity;
                    fuelStation.nextCarWaitTime = car.tankCapacity;
                    car.waitTime = 0;
                    break;
                }
                if (car.tankCapacity <= fuelStation.capacity && fuelStation.isOccupied) {
                    fuelStation.isOccupied = false;
                    fuelStation.capacity = fuelStation.capacity - car.tankCapacity;
                    car.waitTime = fuelStation.nextCarWaitTime;
                    fuelStation.nextCarWaitTime = fuelStation.nextCarWaitTime + car.tankCapacity;
                    fuelStation.isOccupied = true;
                    break;
                }
                if (car.tankCapacity > fuelStation.capacity) {
                    car.waitTime = -1;
                }
            }
        }
        return cars.stream().mapToInt(x -> x.waitTime).max().getAsInt();
    }

    public static String solution3(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        Date baseDate = null;
        try {
            baseDate = simpleDateFormat.parse("31 Jan 1990");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String[] line = str.split("\\\\n");
        int count = 0;
        int size = 240 * 1024;

        for (int i = 0; i < line.length; i++) {
            String[] lineFile = line[i].trim().split(" ");
                if (Integer.valueOf(lineFile[0]) >= size
                        && simpleDateFormat.parse(lineFile[1] + " " + lineFile[2] + " " + lineFile[3]).after(baseDate)) {
                    System.out.println(lineFile[0]);
                    count++;
                }
                
        }
        return String.valueOf(count);
    }
}

class Car {
    int tankCapacity;
    int waitTime;

    public Car(int tankCapacity) {
        super();
        this.tankCapacity = tankCapacity;
    }
}

class FuelStation {
    boolean isOccupied = false;
    int capacity = 0;
    int nextCarWaitTime = 0;

    public FuelStation(boolean isOccupied, int capacity) {
        this.isOccupied = isOccupied;
        this.capacity = capacity;
    }
}