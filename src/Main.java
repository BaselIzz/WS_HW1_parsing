import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        try {
            File Inputfile = new File("src/Books.txt");
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(Inputfile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element:" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("book");
            System.out.println("_________________________________");
            //temp the size of the xml data book number
            for (int temp = 0; temp < nList.getLength(); temp++) {//take the book abd but it in a node
                Node nNode = nList.item(temp);
                //    System.out.println("\nCurrent Element :" + nNode.getNodeName());
//if this node is the type of note element then
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    //put it in element
                    Element eElement = (Element) nNode;


                    Book book = new Book(eElement);
                    books.add(book);


                }
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter\n 1- Show all Books \n 2- Show book Detail that id like bk101 from bk101 to bk112 \n 3- exit");
            String num = scanner.next();
            while (true) {
                switch (num) {
                    case "1" -> {
                        for (Book b : books
                        ) {
                            System.out.println(b.toString());

                        }
                    }
                    case "2" -> {
                        System.out.println("Please enter the book id");
                        String Book_Id = scanner.next();
                        Book b = new Book(Book_Id);
                        int index = 0;
                        for (Book bok
                                :
                                books) {
                            if (bok.getId().equalsIgnoreCase(b.getId())) {
                                break;
                            } else {
                                index++;
                            }

                        }
                        if (books.size() - 1 >= index) {
                            System.out.println(books.get(index).toString());
                        } else {
                            System.out.println("Book with ID : " + Book_Id + " Is Not Exists");
                        }
                    }
                    case "3" -> {
                        return;
                    }
                    default -> System.out.println("Wrong Input\n");
                }
                System.out.println("Please enter 1- Show all Books \n 2- Show book Detail that id like bk101 from bk101 to bk112 \n 3- exit");

                num = scanner.next();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}