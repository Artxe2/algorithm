public class PrintArray {
    private PrintArray() {}
    
    static final void print(boolean[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length = array.length - 1, i = 0;
        System.out.print("{ ");
        while (i < length) {
            System.out.print((array[i++] ? 'O' : 'X') + ", ");
        }
        System.out.println((array[i] ? 'O' : 'X') + " }");
    }

    static final void print(boolean[][] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length, i;
        System.out.print("{\n");
        for (boolean[] a : array) {
            if (a == null) {
                System.out.println("\tnull, ");
            } else {
                length = a.length - 1;
                i = 0;
                System.out.print("\t{ ");
                while (i < length) {
                    System.out.print((a[i++] ? 'O' : 'X') + ", ");
                }
                System.out.println((a[i] ? 'O' : 'X') + " }");
            }
        }
        System.out.println("}");
    }

    static final void print(char[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length = array.length - 1, i = 0;
        System.out.print("{ ");
        while (i < length) {
            System.out.print(array[i++] + ", ");
        }
        System.out.println(array[i] + " }");
    }

    static final void print(char[][] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length, i;
        System.out.print("{\n");
        for (char[] a : array) {
            if (a == null) {
                System.out.println("\tnull, ");
            } else {
                length = a.length - 1;
                i = 0;
                System.out.print("\t{ ");
                while (i < length) {
                    System.out.print(a[i++] + ", ");
                }
                System.out.println(a[i] + " }");
            }
        }
        System.out.println("}");
    }

    static final void print(int[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length = array.length - 1, i = 0;
        System.out.print("{ ");
        while (i < length) {
            System.out.print(array[i++] + ", ");
        }
        System.out.println(array[i] + " }");
    }

    static final void print(int[][] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length, i;
        System.out.print("{\n");
        for (int[] a : array) {
            if (a == null) {
                System.out.println("\tnull, ");
            } else if (a.length == 0) {
                System.out.println("\t{}");
            } else {
                length = a.length - 1;
                i = 0;
                System.out.print("\t{ ");
                while (i < length) {
                    System.out.print(a[i++] + ", ");
                }
                System.out.println(a[i] + " }");
            }
        }
        System.out.println("}");
    }

    static final void print(Integer[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length = array.length - 1, i = 0;
        System.out.print("{ ");
        while (i < length) {
            System.out.print(array[i++] + ", ");
        }
        System.out.println(array[i] + " }");
    }

    static final void print(Integer[][] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length, i;
        System.out.print("{\n");
        for (Integer[] a : array) {
            if (a == null) {
                System.out.println("\tnull, ");
            } else {
                length = a.length - 1;
                i = 0;
                System.out.print("\t{ ");
                while (i < length) {
                    System.out.print(a[i++] + ", ");
                }
                System.out.println(a[i] + " }");
            }
        }
        System.out.println("}");
    }

    static final void print(long[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length = array.length - 1, i = 0;
        System.out.print("{ ");
        while (i < length) {
            System.out.print(array[i++] + ", ");
        }
        System.out.println(array[i] + " }");
    }

    static final void print(long[][] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length, i;
        System.out.print("{\n");
        for (long[] a : array) {
            if (a == null) {
                System.out.println("\tnull, ");
            } else {
                length = a.length - 1;
                i = 0;
                System.out.print("\t{ ");
                while (i < length) {
                    System.out.print(a[i++] + ", ");
                }
                System.out.println(a[i] + " }");
            }
        }
        System.out.println("}");
    }

    static final void print(double[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length = array.length - 1, i = 0;
        System.out.print("{ ");
        while (i < length) {
            System.out.print(array[i++] + ", ");
        }
        System.out.println(array[i] + " }");
    }

    static final void print(double[][] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length, i;
        System.out.print("{\n");
        for (double[] a : array) {
            if (a == null) {
                System.out.println("\tnull, ");
            } else if (a.length == 0) {
                System.out.println("\t{}");
            } else {
                length = a.length - 1;
                i = 0;
                System.out.print("\t{ ");
                while (i < length) {
                    System.out.print(a[i++] + ", ");
                }
                System.out.println(a[i] + " }");
            }
        }
        System.out.println("}");
    }

    static final void print(String[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length = array.length - 1, i = 0;
        System.out.print("{ \"");
        while (i < length) {
            System.out.print(array[i++] + "\", \"");
        }
        System.out.println(array[i] + "\" }");
    }

    static final void print(String[][] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        if (array.length == 0) {
            System.out.println("{}");
            return;
        }
        int length, i;
        System.out.print("{\n");
        for (String[] a : array) {
            if (a == null) {
                System.out.println("\tnull, ");
            } else {
                length = a.length - 1;
                i = 0;
                System.out.print("\t{ \"");
                while (i < length) {
                    System.out.print(a[i++] + "\", \"");
                }
                System.out.println(a[i] + "\" }");
            }
        }
        System.out.println("}");
    }
}
