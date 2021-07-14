package blackBoxInteger;

import java.lang.reflect.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException,
            IllegalAccessException,
            NoSuchFieldException,
            InstantiationException {
        Scanner scanner = new Scanner(System.in);
        //"<command name>_<value>
        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        String[] toDo = scanner.nextLine().split("_");

        while (!toDo[0].equals("END")){
            String command = toDo[0];
            int value = Integer.parseInt(toDo[1]);

            Method method = blackBoxInt.getClass().getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            Field innerField = blackBoxInt.getClass().getDeclaredField("innerValue");
            innerField.setAccessible(true);
            System.out.println(innerField.get(blackBoxInt));
            toDo = scanner.nextLine().split("_");

        }

    }
}
