package Lesson_8;

import java.util.ArrayList;
import java.util.List;

public class ArrayProcessor {
    public int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4. Количество строк: " + array.length + ".");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4. В строке " + (i + 1) +
                        " количество столбцов: " + array[i].length + ".");
            }
        }

        List<MyArrayDataException.ErrorDetail> errors = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    errors.add(new MyArrayDataException.ErrorDetail(i, j, array[i][j]));
                }
            }
        }
        if (!errors.isEmpty()) {
            throw new MyArrayDataException(errors);
        }
        return sum;
    }
}
