
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(60);
        l.add(70);
        l.add(80);
        
        System.out.println(l);
        System.out.println("size = " + l.size());
        
        System.out.println("Get da posicao 2: " + l.get(2));
        System.out.println("Get da posicao 6: " + l.get(6));
        
        System.out.println("Trocou " + l.set(2, 35) + " por 35 na posicao 2.");
        
        System.out.println("Removeu 50? " + l.remove(50));
        System.out.println("Removeu 57? " + l.remove(57));
        System.out.println(l);
        System.out.println(l.removeByIndex(0));
        System.out.println(l.removeByIndex(2));
        System.out.println(l.removeByIndex(4));
        System.out.println(l);
        System.out.println(l.size());
        
        l.addByIndex(0,0);
        System.out.println(l);
        System.out.println(l.size());
        l.addByIndex(l.size(),90);
        System.out.println(l);
        System.out.println(l.size());
        l.addByIndex(4,44);
        System.out.println(l);
        System.out.println(l.size());

        System.out.println("Método set: " + l.set(1, 21));
        System.out.println(l);

        System.out.println("Index do elemento 44: " + l.indexOf(44));
        


        
        System.out.println("Lista de trás para frente: \n"+l.toStringBackToFront());
        
        l.reverse();
        System.out.println(l);
        

        Integer a[] = l.subList(4, 7);
        System.out.println("Sublist(4,7)");
        //for(Integer i : a) {
        //    System.out.println(i);
        //}
        
        DoubleLinkedListOfInteger l2 = new DoubleLinkedListOfInteger();
        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.add(4);
        l2.add(2);
        l2.add(1);
        l2.add(5);
        l2.add(6);
        l2.add(3);
        l2.add(1);
        System.out.println("l2: \n" + l2);
        l2.unique();
        System.out.println("l2 apos remover repetidos: \n" + l2); 
    }
}
