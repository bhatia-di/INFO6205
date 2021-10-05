package edu.neu.coe.info6205.union_find;
import java.util.Random;

public class UnionFindClient {

    public static void main(String[] args) {
        int numberOfSites = 2;
        for (int index = 0; index < 10; index++) {
            UF_HWQUPC uf_hwqupc = new UF_HWQUPC(numberOfSites);
            int numberOfConnections = countOfConnections(uf_hwqupc, numberOfSites);
            System.out.printf("Number of sites %d || Number of connections %d", numberOfSites, numberOfConnections);
            numberOfSites = numberOfSites * 2;
        }
    }

    public static int countOfConnections(UF_HWQUPC uf_hwqupc, int numberOfSites) {




        return uf_hwqupc.getNumberOfConnections();
    }

    public int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }


}
