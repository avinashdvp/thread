package thread;

class A extends Thread
	{
	    public void run()
	    {
	        for(int x=1;x<11;x++)
	        {
	            try
	            {
	                Thread.sleep(2000);
	            }
	            catch (InterruptedException e)
	            {
	            }
	            System.out.println("A is executing");
	        }
	    }
	}
	class B extends Thread
	{
	    public void run()
	    {
	        for(int x=1;x<11;x++)
	        {
	            try
	            {
	                Thread.sleep(2000);
	            }
	            catch (InterruptedException e)
	            {
	            }
	            System.out.println("B is executing");
	        }
	    }
	}
	public class Threadex 
	{

	    public static void main(String[] args) 
	    {

	A a=new A();
	B b=new B();
    a.start();
	b.start();
	     }

	}

