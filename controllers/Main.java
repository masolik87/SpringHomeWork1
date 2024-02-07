package org.example.controllers;
import org.example.domain.Person;
import java.io.*;

/*
Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код,
использующий эти зависимости.
Пример решения:
1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и com.google.code.gson:gson:2.8.6.
3. Создайте класс Person с полями firstName, lastName и age.
4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
 */

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Sylvester", "Stallone", 25);

        try (FileOutputStream fileOut = new FileOutputStream("userdata.JSON");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fileIn = new FileInputStream("userdata.JSON");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            person = (Person)in.readObject();
            System.out.println("name: " + person.getFirstName());
            System.out.println("lastName: " + person.getLastName());
            System.out.println("age: " + person.getAge());
        }
        catch (IOException e) {
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
