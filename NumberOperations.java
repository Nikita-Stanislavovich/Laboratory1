import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ArrayList;

public class NumberOperations {

    public static void main(String[] args) {
        
        List<Number> myNumberList = new ArrayList<>();
        myNumberList.addAll(Arrays.asList(10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9));     
        myNumberList.add(-24);
        myNumberList.add(0.213);
        myNumberList.add(0.0);
        myNumberList.add(null); 
      
        System.out.println("Оригiнальний список: " + myNumberList);        
        CollectionPrinter customPrinter = new CollectionPrinter();
        String formattedOutput = customPrinter.formatCollectionWithRule(myNumberList);
        System.out.println("Форматований список (до двох знакiв пiсля коми): " + formattedOutput);    
        ArraySorter mySorter = new ArraySorter();
        Map<Class<?>, List<Object>> sortedMap = mySorter.sort(myNumberList);
        System.out.println("Сортування за типами: " + sortedMap);       
        double totalProduct = 1;
        int processedNumbers = 0;

        for (Number num : myNumberList) {
            if (num != null) {
                totalProduct *= num.doubleValue(); 
                processedNumbers++; 
            }
            if (processedNumbers == 5) {
                break;
            }
        }

        System.out.println("Добуток перших п'яти чисел: " + totalProduct);
    }
}

class CollectionPrinter {
    public String formatCollectionWithRule(List<Number> numbers) {
        String resultString = "[";

        for (int i = 0; i < numbers.size(); i++) {
            Number currentNum = numbers.get(i);
            if (currentNum != null) {
                resultString += String.format(Locale.US, "%.2f", currentNum.floatValue());
            } else {
                resultString += "null";  
            }

            if (i < numbers.size() - 1) {
                resultString += ", ";  
            }
        }

        resultString += "]";  
        return resultString;  
    }
}

class ArraySorter {
    public Map<Class<?>, List<Object>> sort(List<Number> numberList) {
        Map<Class<?>, List<Object>> sortedMap = new HashMap<>();

        for (Number currentObject : numberList) {
            if (currentObject == null) {
                continue; 
            }

            Class<?> currentClass = currentObject.getClass(); 
            if (!sortedMap.containsKey(currentClass)) {
                sortedMap.put(currentClass, new ArrayList<>()); 
            }
            sortedMap.get(currentClass).add(currentObject); 
        }
        return sortedMap;  
    }
}


