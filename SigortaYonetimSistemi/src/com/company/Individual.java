package com.company;
import java.util.ArrayList;

public class Individual extends Accoount {
    public Individual(User user, ArrayList<Insurance> insurances) {
        super(user, insurances, 0, 0);
    }

    @Override
    public int compareTo(Accoount o) {
        return 0;
    }
}
