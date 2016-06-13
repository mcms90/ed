package p5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lists {
    List<Integer> myArrayList = new ArrayList<Integer>();
    List<Integer> myLinkedList = new LinkedList<Integer>();
    List<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
    List<Float> times = new ArrayList<Float>();
    long before;
    float time;
    final int million = 1000000;
    final int element = 200;
    final int sample = 1000;
    long t1;
    float t2;
    float averageTime;
    int middle;
    float time1;
    
    public void fillLists(){
        myArrayList.clear();
        myLinkedList.clear();
        for (int i = 0; i < 1000; i++) {
            myArrayList.add(i);
            myLinkedList.add(i);
        }
    }
    
    public void fillArrayLists(List<Integer> list){
        arrayList.clear();
        for (int i = 0; i < sample; i++) {
            arrayList.add(new ArrayList<Integer>(list));
        }
    }
    
    
    public void RunTimes(){    
        System.out.println("Tiempo medio y mínimo (en milisegundos) que tarda en ejecutarse cada una de las siguientes acciones:\n");
        System.out.println("                                                                        ArrayList                  LinkedList");
        System.out.println("                                                                   Medio        Mínimo         Medio        Mínimo");
        insert();
        delete();
        deleteValue();
        clearList();
        search();
        sequentialSearch();
        binarySearch();
    }
    
    private void insert(){
        fillLists();
        System.out.print("Test01: Insertar un elemento al final de la lista:         ");
        Test01(myArrayList);
        Test01(myLinkedList);
        System.out.println("");
        
        fillLists();
        System.out.print("Test02: Insertar un elemento al principio de la lista:     ");
        Test02(myArrayList);
        Test02(myLinkedList);
        System.out.println("");
        
        fillLists();
        System.out.print("Test03: Insertar un elemento a mitad de la lista:          ");
        Test03(myArrayList);
        Test03(myLinkedList);
        System.out.println("");
    }
    
    private void delete(){
        fillLists();
        System.out.print("Test04: Borrar el elemento que hay al final de la lista:   ");
        Test04(myArrayList);
        Test04(myLinkedList);
        System.out.println("");
        
        fillLists();
        System.out.print("Test05: Borrar el elemento que hay al principio de la lista: ");
        Test05(myArrayList);
        Test05(myLinkedList);
        System.out.println("");
        
        fillLists();
        System.out.print("Test06: Borrar el elemento que hay en medio de la lista:     ");
        Test06(myArrayList);
        Test06(myLinkedList);
        System.out.println("");
    }
    
    private void deleteValue(){
        fillLists();
        System.out.print("Test07: Borrar el elemento que hay al final (por su valor):  ");
        Test07(myArrayList);
        Test07(myLinkedList);
        System.out.println("");
        
        fillLists();
        System.out.print("Test08: Borrar el elemento que hay al principio (por su valor): ");
        Test08(myArrayList);
        Test08(myLinkedList);
        System.out.println("");
        
        fillLists();
        System.out.print("Test09: Borrar el elemento que hay en medio (por su valor):      ");
        Test09(myArrayList);
        Test09(myLinkedList);
        System.out.println("");
    }
    
    private void clearList(){
        fillLists();
        System.out.print("Test10: Vaciado completo de la lista:                        ");
        Test10(myArrayList);
        Test10(myLinkedList);
        System.out.println("");
    }
    
    private void search(){
        fillLists();
        System.out.print("Test11: Búsqueda de la existencia de un elemento en la lista:");
        Test11(myArrayList);
        Test11(myLinkedList);
        System.out.println("");
    }
    
    private void sequentialSearch(){
        fillLists();
        System.out.print("Test12_1: Búsqueda secuencial (elemento al principio):     ");
        Test12_1(myArrayList);
        Test12_1(myLinkedList);
        System.out.println("");
        
        fillLists();
        System.out.print("Test12_2: Búsqueda secuencial (elemento en medio):         ");
        Test12_2(myArrayList);
        Test12_2(myLinkedList);
        System.out.println("");
        
        fillLists();
        System.out.print("Test12_3: Búsqueda secuencial (elemento al final):         ");
        Test12_3(myArrayList);
        Test12_3(myLinkedList);
        System.out.println("");
        
        fillLists();
        System.out.print("Test12_4: Búsqueda secuencial (elemento no existe):        ");
        Test12_4(myArrayList);
        Test12_4(myLinkedList);
        System.out.println("");
    }
    
    private void binarySearch(){
        fillLists();
        System.out.print("Test13_1: Búsqueda binaria (elemento al principio):        ");
//        binaryTests01(myArrayList);
//        binaryTests01(myLinkedList);
        System.out.println("");
        
        fillLists();
        System.out.print("Test13_2: Búsqueda binaria (elemento en medio):        ");
        int n = myArrayList.size();
        binaryTests01(myArrayList, n/2);
        binaryTests01(myLinkedList, n/2);
        System.out.println("");
        
        fillLists();
        System.out.print("Test13_3: Búsqueda binaria (elemento al final):        ");
        binaryTests01(myArrayList, 999);
        binaryTests01(myLinkedList, 999);
        System.out.println("");
        
        fillLists();
        System.out.print("Test13_4: Búsqueda binaria (elemento no existe):        ");
//        binaryTests01(myArrayList, 200);
//        binaryTests01(myLinkedList, 200);
        System.out.println("");
    }
    
    private void Test01(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            arrayList.get(i).add(element);
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("     " + times.get(0));
    }
    
    private void Test02(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            arrayList.get(i).add(0, element);
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("     " + times.get(0));
    }
    
    private void Test03(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        middle = list.size() / 2;
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            arrayList.get(i).add(middle, element);
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("     " + times.get(0));
    }
    
    int pos;
    
    private void Test04(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        pos = list.size() - 1;
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            arrayList.get(i).remove(pos);
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("       " + times.get(0) + "    ");
    }
    
    private void Test05(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            arrayList.get(i).remove(0);
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("      " + times.get(0) + "    ");
    }
    
    private void Test06(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        middle = list.size() / 2;
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            arrayList.get(i).remove(middle);
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("      " + times.get(0) + "    ");
    }
    
    int value;
        
    private void Test07(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        value = new Integer(999);
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            arrayList.get(i).remove(value);
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("      " + times.get(0) + "    ");
    }

    private void Test08(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        value = new Integer(0);
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            arrayList.get(i).remove(value);
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print(" " + averageTime);
        System.out.print("      " + times.get(0) + "     ");
    }
    
    private void Test09(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        middle = list.size() / 2;
        value = new Integer(middle);
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            arrayList.get(i).remove(value);
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print(averageTime);
        System.out.print("       " + times.get(0) + "       ");
    }
    
    private void Test10(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            arrayList.get(i).clear();
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("    " + times.get(0));
    }
    
    private void Test11(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            arrayList.get(i).indexOf(999);
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("    " + times.get(0));
    }
    
    private void Test12_1(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        int n = list.size();
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            for (int j = 0; j < n; j++) {
                if (arrayList.get(i).get(i).equals(0))
                    break;
            }
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("    " + times.get(0));
    }
    
    private void Test12_2(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        int n = list.size();
        middle = n/2;
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            for (int j = 0; j < n; j++) {
                if (arrayList.get(i).get(i).equals(middle))
                    break;
            }
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("    " + times.get(0));
    }
    
    private void Test12_3(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        int n = list.size();
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            for (int j = 0; j < n; j++) {
                if (arrayList.get(i).get(j).equals(999))
                    break;
            }
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("    " + times.get(0));
    }
    
    private void Test12_4(List<Integer> list){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        int n = list.size();
        before = System.nanoTime();
        for (int i = 0; i < sample; i++) {
            t1 = System.nanoTime();
            for (int j = 0; j < n; j++) {
                if (arrayList.get(i).get(j).equals(200))
                    break;
            }
            t2 = (float)(System.nanoTime() - t1)/million;
            times.add(t2);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / sample;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("    " + times.get(0));
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
    
    private void binaryTests01(List<Integer> list, int elem){
        times = new ArrayList<Float>();
        fillArrayLists(list);
        int n = list.size();
        before = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            time1 = binarySearch(arrayList.get(i), elem);
            times.add(time1);
        }
        time = (float)(System.nanoTime() - before)/million;
        averageTime = time / 1000;
        Collections.sort(times);
        
        System.out.print("    " + averageTime);
        System.out.print("    " + times.get(0));
    }
}