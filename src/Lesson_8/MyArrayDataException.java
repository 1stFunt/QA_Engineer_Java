package Lesson_8;

import java.util.List;

public class MyArrayDataException extends Exception {
    private List<ErrorDetail> errors;

    // Конструктор для списка ошибок
    public MyArrayDataException(List<ErrorDetail> errors) {
        super("Обнаружены следующие ошибки в массиве:");
        this.errors = errors;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder(super.getMessage());
        for (ErrorDetail error : errors) {
            sb.append("\nОшибка в строке ").append(error.getRow() + 1)
                    .append(", столбце ").append(error.getColumn() + 1)
                    .append(": некорректные данные \"").append(error.getValue()).append("\".");
        }
        return sb.toString();
    }

    // Вспомогательный класс для хранения деталей ошибки
    public static class ErrorDetail {
        private final int row;
        private final int column;
        private final String value;

        public ErrorDetail(int row, int column, String value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public String getValue() {
            return value;
        }
    }
}