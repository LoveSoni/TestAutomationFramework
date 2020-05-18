package listeners;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class DynamicTestngGenerator {
    public static void main(String args[]){
        XmlSuite xmlSuite = new XmlSuite();
        XmlTest xmlTest = new XmlTest(xmlSuite);
    }
}
