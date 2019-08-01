package com.mathematica.vanhack;

import com.mathematica.ds.vanhack.Solution_DocumentManagementSystem;
import com.mathematica.ds.vanhack.Solution_DocumentManagementSystem.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution_DocumentManagementSystemTest {

    @Test
    public void testPositive() {
        Heading heading1 = new Heading(1, "America");
        Heading heading2 = new Heading(2, "North America");
        Heading heading3 = new Heading(3, "United States");
        Heading heading4 = new Heading(3, "Canada");
        Heading heading5 = new Heading(2, "South America");
        Heading heading6 = new Heading(3, "Brazil");
        Heading heading7 = new Heading(3, "Uruguay");
        List<Heading> headings = new ArrayList<>();
        headings.add(heading1);
        headings.add(heading2);
        headings.add(heading3);
        headings.add(heading4);
        headings.add(heading5);
        headings.add(heading6);
        headings.add(heading7);
        Solution_DocumentManagementSystem.toOutline(headings);
    }
}
