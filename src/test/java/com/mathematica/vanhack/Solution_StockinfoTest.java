package com.mathematica.vanhack;

        import com.mathematica.ds.vanhack.Solution_Stockinfo;
        import org.testng.annotations.Test;

public class Solution_StockinfoTest {

    @Test
    public void testPositive() {
        Solution_Stockinfo.openAndClosePrices("1-January-2000", "22-February-2000", "Monday");
    }

    @Test
    public void testHttp(){
//        Solution_Stockinfo.httpGet();
    }
}
