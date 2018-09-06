package thread;


class C  extends Thread
{
    public void run()
    {
        for(int x=1;x<10000;x++)
        {
            try
            {
                //Thread.sleep(2000);
            }
            catch (Exception e)
            {
            }
            System.out.println("A is executing  "+x);
        }
    }
}
class D  extends Thread
{
    public void run()
    {
        for(int x=1;x<10000;x++)
        {
            try
            {
                //Thread.sleep(2000);
            }
            catch (Exception e)
            {
            }
            System.out.println("B is executing  "+x);
        }
    }
}
public class ThreadE {

    public static void main(String[] args) {

C a=new C();
D b=new D();



a.start();
b.start();

    }

}

