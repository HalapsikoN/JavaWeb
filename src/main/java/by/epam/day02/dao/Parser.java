package by.epam.day02.dao;

public interface Parser<R, E> {
    R parse(E string);
}
