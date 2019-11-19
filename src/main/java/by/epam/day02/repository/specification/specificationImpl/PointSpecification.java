package by.epam.day02.repository.specification.specificationImpl;

import by.epam.day02.entity.Figure;
import by.epam.day02.entity.figureImpl.Point;
import by.epam.day02.repository.specification.Specification;

public class PointSpecification implements Specification {
    @Override
    public boolean specify(Figure figure) {
        return figure.getClass() == Point.class;
    }
}
