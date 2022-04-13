package ru.alina.util;

import ru.alina.model.Notation;
import ru.alina.to.NotationTo;

import java.util.ArrayList;
import java.util.List;

public interface NotationUtil {
    static List<NotationTo> getNotationTos(List<Notation> notations) {
        List<NotationTo> notationTos = new ArrayList<>();

        for (int i = 0; i < notations.size(); i++) {
            double n1 = notations.get(i).getWeight();

            if (i < notations.size() - 2) {
                double n2 = notations.get(i + 1).getWeight();

                if (n1 > n2) {
                    notationTos.add(new NotationTo(notations.get(i), false));
                } else {
                    notationTos.add(new NotationTo(notations.get(i), true));
                }
            } else {
                notationTos.add(new NotationTo(notations.get(i), true));
            }

        }
        return notationTos;
    }
}
