import org.junit.Test;

import com.target.barrenland.Farm;
import com.target.barrenland.FertileLandHelper;
import com.target.barrenland.InputLoader;

import static org.junit.Assert.assertEquals;

public class FertileLandHelperTest {

    Farm myFarm = new Farm();

    @Test
    public void clearTest() {
        int barrenResult = 0;
        int barrenland = 0;
        FertileLandHelper.clearColoMatrix(myFarm);
        int farmLand[][] = myFarm.getFarmLand();
        for(int i=0;i<myFarm.X_MAX;i++){
            for(int j=0;j<myFarm.Y_MAX;j++){
                if(farmLand[i][j]!=0){
                    barrenland++;
                }
            }
        }
        assertEquals(barrenResult,barrenland);
    }


    @Test
    public void colorOneBarrenTest() {
        String input = new String("{“0 292 399 307”}");
        int barrenResult = 6400;
        int barrenland=0;
        try {
            InputLoader.readInput(input,myFarm);
        }catch (Exception e){
            System.out.print(e.getMessage());
            return;
        }

        FertileLandHelper.colorBarrenFarm(myFarm);
        int farmLand[][] = myFarm.getFarmLand();
        for(int i=0;i<myFarm.X_MAX;i++){
            for(int j=0;j<myFarm.Y_MAX;j++){
                if(farmLand[i][j]!=0){
                    barrenland++;
                }
            }
        }
        assertEquals(barrenResult,barrenland);
    }

    @Test
    public void colorMultiBarrenTest() {
        String input = new String("{“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”}");
        int barrenResult = 24576;
        int barrenland=0;
        try {
            InputLoader.readInput(input,myFarm);
        }catch (Exception e){
            System.out.print(e.getMessage());
            return;
        }

        FertileLandHelper.colorBarrenFarm(myFarm);
        int farmLand[][] = myFarm.getFarmLand();
        for(int i=0;i<myFarm.X_MAX;i++){
            for(int j=0;j<myFarm.Y_MAX;j++){
                if(farmLand[i][j]!=0){
                    barrenland++;
                }
            }
        }
        assertEquals(barrenResult,barrenland);
    }

    @Test
    public void testZero() {

        myFarm = new Farm();
        String result = ("240000");
        String input = new String("");

        try {
            InputLoader.readInput(input,myFarm);
        }catch (Exception e){
            System.out.print(e.getMessage());
            return;
        }
        FertileLandHelper.clearColoMatrix(myFarm);
        FertileLandHelper.colorBarrenFarm(myFarm);
        FertileLandHelper.getFertileLands(myFarm);
        FertileLandHelper.printOutput(myFarm);


        assertEquals(result,FertileLandHelper.printOutput(myFarm));
    }

    @Test
    public void testOneBarren() throws Exception{

        myFarm = new Farm();
        String result = ("116800 116800");
        String input = new String("{“0 292 399 307”}");

        try {
            InputLoader.readInput(input,myFarm);
        }catch (Exception e){
            System.out.print(e.getMessage());
            return;
        }
        FertileLandHelper.clearColoMatrix(myFarm);
        FertileLandHelper.colorBarrenFarm(myFarm);
        FertileLandHelper.getFertileLands(myFarm);
        FertileLandHelper.printOutput(myFarm);


        assertEquals(result,FertileLandHelper.printOutput(myFarm));
    }

    @Test
    public void testMultiBarren() throws Exception{

        myFarm = new Farm();
        String result = ("22816 192608");
        String input = new String("{“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”}");

        try {
            InputLoader.readInput(input,myFarm);
        }catch (Exception e){
            System.out.print(e.getMessage());
            return;
        }
        FertileLandHelper.clearColoMatrix(myFarm);
        FertileLandHelper.colorBarrenFarm(myFarm);
        FertileLandHelper.getFertileLands(myFarm);
        FertileLandHelper.printOutput(myFarm);


        assertEquals(result,FertileLandHelper.printOutput(myFarm));
    }

    @Test
    public void testInnerFertile() throws Exception{

        myFarm = new Farm();
        String result = ("81 239494");
        String input = new String("{“10 10 20 20”, “20 20 30 30”, “5 20 10 30”, “10 30 20 40”}");

        try {
            InputLoader.readInput(input,myFarm);
        }catch (Exception e){
            System.out.print(e.getMessage());
            return;
        }
        FertileLandHelper.clearColoMatrix(myFarm);
        FertileLandHelper.colorBarrenFarm(myFarm);
        FertileLandHelper.getFertileLands(myFarm);
        FertileLandHelper.printOutput(myFarm);


        assertEquals(result,FertileLandHelper.printOutput(myFarm));
    }

    @Test
    public void testMultiFertileResults() throws Exception{

        myFarm = new Farm();
        String result = ("81 59494 119400");
        String input = new String("{“10 10 20 20”, “20 20 30 30”, “5 20 10 30”, “10 30 20 40”, “100 0 200 599”}");

        try {
            InputLoader.readInput(input,myFarm);
        }catch (Exception e){
            System.out.print(e.getMessage());
            return;
        }
        FertileLandHelper.clearColoMatrix(myFarm);
        FertileLandHelper.colorBarrenFarm(myFarm);
        FertileLandHelper.getFertileLands(myFarm);
        FertileLandHelper.printOutput(myFarm);


        assertEquals(result,FertileLandHelper.printOutput(myFarm));
    }
}
