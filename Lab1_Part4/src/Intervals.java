/**
 * @author Vasyl Arkhipov
 * @version 1.0
 * Клас інтервалу
 */
public class Intervals {
    /**Змінна для збереження початку інтервалу*/
    private int start;
    /**Змінна для збереження кінця інтервалу*/
    private int end;
    /**Массив цілих чисел,для збереження ряду Фібоначчі*/
    private int[] fibonacciArr;// array of the fibonacci numbers
    /**Змінна для збереження довжини масиву*/
    private int lengthOfFibonacciArray;
    /** Конструктор - створення об'єкта
     * @param start початок інтервалу
     * @param end кінець інтервалу
     * @param lengthOfFibonacciArray довжина масиву
     * */
    Intervals(int start, int end, int lengthOfFibonacciArray) {
        this.start = start;
        this.end = end;
        this.lengthOfFibonacciArray = lengthOfFibonacciArray;
        fibonacciArr = new int[lengthOfFibonacciArray];
    }
    /**Функція повертає початок інтервалу
     * @return початок інтервалу*/
    public int getStart(){
        return start;
    }
    /**Функція повертає кінець інтервалу
     * @return кінець інтервалу*/
    public int getEnd(){
        return end;
    }
    /**Функція повертає розмір масиву
     * @return довжина масиву*/
    public int getLengthOfFibonacciArray(){
        return lengthOfFibonacciArray;
    }


    /**Функція,яка вираховує суму парних чисел інтервалу
     * @return сума парних чисел*/
    public int SumOfEven() {
        int sumOfEven = 0;
        for (int index = start; index < end + 1; index++) {
            if (index % 2 == 0){
                sumOfEven += index;
            }
        }
        return sumOfEven;
    }
    /**Функція,яка вираховує суму непарних чисел інтервалу
     * @return сума непарних чисел*/
    public int SumOfOdd() {
        int sumOfOdd = 0;
        for (int index = start; index < end + 1; index++) {
            if (index % 2 != 0){
                sumOfOdd += index;
            }
        }
        return sumOfOdd;
    }

    /**Функція,яка знаходить 2 перших члени ряду Фібоначчі і утворює його далі
     * @return массив ряду Фібоначчі*/
    public int[] fibonacci() {
        int firstOdd = end - 1, secondEven = end,currentNum;//пошук перших двух чисел ряду фібоначчі
        if (end % 2 != 0) {
            secondEven--;
            firstOdd++;
        }
        fibonacciArr[0] = firstOdd;
        fibonacciArr[1] = secondEven;

        currentNum = secondEven + firstOdd;                 //цикл для ряду фібоначчі
        for (int index=2;index < lengthOfFibonacciArray;index++) {
            fibonacciArr[index] = currentNum;
            int prevFibonacci = currentNum;
            currentNum += secondEven;
            secondEven = prevFibonacci;
        }
        return fibonacciArr;
    }
}