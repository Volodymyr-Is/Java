package Classes.task8;

public class Array implements IShow{
    int []arr;

    public Array(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void Print() {
        for (int i = 0; i < this.arr.length; i++)
            System.out.print(this.arr[i] + " ");

        System.out.println();
    }
    @Override
    public void Print(String info) {
        System.out.println(info);
        Print();
    }
}
