

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.File;
import java.util.Iterator;

public class xmlPos extends gmailLogin {

    private String xmlSubtotal = "";
    private String xmlTotal = "";

    @Test
    public void readAndValidatePosXML() {
        try {
            Document doc = loadXMLDocument("C:\\Users\\HP\\Downloads\\Pos.xml");
            XPath xpath = createXPath();
            NodeList transactions = getTransactionNodes(doc, xpath);

            for (int i = 0; i < transactions.getLength(); i++) {
                Node transaction = transactions.item(i);
                System.out.println("=== Transaction " + (i + 1) + " ===");
                extractSalesDetails(transaction, xpath);
                extractTransactionTotal(transaction, xpath);
            }

            // Now validate against Gmail
            Login(); // From gmailLogin base class
            validateEmailOrderSummary();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= XML Methods ===================

    private Document loadXMLDocument(String filePath) throws Exception {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(xmlFile);
    }

    private XPath createXPath() {
        XPath xpath = XPathFactory.newInstance().newXPath();
        xpath.setNamespaceContext(new NamespaceContext() {
            public String getNamespaceURI(String prefix) {
                return "ns".equals(prefix) ? "http://www.nrf-arts.org/IXRetail/namespace/" : null;
            }

            public String getPrefix(String namespaceURI) { return null; }

            public Iterator getPrefixes(String namespaceURI) { return null; }
        });
        return xpath;
    }

    private NodeList getTransactionNodes(Document doc, XPath xpath) throws XPathExpressionException {
        return (NodeList) xpath.evaluate("//ns:Transaction", doc, XPathConstants.NODESET);
    }

    private void extractSalesDetails(Node transaction, XPath xpath) throws XPathExpressionException {
        NodeList sales = (NodeList) xpath.evaluate(".//ns:Sale", transaction, XPathConstants.NODESET);
        for (int j = 0; j < sales.getLength(); j++) {
            Node sale = sales.item(j);
            String itemId = getTagValue("ItemID", sale, xpath);
            String desc = getTagValue("Description", sale, xpath);
            String qty = getTagValue("Quantity", sale, xpath);
            String extAmount = getTagValue("ExtendedAmount", sale, xpath);

            xmlSubtotal = extAmount; // Last item assumed for simplicity
            System.out.println("Item ID: " + itemId);
            System.out.println("Description: " + desc);
            System.out.println("Quantity: " + qty);
            System.out.println("Subtotal (Extended Amount): " + extAmount);
            System.out.println("-------------------------------");
        }
    }

    private void extractTransactionTotal(Node transaction, XPath xpath) throws XPathExpressionException {
        xmlTotal = xpath.evaluate(".//ns:Total[@TotalType='TransactionGrandAmount']", transaction).trim();
        System.out.println("Transaction Total: " + xmlTotal);
        System.out.println("=====================================\n");
    }

    private String getTagValue(String tag, Node contextNode, XPath xpath) {
        try {
            return xpath.evaluate(".//ns:" + tag, contextNode).trim();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            return "";
        }
    }

    // ================= Email Validation ===================
@Test
    private void validateEmailOrderSummary() {
        try {
            WebElement orderSummary = driver.findElement(By.cssSelector("td[height='16'][align='left']"));
            String orderText = orderSummary.getText();
            System.out.println("Email Order Details:\n" + orderText);
            System.out.println("-------------------------------");

            boolean subtotalMatch = orderText.contains("Subtotal") && orderText.contains(xmlSubtotal);
            boolean totalMatch = orderText.contains("Order Total") && orderText.contains(xmlTotal);

            System.out.println("\n=== Validation Results ===");
            System.out.println(subtotalMatch ? "✅ Subtotal matched" : "❌ Subtotal mismatch");
            System.out.println(totalMatch ? "✅ Total matched" : "❌ Total mismatch");

        } catch (Exception e) {
            System.out.println("Failed to validate email content: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
