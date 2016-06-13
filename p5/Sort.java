package p5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
    MyList myListAl = new MyList();
    MyList myListOrd = new MyList();
    MyList myListInv = new MyList();
    MyList myListSame = new MyList();
    List<Integer> myListAlOriginal;
    List<Integer> myListOrdOriginal;
    List<Integer> myListInvOriginal;
    List<Integer> myListSameOriginal;
    List<Integer> orderedList;
    long before;
    float time;
    final int million = 1000000;
    int comparisons;
    int swaps;
    
    List<Float> times = new ArrayList<Float>();
    float t1;
    long time1;
    float time2;
    float averageTime;
    
    ComparerAndSwapperStadistics aux;
    
    private void fillLists(){
        myListAl.clear();
        myListInv.clear();
        myListOrd.clear();
        myListSame.clear();
        for (int i = 0; i < 1000; i++) {
            myListAl.add((int) (Math.random() * 1000));
            myListOrd.add(i);
            myListInv.add(999-i);
            myListSame.add(26);
        }
    }
    
    List<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
    
    private void fillArrayList(List<Integer> array){
        arrayList.clear();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(new ArrayList<Integer>(array));
        }
    }
    
    
    public class MyList extends ArrayList<Integer>
    {
        int access = 0;
        @Override
        public Integer get(int index)
        {
            access++;
            return super.get(index);
        }
    }
    
    class ComparerAndSwapper
    {
        boolean isGreater(Integer a, Integer b)
        {
            return a > b;
        }
        void swap(List<Integer> list, int i, int j)
        {
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    class ComparerAndSwapperStadistics extends ComparerAndSwapper
    {
        int comparisons = 0;
        int swaps = 0;
        boolean isGreater(Integer a, Integer b)
        {
            comparisons++;
            return a > b;
        }
        void swap(List<Integer> list, int i, int j)
        {
            swaps++;
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
    
    public boolean checkSortedList(List<Integer> originalList, List<Integer> sortedList){
        orderedList = new ArrayList<Integer>(originalList);
        Collections.sort(orderedList);
        return sortedList.equals(orderedList);
    }
    
    private void checkSortedListLog(List<Integer> originalList, List<Integer> sortedList){
        if (checkSortedList(originalList, sortedList))
            System.out.println("    Ordenado correctamente");
        else
            System.out.println("    No ordenado correctamente");
    }
    
    
    public void RunTimes(){
        bubble();
        selection();
        insertion();
        quick();
        binary();
        System.out.println("");
        sequential();
        System.out.println("");

        System.out.println("                                               Comparaciones        Accesos        Swaps");
        
        fillLists();
        System.out.print("Bubble01: Lista aleatoria:                        ");
        bubbleTests(myListAl);
        System.out.print("Bubble02: Elementos ya ordenados:                 ");
        bubbleTests(myListOrd);
        System.out.print("Bubble03: Elementos inversamente ordenados:       ");
        bubbleTests(myListInv);
        System.out.print("Bubble04: Elementos todos iguales:                ");
        bubbleTests(myListSame);
        System.out.println("");
        
        fillLists();
        System.out.print("Selection01: Lista aleatoria:                       ");
        selectionTests(myListAl);
        System.out.print("Selection02: Elementos ya ordenados:                ");
        selectionTests(myListOrd);
        System.out.print("Selection03: Elementos inversamente ordenados:      ");
        selectionTests(myListInv);
        System.out.print("Selection04: Elementos todos iguales:               ");
        selectionTests(myListSame);
        System.out.println("");
        
        fillLists();
        System.out.print("Insertion01: Lista aleatoria:                      ");
        insertionTests(myListAl);
        System.out.print("Insertion02: Elementos ya ordenados:               ");
        insertionTests(myListOrd);
        System.out.print("Insertion03: Elementos inversamente ordenados:     ");
        insertionTests(myListInv);
        System.out.print("Insertion04: Elementos todos iguales:              ");
        insertionTests(myListSame);
        System.out.println("");
        
        fillLists();
        System.out.print("Quick01: Lista aleatoria:                          ");
        quickTests(myListAl);
        System.out.print("Quick02: Elementos ya ordenados:                   ");
        quickTests(myListOrd);
        System.out.print("Quick03: Elementos inversamente ordenados:         ");
        quickTests(myListInv);
        System.out.print("Quick04: Elementos todos iguales:                  ");
        quickTests(myListSame);
        System.out.println("");
    }
    
    public void RunTests(){
        bubleTestAlgorithm();
        selectionTestAlgorithm();
        insertionTestAlgorithm();
        quickTestAlgorithm();
    }
    
    
    
    private void bubble(){
        System.out.println("");
        fillLists();
        System.out.println("Test_Bubble01: Ordenar una lista aleatoria:                                         ");
        bubbleTestsTimes(myListAl);
        System.out.println("");
        
        System.out.println("Test_Bubble02: Ordenar una lista cuyos elementos están ya ordenados:                ");
        bubbleTestsTimes(myListOrd);
        System.out.println("");
        
        System.out.println("Test_Bubble03: Ordenar una lista cuyos elementos están inversamente ordenados:      ");
        bubbleTestsTimes(myListInv);
        System.out.println("");
        
        System.out.println("Test_Bubble04: Ordenar una lista cuyos elementos sean todos iguales:                ");
        bubbleTestsTimes(myListSame);
        System.out.println("");
    }
    
    private void selection(){
        fillLists();
        System.out.println("Test_Selection01: Ordenar una lista aleatoria:                                         ");
        selectionTestsTimes(myListAl);
        System.out.println("");
        
        System.out.println("Test_Selection02: Ordenar una lista cuyos elementos están ya ordenados:                ");
        selectionTestsTimes(myListOrd);
        System.out.println("");
        
        System.out.println("Test_Selection03: Ordenar una lista cuyos elementos están inversamente ordenados:      ");
        selectionTestsTimes(myListInv);
        System.out.println("");
        
        System.out.println("Test_Selection04: Ordenar una lista cuyos elementos sean todos iguales:                ");
        selectionTestsTimes(myListSame);
        System.out.println("");
    }
    
    private void insertion(){
        fillLists();
        System.out.println("Test_Insertion01: Ordenar una lista aleatoria:                                         ");
        insertionTestsTimes(myListAl);
        System.out.println("");
        
        System.out.println("Test_Insertion02: Ordenar una lista cuyos elementos están ya ordenados:                ");
        insertionTestsTimes(myListOrd);
        System.out.println("");
        
        System.out.println("Test_Insertion03: Ordenar una lista cuyos elementos están inversamente ordenados:      ");
        insertionTestsTimes(myListInv);
        System.out.println("");
        
        System.out.println("Test_Insertion04: Ordenar una lista cuyos elementos sean todos iguales:                ");
        insertionTestsTimes(myListSame);
        System.out.println("");
    }
    
    private void quick(){
        fillLists();
        System.out.println("Test_Quick01: Ordenar una lista aleatoria:                                         ");
        quickTestsTimes(myListAl);
        System.out.println("");
        
        System.out.println("Test_Quick02: Ordenar una lista cuyos elementos están ya ordenados:                ");
        quickTestsTimes(myListOrd);
        System.out.println("");
        
        System.out.println("Test_Quick03: Ordenar una lista cuyos elementos están inversamente ordenados:      ");
        quickTestsTimes(myListInv);
        System.out.println("");
        
        System.out.println("Test_Quick04: Ordenar una lista cuyos elementos sean todos iguales:                ");
        quickTestsTimes(myListSame);
        System.out.println("");
    }
    
    private void binary(){
        fillLists();
        System.out.print("Test_Binary01: Búesqueda en una lista aleatoria:                                        ");
        binaryTests(myListAl);
        System.out.println("");
        
        System.out.print("Test_Binary02: Búsqueda en una lista cuyos elementos están ya ordenados:                ");
        binaryTests(myListOrd);
        System.out.println("");
        
        System.out.print("Test_Binary03: Búsqueda en una lista cuyos elementos están inversamente ordenados:      ");
        binaryTests(myListInv);
        System.out.println("");
        
        System.out.print("Test_Binary04: Búsqueda en una lista cuyos elementos sean todos iguales:                ");
        binaryTests(myListSame);
        System.out.println("");
    }
    
    private void sequential(){
        fillLists();
        System.out.print("Test_Sequential01: Búesqueda en una lista aleatoria:                                        ");
        sequentialTests(myListAl);
        System.out.println("");
        
        System.out.print("Test_Sequential02: Búsqueda en una lista cuyos elementos están ya ordenados:                ");
        sequentialTests(myListOrd);
        System.out.println("");
        
        System.out.print("Test_Sequential03: Búsqueda en una lista cuyos elementos están inversamente ordenados:      ");
        sequentialTests(myListInv);
        System.out.println("");
        
        System.out.print("Test_Sequential04: Búsqueda en una lista cuyos elementos sean todos iguales:                ");
        sequentialTests(myListSame);
        System.out.println("");
    }
    
    private void bubleTestAlgorithm(){
        fillLists();
        
        System.out.print("Bubble01: Lista aleatoria:                       ");
        myListAlOriginal = new ArrayList<Integer>(myListAl);
        bubbleSort(myListAl, aux);
        checkSortedListLog(myListAlOriginal, myListAl);
        
        System.out.print("Bubble02: Elementos ya ordenados:                ");
        myListOrdOriginal = new ArrayList<Integer>(myListOrd);
        bubbleSort(myListOrd, aux);
        checkSortedListLog(myListOrdOriginal, myListOrd);
        
        System.out.print("Bubble03: Elementos inversamente ordenados:      ");
        myListInvOriginal = new ArrayList<Integer>(myListInv);
        bubbleSort(myListInv, aux);
        checkSortedListLog(myListInvOriginal, myListInv);
        
        System.out.print("Bubble04: Elementos todos iguales:               ");
        myListSameOriginal = new ArrayList<Integer>(myListSame);
        bubbleSort(myListSame, aux);
        checkSortedListLog(myListSameOriginal, myListSame);
        System.out.println("");
    }
    
    
    
    private void selectionTestAlgorithm(){
        fillLists();
        
        System.out.print("Selection01: Lista aleatoria:                    ");
        myListAlOriginal = new ArrayList<Integer>(myListAl);
        selectionSort(myListAl, aux);
        checkSortedListLog(myListAlOriginal, myListAl);
        
        System.out.print("Selection02: Elementos ya ordenados:             ");
        myListOrdOriginal = new ArrayList<Integer>(myListOrd);
        selectionSort(myListOrd, aux);
        checkSortedListLog(myListOrdOriginal, myListOrd);
        
        System.out.print("Selection03: Elementos inversamente ordenados:   ");
        myListInvOriginal = new ArrayList<Integer>(myListInv);
        selectionSort(myListInv, aux);
        checkSortedListLog(myListInvOriginal, myListInv);
        
        System.out.print("Selection04: Elementos todos iguales:            ");
        myListSameOriginal = new ArrayList<Integer>(myListSame);
        selectionSort(myListSame, aux);
        checkSortedListLog(myListSameOriginal, myListSame);
        System.out.println("");
    }
    
    private void insertionTestAlgorithm(){
        fillLists();
        
        System.out.print("Insertion01: Lista aleatoria:                    ");
        myListAlOriginal = new ArrayList<Integer>(myListAl);
        insertionSort(myListAl);
        checkSortedListLog(myListAlOriginal, myListAl);
        
        System.out.print("Insertion02: Elementos ya ordenados:             ");
        myListOrdOriginal = new ArrayList<Integer>(myListOrd);
        insertionSort(myListOrd);
        checkSortedListLog(myListOrdOriginal, myListOrd);
        
        System.out.print("Insertion03: Elementos inversamente ordenados:   ");
        myListInvOriginal = new ArrayList<Integer>(myListInv);
        insertionSort(myListInv);
        checkSortedListLog(myListInvOriginal, myListInv);
        
        System.out.print("Insertion04: Elementos todos iguales:            ");
        myListSameOriginal = new ArrayList<Integer>(myListSame);
        insertionSort(myListSame);
        checkSortedListLog(myListSameOriginal, myListSame);
        System.out.println("");
    }
    
    private void quickTestAlgorithm(){
        fillLists();
        
        System.out.print("Quick01: Lista aleatoria:                        ");
        myListAlOriginal = new ArrayList<Integer>(myListAl);
        quickSort(myListAl, 0, 999, aux);
        checkSortedListLog(myListAlOriginal, myListAl);
        
        System.out.print("Quick02: Elementos ya ordenados:                 ");
        myListOrdOriginal = new ArrayList<Integer>(myListOrd);
        quickSort(myListOrd, 0, 999, aux);
        checkSortedListLog(myListOrdOriginal, myListOrd);
        
        System.out.print("Quick03: Elementos inversamente ordenados:       ");
        myListInvOriginal = new ArrayList<Integer>(myListInv);
        quickSort(myListInv, 0, 999, aux);
        checkSortedListLog(myListInvOriginal, myListInv);
        
        System.out.print("Quick04: Elementos todos iguales:                ");
        myListSameOriginal = new ArrayList<Integer>(myListSame);
        quickSort(myListSame, 0, 999, aux);
        checkSortedListLog(myListSameOriginal, myListSame);
        System.out.println("");
    }
    
    
    private float bubbleSort(List<Integer> list, ComparerAndSwapper aux){
        int n = list.size() - 1;
        int m = list.size();
        before = System.nanoTime();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < m; j++) {
                if (aux.isGreater(list.get(i), list.get(j))){
                    aux.swap(list, i, j);
                }
            }
        }
        time = (float)(System.nanoTime() - before)/million;
        return time;
    }
    
    private void bubbleTestsTimes(MyList list){
        times = new ArrayList<Float>();
        fillArrayList(list);
        time1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            aux = new ComparerAndSwapperStadistics();
            t1 = bubbleSort(arrayList.get(i), aux);
            times.add(t1);
        }
        time2 = (float)(System.nanoTime() - time1)/million;
        averageTime = time2 / 1000;
        Collections.sort(times);
        
        System.out.println("    Tiempo medio:   " + averageTime + " ms");
        System.out.println("    Tiempo mínimo:  " + times.get(0) + " ms");
    }
    
    private void bubbleTests(MyList list){
        aux = new ComparerAndSwapperStadistics();
        bubbleSort(list, aux);
        
        System.out.print(aux.comparisons + "            ");
        System.out.print(list.access + "        ");
        System.out.println(aux.swaps);
    }
    
    private float selectionSort(List<Integer> list, ComparerAndSwapper aux){
        int n = list.size() - 1;
        int m = list.size();
        before = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int less = i;
            for (int j = i+1; j < m; j++) 
                if (list.get(j) < list.get(less)){
                    less = j;
                }
                if (i != less){
                    aux.swap(list, i, less);
                }
        }
        time = (float)(System.nanoTime() - before)/million;
        return time;
    }
    
    private void selectionTestsTimes(MyList list){
        times = new ArrayList<Float>();
        fillArrayList(list);
        time1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            aux = new ComparerAndSwapperStadistics();
            t1 = selectionSort(arrayList.get(i), aux);
            times.add(t1);
        }
        time2 = (float)(System.nanoTime() - time1)/million;
        averageTime = time2 / 1000;
        Collections.sort(times);
        
        System.out.println("    Tiempo medio:   " + averageTime + " ms");
        System.out.println("    Tiempo mínimo:  " + times.get(0) + " ms");
    }
    
    private void selectionTests(MyList list){
        aux = new ComparerAndSwapperStadistics();
        selectionSort(list, aux);
        
        System.out.print(aux.comparisons + "               ");
        System.out.print(list.access + "         ");
        System.out.println(aux.swaps);
    }
    
    private float insertionSort(List<Integer> list){
        comparisons = 0;
        swaps = 0;
        int temp;
        int n = list.size();
        before = System.nanoTime();
        for (int i = 1; i < n; i++) {
            temp = list.get(i);
            int j;
            for (j = i - 1; j >= 0 && temp < list.get(j); j--){
                comparisons++;
                list.set(j+1, list.get(j));
                swaps++;
            } 
            list.set(j+1, temp);
        }
        time = (float)(System.nanoTime() - before)/million;
        return time;
    }
    
    private void insertionTestsTimes(MyList list){
        times = new ArrayList<Float>();
        fillArrayList(list);
        time1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            t1 = insertionSort(arrayList.get(i));
            times.add(t1);
        }
        time2 = (float)(System.nanoTime() - time1)/million;
        averageTime = time2 / 1000;
        Collections.sort(times);
        
        System.out.println("    Tiempo medio:   " + averageTime + " ms");
        System.out.println("    Tiempo mínimo:  " + times.get(0) + " ms");
    }
    
    private void insertionTests(MyList list){
        aux = new ComparerAndSwapperStadistics();
        insertionSort(list);
        
        System.out.print(comparisons + "          ");
        System.out.print("   " + list.access + "         ");
        System.out.println(swaps);
    }
    
    private float quickSort(List<Integer> list, int low, int high, ComparerAndSwapper aux){
        before = System.nanoTime();
        int middle = low + (high - low) / 2;
        int pivot = list.get(middle);
        
        int i = low;
        int j = high;
        while (i <= j){
            while (aux.isGreater(pivot, list.get(i)))
                i++;
            while (aux.isGreater(list.get(j), pivot))
                j--;
            
            if (i <= j){
                aux.swap(list, i, j);
                i++;
                j--;
            }
        }
        
        if (low < j)
            quickSort(list, low, j, aux);
        if (high > i)
            quickSort(list, i, high, aux);
        time = (float)(System.nanoTime() - before)/million;
        return time;
    }
    
    private void quickTestsTimes(MyList list){
        times = new ArrayList<Float>();
        fillArrayList(list);
        time1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            aux = new ComparerAndSwapperStadistics();
            t1 = quickSort(arrayList.get(i), 0, 999, aux);
            times.add(t1);
        }
        time2 = (float)(System.nanoTime() - time1)/million;
        averageTime = time2 / 1000;
        Collections.sort(times);
        
        System.out.println("    Tiempo medio:   " + averageTime + " ms");
        System.out.println("    Tiempo mínimo:  " + times.get(0) + " ms");
    }
    
    private void quickTests(MyList list){
        aux = new ComparerAndSwapperStadistics();
        quickSort(list, 0, 999, aux);
        
        System.out.print(aux.comparisons + "            ");
        System.out.print(list.access + "        ");
        System.out.println(aux.swaps);
    }
    
    private float binarySearch(List<Integer> list, int element){
        Collections.sort(list);
        int inf = 0;
        int middle;
        int sup = 1000;
        before = System.nanoTime();
        while (inf < sup){
            middle = ((1000-inf)/2)+inf;
            if (list.get(middle) == element){
                time = (float)(System.nanoTime() - before)/million;
                return time;
            }
            else if (element < list.get(middle))
                sup = middle - 1;
            else
                inf = middle + 1;
        }
        time = (float)(System.nanoTime() - before)/million;
        return time;
    }
    
    private void binaryTests(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayList(list);
        int n = list.size();
        before = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            t1 = binarySearch(arrayList.get(i), 999);
            times.add(t1);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / 1000;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("    " + times.get(0));
    }
    
    private void sequentialTests(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayList(list);
        int n = list.size();
        before = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            t1 = System.nanoTime();
            for (int j = 0; j < n; j++) {
                if (arrayList.get(i).get(j).equals(999))
                    break;
            }
            time2 = (float)(System.nanoTime() - t1)/million;
            times.add(time2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / 1000;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("    " + times.get(0));
    }
}

