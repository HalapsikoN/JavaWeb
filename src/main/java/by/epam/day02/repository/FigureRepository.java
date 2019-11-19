package by.epam.day02.repository;

import by.epam.day02.entity.Figure;
import by.epam.day02.entity.ParamRegister;
import by.epam.day02.entity.figureImpl.Pyramid;
import by.epam.day02.entity.paramRegisterImpl.ParamRegisterForPyramid;
import by.epam.day02.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureRepository {
    public final static Logger logger = LogManager.getLogger(FigureRepository.class);

    private List<Figure> figureList;
    private Map<String, ParamRegister> figureParamRegisterMap;

    public FigureRepository() {
        figureList = new ArrayList<>();
        figureParamRegisterMap = new HashMap<>();
    }

    public void addFigure(Figure figure) {
        logger.info("Add Figure: " + figure);
        figureList.add(figure);
        if (figure.getClass() == Pyramid.class) {
            Pyramid pyramid = (Pyramid) figure;
            ParamRegisterForPyramid paramRegister = new ParamRegisterForPyramid(pyramid);
            pyramid.subscribe(paramRegister);
            figureParamRegisterMap.put(pyramid.getId(), paramRegister);
        }
    }

    public void removeFigure(Figure figure) {
        logger.info("Remove Figure: " + figure);
        figureList.remove(figure);
        if (figure.getClass() == Pyramid.class) {
            Pyramid pyramid = (Pyramid) figure;
            figureParamRegisterMap.remove(pyramid.getId());
        }
    }

    public List<Figure> getFigureList() {
        return figureList;
    }

    public List<Figure> query(Specification specification) {
        List<Figure> findList = new ArrayList<>();
        for (Figure figure : figureList) {
            if (specification.specify(figure)) {
                findList.add(figure);
            }
        }
        return findList;
    }

    public Map<String, ParamRegister> getFigureParamRegisterMap() {
        return figureParamRegisterMap;
    }

    public ParamRegister getParameters(Figure figure) {
        if (figure.getClass() == Pyramid.class) {
            Pyramid pyramid = (Pyramid) figure;
            return figureParamRegisterMap.get(pyramid.getId());
        }
        return null;
    }
}
