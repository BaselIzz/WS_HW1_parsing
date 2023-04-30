import org.w3c.dom.Element;

public class Book {
    private final String id;
    private String author;
    private String title;
    private String Genre;
    private double price;
    private String publish_Date;
    private String Description;


    @Override
    public String toString() {
        return "Book" +
                "id : " + id + "\n" +
                "author : " + author + "\n" +
                "title : " + title + "\n" +
                "Genre : " + Genre + "\n" +
                "price : " + price + "\n" +
                "publish_Date : " + publish_Date + "\n" +
                "Description : " + Description + "\n"
                ;
    }

    public String getId() {
        return id;
    }


    public Book(String id) {
        this.id = id;
    }
//passing the element  to parse it to book class
    public Book(Element eElement) {
        //set id equal the Attribute  in the element that is id
        this.id = eElement.getAttribute("id");
        this.author =
                eElement
                        .getElementsByTagName("author")
                        .item(0)
                        .getTextContent();
        this.title = eElement
                .getElementsByTagName("title")
                .item(0)
                .getTextContent();
        this.Genre = eElement
                .getElementsByTagName("genre")
                .item(0)
                .getTextContent();
        this.price = Double.parseDouble(eElement
                .getElementsByTagName("price")
                .item(0)
                .getTextContent());
        this.publish_Date = eElement
                .getElementsByTagName("publish_date")
                .item(0)
                .getTextContent();
        this.Description = eElement
                .getElementsByTagName("description")
                .item(0)
                .getTextContent();
    }
}
