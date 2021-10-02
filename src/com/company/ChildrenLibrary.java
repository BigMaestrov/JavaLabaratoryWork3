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
        System.out.println(childrenLibraryHalls.length);

        //Запись в новый массив
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            System.out.println(childrenLibraryHalls[i].getChildrenBooks().length);
            for (int j = 0; j < childrenLibraryHalls[i].getChildrenBooks().length; j++, numBookInLibrary++) {
                System.out.println("work");
                booksInLibrary[numBookInLibrary] = childrenLibraryHalls[i].getBookByID(j);
            }
        }
        //Сортировка
        for (int left = 0; left < booksInLibrary.length; left++) {
            int minInd = left;
            for (int i = left; i < booksInLibrary.length; i++) {
                if (booksInLibrary[i].getCost() < booksInLibrary[minInd].getCost()) {
                    minInd = i;
                }
            }
            swap(booksInLibrary, left, minInd);
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

    public void addBookByID(int num, ChildrenBook book) {
        if (num <= childrenLibraryHalls.length * numBooksInHalls.length) {
            changeBookByID(num, book);
        }
        if (num > childrenLibraryHalls.length * numBooksInHalls.length) {
            int IDofBook = 0;
            //Запись в новый массив
            for (int i = 0; i < childrenLibraryHalls.length; i++) {
                for (int j = 0; j < numBooksInHalls.length; j++) {
                    if (num == IDofBook) {
                        childrenLibraryHalls[i].addBook(book, j);
                    }
                    IDofBook++;
                }
            }
        }

    }

    public void deleteBookFromLibrary(int number) {
        //Проверка на существование
        if (number > sumOfAllBooks()) {
            return;
        }

        //Запись книг в новый массив
        ChildrenBook[] booksInLibrary = new ChildrenBook[sumOfAllBooks() - 1];
        int numBookInLibrary = 0;
        int indexOfHall = 0;
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            for (int j = 0; j < childrenLibraryHalls[i].getChildrenBooks().length; j++) {
                if (numBookInLibrary != number) {
                    booksInLibrary[numBookInLibrary] = childrenLibraryHalls[i].getBookByID(j);
                    numBookInLibrary++;
                }else indexOfHall=i;
            }
        }
        int[] numBooksInHalls = getNumBooksInHalls();
        numBooksInHalls[indexOfHall]--;
        setNumBooksInHalls(numBooksInHalls);

        //Распределение по залам
        numBookInLibrary = 0;
        ChildrenBook[] booksBufferForHall;
        ChildrenLibraryHall[] libraryHalls = new ChildrenLibraryHall[childrenLibraryHalls.length];
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            libraryHalls[i] = new ChildrenLibraryHall("", numBooksInHalls[i]);
            booksBufferForHall = new ChildrenBook[numBooksInHalls[i]];
            for (int j = 0; j < numBooksInHalls[i]; j++) {
                booksBufferForHall[j] = booksInLibrary[numBookInLibrary];
            }
            libraryHalls[i].setChildrenBooks(booksBufferForHall);
        }
        setNumBooksInHalls(numBooksInHalls);
        setChildrenLibraryHalls(libraryHalls);
    }

    public ChildrenBook getBestBook() {
        ChildrenBook bestBook = new ChildrenBook();
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            if (bestBook.getCost() < childrenLibraryHalls[i].getBestBook().getCost())
                bestBook = childrenLibraryHalls[i].getBestBook();
        }
        return bestBook;
    }

    public void printBooks(ChildrenBook[] booksInLibrary) {
        for (int i = 0; i < booksInLibrary.length; i++) {
            System.out.println(booksInLibrary[i].toString());
        }
    }

}




