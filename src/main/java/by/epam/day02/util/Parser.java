package by.epam.day02.util;

public interface Parser<R, E> {
    R parse(E string);
}
