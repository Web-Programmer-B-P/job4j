package ru.job4j.tictactoe;

import java.util.function.Predicate;

/**
 * Class Logic3T
 *
 * @author Petr B.
 * @since 14.09.2019, 19:13
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean commonWinnerLogicForXAndO(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0, 0, 0, 1)
                || this.fillBy(predicate, 0, 1, 1, 0)
                || this.fillBy(predicate, 0, this.table.length - 1, 1, 0)
                || this.fillBy(predicate, this.table.length - 1, 0, -1, 1)
                || this.fillBy(predicate, 0, 0, 1, 1)
                || this.fillBy(predicate, 0, 0, 1, 0)
                || this.fillBy(predicate, this.table.length - 1, 0, 0, 1)
                || this.fillBy(predicate, 1, 0, 0, 1);
    }

    public boolean isWinnerX() {
        return this.commonWinnerLogicForXAndO(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return this.commonWinnerLogicForXAndO(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        int size = this.table.length;
        boolean result = false;
        for (int outer = 0; outer < size; outer++) {
            for (int inner = 0; inner < size; inner++) {
                if (!this.table[outer][inner].hasMarkO() && !this.table[outer][inner].hasMarkX()) {
                    result = true;
                }
            }
        }
        return result;
    }
}
