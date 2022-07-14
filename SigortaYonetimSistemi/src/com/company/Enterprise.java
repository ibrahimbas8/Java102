package com.company;
import java.util.ArrayList;

public class Enterprise extends Accoount {

    public Enterprise(User user, ArrayList<Insurance> insurances) {
        super(user, insurances, 0, 1);
    }

    @Override
    public int compareTo(Accoount o) {
        return 0;
    }
}