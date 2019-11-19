package by.epam.day02.comparator;

import by.epam.day02.entity.figureImpl.Pyramid;

import java.util.Comparator;

public class PyramidIdComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
