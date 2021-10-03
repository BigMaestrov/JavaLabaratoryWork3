package com.company;

public class ChildrenLibrary {
    int numHalls;
    ChildrenLibraryHall[] childrenLibraryHalls;
    int[] numBooksInHalls;

    public int getNumHalls() {
        return numHalls;
    }

    public void setNumHalls(int numHalls) {
        this.numHalls = numHalls;
    }

    public ChildrenLibraryHall[] getChildrenLibraryHalls() {
        return childrenLibraryHalls;
    }

    public ChildrenLibraryHall getChildrenLibraryHallsByID(int id) {
        return childrenLibraryHalls[id];
    }

    public Book getBookByID(int id) {
        ChildrenBook[] booksInLibrary = new ChildrenBook[sumOfAllBooks()];
        int numBookInLibrary = 0;
        //Запись в новый массив
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            for (int j = 0; j < childrenLibraryHalls[i].getChildrenBooks().length; j++) {
                booksInLibrary[numBookInLibrary] = childrenLibraryHalls[i].getBookByID(j);
                numBookInLibrary++;
            }
        }
        return booksInLibrary[id];
    }

    public void setChildrenLibraryHalls(ChildrenLibraryHall[] childrenLibraryHalls) {
        this.childrenLibraryHalls = childrenLibraryHalls;
    }

    public int[] getNumBooksInHalls() {
        return numBooksInHalls;
    }

    public void setNumBooksInHalls(int[] numBooksInHalls) {
        this.numBooksInHalls = numBooksInHalls;
    }

    public ChildrenLibrary(int numHalls, int[] numBooksInHalls) {
        setNumHalls(numHalls);
        setNumBooksInHalls(numBooksInHalls);
        ChildrenLibraryHall[] childrenLibraryHall = new ChildrenLibraryHall[getNumHalls()];
        for (int i = 0; i < getNumHalls(); i++) {
            childrenLibraryHall[i] = new ChildrenLibraryHall("hall_" + i, numBooksInHalls[i]);
        }
        setChildrenLibraryHalls(childrenLibraryHall);
    }

    public ChildrenLibrary(ChildrenLibraryHall[] childrenLibraryHalls) {
        setNumHalls(childrenLibraryHalls.length);
        setChildrenLibraryHalls(childrenLibraryHalls);
        int[] numBookInHalls = new int[getNumHalls()];
        for (int i = 0; i < getNumHalls(); i++) {
            numBookInHalls[i] = childrenLibraryHalls[i].getChildrenBooks().length;
        }
        setNumBooksInHalls(numBookInHalls);
    }

    public int sumOfAllBooks() {
        int numBook = 0;
        for (int i = 0; i < getNumHalls(); i++) {
            numBook += numBooksInHalls[i];
        }
        return numBook;
    }

    public ChildrenBook[] selectionSortBookInHallByCost() {
        ChildrenBook[] booksInLibrary = new ChildrenBook[sumOfAllBooks()];
        int numBookInLibrary = 0;

        //Запись в новый массив
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            for (int j = 0; j < childrenLibraryHalls[i].getChildrenBooks().length; j++, numBookInLibrary++) {
                booksInLibrary[numBookInLibrary] = childrenLibraryHalls[i].getBookByID(j);
            }
        }
        //Сортировка
        for (int left = 0; left < booksInLibrary.length; left++) {
            int maxInd = left;
            for (int i = left; i < booksInLibrary.length; i++) {
                if (booksInLibrary[i].getCost() > booksInLibrary[maxInd].getCost()) {
                    maxInd = i;
                }
            }
            swap(booksInLibrary, left, maxInd);
        }
        return booksInLibrary;
    }

    private void swap(Book[] books, int left, int minId) {
        Book book = books[left];
        books[left] = books[minId];
        books[minId] = book;
    }

    public void printNamesAndNumBooksOfHalls() {
        for (int i = 0; i < getNumHalls(); i++) {
            System.out.println("Name:" + childrenLibraryHalls[i].getName() + ", NumOfBook:" + childrenLibraryHalls[i].getChildrenBooks().length);
        }
    }

    public void changeHallByID(int numHall, ChildrenLibraryHall newHall) {
        childrenLibraryHalls[numHall] = newHall;
        int[] numBooksInHalls = new int[getChildrenLibraryHalls().length];
        for (int i = 0; i < getChildrenLibraryHalls().length; i++) {
            numBooksInHalls[i] = childrenLibraryHalls[i].getChildrenBooks().length;
        }
        setNumBooksInHalls(numBooksInHalls);
    }

    public void changeBookByID(int num, ChildrenBook book) {
        int IDofBook = 0;
        //Запись в новый массив
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            for (int j = 0; j < childrenLibraryHalls[i].getChildrenBooks().length; j++) {
                if (num == IDofBook) {
                    childrenLibraryHalls[i].redactBook(book, j);
                }
                IDofBook++;
            }
        }
    }

    public void addBookByID(int number, ChildrenBook book) {
        if (number < 0) {
            return;
        }
        if (number > sumOfAllBooks()) {
            return;
        }
        ChildrenLibraryHall[] halls = getChildrenLibraryHalls();
        int[] numsBookInLibrary = getNumBooksInHalls();
        int numBookInLibrary = 0;
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            for (int j = 0; j < childrenLibraryHalls[i].getChildrenBooks().length; j++) {
                if (numBookInLibrary == number) {
                    childrenLibraryHalls[i].addBook(book,j);
                    numsBookInLibrary[i] = childrenLibraryHalls[i].getChildrenBooks().length;
                    halls[i] = childrenLibraryHalls[i];
                }
                halls[i] = childrenLibraryHalls[i];
                numBookInLibrary++;
            }
        }
        setNumBooksInHalls(numsBookInLibrary);
        setChildrenLibraryHalls(halls);
    }

    public void deleteBookFromLibrary(int number) {
        //Проверка на существование
        if (number > sumOfAllBooks()) {
            return;
        }
        ChildrenLibraryHall[] halls = getChildrenLibraryHalls();
        int[] numsBookInLibrary = getNumBooksInHalls();
        int numBookInLibrary = 0;
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            for (int j = 0; j < childrenLibraryHalls[i].getChildrenBooks().length; j++) {
                if (numBookInLibrary == number) {
                    childrenLibraryHalls[i].deleteBook(j);
                    numsBookInLibrary[i]=childrenLibraryHalls[i].getChildrenBooks().length;
                    halls[i]=childrenLibraryHalls[i];
                }
                halls[i]=childrenLibraryHalls[i];
                numBookInLibrary++;
            }
        }
        setNumBooksInHalls(numsBookInLibrary);
        setChildrenLibraryHalls(halls);
    }

    public ChildrenBook getBestBook() {
        ChildrenBook bestBook = new ChildrenBook();
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            if (bestBook.getCost() < childrenLibraryHalls[i].getBestBook().getCost())
                bestBook = childrenLibraryHalls[i].getBestBook();
        }
        return bestBook;
    }

    public void printBooks() {
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            childrenLibraryHalls[i].printBooks();
        }
    }

    public void printBooks(ChildrenBook[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }
    }
}





