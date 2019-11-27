package by.epam.day02.observer.figureObserverImpl;

import by.epam.day02.entity.Figure;
import by.epam.day02.observer.Observer;

public interface ParamRegisterObserver<E, F extends Figure> extends Observer<E, F> {
}
