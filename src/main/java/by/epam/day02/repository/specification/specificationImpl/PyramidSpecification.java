package by.epam.day02.repository.specification.specificationImpl;

import by.epam.day02.entity.Figure;
import by.epam.day02.entity.figureImpl.Pyramid;
import by.epam.day02.repository.specification.Specification;

public class PyramidSpecification implements Specification {
    @Override
    public boolean specify(Figure figure) {
        return figure.getClass() == Pyramid.class;
    }
}
