
import java.math.BigInteger;

public class randomGen {
    static int minInt = 1;
    static int maxInt = 10;
    static Integer addOne = 0;
    static Integer addTwo = 0;
    static Integer addThree = 0;
    static Integer addFour = 0;
    static  Integer addFive = 0;
    static  Integer addTest = 0;
    static int[] intArray = new int[200000000];    //declaring array
    static long startTime;
    static long elapsedTime;

    public static void main(String args[]) {
        //Iterates through index values 0 - 50000000 of 200M int Array.
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < 50000000; i++) {

                    addOne = addOne + intArray[i];

                }

            }

        });
        //Iterates through index values 50000000 - 100000000 of 200M int Array.
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 50000000; i < 100000000; i++) {

                    addTwo = addTwo + intArray[i];

                }

            }

        });
        //Iterates through index values 100000000 - 150000000 of 200M int Array.
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 100000000; i < 150000000; i++) {

                    addThree = addThree + intArray[i];

                }

            }

        });
        //Iterates through index values 150000000 - 200000000 of 200M int Array.
        Thread t4 = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 150000000; i < 200000000; i++) {

                    addFour = addFour + intArray[i];

                }

            }

        });

        //Iterates through 200M int Array with a single thread
        Thread t5 = new Thread(new Runnable() {

            @Override
            public void run() {

                //for (int i = 0; i < 200000000; i++) {
                for (int i = 0; i < 200000000; i++) {

                    addFive = addFive + intArray[i];

                }

            }

        });

        intArrayCreator();

        System.out.println("");
        System.out.println("200M random number array created (containing values 1-10)...");
        int arraysize = intArray.length;

        System.out.println("Array size " + arraysize);
        startTime = System.nanoTime();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //elapsedTime = ((System.currentTimeMillis() - startTime) / 60000); --> use to calculate minutes
        elapsedTime = ((System.nanoTime() - startTime)); //-- > use to calculate seconds

        //Integer sumT = addOne + addTwo + addThree + addFour;

        System.out.println("");
        System.out.println("");
        System.out.println("Finished calculation with four threads...");
        System.out.println("Elapsed time: " + elapsedTime + " nanoseconds");

        System.out.print("Sum Total: ");
        System.out.println(addOne + addTwo + addThree + addFour);

        startTime = System.nanoTime();

        t5.start();

        try {
            t5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        elapsedTime = ((System.nanoTime() - startTime));

        System.out.println("");
        System.out.println("Array size " + arraysize);
        System.out.println("");
        System.out.println("");

        System.out.println("Finished calculation with one thread...");
        System.out.println("Elapsed time: " + elapsedTime + " nanoseconds");

        BigInteger e =  BigInteger.valueOf(addFive);
        System.out.println("One Thread (e) using BigInteger: " + e);
        System.out.println("Sum total using Integer: " + addFive);

        //for (int i = 0; i < 200000000; i++) {
        for (int i = 0; i < 200000000; i++) {

            addTest = addTest + intArray[i];

      //      System.out.println(addTest);

        }
        System.out.println("");
        System.out.println("Sum of values in Array calculated in Main method: " + addTest);

    }

    //Method below creates Array containing 200M values from 1-10
    public static int[]  intArrayCreator() {

        //for loop to add values to intArray
        for (int i = 0; i < 200000000; i++) {

            int randomInt = (int) Math.floor(Math.random() * (maxInt - minInt + 1) + minInt);
            //System.out.println(randomInt);

            intArray[i] = randomInt;

        }
        return intArray;
    }
}















