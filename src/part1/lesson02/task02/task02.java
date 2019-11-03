package part1.lesson02.task02;

import java.util.Random;

public class task02 {

    public static void main(String[] args) throws MyException {
      int N = (int) (Math.random()*100);

        Double[] dCh = new Double[N];

      double temp0;
      int temp1;
        Random n = new Random();
        for (int i=0; i < N; i++)
        {
            dCh [i] = (double) (-100+ n.nextInt(200));
        }
        for (int i=0; i < N; i++)
        {
            try {
                if (dCh[i] < 0)
                    throw new MyException(dCh[i]);
                temp0 = Math.sqrt(dCh[i]);
                temp1 = (int) temp0;
                temp0 = Math.pow(temp1,2);
                if (dCh[i]==temp0)
                {
                    System.out.println(String.valueOf(dCh[i]));
                }
            } catch (MyException e) {
                System.out.println(e);
            }
        }
    }
}
