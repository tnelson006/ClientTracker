/*******************************************************************************
 * @author Travis Nelson
 ******************************************************************************/

public class StrategyDemo
{
  public static void main(String[] args)
  {
    final int x = 5;
    final int y = 10;

    final int messageNum = 2;
    final int mathNum = 2;
    message messageAlgo = null;
    math mathAlgo = null;

    if(messageNum == 1)
    {
      messageAlgo = new messageOne();
    }
    else
    {
      messageAlgo = new messageTwo();
    }

    if(mathNum == 1)
    {
      mathAlgo = new add();
    }
    else
    {
      mathAlgo = new multiply();
    }

    messageAlgo.printMessage(mathAlgo.calculate(x,y));
  }
}

interface message
{
  public void printMessage(int value);
}

class messageOne implements message
{
  public void printMessage(int value)
  {
    System.out.println("The calculated value is: " + value);
  }
}

class messageTwo implements message
{
  public void printMessage(int value)
  {
    System.out.println("Much " + value + "! Such wow!");
  }
}

interface math
{
  public int calculate(int a, int b);
}

class add implements math
{
  public int calculate(int a, int b)
  {
    return a + b;
  }
}

class multiply implements math
{
  public int calculate(int a, int b)
  {
    return a * b;
  }
}