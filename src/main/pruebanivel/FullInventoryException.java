package pruebanivel;

public class FullInventoryException extends Exception{
    public FullInventoryException(){
        super();
    }
    public String getMessage(){
        return "Oh no! This vendor has a full inventory and cannot buy item :(";
    }
}
