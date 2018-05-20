package com.mathematica.ds.techgig;

import java.util.ArrayList;
import java.util.Collection;

public class child extends parent {

    @Override
    int testArg(Object obj) throws NullPointerException{
        final Collection<? extends Number> foo = new ArrayList<Number>();
        foo.add(null);
//        foo = null;
        return 0;
    }
}
