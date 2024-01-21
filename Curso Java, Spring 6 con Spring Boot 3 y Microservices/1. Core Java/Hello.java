
class A
{
    public void show()
    {
        System.out.println("In A Show");
    }
}


class B extends A
{
    public void show()
    {
        System.out.println("In B Show");
    }
}

public class Hello 
{
    public static void main(String[] args) 
    {
        A obj;

        obj = new A();
        obj.show();

        obj = new B();
        obj.show();
        
    }
}



