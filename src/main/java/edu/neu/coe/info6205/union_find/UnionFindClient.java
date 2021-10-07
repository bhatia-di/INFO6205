package edu.neu.coe.info6205.union_find;
import java.util.Random;

public class UnionFindClient {

    public static void main(String[] args) {
        int numberOfSites = 2;
        for (int index = 0; index < 20; index++) {
            UF_HWQUPC uf_hwqupc = new UF_HWQUPC(numberOfSites);
            int numberOfConnections = countOfConnections(uf_hwqupc, numberOfSites);
            System.out.printf(" %d  %d \n", numberOfSites, numberOfConnections);
            numberOfSites = numberOfSites * 2;
        }
    }

    public static int countOfConnections(UF_HWQUPC uf_hwqupc, int numberOfSites) {
        int numberOfConnections = 0;

        while (uf_hwqupc.components() != 1) {
            uf_hwqupc.connect(getRandomNumberWithinRange(0, numberOfSites), getRandomNumberWithinRange(0, numberOfSites));
            numberOfConnections++;
        }
        return numberOfConnections;
    }

    public static int getRandomNumberWithinRange(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }


}
