package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for (int i = 2; i <= finish; i++){
            int checkNumber = 0;
            for (int j = 1; j <= i; j++){
                if (i % j == 0){
                    checkNumber++;
                }
            }
            //Если число делиться нацело больше двух раз, значит оно не простое.
            if (checkNumber == 2){
                count++;
            }
        }
        return count;
    }
}
