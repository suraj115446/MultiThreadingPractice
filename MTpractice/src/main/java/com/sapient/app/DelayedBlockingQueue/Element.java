package com.sapient.app.DelayedBlockingQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by Suraj on 3/12/2017.
 */
public class Element implements Delayed {

    public Element(long quantity) {
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    private long quantity;


    public long getDelay(TimeUnit unit) {
        return 1000l;
    }

    public int compareTo(Delayed o) {
        if (!o.getClass().equals(this.getClass())) {

            Element obj = (Element) o;
            if (obj.getQuantity() > this.getQuantity()) {
                return 1;
            } else if (obj.getQuantity() < this.getQuantity()) {
                return -1;
            }

            return 0;
        }
        return -1;
    }


}
