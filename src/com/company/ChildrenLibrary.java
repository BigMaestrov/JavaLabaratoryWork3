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

    public Book getBookByID(int numInHall, int id) {
        return childrenLibraryHalls[numInHall].getBookByID(id);
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
    }

    public ChildrenLibrary(ChildrenLibraryHall[] childrenLibraryHalls) {
        setChildrenLibraryHalls(childrenLibraryHalls);
    }

    public int sumOfAllBooks() {
        int numBook = 0;
        for (int i = 0; i < this.numBooksInHalls.length; i++) {
            numBook = +this.numBooksInHalls[i];
        }
        return numBook;
    }

    public ChildrenBook[] selectionSortBookInHallByCost() {
        ChildrenBook[] booksInLibrary = new ChildrenBook[sumOfAllBooks()];
        int numBookInLibrary = 0;
        //Запись в новый массив
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            for (int j = 0; j < numBooksInHalls[i]; j++) {
                booksInLibrary[numBookInLibrary] = childrenLibraryHalls[i].getBookByID(j);
                numBookInLibrary++;
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
            System.out.println("Name:" + childrenLibraryHalls[i].getName() + ", NumOfBook:" + childrenLibraryHalls[i].getNumBook());
        }
    }

    public void changeHallByID(int numHall, ChildrenLibraryHall newHall) {
        childrenLibraryHalls[numHall] = newHall;
    }

    public void changeBookByID(int num, ChildrenBook book) {
        int IDofBook = 0;
        //Запись в новый массив
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            for (int j = 0; j < numBooksInHalls[i]; j++) {
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

    public void deleteBookFromLibrary(int num) {
        if (num > childrenLibraryHalls.length * numBooksInHalls.length) {
            int IDofBook = 0;
            //Запись в новый массив
            for (int i = 0; i < childrenLibraryHalls.length; i++) {
                for (int j = 0; j < numBooksInHalls.length; j++) {
                    if (num == IDofBook) {
                        childrenLibraryHalls[i].deleteBook(j);
                    }
                    IDofBook++;
                }
            }
        }
    }

    public ChildrenBook getBestBook() {
        int Imax = 0;
        int Jmax = 0;
        int max = 0;
        boolean isFounded = false;
        for (int i = 0; i < childrenLibraryHalls.length; i++) {
            for (int j = 0; j < numBooksInHalls.length; j++) {
                if (max < childrenLibraryHalls[i].getBookByID(j).getCost()) {
                    max = childrenLibraryHalls[i].getBookByID(j).getCost();
                    isFounded = true;
                }
            }
        }
        if (!isFounded) {
            return childrenLibraryHalls[Imax].getBookByID(Jmax);
        } else return null;
    }

    public void printBooks(ChildrenBook[] booksInLibrary) {
        for (int i = 0; i < booksInLibrary.length; i++) {
            System.out.println(booksInLibrary.toString());
        }
    }
}




