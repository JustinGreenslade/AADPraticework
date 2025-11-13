package Queues;

public class Animal {
    public int order;
    public String type;

    public Animal(int order, String type) {
        this.order = order;
        this.type = type;
    }

    public String toString(){
        return type + "(#" + order + ")";
    }
}
