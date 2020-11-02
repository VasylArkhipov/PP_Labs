
/**
 * Клас для тестування класу Intervals
 * @author Vasyl Arkhipov
 * @version 1.0
 * */

public class TestDriveIntervals {
    /**Конструктор за замовчуванням*/
    public TestDriveIntervals(){

    }
    /**Головний метод програми,у якому ми передаємо в іншу функцію 3 значення командого рядка
     * @param args Параметри командного рядка
     * */
    public static void main(String[] args) {// main function
        TestDriveIntervals.StartTest(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));

    }
    /**Функція,яка створює об'єкт класу Intervals і викликає функції з нього
     * @param start  початок інтервалу
     * @param end  кінець інтервалу
     * @param lengthOfFibonacciArray  довжина массиву ряду Фібоначчі
     * */
    public static void StartTest(int start,int end,int lengthOfFibonacciArray){//test of the program'
        Intervals firstInterval = new Intervals(start,end,lengthOfFibonacciArray);
        System.out.println("Початок інтервалу - " + start);
        System.out.println("Кінець інтервалу - " + end);
        // Output even and odd numbers
        TestDriveIntervals.outputEvenAndOdd(firstInterval);
        // Output of sum an odd numbers
        System.out.println("\nSum of even - " + firstInterval.SumOfEven() +"\nSum of Odd - " + firstInterval.SumOfOdd());
        //firstInterval.outputSumOfEvenAndOdd();
        // Fibonacci
        TestDriveIntervals.outputFibonacci(firstInterval.fibonacci());
    }

    /**Фукнція виводить парні числа за спаданням та непарні за зростанням
     * @param interval силка на об'єкт,для получення початку і кінця інтервалу*/
    public static void outputEvenAndOdd(Intervals interval) {
        int end = interval.getEnd(),start = interval.getStart();
        System.out.print("\nEven numbers - ");
        for (int index = end; index > start - 1; index--) {
            if (index % 2 == 0) {
                System.out.print(index + " ");
            }
        }
        System.out.print("\nOdd numbers - ");
        for(int index = start;index <end+1;index++) {
            if (index % 2 != 0) {
                System.out.print(index + " ");
            }
        }
    }
    /**Функція,яка виводить ряд Фібоначчі і відсоток парних і непарних чисел інтервалу
     * @param fibonacciArr масив ряду Фібоначчі*/
    public static void outputFibonacci(int[] fibonacciArr) {
        int odd = 0, even = 0;
        System.out.print("Fibonacci - ");
        for (int index = 0; index < fibonacciArr.length; index++) {
            System.out.print(fibonacciArr[index] + " ");
            if (fibonacciArr[index] % 2 == 0){
                even++;
            }
            else {
                odd++;
            }
        }
        System.out.println("\nEven - " + (even * 100) / fibonacciArr.length + "%");
        System.out.println("Odd - " + (odd * 100) / fibonacciArr.length + "%");
    }
}

