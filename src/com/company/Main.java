package com.company;

public class Main {

    public static void main(String[] args) {
        //Создание книг
        ChildrenBook childrenBook1 = new ChildrenBook("Tolkien", "Lord Of The Rings", 26, 1954, 12);
        ChildrenBook childrenBook2 = new ChildrenBook("Azimov", "Foundation", 25, 1942, 12);
        ChildrenBook childrenBook3 = new ChildrenBook("Dostoevsky", "Crime and punishment", 25, 1866, 18);
        ChildrenBook childrenBook4 = new ChildrenBook("Nikita", "nameOfBook", 1, 2021, 12);
        ChildrenBook childrenBook5 = new ChildrenBook("Daniel", "nameOfBook2", 2, 2021, 12);
        ChildrenBook childrenBook6 = new ChildrenBook("Max", "nameOfBook3", 3, 2021, 12);
        ChildrenBook childrenBook7 = new ChildrenBook("Andrey", "nameOfBook4", 4, 2021, 12);
        //Создание массива книг
        ChildrenBook[] books1 = {childrenBook1, childrenBook2, childrenBook3};
        ChildrenBook[] books2 = {childrenBook4, childrenBook5};
        ChildrenBook[] books3 = {childrenBook6, childrenBook7};
        //Создание залов
        ChildrenLibraryHall hall_1 = new ChildrenLibraryHall("hall_1", books1);
        ChildrenLibraryHall hall_2 = new ChildrenLibraryHall("hall_2", books2);
        ChildrenLibraryHall hall_3 = new ChildrenLibraryHall("hall_3", books3);
        //Создание массива залов
        ChildrenLibraryHall[] halls = {hall_1, hall_2, hall_3};
        //Создание экземпляра библиотеки
        ChildrenLibrary library = new ChildrenLibrary(halls);

        //измените книгу;
        //ChildrenBook newBook = new ChildrenBook("newAuthor", "newName", 15, 1954, 12);
        //library.changeBookByID(1,newBook); Починить
        //измените зал;
        //ChildrenLibraryHall newHall = new ChildrenLibraryHall("newHall", books1);
        //library.changeHallByID(1,newHall);
        // удалите книгу;
        //library.deleteBookFromLibrary(1);
        //Выведите автора самой лучшей книги;
        System.out.println(library.getBestBook().getAuthor());
        // выведите список названий книг по убыванию цены.
        library.printBooks(library.selectionSortBookInHallByCost());
    }
}
