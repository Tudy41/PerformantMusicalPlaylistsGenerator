package org.example;

import java.util.HashMap;
import java.util.Map;
/**
 * Clasa ce ofera obiecte utilitare pentru a fi folosite in functiile DAO-urilor din modelul POO.
 *
 *
 *
 */
public class ForHandleAndReturnObj {

    private final Map<Integer, String> container;

    int argContainerCounter;

    public ForHandleAndReturnObj(Object... sequence) {
        argContainerCounter = 0;
        String spliter;
        container = new HashMap<>();
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] != null && sequence[i].toString() != null) {
                this.container.put(i, sequence[i].toString());
            }
            argContainerCounter++;
        }

    }

    public void addToContains(String value) {

        container.put(argContainerCounter, value);
        argContainerCounter++;
    }

    public void removeFromContains(String value) {

        argContainerCounter = argContainerCounter - 1;
        container.remove(argContainerCounter);

    }

    public Map<Integer, String> getContains() {
        return this.container;
    }

    public String toString() {

        return container.get(0);
    }
}
