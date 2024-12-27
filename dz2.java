import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class dz2 {
    public static void main(String[] args) {
        // 4.

        int[] array = new int[20];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++)
        {
            array[i] = rnd.nextInt(100);
        }

        for (int j = 0; j < array.length; j++)
        {
            for (int g = j+1;g < array.length; g++)
            {
                if (array[j] == array[g])
                    array[g] = rnd.nextInt(100);
            }
        }

        System.out.println(Arrays.toString((array)));
    }
}