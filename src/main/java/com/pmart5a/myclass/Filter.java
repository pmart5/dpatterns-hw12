package com.pmart5a.myclass;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getLogger();
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        for (int item : source) {
            if (item > treshold) {
                result.add(item);
                counter++;
                logger.log("Элемент " + item + " проходит");
            } else {
                logger.log("Элемент " + item + " не проходит");
            }
        }
        logger.log("Прошло фильтр " + counter + " элемента из " + source.size());
        return result;
    }
}