{\rtf1\ansi\ansicpg1252\cocoartf1561\cocoasubrtf200
{\fonttbl\f0\froman\fcharset0 Times-Roman;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\li720\fi-720\sl480\slmult1\pardirnatural\partightenfactor0

\f0\fs24 \cf0 public class StrategyDemo\
\{\
  public static void main(String[] args)\
  \{\
    message messageAlgo = new messageTwo();\
    math mathAlgo = new multiply();\
    messageAlgo.printMessage(mathAlgo.calculate(1,2));\
    System.out.println(args[0]);\
    System.out.println(args[1]);\
  \}\
\}\
\
interface message\
\{\
  public void printMessage(int value);\
\}\
\
class messageOne implements message\
\{\
  public void printMessage(int value)\
  \{\
    System.out.println("The calculated value is: " + value);\
  \}\
\}\
\
class messageTwo implements message\
\{\
  public void printMessage(int value)\
  \{\
    System.out.println("Much " + value + "! Such wow!");\
  \}\
\}\
\
interface math\
\{\
  public int calculate(int a, int b);\
\}\
\
class add implements math\
\{\
  public int calculate(int a, int b)\
  \{\
    return a + b;\
  \}\
\}\
\
class multiply implements math\
\{\
  public int calculate(int a, int b)\
  \{\
    return a * b;\
  \}\
\}}