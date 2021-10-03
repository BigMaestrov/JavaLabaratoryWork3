package com.company;

public class Main {

    public static void main(String[] args) {
        //Создание книг
        ChildrenBook childrenBook1 = new ChildrenBook("Tolkien", "Lord Of The Rings", 26, 1954, 12);
        ChildrenBook childrenBook2 = new ChildrenBook("Azimov", "Foundation", 25, 1942, 12);
        ChildrenBook childrenBook3 = new ChildrenBook("Dostoevsky", "Crime and punishment", 25, 1866, 18);
        ChildrenBook childrenBook4 = new ChildrenBook("Nikita", "nameOfBook", 1, 2021, 12);
        ChildrenBook childrenBook5 = new ChildrenBook("Daniel", "nameOfBook1", 2, 2021, 12);
        ChildrenBook childrenBook6 = new ChildrenBook("Max", "nameOfBook2", 3, 2021, 12);
        ChildrenBook childrenBook7 = new ChildrenBook("Andrey", "nameOfBook3", 4, 2021, 12);
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
        System.out.println("Books in library: ");
        library.printBooks();
        System.out.println("\n");

        //измените книгу;
        System.out.println("1)Change book:"+"\n"+"book 1 before changing:");
        ChildrenBook newBook = new ChildrenBook("newAuthor", "newName", 15, 1954, 12);
        System.out.println(library.getBookByID(1).toString());
        library.changeBookByID(1, newBook);
        System.out.println("book 1 after changing:");
        System.out.println(library.getBookByID(1).toString());

        //измените зал;
        System.out.println("2)Change hall:"+"\n"+"hall before changing:");
        System.out.println("name:"+library.childrenLibraryHalls[1].getName() +",  num of books:"+ library.childrenLibraryHalls[1].getChildrenBooks().length);
        ChildrenLibraryHall newHall = new ChildrenLibraryHall("newHall", books2);
        library.changeHallByID(1, newHall);
        System.out.println("hall after changing:");
        System.out.println("name:"+library.childrenLibraryHalls[1].getName() +",  num of books:"+ library.childrenLibraryHalls[1].getChildrenBooks().length);

        // удалите книгу;
        System.out.println("3)delete book:"+"\n"+"book №1 before delete:");
        System.out.println(library.getBookByID(1).toString());
        library.deleteBookFromLibrary(1);
        System.out.println("book №1 after delete (books remove):");
        System.out.println(library.getBookByID(1).toString());

        //Выведите автора самой лучшей книги;
        System.out.println("4)Print author of the best book:");
        System.out.println("Best Author: "+library.getBestBook().getAuthor());

        // выведите список названий книг по убыванию цены.
        System.out.println("5)Print list of the names books descending price: ");
        library.printBooks(library.selectionSortBookInHallByCost());
    }
}
