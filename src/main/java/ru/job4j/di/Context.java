package ru.job4j.di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс представляет хранилище объектов.
 * В нём регистрируются классы, объекты которых будут использоваться в
 * проекте.
 */
public class Context {

    /**
     * Хранилище объектов
     */
    private final Map<String, Object> els = new HashMap<>();

    /**
     * Регистрирует классы, объекты которых будут использоваться в проекте,
     * добавляет инициализированные объекты в хранилище.
     * @param cl Class
     * @exception IllegalStateException может выбрасывать исключение в случае:
     * региструемый класс имеет более одного конструктора,
     * аргументу конструктора не найден соответствующий объект из хранилища
     * зарегистрированных объектов,
     * не возможно создать объект из аргументов конструктора
     */
    public void reg(Class<?> cl) {
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException(
                    "Class has multiple constructors : " + cl.getCanonicalName());
        }
        Constructor<?> con = constructors[0];
        final List<Object> args = new ArrayList<>();
        for (Class<?> arg: con.getParameterTypes()) {
            if (!els.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException(
                        "Object doesn't found in context : " + arg.getCanonicalName());
            }
            args.add(els.get(arg.getCanonicalName()));
        }
        try {
            els.put(cl.getCanonicalName(), con.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException(
                    "Coun't create an instance of : " + cl.getCanonicalName(), e);
        }
    }

    /**
     * Предоставляет проинициализированный объект из хранилища
     * зарегистрированных объектов
     * @param inst Class класс, объект которого требуется получить
     * @return проинициализированный объект
     * @param <T> T тип объекта
     */
    public <T> T get(Class<T> inst) {
        return (T) els.get(inst.getCanonicalName());
    }
}
